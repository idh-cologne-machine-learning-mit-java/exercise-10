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
                if(Character.isUpperCase(t.getCoveredText().charAt(0))){
                    int startIndex = t.getBegin();
                    int endIndex = endOfEntity(t, s, jcas);
                    NamedEntity ne = new NamedEntity(jcas, startIndex, endIndex);
                    ne.addToIndexes();
                }
            }

        }
    }

    public int endOfEntity (Token t, Sentence s, JCas jcas) {
        /*Not sure whether this starts at correct poition
        * but since I cannot test this
        * I just hope it works*/
        List<Token> sentenceTokens = jcas.select(Token.class).coveredBy(s).following(t.getEnd()).asList();
        
        
        if(Character.isUpperCase(sentenceTokens.get(0).getCoveredText().charAt(0))){
            return endOfEntity(sentenceTokens.get(0), s, jcas);     
        }
        return t.getEnd();
    }

}
