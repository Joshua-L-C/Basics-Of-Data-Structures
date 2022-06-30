package com.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
	
	
	   public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
	        ArrayList<Boolean> result = new ArrayList<Boolean>();
	        
	        for(int runner = 0; runner < candies.length; runner++){
	            result.add(false);
	        }
	        
	        
	        recur(candies, extraCandies, result,0,0);
	        
	        return result;
	    }
	    
	    
	    public int recur(int[] candies, int extraCandies,ArrayList<Boolean> result, int index, int biggest){
	        
	        if(index == candies.length){
	            return biggest;
	        }
	        
	        if(candies[index] > biggest){
	            biggest = candies[index];
	        }
	        
	        biggest = recur(candies,extraCandies,result,index + 1,biggest);
	        
	        if((candies[index] + extraCandies) >= biggest){
	            //result[index] = true;
	            result.set(index,true);
	        }
	        
	        return biggest;
	        
	    }

	    
	    
	    /*
	        1) Create a result array 
	        2) Create a recursive function that takes in candies, extraCandies and the result array an index variable plus a variable called biggest
	        3) The recursion stops when the index is equal to the length of the candies array
	        4) In the first part check if the current candie is bigger than the biggest if it is then we assign it to biggest
	        5) Increment the index variable by 1 and call the function again.
	        6) Assign biggest again to what the function returns.
	        7) When the index is equal to the candies length return the biggest variable 
	        8) On return of the biggest from the function check if the current candie at the index plus the extra candie is greater than the biggest
	           TRUE: assign the current index of the result array to true;
	           FALSE: assign the current index of the result array to false;

	    */
	    public List<Boolean> kidsWithCandies2(int[] candies, int extraCandies) {
	        List<Integer> arr = Arrays.asList(new Integer[10]);
	        Boolean[] result = new Boolean[candies.length];
	        
	        recur1(candies, extraCandies, result,0,0);
	        
	        return Arrays.asList(result);
	    }
	    
	    
	    public int recur1(int[] candies, int extraCandies,Boolean[] result, int index, int biggest){
	        
	        if(index == candies.length){
	            return biggest;
	        }
	        
	        if(candies[index] > biggest){
	            biggest = candies[index];
	        }
	        
	        biggest = recur1(candies,extraCandies,result,index + 1,biggest);
	        
	        if((candies[index] + extraCandies) >= biggest){
	            result[index] = true;
	        }else{
	            result[index] = false;
	        }
	        
	        return biggest;
	        
	    }
	    
	    
	    /*
	        1) Create a result array
	        2) Cycle through candies and find the greatest number.
	        3) Cycle through the array of candies add the extraCandies to the current index and 
	           updating the result array with true if it is greater than the bigest when the extra candies are added
	           or false when it is not.
	    */
	    public List<Boolean> kidsWithCandies1(int[] candies, int extraCandies) {
	        
	        List<Boolean> result = new ArrayList<Boolean>();
	        
	        int biggest = candies[0];
	        
	        
	        for(int runner = 0; runner < candies.length; runner++){
	            if(candies[runner] > biggest){
	                biggest = candies[runner];
	            }
	            
	            candies[runner] += extraCandies;
	        }
	        
	        for(int runner = 0; runner < candies.length; runner++){
	            
	            //System.out.println("Candies: " + candies[runner]);
	            //System.out.println("Biggest: " + candies[runner]);
	            
	            if(candies[runner] >= biggest){
	                result.add(true);
	            }else{
	                result.add(false);
	            }
	        }
	        
	        
	        return result;
	    }

	public static void main(String[] args) {
		

	}

}
