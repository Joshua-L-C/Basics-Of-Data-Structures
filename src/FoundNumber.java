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
    
    public static void addAtIndex(int[] array, int index, int value) {
    	
    	int holder = array[index];
    	array[index]= value;
    	int holder2 = array[index + 1];
    	
    	for(int runner = index + 1; runner < array.length && runner + 1 < array.length; runner++) {
    		
    		array[runner] = holder;
    		holder = holder2;
    		holder2 = array[runner + 1];
    		array[runner + 1] = holder2;
    	}
    	

		
    	
    }
	public static void main(String[] args) {
//		System.out.println(singleNumber(new int[]{-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354}));
//		
//		
//		System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1}));
//		System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
//		
//		int n = 1000;
//		int length = (int)(Math.log10(n)+1);
		
		int[] insertionArray = new int[]{0,1,2,3,4,5,0,0,0,0,0,0};
		
		System.out.println("InsertionArray: " + insertionArray.length);
		addAtIndex(insertionArray,2,4);
		addAtIndex(insertionArray,3,7);
		
		
		
		for(int val: insertionArray) {
			System.out.println(val);
		}
		
		
		
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
		
	
	}

}
