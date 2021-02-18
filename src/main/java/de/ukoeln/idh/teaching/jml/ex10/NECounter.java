package de.ukoeln.idh.teaching.jml.ex10;
import java.util.HashMap;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;


import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;


public class NECounter extends JCasAnnotator_ImplBase{
    @Override
    public void process(JCas jcas) throws AnalysisEngineProcessException{
        HashMap<String, Integer> totalNEEntities = new HashMap<String, Integer>();

        for (NamedEntity ne : jcas.select(NamedEntity.class)){
            if(totalNEEntities.containsKey(ne.getCoveredText())){
                totalNEEntities.put(ne.getCoveredText(), totalNEEntities.get(ne.getCoveredText()) + 1);
            }else{
                totalNEEntities.put(ne.getCoveredText(), 1);
            }
        }
        System.out.println("Named Entities in Corpus: ");
        for(String neString : totalNEEntities.keySet()){
            System.out.println(totalNEEntities.get(neString).toString() + " " + neString);
        }
    }
}
