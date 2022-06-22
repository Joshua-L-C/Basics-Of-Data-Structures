package com.hashTables;

public class AreOccurrencesEqual {
	
	 public static boolean areOccurrencesEqual(String s) {
	        
	        int[] table = new int[123];
	        boolean equals = recur(s.toCharArray(),0,table);
	        
	        return equals;
	    }
	    
	    
	    public static boolean recur(char[] array,int index, int[] table){
	        
	        
	        if(index == array.length){
	            int starterIndex = 97;
	            int previousValue = 0;
	        
	            for(; table[starterIndex] == 0; starterIndex++){}
	            //System.out.println("Starter Index: " + starterIndex);
	            previousValue = table[starterIndex];
	            //System.out.println("Previous Value: " + previousValue);
	        
	        
	            for(; starterIndex < table.length; starterIndex++){
	                if( table[starterIndex] > 0 && table[starterIndex] != previousValue){
	                    return false;
	                }
	            }
	        
	        
	            return true;
	        }
	        
	        table[array[index]] += 1;
	        
	        boolean value = recur(array,index + 1,table);
	        
	        return value;
	    }

	public static void main(String[] args) {
		String test = "abacbc";
		System.out.println(areOccurrencesEqual(test));

	}

}
