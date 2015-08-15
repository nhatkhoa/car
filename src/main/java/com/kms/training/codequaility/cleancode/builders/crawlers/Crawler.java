package com.kms.training.codequaility.cleancode.builders.crawlers;

import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.kms.training.codequaility.cleancode.builders.ChartErrorCode;
import com.kms.training.codequaility.cleancode.builders.ChartException;

public abstract class Crawler {

	public static Logger log = LogManager.getLogger(Crawler.class);
	protected String pathFileInput;
	protected Map<String, Double> values;

	public Crawler(String pathFileInput) throws ChartException {
		if (pathFileInput.isEmpty()) {
			throw new ChartException(ChartErrorCode.FILE_INPUT_NULL);
		}
		this.pathFileInput = pathFileInput;
		log.debug("Set input file path : " + pathFileInput);

	}

	protected abstract void parseData() throws Exception;

	public Map<String, Double> getValues() throws Exception {

		if (values == null)
			parseData();

		if (values.isEmpty()) {
			log.error("There no data in input file.");
			throw new ChartException(ChartErrorCode.DATA_EMPTY);
		}

		return this.values;
	}
}
