package com.kms.training.codequaility.cleancode.builders.charts;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

@SuppressWarnings("unused")
public abstract class Chart {

	private String title;
	private int width;
	private int height;
	private Map<String, Double> values;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setValues(Map<String, Double> values) {
		this.values = values;
	}

	protected abstract BufferedImage draw();

	/**
	 * Write chart to new image file.
	 *
	 * @param filePath
	 *            the path of file which will be stored image of chart.
	 */
	public void writeToFile(String filePath) throws IOException {

	}

	/**
	 * Get buffered of chart image after generated.
	 *
	 * @return the chart under BufferedImage format.
	 */
	public BufferedImage getImage() throws Exception {

		return null;
	}

}
