package de.ukoeln.idh.teaching.jml.ex10;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NamedEntityRecognizer {
	
	public void process(JCas cas) throws AnalysisEngineProcessException {
		 
	    for (Sentence sentence : cas.select(Sentence.class)) {
	      
	      Token[] tokens = cas.select(Token.class).coveredBy(sentence).asArray(Token.class);
	      int namedEntityBeginning = -1;
	      
	      // ignore these chars at the beginning
	      String stopCharsRegEx = "[I]";
	      
	      
	      int first = 1;
	      if (tokens.length > 1) {
	        if (tokens[0].getCoveredText().equals("\"")) first = 2;
	      }

	      // iterate over tokens in sentence, disregard first token
	      for (int i=first; i<tokens.length; i++) {
	        
	        char charFirst = tokens[i].getCoveredText().charAt(0);
	        if (String.valueOf(charFirst).matches(stopCharsRegEx)) {
	          if (tokens[i].getCoveredText().length() > 1) {
	        	  charFirst = tokens[i].getCoveredText().charAt(1);
	          } else {
	            continue;
	          }
	        }
	        
	        if (Character.isUpperCase(charFirst)) {
	          // first char of token is capitalized
	          if (namedEntityBeginning == -1) {
	            namedEntityBeginning = i;
	          }
	        } else {
	          
	          if (namedEntityBeginning != -1) {
	        	  
	           
	            int NEBegin = tokens[namedEntityBeginning].getBegin();
	            int NEEnd = tokens[i-1].getEnd();
	            
	            addNamedEntity(cas, NEBegin, NEEnd);
	            namedEntityBeginning = -1;
	          }
	        }

	      }
	    }
	    
	  }

	  private void addNamedEntity(JCas cas, int start, int stop) {
		  
		  
	    NamedEntity NE = new NamedEntity(cas);
	    NE.setBegin(start);
	    NE.setEnd(stop);
	    NE.addToIndexes();
	  }

}
