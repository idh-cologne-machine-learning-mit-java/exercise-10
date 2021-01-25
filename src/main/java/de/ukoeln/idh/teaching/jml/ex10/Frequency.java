package de.ukoeln.idh.teaching.jml.ex10;
import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;

import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class Frequency extends JCasAnnotator_ImplBase{

 	public void process(JCas aJCas) throws AnalysisEngineProcessException{
         
        HashMap<String, Integer> namedEntityCounter = new HashMap<String, Integer>();

 		for (NamedEntity ne: aJCas.select(NamedEntity.class)) {
 			String NamedEntityText = ne.getCoveredText();
 			if (namedEntityCounter.containsKey(NamedEntityText)) {
 				namedEntityCounter.put(NamedEntityText, namedEntityCounter.get(NamedEntityText) + 1);
 			} else {
 				namedEntityCounter.put(NamedEntityText, 1);
 			}
 		}

 	    for (String NamedEntityString : namedEntityCounter.keySet()) {
 			System.out.println(namedEntityCounter.get(NamedEntityString).toString() + " " + NamedEntityString);
 		}
 	}

} 