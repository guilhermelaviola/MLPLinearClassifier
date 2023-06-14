package com.java.ml.linear_classifier;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.List;

import org.datavec.api.conf.Configuration;
import org.datavec.api.exceptions.UnknownFormatException;
import org.datavec.api.records.Record;
import org.datavec.api.records.listener.RecordListener;
import org.datavec.api.records.metadata.RecordMetaData;
import org.datavec.api.records.reader.RecordReader;
import org.datavec.api.records.reader.factory.RecordReaderFactory;
import org.datavec.api.records.reader.impl.csv.CSVRecordReader;
import org.datavec.api.split.FileSplit;
import org.datavec.api.split.InputSplit;
import org.datavec.api.writable.Writable;
import org.deeplearning4j.datasets.datavec.RecordReaderDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

public class MLPLinearClassifier {
	public static void main(String[] args) {
		int seed = 123;
		double learningRate = 0.01;
		int batchSize = 50;
		int numEpochs = 30;
		int numInputs = 2;
		int numOutputs = 2;
		int numHiddenNodes = 20;
		
		// Configuring how the data is gonna be loaded
		// Loading the training data
		RecordReader rr = new CSVRecordReader();
		rr.initialize(new FileSplit(File("")));
		DataSetIterator trainIterator = new RecordReaderDataSetIterator(rr, batchSize, 0, 2);
		
		// Loading the test-evaluation data
		RecordReader rrTest = new CSVRecordReader();
		rrTest.initialize(new FileSplit(File("")));
		DataSetIterator testIterator = new RecordReaderDataSetIterator(rrTest, batchSize, 0, 2);
		
		// Building the network
		
	}
}
