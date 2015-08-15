/*
 * Copyright (c) 2015 KMS Technology, Inc.
 * Created Date : Aug 15, 2015
 * Author : khoahoang
 */
package com.kms.training.codequaility.cleancode.builders.crawlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.kms.training.codequaility.cleancode.builders.ChartErrorCode;
import com.kms.training.codequaility.cleancode.builders.ChartException;

public class CarSpeedCrawler extends Crawler {
	private Logger log = LogManager.getLogger(CarSpeedCrawler.class);

	private Map<String, Cars> carsByManufacture;

	public CarSpeedCrawler(String pathFileInput) throws Exception {
		super(pathFileInput);
	}

	@Override
	protected void parseData() throws Exception {
		try {
			long startTime = System.nanoTime();
			carsByManufacture = new HashMap<String, Cars>();
			BufferedReader inputFile = Files.newBufferedReader(Paths.get(super.pathFileInput));

			// Ignore line header
			inputFile.readLine();

			String strLine;
			while ((strLine = inputFile.readLine()) != null) {
				addSpeed(strLine);
			}
			summaryValues();
			log.info(String.format("We spent %s nanosecond for collect car speed from file.",
					System.nanoTime() - startTime));

		} catch (IOException e) {
			log.error("Can not read input database file.", e);
			throw new ChartException(ChartErrorCode.READ_FILE_ERROR);
		} catch (Exception e) {
			log.error(e);
			throw e;
		}

	}

	private void summaryValues() {
		values = new HashMap<String, Double>();
		for (Entry<String, Cars> manufacture : carsByManufacture.entrySet()) {
			values.put(manufacture.getKey(), manufacture.getValue().getAvgSpeed());
			log.info(String.format("Add new avg speed of %s : %s", manufacture.getKey(),
					manufacture.getValue().getAvgSpeed()));
		}
	}

	private void addSpeed(String strLine) {

		try {
			String[] values = strLine.split("\\t");
			String manufacture = values[1];
			Double speed = Double.parseDouble(values[2]);
			log.debug("Readline " + manufacture + " - " + speed);
			try {
				carsByManufacture.get(manufacture).addSpeed(speed);
			} catch (NullPointerException nullPointer) {
				Cars cars = new Cars();
				cars.addSpeed(speed);
				carsByManufacture.put(manufacture, cars);
			}
		} catch (NumberFormatException e) {
			log.debug("Ignore line : " + strLine);

		}

	}

}
