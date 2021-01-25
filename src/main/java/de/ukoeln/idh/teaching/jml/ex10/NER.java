package de.ukoeln.idh.teaching.jml.ex10;

import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NER extends JCasAnnotator_ImplBase{
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException{
		//iterate over sentences
		for (Sentence sentence : jcas.select(Sentence.class)) {
			int NamedEntityEnd = -1;
			//iterate over tokens in each sentence
			for (Token token : jcas.select(Token.class).coveredBy(sentence).asList()) {
				
				//if token is not at beginning of a sentence
				if (token.getBegin() > NamedEntityEnd && token.getBegin() > sentence.getBegin()) {
					
					//if token starts with an upper case char
					if (Character.isUpperCase(token.getCoveredText().charAt(0))) {
						int NamedEntityBegin = token.getBegin();
						NamedEntityEnd = getNeEnd(token, sentence, jcas);
						
						//create new annotation
						NamedEntity ne = new NamedEntity(jcas);
						ne.setBegin(NamedEntityBegin);
						ne.setEnd(NamedEntityEnd);
						ne.addToIndexes();
						
					}
				
				}	
			}	
		}
	}
	
	public int getNeEnd(Token token, Sentence sentence, JCas jcas) {
		List<Token> nextTokens = jcas.select(Token.class).following(token.getEnd() -1).asList();
		
		//if no token after current token
		if (nextTokens.isEmpty()) {
			return token.getEnd();
		}
		
		//if next token starts with upper case char --> recursion
		if (Character.isUpperCase(nextTokens.get(0).getCoveredText().charAt(0))) {
			return getNeEnd(nextTokens.get(0), sentence, jcas);
		}
		return token.getEnd();
	}
	
}