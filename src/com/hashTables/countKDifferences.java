package com.hashTables;

import java.util.HashMap;

public class countKDifferences {
	
	public static int countKDifference(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int result = 0;
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(map.containsKey(nums[runner])){
                map.put(nums[runner],map.get(nums[runner]) + 1);
                nums[runner] = 0;
            }else {
            	map.put(nums[runner],1);
            }
                
        }
        
        
        for(int runner = 0; runner < nums.length; runner++){
        	
        	if(nums[runner] > 0) {
        		if(map.containsKey(Math.abs(nums[runner] + k)) && map.containsKey(nums[runner])) {
        			result += map.get(Math.abs(nums[runner] + k))  * map.get(nums[runner]);
        		}
        	}
        	
        }
        
        
        return result;
	}
	
	
	//Why is this broken
	public static int countKDifferenceBroken(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int result = 0;
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(map.containsKey(nums[runner])){
                map.put(nums[runner],map.get(nums[runner]) + 1);
                
            }else {
            	map.put(nums[runner],1);
            }
                
        }
        
        
        
        //We are going through the array here again 
        for(int runner = 0; runner < nums.length; runner++){
        	
        	//We dont need to check every key this defeats the whole purpose of
        	//a hash map
            for (int key: map.keySet()) {
              //System.out.println(key+ ":"+map.get(key));
              
            	 // This logic only works if the pairs made are all unique [] 
            	 // but if there is a number resued for example 3 in the second test case then it will
            	 // fail to pick it up because it is assigned to 0
                 if(Math.abs(nums[runner] - key) == k){
                     result += (map.get(key) * map.get(nums[runner]));    
                     map.put(key,0);
                     map.put(nums[runner],0);
                     break;
                 }
                
            }
        }
        System.out.println();
        
        
        return result;
    }
	
	
	
	public static int countKDifference5broken(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int result = 0; 
        
        for(int runner = 0; runner < nums.length; runner++){
        	int test = Math.abs(nums[runner] - k);
            if(map.containsKey(test)){
                map.put(test,map.get(test) + 1);
                
                result++;
                
            }else{
                map.put(nums[runner],0);
            }   
        }
        
        
        for (int key: map.keySet()) {
            result += map.get(key);
        }
           
        
        return result;
    }
	
	
	//Why was this wrong
    public static int countKDifference3(int[] nums, int k) {
        
        int[] numbLine = new int[101];
        int result = 0;
        
        
        for(int runner = 0; runner < nums.length; runner++){
            numbLine[nums[runner]] += 1;
        }
        
        //second index should really be k + 1
        for(int firstIndex = 1,secondIndex = k; secondIndex < numbLine.length; secondIndex++,firstIndex++){
            
        	
            if(numbLine[firstIndex] > 0 && numbLine[secondIndex] > 0){
                int secondHolder = numbLine[secondIndex];
                
                //this loop is bad because its trying to determine the number of pairs by subtraction 
                // when you could simply multiply the value at the first and second indexes and add the result to
                // result
                
                // what i was trying to do was subtract 1 from each position making them a pair but you 
                // can make a pair with the reuse of one element just by tying it to a different second element
                while(numbLine[firstIndex] > 0 && numbLine[secondIndex] > 0){
                    numbLine[firstIndex] -= 1;
                    numbLine[secondIndex] -= 1;
                    result++;
                }
                
                numbLine[secondIndex] = secondHolder;
            }
            
        }
        
        return result;
    }
	
    
    public static int countKDifference3Fixed(int[] nums, int k) {
        
        int[] numbLine = new int[101];
        int result = 0;
        
        
        for(int runner = 0; runner < nums.length; runner++){
            numbLine[nums[runner]] += 1;
        }
        
        //second index should really be k + 1
        for(int firstIndex = 1,secondIndex = k + 1; secondIndex < numbLine.length; secondIndex++,firstIndex++){
            
        	
            if(numbLine[firstIndex] > 0 && numbLine[secondIndex] > 0){
                //int secondHolder = numbLine[secondIndex];
                
                //this loop is bad because its trying to determine the number of pairs by subtraction 
                // when you could simply multiply the value at the first and second indexes and add the result to
                // result
                
                // what i was trying to do was subtract 1 from each position making them a pair but you 
                // can make a pair with the reuse of one element just by tying it to a different second element
                // while(numbLine[firstIndex] > 0 && numbLine[secondIndex] > 0){
                //     numbLine[firstIndex] -= 1;
                //     numbLine[secondIndex] -= 1;
                //     result++;
                // }
                
                result += numbLine[firstIndex] * numbLine[secondIndex];
                
                //numbLine[secondIndex] = secondHolder;
            }
            
        }
        
        return result;
    }
    
    
    //Why was this wrong
    public static int countKDifference2Broken(int[] nums, int k) {
        
        int result = 0;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        
        for(int runner = 0; runner < nums.length; runner++){
        	
        	//The logic here was wrong because you get the absolute value
        	//really what this ends up giving you is the number of unique valued pairs 
        	//because all its checking for is a number that meets the absolute value criteria 
            if(map.containsKey(Math.abs(nums[runner] - k))){
                result++;
            }
            
            //This isint contained in an else block so this is always going to run 
            //and all it does is tie the index with the current key to its current value 
            map.put(nums[runner],runner);
        }    
        return result;
    }
    
	public static void main(String[] args) {
//		int[] nums = new int[] {3,2,1,5,4};
//		int k = 2;
		
//		int[] nums = new int[] {1,2,2,1};
//		int k = 1;
		
		int[] nums = new int[] {7,7,8,3,1,2,7,2,9,5};
		int k = 6;
				
		
		System.out.println(countKDifference(nums, k));

	}

}
