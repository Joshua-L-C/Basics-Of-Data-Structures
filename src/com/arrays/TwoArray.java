package com.arrays;

import java.util.ArrayList;
import java.util.List;

public class TwoArray {
	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        
        boolean skip = false;
        
        for(int runner = 0; runner < nums1.length; runner++){
        	
        	skip = false;
        	
            for(int runnerTwo = 0; runnerTwo < nums2.length; runnerTwo++){
                if(nums1[runner] == nums2[runnerTwo]){
                    skip = true;
                    break;
                }
            }
            
            if(!skip){
                list1.add(nums1[runner]);
            }
        }
        
        
        
        for(int runner = 0; runner < nums2.length; runner++){
        	
        	skip = false;
        	
            for(int runnerTwo = 0; runnerTwo < nums1.length; runnerTwo++){
                if(nums2[runner] == nums1[runnerTwo]){
                    skip = true;
                    break;
                }
                
                
            }
            
            if(!skip){
                list2.add(nums2[runner]);
            }
        }
        
//        for(int runner = 0 ; runner < list1.size();runner++){
//            System.out.println(list1.get(runner));
//        }
//        
//        for(int runner = 0 ; runner < list2.size();runner++){
//            System.out.println(list2.get(runner));
//        }
        
        
        List<ArrayList<Integer>> sendBackList = new ArrayList<ArrayList<Integer>>();
        
        return null;
    }
	
	public List<List<Integer>> findDifferenceFast(int[] nums1, int[] nums2) {
	     
		List<List<Integer>> outerList = new ArrayList<>();
				List<Integer> innerList1 = new ArrayList<>();
				List<Integer> innerList2 = new ArrayList<>();

				boolean b1[] = new boolean[2001];
				boolean b2[] = new boolean[2001];

				for (int i : nums1) {
					b1[i + 1000] = true;
				}

				for (int i : nums2) {
					b2[i + 1000] = true;
				}

				for (int i : nums1) {
					if (!b2[i + 1000] && b1[i + 1000]) {
						b1[i + 1000] = false;
						innerList1.add(i);
					}
				}

				for (int i : nums2) {
					if (!b1[i + 1000] && b2[i + 1000]) {
						b2[i + 1000] = false;
						innerList2.add(i);
					}
				}

				outerList.add(innerList1);
				outerList.add(innerList2);

				return outerList;
		    }
	
	 public static int recursiveValue(int result, int position, String[] operations){
	        
	        if(position == operations.length - 1){
	            
	            if(operations[position].charAt(1) == '-'){
	                result--;
	            }else{
	                result++;
	            }
	            
	            return result;
	        }
	        
	        
	            if(operations[position].charAt(1) == '-'){
	                result = recursiveValue(result - 1,position + 1,operations);
	            }else{
	                result = recursiveValue(result + 1,position + 1,operations);
	            }
	        
	        return result;
	        
	    }
	
	public static void main(String[] args) {
//		int[] nums1 = new int[] {1,2,3};
//		int[] nums2 = new int[] {2,4,6};
//		findDifference(nums1, nums2);
		
		String[] operations = new String[] {"++X","++X","X++"};
		int res = 0;
		System.out.println(recursiveValue(res, 0, operations));
		
		
	}

}
