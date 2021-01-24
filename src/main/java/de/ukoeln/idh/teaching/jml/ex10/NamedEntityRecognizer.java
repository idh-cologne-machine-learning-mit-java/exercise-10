package de.ukoeln.idh.teaching.jml.ex10;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Sentence;
import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NamedEntityRecognizer extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
 
    for (Sentence sentence : aJCas.select(Sentence.class)) {
      
      Token[] tokens = aJCas.select(Token.class).coveredBy(sentence).asArray(Token.class);
      int namedEntityBeginning = -1;
      
      // ignore these chars at the beginning of a token
      String stopCharsRegEx = "[I]";
      
      // skip " char as first character/token
      int firstToken = 1;
      if (tokens.length > 1) {
        if (tokens[0].getCoveredText().equals("\"")) firstToken = 2;
      }

      // iterate over tokens in sentence, disregard first token
      for (int i=firstToken; i<tokens.length; i++) {
        
        char firstChar = tokens[i].getCoveredText().charAt(0);
        if (String.valueOf(firstChar).matches(stopCharsRegEx)) {
          if (tokens[i].getCoveredText().length() > 1) {
            firstChar = tokens[i].getCoveredText().charAt(1);
          } else {
            continue;
          }
        }
        
        if (Character.isUpperCase(firstChar)) {
          // first char of token is capitalized
          if (namedEntityBeginning == -1) {
            namedEntityBeginning = i;
          }
        } else {
          // first char is not capitalized
          if (namedEntityBeginning != -1) {
            // named entity ends
            int neBegin = tokens[namedEntityBeginning].getBegin();
            int neEnd = tokens[i-1].getEnd();
            
            addNamedEntity(aJCas, neBegin, neEnd);
            namedEntityBeginning = -1;
          }
        }

      }
    }
    
  }

  private void addNamedEntity(JCas JCas, int beginning, int end) {
    NamedEntity ne = new NamedEntity(JCas);
    ne.setBegin(beginning);
    ne.setEnd(end);
    ne.addToIndexes();
  }



}
