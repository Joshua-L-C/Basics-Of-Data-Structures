package com.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class kDistinctArray {
	public String kthDistinct1(String[] arr, int k) {
        
        Map<String, Integer> distinct = new LinkedHashMap<String, Integer>();
        
    
        for(String x: arr){    
            distinct.put(x, distinct.getOrDefault(x, 0) + 1);
        }
        
        
        int counter = 1;    
        for(Map.Entry<String,Integer> entry: distinct.entrySet()){
            if(entry.getValue() == 1){
                
                if(counter == k){
                    return entry.getKey();
                }    
                
                counter++;
            }
        }
        
    
        
        return "";
    }

	public static void main(String[] args) {
		

	}

}
