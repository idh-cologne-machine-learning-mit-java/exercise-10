package de.ukoeln.idh.teaching.jml.ex10;

import java.util.HashMap;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class FrequencyTablePrinter {
	
	 public void process(JCas cas) throws AnalysisEngineProcessException {
	    
	    HashMap<String, Integer> namedEntities = new HashMap<String, Integer>();
	    
	    for (NamedEntity ne : cas.select(NamedEntity.class)) {
	      
	      String text = ne.getCoveredText();
	      if (namedEntities.containsKey(ne.getCoveredText())) {
	    	  //add to HashMap
	    	  namedEntities.put(text, namedEntities.get(text) + 1);
	      } else {
	    	  
	    	  namedEntities.put(text, 1);
	      }

	    }
	    System.out.println("Frequency Table of Named Entities");
	    
	    for (String NEText : namedEntities.keySet()) {
	      // print out each line from entry
	      System.out.println(namedEntities.get(NEText).toString() + " " + NEText);
	    }
	    

	  }


}
