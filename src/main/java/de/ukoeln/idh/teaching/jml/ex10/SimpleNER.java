package de.ukoeln.idh.teaching.jml.ex10;


import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;

public class SimpleNER extends JCasAnnotator_ImplBase {
	public void process (JCas jcas) throws AnalysisEngineProcessException {
		
		for (Sentence sentence : toSentences(jcas)) {
			Token[] tokens = toTokens(jcas, sentence);
			
			int localStartIndex = 0;
			int localEndIndex = 0;
			
			int i = tokens[0].getCoveredText().equals("\"") ? 2 : 1;
			while (i < tokens.length) {
				Token token = tokens[i];
				if (isUppercase(jcas, token)) {
					localStartIndex = i;
					localEndIndex = i + 1 < tokens.length ? i + 1 : i;
					while(isUppercase(jcas, tokens[localEndIndex])) {
						localEndIndex++;
					}
					int startIndex = tokens[localStartIndex].getBegin();
					int endIndex = tokens[localEndIndex].getBegin();
					createNE(jcas, startIndex, endIndex);
					i = localEndIndex;
				} else {
					i++;
				}
			}
		}
	}
	
	private Sentence[] toSentences(JCas jcas) {
		return jcas.select(Sentence.class).asArray(Sentence.class);
	}
	
	private Token[] toTokens(JCas jcas, Sentence sentence) {
		return jcas.select(Token.class).coveredBy(sentence).asArray(Token.class);
	}
	
	private Boolean isUppercase(JCas jcas, Token token) {
		String text = token.getCoveredText();
		return !text.equals("I") && Character.isAlphabetic(text.charAt(0)) && Character.isUpperCase(text.charAt(0));
	}
	
	
	private void createNE(JCas jcas, int startIndex, int endIndex) {
		
		NamedEntity namedEntity = new NamedEntity(jcas);
		namedEntity.setBegin(startIndex);
		namedEntity.setEnd(endIndex);
		namedEntity.addToIndexes();	
	}
}
