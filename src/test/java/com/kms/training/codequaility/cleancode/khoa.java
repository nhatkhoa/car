package com.kms.training.codequaility.cleancode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class khoa {

	@Before
	public void beforeTest(){
		
	}
	
	@After
	public void afterTest(){
		
	}
	
	@Test
	public void test() throws IOException {
		
		long startTime = System.currentTimeMillis();
		
		Map<String, OT> ots = new HashMap<String,OT>();
		
		
		// Open the file
		BufferedReader br = Files.newBufferedReader(Paths.get("car.txt"));
		String strLine;
		br.readLine();
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			// Split 'tab' delimiter
			String[] tabs = strLine.split("\\t");
			String name = tabs[1];
			Double speed = Double.parseDouble(tabs[2]);
			
			try{
				ots.get(name).setSum(ots.get(name).getSum() + speed);
				ots.get(name).setCount(ots.get(name).getCount() + 1);
			}
			catch(NullPointerException e){
				OT ot = new OT(name);
				ot.setCount(1);
				ot.setSum(speed);
				ots.put(name, ot);
			}
		}
		// Close the input stream
		br.close();
		
		for(Entry<String,OT> ot : ots.entrySet()){
			System.out.format("- name = %s -- count = %s  -- speed = %s \n", ot.getKey(), ot.getValue().getCount(), ot.getValue().getSum());
		}
		
		
		
	}

}
