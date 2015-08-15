package com.kms.training.codequaility.cleancode.builders.crawlers;

import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.kms.training.codequaility.cleancode.builders.ChartException;

public class CarSpeedCrawlerTest {
	@Before
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
	}

	@Test
	public void testGetValues() {
		try {
			Crawler speedCrawler = new CarSpeedCrawler("car.txt");
			Assert.assertFalse(speedCrawler.getValues().size() == 0);

		} catch (ChartException e) {
			System.out.println(e.getCode().name());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

	}

}
