package com.arrays;

import java.util.Arrays;

public class MaxProductDifference {
	
	public static int maxProductDifference(int[] nums) {
        
        int[] answerArray = new int[4];
        answerArray[0] = nums[0];
        answerArray[3] = nums[0];
        
        recur(nums,answerArray,0,0,0);
        
        System.out.println(answerArray[3]);
        System.out.println(answerArray[2]);
        System.out.println(answerArray[1]);
        System.out.println(answerArray[0]);
        
        System.out.println();
        
        return (answerArray[3] * answerArray[2]) - (answerArray[1] * answerArray[0]);
        
    }
    
    public static int[] recur(int[] nums,int[] answerArray,int index,int lowIndex, int highIndex){
        
        if(index == nums.length){
            nums[lowIndex] = -1;
            nums[highIndex] = -1;
            
             lowIndex = 0;
        
            while(nums[lowIndex] == -1){
                lowIndex++;
            }
            
            answerArray[1] = nums[lowIndex];
            answerArray[2] = nums[lowIndex];
            
            return nums;
        }
        
        if(nums[index] > answerArray[3]){
            answerArray[3] = nums[index];
            highIndex = index;
        }
        
        if(nums[index] < answerArray[0]){
            answerArray[0] = nums[index];
            lowIndex = index;
        }
        
        
        nums = recur(nums,answerArray,index+1,lowIndex, highIndex);
        
        if(nums[index] > answerArray[2]){
            answerArray[2] = nums[index];
        }
        
        if(nums[index] < answerArray[1] && nums[index] != -1){
            answerArray[1] = nums[index];
        }
        
        
        return nums;
    }
    
    public static int maxProductDifference2(int[] nums) {
        Arrays.sort(nums);
        
        return (nums[nums.length - 1] * nums[nums.length -2]) - (nums[0] * nums[1]);
    }
    
    public static int maxProductDifference1(int[] nums) {
        
        int lowest = nums[0];
        int greatest = nums[0];
        
        int lowIndx = 0;
        int greatIndx = 0;
        
    
        for(int runner = 0; runner < nums.length; runner++){
            
            if(nums[runner] < lowest){
                lowest = nums[runner];
                lowIndx = runner;
            }else if(nums[runner] > greatest){
                greatest = nums[runner];
                greatIndx = runner;
            }
        }
        
        nums[lowIndx] = -1;
        nums[greatIndx] = -1;
        
        lowIndx = 0;
        
        while(nums[lowIndx] == -1){
            lowIndx++;
        }
        int secondLowest = nums[lowIndx];;
        int secondGreatest = nums[lowIndx];;
        
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(nums[runner] < secondLowest && nums[runner] != -1){
                secondLowest = nums[runner];
                
            }else if(nums[runner] > secondGreatest ){
                secondGreatest = nums[runner];
                
            }
        }
        

        
        return ((greatest * secondGreatest) - (lowest * secondLowest));
    }
	

	public static void main(String[] args) {
		//System.out.println(maxProductDifference(new int[] {1,6,7,5,2,4,10,6,4}));
		
		int number = 101; // = some int

		while (number > 0) {
			System.out.println("Number: "+number);
		    System.out.println( number % 10);
		    number = number / 10;
		}

	}

}
