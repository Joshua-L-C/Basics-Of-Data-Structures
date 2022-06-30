package com.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DestCity {
	
	public static String destCity(List<List<String>> paths) {
	     
        String currentCity = paths.get(0).get(1);
        System.out.println("Current City: "+currentCity);
        String endingCity = recur(paths,currentCity,1);
        
        
        return endingCity;
    }
    
	public static String recur(List<List<String>> paths, String currentCity,int index) {
		 if(index == paths.size()){
	            
	            if(paths.get(index - 1).get(0) != currentCity){
	                return currentCity;
	            }else{
	                currentCity = paths.get(index - 1).get(1);
	                recur(paths,currentCity,0);
	            }
	            
	            
	        }
	        
	        
	        if(paths.get(index).get(0) == currentCity){
	            
	            currentCity = paths.get(index).get(1);
	            currentCity = recur(paths,currentCity,0);
	            
	        }else{
	            
	            currentCity = recur(paths,currentCity,index + 1);
	        }
	        
	        
	       return currentCity;
	}
	
    public static String recurOld(List<List<String>> paths, String currentCity,int index){
        
        if(index == paths.size()){
            
            if(paths.get(index - 1).get(1) != currentCity){
            	currentCity = paths.get(index).get(1);
            	recur(paths,currentCity,0);
            }else{
                return currentCity;    
            }
        }
        
        //System.out.println(paths.get(index).get(0));
        
        if(paths.get(index).get(0) == currentCity){
            currentCity = paths.get(index).get(1);
            currentCity = recur(paths,currentCity,0);
        }else{
        	currentCity = recur(paths,currentCity,index + 1);
        }
        
        return currentCity;
    }
    
    
    public static String destCity1(List<List<String>> paths) {
        
    	
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
		cities.add(new ArrayList<String>(Arrays.asList("Sao Paulo","L.A")));
		cities.add(new ArrayList<String>(Arrays.asList("Lima","Sao Paulo")));
		
//		
//		cities = null;
//		cities = new ArrayList<List<String>>();
//		cities.add(new ArrayList<String>(Arrays.asList("B", "C")));
//		cities.add(new ArrayList<String>(Arrays.asList("D","B")));
//		cities.add(new ArrayList<String>(Arrays.asList("C","A")));
		
		
		
		
		System.out.println(destCity(cities));
	}

}
