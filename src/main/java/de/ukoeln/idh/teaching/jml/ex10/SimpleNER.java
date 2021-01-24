package de.ukoeln.idh.teaching.jml.ex10;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;


import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

public class SimpleNER extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		for (Sentence sentence : jcas.select(Sentence.class)) {
			int end_ne = -1;
			for (Token token : jcas.select(Token.class).coveredBy(sentence).asList()) {	
				if (token.getBegin() > end_ne && token.getBegin() > sentence.getBegin()) {
					if (Character.isUpperCase(token.getCoveredText().charAt(0))) {
						int beginning_ne = token.getBegin();
						end_ne = get_ne_end(token, sentence, jcas);
						create_named_entity(beginning_ne, end_ne, jcas);
					}
				}
			}
		}
	}
	
	public int get_ne_end(Token token, Sentence sentence, JCas jcas) {
		List<Token> nextTokens = jcas.select(Token.class).following(token.getEnd() - 1).asList();
		
		if (nextTokens.isEmpty()) {
			return token.getEnd();
		}
		
		if (Character.isUpperCase(nextTokens.get(0).getCoveredText().charAt(0))) {
			return get_ne_end(nextTokens.get(0), sentence, jcas);
		}
		return token.getEnd();
	}

	private void create_named_entity(int beginning_ne, int end_ne, JCas jcas) {
		NamedEntity ne = new NamedEntity(jcas);
		ne.setBegin(beginning_ne);
		ne.setEnd(end_ne);
		ne.addToIndexes();
	}
}
