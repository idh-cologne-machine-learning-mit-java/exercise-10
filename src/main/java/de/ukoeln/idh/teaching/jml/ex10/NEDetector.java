package de.ukoeln.idh.teaching.jml.ex10;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;

import java.util.List;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;


import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;


public class NEDetector extends JCasAnnotator_ImplBase{
    
    @Override
    public void process(JCas jcas) throws AnalysisEngineProcessException{
        for (Sentence s: jcas.select(Sentence.class)){  
            boolean firstWord = true; 
            for (Token t : jcas.select(Token.class).coveredBy(s).asList()){
                if(firstWord){
                    firstWord= false;
                    continue;
                }
                else if(Character.isUpperCase(t.getCoveredText().charAt(0)) && (t.getEnd()==t.getBegin()+1)){
                    /*Filters out I but other stopwords still present */
                    continue;
                }else if(Character.isUpperCase(t.getCoveredText().charAt(0)) && Character.isUpperCase(t.getCoveredText().charAt(1))){
                    continue;
                }else if(Character.isUpperCase(t.getCoveredText().charAt(0))){
                    int startIndex = t.getBegin();
                    
                    int endIndex = endOfEntity(t, s, jcas);
                    
                    NamedEntity ne = new NamedEntity(jcas, startIndex, endIndex);
                    ne.addToIndexes();
                }
                
            }

        }
    }

    public int endOfEntity (Token t, Sentence s, JCas jcas) {
   
        List<Token> sentenceTokens = jcas.select(Token.class).following(t.getEnd()-1).asList();
        
        if(Character.isUpperCase(sentenceTokens.get(0).getCoveredText().charAt(0))){
 
            return endOfEntity(sentenceTokens.get(0), s, jcas);     
        }
        return t.getEnd();
    }

}
