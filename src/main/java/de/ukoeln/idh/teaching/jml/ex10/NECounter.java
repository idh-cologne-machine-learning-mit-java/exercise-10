package de.ukoeln.idh.teaching.jml.ex10;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.dkpro.core.api.io.JCasFileWriter_ImplBase;

import de.ukoeln.idh.teaching.jml.ex10.types.NamedEntity;

public class NECounter extends JCasFileWriter_ImplBase {

	@Override
	public void process(JCas jcas) throws AnalysisEngineProcessException {
		Map<String, Integer> counts = new HashMap<String, Integer>();

		for (NamedEntity ne : jcas.select(NamedEntity.class)) {
			String neSurface = ne.getCoveredText();
			if (counts.containsKey(neSurface))
				counts.put(neSurface, counts.get(neSurface) + 1);
			else
				counts.put(neSurface, 1);
		}

		try {
			OutputStreamWriter osw = new OutputStreamWriter(getOutputStream(jcas, ".txt"));
			for (String s : counts.keySet()) {
				osw.write(String.valueOf(counts.get(s)));
				osw.write(" ");
				osw.write(s);
				osw.write('\n');
			}
		} catch (IOException e) {
			throw new AnalysisEngineProcessException(e);
		}

	}

}
