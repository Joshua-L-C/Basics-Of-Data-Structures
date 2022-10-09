package com.arrays;

import java.util.Arrays;

public class BeEqual {
	
	public boolean canBeEqual(int[] target, int[] arr) {
        int[] list = new int[1001];
        
        for(int runner = 0; runner < target.length; runner++){
            list[target[runner]] += 1;
            list[arr[runner]] -= 1;
        }
        
        for(int runner = 0; runner < list.length; runner++){
            if(list[runner] != 0){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean canBeEqual2(int[] target, int[] arr) {
        int[] firstArray = new int[1001];
        int[] secondArray = new int[1001];
        
        for(int runner = 0; runner < target.length; runner++){
            firstArray[target[runner]] += 1;
            secondArray[arr[runner]] += 1;
        }
        
        
        for(int runner = 0; runner < firstArray.length; runner++){
            if(firstArray[runner] != secondArray[runner]){
                return false;
            }
            
        }
        
        return true;
    }
    
    public boolean canBeEqual1(int[] target, int[] arr) {
        
        Arrays.sort(target);
        Arrays.sort(arr);
        
        
        for(int runner = 0; runner < target.length; runner++){
            if(target[runner] != arr[runner]){
                return false;
            }
        }
        
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
