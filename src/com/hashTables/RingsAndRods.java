package com.hashTables;

import java.util.HashMap;
import java.util.Map.Entry;

public class RingsAndRods {
	
	
	/*
	 * Steps: 
	 * - create a hash map from 0 to 9 with the number as the key and boolean array as value
	 * - cutting up the string 2 spaces at a time assigning the color and the number.
	 *  
	 * 
	 */
	
    public static int countPoints(String rings) {
       HashMap<Integer,boolean[]> rods = new HashMap<Integer,boolean[]>();
       
       for(int col = 0,num = 1; num < rings.length(); col += 2,num += 2) {
    	   
    	   int rod = Integer.parseInt(rings.charAt(num)+"");
    	   
    	   if(rods.get(rod) != null) {
    		   boolean[] array = rods.get(rod);
    		   
    		   if(rings.charAt(col) == 'R') {
    			   array[0] = true;
    		   }else if(rings.charAt(col) == 'G') {
    			   array[1] = true;
    		   }else if(rings.charAt(col) == 'B') {
    			   array[2] = true;
    		   }
    		
    		   rods.put(rod,array);
    	   }else {
    		   boolean[] array = new boolean[] {false,false,false};
        	   
        	   if(rings.charAt(col) == 'R') {
    			   array[0] = true;
    		   }else if(rings.charAt(col) == 'G') {
    			   array[1] = true;
    		   }else if(rings.charAt(col) == 'B') {
    			   array[2] = true;
    		   }
        	   
        	   rods.put(rod, array);   
    	   }
    	   
    	   
       }
       
       int totalRods = 0;
       for(Entry<Integer, boolean[]> entry : rods.entrySet()) {
    	    	
    	   boolean toAdd = true;
    	   for(int runner = 0; runner < entry.getValue().length; runner++) {
    		   if(entry.getValue()[runner] == false) {
    			   toAdd = false;
    		   }
    	   }

    	   if(toAdd) {
    		   totalRods++;
    	   }
    	   
    	   
    	    // do what you have to do here
    	    // In your case, another loop.
    	}
    	
       
       return totalRods;
    }
	
	
	public static void main(String[] args) {
		System.out.println(countPoints("B0B6G0R6R0R6G9"));

	}

}
