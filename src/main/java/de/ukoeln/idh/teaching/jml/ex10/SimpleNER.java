package de.ukoeln.idh.teaching.jml.ex10;

import de.ukoeln.idh.teaching.jml.ex10.types.Token;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

public class SimpleNER extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		
		for (Token token : jcas.select(Token.class)) {
			
		}
		
	}
	
	public void next_is_upper(Token token, JCas jcas) {
		List<Token> nextTokens = jcas.select(Token.class).following(token).limit(1).asList();
	}

}
