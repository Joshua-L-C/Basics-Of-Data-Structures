import java.util.Arrays;

public class FoundNumber {
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        if(nums.length == 1){
            return nums[0];
        }
        
        if(nums[0] != nums[1]){
            return nums[0];
        } 
        
        if(nums[nums.length - 1] != nums[nums.length -2]){
            return nums[nums.length - 1];
        }
        
        int current = 0;
        int steps = 0;
        for(int runner = 0; runner < nums.length; runner++){
            
            current = nums[runner];
            
            while(current == nums[runner] && runner < nums.length){
                current = nums[runner];
                runner++;
                steps++;
            }
            
            if(steps == 1){
                return current;
            }
            
            steps = 0;
            runner--;
        }
        
        
        
        return 0;
    }
    
    public static int findMaxConsecutiveOnes(int[] nums) {
        
        int counter = 0;
        int longest = 0;
        
        for(int runner = 0; runner < nums.length; runner++){
            
            if(nums[runner] == 1){
                counter++;
            }else{
                if(counter > longest){
                    longest = counter;
                }
                
                counter = 0;
            }
            
        }
        
        if(counter > longest){
            longest = counter;
        }
        
        return longest;
        
    }
    
    public static void addAtIndexForward(int[] array, int index, int value) {
    	
    	int holder = array[index];
    	array[index]= value;
    	int holder2 = array[index + 1];
    	
    	for(int runner = index + 1; runner < array.length && runner + 1 < array.length; runner++) {
    		
    		array[runner] = holder;
    		holder = holder2;
    		holder2 = array[runner + 1];
    		
    	
    	}
    	array[array.length - 1] = holder;

		
    	
    }
    
    public static void addAtIndexBackward(int []array,int index,int value) {
    	
    	
    	//int holder = array[];
    	
    	int holder = array[index];
    	array[index] = value;
    	int holder2 = array[index - 1];
    	
    	
    	for(int runner = index - 1; runner > 0; runner--) {
    		array[runner] = holder;
    		holder = holder2;
    		holder2 = array[runner - 1];
    	}
    	
    	array[0] = holder;
    }
    
    public static int[] duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included  
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
        
        return arr;
    }
   
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
    	
    	
    	int runner = 0;
    	int runner1 = 0;
    	int runner2 = 0;
    	
    	int[] array = new int[nums1.length];
    	
    	for(;runner1 != m && runner2 != n;runner++) {
    		
    		if(nums1[runner1] <= nums2[runner2]) {
    			//System.out.println(nums1[runner1]);
    			array[runner] = nums1[runner1];
    			runner1++;
    		}else if(nums1[runner1] > nums2[runner2]) {
    			//System.out.println(nums2[runner2]);
    			array[runner] = nums2[runner2];
    			runner2++;
    		}
    		
    	}
    	
    	if(runner1 != m) {
    		for(;runner1 != m;runner1++,runner++) {
    			array[runner] = nums1[runner1];
    		}
    	}
    	
    	if(runner2 != n) {
    		for(;runner2 != n;runner2++,runner++) {
    			array[runner] = nums2[runner2];
    		}
    	}
    	
    	nums1 = null;
    	nums1 = array;
    	
    	for(int i: array) {
    		System.out.println(i);
    	}
    }
    
	public static void main(String[] args) {
		
		//Single Number and Max Consecutive Ones
//		System.out.println(singleNumber(new int[]{-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354}));
//		
//		System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1}));
//		System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
//		
//		int n = 1000;
//		int length = (int)(Math.log10(n)+1);

		
		//Array Addition Forward
//		int[] insertionArray = new int[]{0,1,2,3,4,5,0,0,0,0,0,0};
//		
//		System.out.println("InsertionArray: " + insertionArray.length);
//		addAtIndexForward(insertionArray,2,4);
//		addAtIndexForward(insertionArray,3,7);
//		
//		for(int val: insertionArray) {
//			System.out.println(val);
//		}		
//		
//		System.out.println();
//		
		//Array Addition Backwards
//		addAtIndexBackward(insertionArray, 5, 10);
//		addAtIndexBackward(insertionArray, 5, 11);
//	
//		for(int val: insertionArray) {
//			System.out.println(val);
//		}
//		
//		System.out.println();
//	
		
		
		
		//Duplicate Zeros 
//		insertionArray = new int[]{1,0,0,2,0,1,2};
//		insertionArray = duplicateZeros(insertionArray);
//		
//		for(int val: insertionArray) {
//			System.out.println(val);
//		}
		
//		int[] intArray = new int[6];
//		int length = 0;
//
//		// Add 3 elements to the Array
//		for (int i = 0; i < 3; i++) {
//		    intArray[length] = i;
//		    length++;
//		}
//		
//		
//		for(int val: intArray) {
//			System.out.println(val);
//		}
//		
//		
//		System.out.println();
//		for (int i = 3; i >= 0; i--) {
//		    intArray[i + 1] = intArray[i];
//		}
//
//		// Now that we have created space for the new element,
//		// we can insert it at the beginning.
//		intArray[0] = 20;
//		
//		for(int val: intArray) {
//			System.out.println(val);
//		}
		
//		[4,5,6,0,0,0]
//				3
//				[1,2,3]
//				3
		
		
//		[-1,0,0,3,3,3,0,0,0]
//				6
//				[1,2,2]
//				3

		int[] nums1 = new int[] {-1,0,0,3,3,3,0,0,0};
		int[] nums2 = new int[] {1,2,2};
		
		merge(nums1, 6,nums2,3);
		
//		for(int i : nums1) {
//			System.out.println(i);
//		}
	
	}

}
