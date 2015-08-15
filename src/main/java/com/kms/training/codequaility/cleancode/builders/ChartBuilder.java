/*
 * Copyright (c) 2015 KMS Technology, Inc.
 * Created Date : Aug 15, 2015
 * Author : khoahoang
 */
package com.kms.training.codequaility.cleancode.builders;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.kms.training.codequaility.cleancode.builders.charts.Chart;

/**
 * The Class ChartBuilder.
 */
@SuppressWarnings("unused")
public abstract class ChartBuilder {

	public static Logger log = LogManager.getLogger(ChartBuilder.class);

	private String pathFileInput;

	/**
	 * Instantiates a new chart builder.
	 *
	 * @param fileInput
	 *            Path to input database file.
	 */
	public ChartBuilder(String pathFileInput) throws ChartException {
		this.pathFileInput = pathFileInput;
	}

	/**
	 * Gets the chart.
	 *
	 * @return the chart
	 */
	public abstract Chart getChart();

}
