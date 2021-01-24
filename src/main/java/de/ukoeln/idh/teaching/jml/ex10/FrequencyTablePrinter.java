package de.ukoeln.idh.teaching.jml.ex10;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;


public class FrequencyTablePrinter extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
    HashMap<String, Integer> namedEntitiesFrequencies = new HashMap<String, Integer>();
    
    for (NamedEntity ne : aJCas.select(NamedEntity.class)) {
      
      String neText = ne.getCoveredText();
      if (namedEntitiesFrequencies.containsKey(ne.getCoveredText())) {
        namedEntitiesFrequencies.put(neText, namedEntitiesFrequencies.get(neText) + 1);
      } else {
        namedEntitiesFrequencies.put(neText, 1);
      }

    }
    
    for (String neString : namedEntitiesFrequencies.keySet()) {
      System.out.println(namedEntitiesFrequencies.get(neString).toString() + " " + neString);
    }
    

  }

}
