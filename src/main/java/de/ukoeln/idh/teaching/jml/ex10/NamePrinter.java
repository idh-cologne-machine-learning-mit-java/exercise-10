package de.ukoeln.idh.teaching.jml.ex10;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;
import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;



public class NamePrinter extends JCasAnnotator_ImplBase{

	@Override
	public void process(JCas cas) throws AnalysisEngineProcessException {

	    HashMap<String, Integer> entities = new HashMap<String, Integer>();

	    for (NamedEntity entity : cas.select(NamedEntity.class)) {

	      String entityString = entity.getCoveredText();
	      
	      if (entities.containsKey(entity.getCoveredText())) {

	    	  entities.put(entityString, entities.get(entityString) + 1);
	    	  
	      } else {

	    	  entities.put(entityString, 1);
	      }

	    }
	    System.out.println("Named Entities: ");

	    for (String entityString : entities.keySet()) {
	 
	      System.out.println(entities.get(entityString).toString() + " " + entityString);
	    }


	  }

}
