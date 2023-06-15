package com.java.ml.storm_reports_record_reader;

import java.util.Date;

import javax.xml.validation.Schema;

import org.datavec.api.transform.TransformProcess;

public class StormReportsRecordReader {

	public static void main(String[] args) {
		int numOfLinesToSkip = 0;
		String delimiter = ",";

		/*
		 * Specifying the root directory
		 */

		String baseDir = "/Users/guilh/MLPLinearClassifier/data/reports/";
		String fileName = "reports.csv";
		String inputPath = baseDir + fileName;
		String timeStamp = String.valueOf(new Date().getTime());
		String outputPath = baseDir + "reports_processed_" + timeStamp;

		org.datavec.api.transform.schema.Schema inputDataSchema = new org.datavec.api.transform.schema.Schema.Builder()
				.addColumnsString("", "", "", "", "", "")
				.addColumnDouble(fileName, null, null)
				.addColumnsString("comment")
				.addColumnCategorical("", "", "", "")
				.build();
		
		/*
		 * Defining a transform process to extract lat and lon
		 * and also transform type from one of the three strings
		 * to either 0, 1 or 2
		 */
		
		TransformProcess tp = new TransformProcess.Builder(inputDataSchema)
				.removeColumns("", "", "", "", "", "")
				.categoricalToInteger("")
				.build();
		
		/*
		 * Stepping through and printing the before and
		 * after Schema
		 */
		
		int numActions = tp.getActionList().size();
		for (int i = 0; i < numActions; i++) {
			System.out.println("\n\n=======================");
			System.out.println("--- Schema after step " + i + " (" + tp.getActionList().get(i) + ")--");
			System.out.println(tp.getSchemaAfterStep(i));
		}
	}
}
