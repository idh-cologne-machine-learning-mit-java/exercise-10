package de.ukoeln.idh.teaching.jml.ex10;

import java.util.List;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class NameRecognizer extends JCasAnnotator_ImplBase  {


	public void process (JCas jcas) throws AnalysisEngineProcessException {
		for (Sentence sentence : jcas.select(Sentence.class)) {
			int endIndex = -1;
			for(Token token : jcas.select(Token.class).coveredBy(sentence).asList()) {
				if(token.getBegin() > endIndex && token.getBegin() > sentence.getBegin()) {
					if(Character.isUpperCase(token.getCoveredText().charAt(0))) {
						int startIndex = token.getBegin();
						
						endIndex = entityEnd(token, sentence, jcas);
						
						addNE(startIndex, endIndex, jcas);
					}
				}
			}	
		}
	}
	
	
	private void addNE(int startIndex, int endIndex, JCas jcas) {
		
		NamedEntity namedEntity = new NamedEntity(jcas);
		namedEntity.setBegin(startIndex);
		namedEntity.setEnd(endIndex);
		namedEntity.addToIndexes();	
	}
	
	
	public int entityEnd(Token token, Sentence sentence, JCas jcas) {
		
		List<Token> followingTokens = jcas.select(Token.class).following(token.getEnd() - 1).asList();
		
//		if(followingTokens.isEmpty()) {
//			
//			return token.getEnd();
//		}
		
		if(Character.isUpperCase(followingTokens.get(0).getCoveredText().charAt(0))) {
			
			return entityEnd(followingTokens.get(0), sentence, jcas);
		}
		
		
		return token.getEnd();
		
	}
	
	

}
