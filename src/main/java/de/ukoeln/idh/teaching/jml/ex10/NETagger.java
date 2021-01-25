package de.ukoeln.idh.teaching.jml.ex10;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NETagger extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {

		for (Sentence sentence : jcas.select(Sentence.class)) {
			Token potentialBegin = null;
			boolean first = true;
			Token previousToken = null;
			for (Token token : jcas.select(Token.class).coveredBy(sentence)) {
				if (first) {
					first = false;
					continue;
				}

				if (potentialBegin != null) {
					if (Character.isUpperCase(token.getCoveredText().charAt(0))) {

					} else {
						NamedEntity ne = new NamedEntity(jcas, potentialBegin.getBegin(), previousToken.getEnd());
						ne.addToIndexes();
						potentialBegin = null;
					}
				} else {
					if (Character.isUpperCase(token.getCoveredText().charAt(0))) {
						potentialBegin = token;
					}

				}

				previousToken = token;
			}
			if (potentialBegin != null) {
				NamedEntity ne = new NamedEntity(jcas, potentialBegin.getBegin(), previousToken.getEnd());
				ne.addToIndexes();
			}
		}
	}

}
