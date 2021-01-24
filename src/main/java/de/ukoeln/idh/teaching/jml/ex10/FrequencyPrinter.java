package de.ukoeln.idh.teaching.jml.ex10;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;
import java.util.HashMap;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

public class FrequencyPrinter extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    
    HashMap<String, Integer> frequencies = new HashMap<String, Integer>();
    
    for (NamedEntity ne : aJCas.select(NamedEntity.class)) {
      String ne_string = ne.getCoveredText();   
      boolean frequencies_contain_ne = frequencies.containsKey(ne_string);    
      
      if (frequencies_contain_ne == true) {
    	  frequencies.put(ne_string, frequencies.get(ne_string) + 1);
      } else {
    	  frequencies.put(ne_string, 1);
      }

    }
    
    for (String neString : frequencies.keySet()) {
      System.out.println(frequencies.get(neString).toString() + " " + neString);
    }
    

  }

}
