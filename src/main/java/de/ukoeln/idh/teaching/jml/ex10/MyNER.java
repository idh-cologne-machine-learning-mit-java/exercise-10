package de.ukoeln.idh.teaching.jml.ex10;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class MyNER extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		for (Token token : jcas.select(Token.class)) {
			
			if(Character.isUpperCase(token.getText().charAt(0))) {
				// Annotate Named Entity
				// TODO continue if sentence begin
//				System.out.println(token.getBegin() + " " + token.getEnd());
				NamedEntity ne = new NamedEntity(jcas, token.getBegin(), token.getEnd());
				ne.addToIndexes(jcas);
			}	
		}
		
	}

}
