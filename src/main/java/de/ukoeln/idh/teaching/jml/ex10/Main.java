package de.ukoeln.idh.teaching.jml.ex10;

import java.io.IOException;

import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.dkpro.core.io.text.TextReader;
import org.dkpro.core.tokit.BreakIteratorSegmenter;

public class Main {

	static JCas jcas;

	public static void main(String[] args) throws ResourceInitializationException, CASException,
			AnalysisEngineProcessException, CollectionException, IOException {
		CollectionReaderDescription crd = CollectionReaderFactory.createReaderDescription(TextReader.class);

		AnalysisEngineDescription tokenizer = AnalysisEngineFactory
				.createEngineDescription(BreakIteratorSegmenter.class);

		SimplePipeline.runPipeline(crd, tokenizer);

	}

}
