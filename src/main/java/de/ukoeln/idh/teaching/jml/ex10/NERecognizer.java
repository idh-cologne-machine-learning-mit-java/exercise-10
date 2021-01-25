package de.ukoeln.idh.teaching.jml.ex10;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NERecognizer extends JCasAnnotator_ImplBase {

		private final static int DEFAULT_VALUE = -1;
	
	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		int begin = DEFAULT_VALUE;
		
		List<Sentence> sentences = jcas.select(Sentence.class).asList();
		int numSentences = sentences.size();
		
		for (int s = 0; s < numSentences; s++) {
			Sentence sentence = sentences.get(s);
			
			List<Token> tokens = jcas.select(Token.class).coveredBy(sentence).asList();
			int numTokens = tokens.size();
			
			for (int t = 0; t < numTokens; t++) {
				Token token = tokens.get(t);
				String text = token.getCoveredText();

				if (Character.isUpperCase(text.charAt(0))) {
					if ((t > 0) && (begin == DEFAULT_VALUE)) begin = token.getBegin();
				} else 
					if ((begin > DEFAULT_VALUE) &&	/* sentence split fix, see e.g. "|...Mr.|Holmes.|" */ 
							((t < numTokens-1) || (s == numSentences-1) || (jcas.select(Token.class).coveredBy(sentences.get(s+1)).count() > 2))) {
						int end = DEFAULT_VALUE;
						
						if (t > 0) end = tokens.get(t-1).getEnd();
						else end = tokens.get(t).getEnd();
						
						NamedEntity ne = new NamedEntity(jcas);
						ne.setBegin(begin);
						ne.setEnd(end);
						ne.addToIndexes();
						
						begin = DEFAULT_VALUE;
				}
			}
		}
	}

}
