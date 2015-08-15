/*
 * Copyright (c) 2015 KMS Technology, Inc.
 * Created Date : Aug 15, 2015
 * Author : khoahoang
 */
package com.kms.training.codequaility.cleancode.builders.charts;

import java.awt.image.BufferedImage;

/**
 * Feature : get output of chart.
 */
public interface ChartOutput {

	/**
	 * Write chart to new image file.
	 *
	 * @param filePath
	 *            the path of file which will be stored image of chart.
	 */
	void writeToFile(String filePath);

	/**
	 * Get buffered of chart image after generated.
	 *
	 * @return the chart under BufferedImage format.
	 */
	BufferedImage getImage();
}
