package com.arrays;

public class MaxProductDifference {
	
	public static int maxProductDifference(int[] nums) {
        
        int lowest = nums[0];
        int greatest = nums[0] + 1;
        int secondLowest = nums[0];
        int secondGreatest = nums[0];
        
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(nums[runner] < lowest){
                secondLowest = lowest;
                lowest = nums[runner];
            }else if(nums[runner] > greatest){
                secondGreatest = greatest;
                greatest = nums[runner];
            }else if(nums[runner] < secondLowest && (nums[runner] != lowest)){
                secondLowest = nums[runner];
            }else if(nums[runner] > secondGreatest && (nums[runner] != greatest)){
                secondGreatest = nums[runner];
            }
        }
        
        
        System.out.println("Lowest: " + lowest);
        System.out.println("secondLowest: " + secondLowest);
        System.out.println("secondGreatest: " + secondGreatest);
        System.out.println("greatest: " + greatest);
        
        return ((greatest * secondGreatest) - (lowest * secondLowest));
    }
	

	public static void main(String[] args) {
		System.out.println(maxProductDifference(new int[] {1,6,7,5,2,4,10,6,4}));

	}

}
