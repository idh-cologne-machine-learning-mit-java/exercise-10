package de.ukoeln.idh.teaching.jml.ex10;

import java.util.HashMap;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.metadata.type.DocumentMetaData;
import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NELogger extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		DocumentMetaData meta = DocumentMetaData.get(jcas);
		System.out.println("### " + meta.getDocumentTitle() + " #####################");
		
		Map<String, Integer> freqs = new HashMap<String, Integer>();
		
		for (NamedEntity ne : jcas.select(NamedEntity.class)) {
			String text = ne.getCoveredText();
			
			if (!freqs.containsKey(text)) freqs.put(text, 1);
			else freqs.put(text, freqs.get(text)+1);
		}
		
		for (String key : freqs.keySet()) {
			int value = freqs.get(key);
			int i = -1;
			
			if ((i = key.indexOf("\n")) > -1) 
				key = key.substring(0, i).concat("...");
			
			System.out.println(value + " " + key);
		}
		
		System.out.println();
	}

}
