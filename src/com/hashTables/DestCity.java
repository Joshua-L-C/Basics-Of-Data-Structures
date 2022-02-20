package com.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DestCity {
	
    public static String destCity(List<List<String>> paths) {
        
    	
    	HashMap<String, String> cityMap = new HashMap<String, String>();
    	String runnerCity = "";
    	for(List<String> x:paths) {
    		runnerCity = x.get(0);
    		cityMap.put(x.get(0), x.get(1));
    	}
    	
    	
    	
    	while(cityMap.containsKey(runnerCity)) {
    		runnerCity = cityMap.get(runnerCity);
    	}
    	
    	
    	return runnerCity;
    }
    
    
	public static void main(String[] args) {
		
		
		List<List<String>> cities = new ArrayList<List<String>>();
		cities.add(new ArrayList<String>(Arrays.asList("London", "New York")));
		cities.add(new ArrayList<String>(Arrays.asList("New York","Lima")));
		cities.add(new ArrayList<String>(Arrays.asList("Lima","Sao Paulo")));
		
		System.out.println(destCity(cities));
	}

}
