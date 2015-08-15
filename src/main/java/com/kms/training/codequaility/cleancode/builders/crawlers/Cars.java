/*
 * Copyright (c) 2015 KMS Technology, Inc.
 * Created Date : Aug 15, 2015
 * Author : khoahoang
 */
package com.kms.training.codequaility.cleancode.builders.crawlers;

/**
 * The car repository : include all of cars which same manufacture .
 */
public class Cars {

	/** The number of cars. */
	private int numOfCars;

	/** The sum speed of all car. */
	private Double sumOfSpeeds;

	/**
	 * Instantiates a new manufacture.
	 */
	public Cars() {
		numOfCars = 0;
		sumOfSpeeds = 0.0;
	}

	/**
	 * Adds the speed.
	 *
	 * @param speed
	 *            new speed of car which same manufacture
	 */
	public void addSpeed(Double speed) {
		if (speed > 0) {
			numOfCars++;
			sumOfSpeeds += speed;
		}
	}

	/**
	 * Gets the avg speed of car.
	 *
	 * @return Avg speed of all car same manufacture
	 */
	public Double getAvgSpeed() {
		if (numOfCars <= 0)
			return 0.0;
		return sumOfSpeeds / numOfCars;
	}

}
