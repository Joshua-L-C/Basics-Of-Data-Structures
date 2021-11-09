import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

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
    	
  
    	
    	
    	for(int newRunner = 0; newRunner < array.length; newRunner++) {
    		nums1[newRunner] = array[newRunner];
    	}
    }
    
    
    
    
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
    	
    	
    	int runner = 0;
    	int runner1 = 0;
    	int runner2 = 0;
    	
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	
    	
    	for(; (runner1 != m && runner2 != n) || !queue.isEmpty();) {
    		
    	
    		
    	}
    	

    	
    	//nums1 = null;
    	//nums1 = array;
    	
    	for(int i: nums1) {
    		System.out.println(i);
    	}
    }
 
 	public static int removeElementWithQueue(int[] nums, int val) {
     /*
         Steps:
         - Create a loop that will run through the array as well as an index queue
         - If you see a number that is VAL remove it by making it MAX
         - Record the index in the index queue
         - Move on to the next value 
         
         Cases:
         - What if the next value in the queue is a VAL
         ANS: Just add the value to the index queue
         
         - What if its not the VAL
         ANS: Swap the value at the current index with the index that you 
         poll off the index queue.Then add the current index to the index queue.
     */
 	   int removed = 0;
       Queue<Integer> indexQueue = new LinkedList<Integer>();
       
       for(int runner = 0; runner < nums.length; runner++){
           if(indexQueue.isEmpty()){
               if(nums[runner] == val){
                   removed++;
                   nums[runner] = Integer.MAX_VALUE;
                   indexQueue.add(runner);
               }
           }else if(!indexQueue.isEmpty()){
               if(nums[runner] == val){
                   removed++;
                   nums[runner] = Integer.MAX_VALUE;
                   indexQueue.add(runner);
               }else if(nums[runner] != val){
                   int holder = nums[runner];
                   int index = indexQueue.poll();
                   nums[index] = holder;
                   nums[runner] = Integer.MAX_VALUE;
                   indexQueue.add(runner);
               }
               
           }
       }
       
//       for(int i: nums) {
//    	   System.out.println(i);
//       }
       
       return removed;
 		
 	}
 	
 	public static int removeElementWithPointers(int [] nums, int val) {
 		
// 		for(int runner = 0, otherRunner = 0; runner < nums.length; runner++) {
// 			System.out.println("Regular Runner");
// 			System.out.println(nums[runner]);
// 			System.out.println();
// 			System.out.println("Other Runner");
// 			System.out.println(nums[otherRunner++]);
// 			
// 		}
 		
// 		if(nums.length == 0) {
// 			return 0;
// 		}if(nums.length == 1) {
// 			
// 			if(nums[0] == val) {
// 				return 0;
// 			}else {
// 				return 1;
// 			}
// 		}
// 		
// 		
// 		
// 		//return 0;
// 		int front = 0;
// 		int back = nums.length - 1;
// 		int removed = 0;
// 		
// 		
// 		while(front <= back) {
//
// 			if(nums[front] == val) {
// 				
// 				
// 				if(nums[back] != val) {
// 					
// 					
// 					int holder = nums[back];
// 					nums[back] = nums[front];
// 					nums[front] = holder;
// 					front++;
// 				}else {
//
// 					back--;
// 				}
// 				
// 				
// 				
// 			}
// 			
// 			if(nums[front] != val) {
// 				front++;
// 			}
// 			
// 			
// 		}
// 		
// 		
// 		
// 		for(int runner = nums.length - 1; runner != -1 &&nums[runner] == val ;runner--) {
// 			removed++;
// 		}
 		
 		
 	    int i = 0;
 	    for (int j = 0; j < nums.length; j++) {
 	        if (nums[j] != val) {
 	            nums[i] = nums[j];
 	            i++;
 	        }
 	    }
 	    
 	    for(int x: nums) {
			System.out.println(x);
		}
 	    return i;
 	    
 	    
 		
// 		System.out.println(nums.length - removed);
// 		
// 		return nums.length - removed;
 	}
 	
 	
 	public static int removeElement2(int[] nums, int val) {
        int front = 0, back = nums.length-1;
        while(back >= front){
            if(nums[front] == val){
                if(nums[back] != val) {
                    nums[front++] = nums[back];
                    nums[back] = val;
                }else {
                    back--;
                }
            } else{
                front++;
            }
        }
        
 		for(int i: nums) {
 			System.out.println(i);
 		}
 		
 		System.out.println(front);
        
        return front;
    }
 	
 	
 	
 	public static void removeAtIndexBackward(int[] nums, int indx) {
 		
 		if(indx == nums.length || indx < 0) {
 			System.out.println("Indx out of bounds.");
 		}
 		
 		
 		nums[indx] = 0;
 		
 		for(int runner = indx + 1; runner < nums.length; runner++) {
 			nums[runner - 1] = nums[runner];
 		}
 		
 		nums[nums.length - 1] = 0;
 	}
 	
 	public static void removeAtIndexForward(int[] nums, int indx) {
 		
 		if(indx == nums.length || indx < 0) {
 			System.out.println("Indx out of bounds.");
 		}
 		
 		nums[indx] = 0;
 		
 		for(int runner = indx; runner > 0; runner--) {
 			nums[runner] = nums[runner - 1];
 		}
 		
 		nums[0] = 0;
 	}
    
    public static int removeDuplicates(int[] nums) {
        
    	/*
    	 * Steps:
    	 * - Create two pointers starting at index 0 called leading and trailing poniters.
    	 * - increment the leading pointer.
    	 * - if the leading pointer is the same as the trailing pointer increment it again (repeat unitl different) 
    	 * - if the leading pointer is not the same as the trailing pointer increment the 
    	 * 	 trailing pointer and overwrite the value found at that index with the value found at the leading pointer.
    	 * - if the leading pointer hits the end of the array return the position of the trailing pointer. 
    	 * 
    	 * 
    	 * Cases:
    	 * - [] array
    	 * - [1] array with one value.
    	 * - [1,2] array with no repeated values.
    	 * - [1,1,2] array with repeated values.
    	 * - [1,2,3,4,5,5,6,7,8,9] array with repeated values in center.
    	 * - [1,2,3,4,5,5] array with repeated values at the end.
    	 */
    	
    	
    	if(nums.length == 0) {
    		return 0;
    	}else if(nums.length == 1) {
    		return 1;
    	}
    	
    	
    	int trailing = 0;
    	int leading = 0;
    	
    	for(;leading + 1 < nums.length && leading < nums.length;) {
    		//leading++;
    		
    		if(nums[leading] != nums[trailing]) {
    			trailing++;
    			nums[trailing] = nums[leading];
    		}else {
    			
    			while(leading < nums.length - 1 && nums[leading] == nums[trailing]) {
    				leading++;
    			}
    			
    			if(nums[leading] != nums[trailing]) {
    				trailing++;
        			nums[trailing] = nums[leading];
    			}
    		}
    		
    	}
    	
    	
    	trailing++;
    	
    	System.out.println("Trailing: " + trailing);
    	
    	return trailing;
    }
 	
    
    public boolean checkIfExist(int[] arr) {
        /*
        Steps:
        - Create two runners that will cycle through each value of the array
        - i and j then multiply i by two and compare it to j 
        - if its double than j break. 
        - if not then multiply j by two and compare it to i 
        - if its double then i break.
        
        Cases:
        - arr[]
        - arr[1]
    */
    
		    if(arr.length == 0 || arr.length == 1){
		        return false;
		    }
		    
		    int frontRunner = 0;
		    int backRunner = 0;
		    for(;backRunner < arr.length;){
		        frontRunner = backRunner + 1;
		        
		        for(;frontRunner <= arr.length - 1;frontRunner++){
		            
		            int firstMultiple = arr[frontRunner] * 2;
		            
		            if(arr[backRunner] == firstMultiple){
		                return true;
		            }
		            
		            firstMultiple =  arr[backRunner] * 2;
		            
		            if(arr[frontRunner] == firstMultiple){
		                return true;
		            }
		            
		        }
		        
		        backRunner++;
		    }
		    
		    
		    return false;
    }
    
    public static  boolean validMountainArray(int[] arr) {
        
        /*
            Steps:
            - Run through the array and find the highest point on the first pass.
            - then we will run through the array again except we will start at the highest point 
              that we found and create two pointers.
            - these two pointers will check that every variable after it will be decreasing.
            - if two of the pointers passed indexes have the same value we will return false.
            - if the pointers value all of a sudden increases we will return false.
            
            
            Cases:
            - []
            - [1]
            - [1,2]
            - [2,2]
            - [2,1]
            - [1,2,3]
            - [3,2,1]
            - [1,3,2]
            - [2,3,1]
        */
        
    	   /*
        Steps:
        - Run through the array and find the highest point on the first pass.
        - then we will run through the array again except we will start at the highest point 
          that we found and create two pointers.
        - these two pointers will check that every variable after it will be decreasing.
        - if two of the pointers passed indexes have the same value we will return false.
        - if the pointers value all of a sudden increases we will return false.
        
        
        Cases:
        - []
        - [1]
        - [1,2]
        - [2,2]
        - [2,1]
        - [1,2,3]
        - [3,2,1]
        - [1,3,2]
        - [2,3,1]
    */
    
    if(arr.length < 3){
        return false;
    }
    
    int highestPoint = Integer.MIN_VALUE;
    int highestPointIndex = Integer.MIN_VALUE;
    
    for(int runner = 0; runner < arr.length; runner++){
      
        
        if(highestPoint == arr[runner]){
            return false;   
        }else if(highestPoint < arr[runner]){
            highestPoint = arr[runner];
            highestPointIndex = runner;
        }
    }
    
    if(highestPointIndex == 0 || highestPointIndex == arr.length - 1) {
    	return false;
    }
    
    int leftRunner = highestPointIndex - 1 ;
    int rightRunner = highestPointIndex + 1;
    
    int leftRunnerPrev = Integer.MIN_VALUE;
    int rightRunnerPrev = Integer.MIN_VALUE; 
    
    for(;leftRunner >= 0 || rightRunner < arr.length;){
        
        if(leftRunner >= 0){
        		
        		if(leftRunner == highestPointIndex - 1) {
        			leftRunnerPrev = arr[leftRunner];
        		}else{
        			if(arr[leftRunner] >= leftRunnerPrev) {
        				return false;
        			}else {
        				leftRunnerPrev = arr[leftRunner];
        			}
        		}
        	
        		
        		System.out.println("Left Value: " + arr[leftRunner]);
                leftRunner--;
        	
        }
        
        if(rightRunner < arr.length){
        	
        		if(rightRunner == highestPointIndex + 1) {
        			rightRunnerPrev = arr[rightRunner];
        		}else {
        			if(rightRunnerPrev <= arr[rightRunner]) {
        				return false;
        			}else {
        				rightRunnerPrev = arr[rightRunner];
        			}
        		}
        	
        		System.out.println("Right Value: " + arr[rightRunner]);
                rightRunner++;
        	
            
        }
    }
  
    
    return true;
    }
    
    public static int[] replaceElements(int[] arr) {
        /*
            Steps:
            - begin a pointer and another holder variable on the end of 
              the array.
            - increase it by one each time and if the pointer is currently
              pointing to a variable that is greater than what is in holder
              assign holder to it.
            - otherwise just assign holder to what the current pointer is pointing
              to. 
              
            Cases:
            - []
            - [1]
        */
        
        
        if(arr.length == 0 || arr.length == 1){
            arr = new int[]{-1};
            return arr;
        }
        
        int holder = -1;
        int swap = 0;
        for(int reverseRunner = arr.length - 1; reverseRunner >= 0; reverseRunner--){
            if(reverseRunner == arr.length - 1){
                swap = arr[reverseRunner];
                arr[reverseRunner] = holder;
                holder = swap;
            }else if(arr[reverseRunner] > holder){
                swap = arr[reverseRunner];
                arr[reverseRunner] = holder;
                holder = swap;
            }else{
                arr[reverseRunner] = holder;
            }
            
        }
        
        return arr;
        
    }
    
    public static void moveZeroes(int[] nums) {
        /*
            Steps: 
            - Initialize two pointers leading and trailing pointers.
            - The trailing pointer will be where we insert the non zero element
            - the leading pointer will swap the non zero elements and skip an zero elements.
            - when the leading pointer hits the end we will assign every index after the 
              trailing element to zero. 
              
            Cases:
            -[]
            -[0]
            -[0,0,0,1]
        */
        
        
        int leading = 0;
        int trailing = 0;
        
        for(;leading <= nums.length - 1;){
            
            if(nums[leading] != 0){
                nums[trailing] = nums[leading];
                trailing++;
                leading++;
            }else{
                leading++;
            }
            
        }
        
        for(;trailing <= nums.length - 1;){
            nums[trailing] = 0;
            trailing++;
        }
        
    }
    
    public static int[] sortArrayByParity(int[] nums) {
        
        /*
            Steps: 
            - Starting at the begining of the array initialize a leading and trailing pointer.
            - if the current trailing pointer is even increase it by 1.
            - if it is not run through from its position to the find the next even number and 
              swap it. 
            - if none are found increase the trailing position. 
        
        
            Cases:
            - []
            - [1]
            - [1,2]
            - [1,2,3]
        */
        
    	int leading = 0;
        int trailing = 0;
        int swap = 0;
        boolean foundEven = false;
        
        
        for(;trailing <= nums.length -1;){
            
            if(nums[trailing] % 2 == 0){
                trailing++;
            }else{
                
                while(leading <= nums.length - 1){
                    if(nums[leading] % 2 == 0){
                        foundEven = true;
                        break;
                    }else{
                        leading++;
                    }
                }
                if(foundEven){
                    swap = nums[leading] ;
                    nums[leading] = nums[trailing];
                    nums[trailing] = swap;
                    foundEven = false;
                }else{
                    break;
                }
                    
                
            }
            
            leading = trailing + 1;
            
        }
        
        return nums;
        
    }
    
    public List<Integer> findDisappearedNumbersBooleanArraySolution(int[] nums) {
        
        /*
            Steps: 
            - Create a boolean array that is one element greater than the nums array.
            - Every time we pick off an element in the nums array we will use it to assign true 
              the index value of the boolean array. 
            - After the array is done processing we will run through the boolean array 
              and see which elements are still false this we will add to a list and return it. 
        
            Cases:
            - []
            - [1]
        */
        
        
        if(nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        boolean[] numbers = new boolean[nums.length + 1];
        List<Integer> integers = new ArrayList<Integer>();
        
        for(int runner = 0; runner < nums.length; runner++){
            numbers[nums[runner]] = true;
        }
        
        for(int runner = 1; runner < numbers.length; runner++){
            //System.out.println(runner+" "+numbers[runner]);
            if(numbers[runner] == false){
                integers.add(runner);
            }
        }
        
        return integers;
    }
 	
    
    public static List<Integer> findDisappearedNumbersTreeSetSolution(int[] nums) {
        
        /*
            Steps: 
            - Create a runner through the nums array.
            - Create a tree set, if the current element at the current index is not
              the index + 1 add (index + 1) to the tree set.
            - but first check to see if index + 1 is already in the tree set if it is 
              remove it. 
            - then return all the elements in the tree set. 
        
            Cases:
            - []
            - [1]
        */
        Arrays.sort(nums);
        TreeSet<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for(int runner = 0; runner < nums.length; runner++){
            
            if(nums[runner] != runner + 1){
                set.add(runner + 1);
            }
            
            
            
        }
        
        
        for(int runner = 0; runner < nums.length; runner++){
            
             if(set.contains(nums[runner])){
                set.remove(nums[runner]);
            }
            
        }
        
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()){
            //System.out.println(iter.next());
            list.add(iter.next());
        }
        
        
        return list;
    }
    
    public static List<Integer> findDisappearedNumbersLoopBrokenSolution(int[] nums) {
        
        /*
            Steps: 
            - Sort the array nums array.
            - If the value at the current index is not the value (index + 1)
              search the array until it is found or it reaches the end.
        
            Cases:
            - []
            - [1]
        */
        Arrays.sort(nums);
        
        int pointer = 0;
        boolean found = false;
        List<Integer> list = new ArrayList<Integer>();
        int lastInPlaceIndex = 0;
        for(int runner = 0; runner < nums.length; runner++){
        
            if(nums[runner] != runner + 1){
                pointer = lastInPlaceIndex;
                
                while(pointer < nums.length  && nums[pointer] != runner + 1){
                    
                    
                    if(nums[pointer] == runner + 1){
                        found = true;
                    }
                    pointer++;
                }
                
                if(pointer < nums.length && nums[pointer] == runner + 1){
                    found = true;
                }
                
                if(found == false){
                    list.add(runner + 1);
                }
                
            }
            
            if(nums[runner] != runner + 1) {
            	lastInPlaceIndex = runner;
            }
            
            found = false;
            
        }
        
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        System.out.println();
        
        return list;
    }
    
    

    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        
        /*
            Steps: 
            - Initialize a list 
            - assign the numbers from 1 to n
            - check the nums values and if they exits change the values in the list indexes to -1
            - return all the values that are not - 1
        
            Cases:
            - []
            - [1]
        */
        
        
        if(nums.length == 0){
            return new ArrayList<Integer>();
        }
        
        //boolean[] numbers = new boolean[nums.length + 1];
        List<Integer> integers = new ArrayList<Integer>();
        
        for(int runner = 0; runner < nums.length; runner++){
            integers.add(runner + 1);
        }
        
        for(int runner = 0; runner < nums.length; runner++){
        	integers.set(nums[runner] - 1, -1);
        }
        
        //Iterator iter = integers.iterator();
       
        Iterator<Integer> it = integers.iterator();
        while(it.hasNext()) {
        	if(it.next()==-1) {
        		it.remove();
        	}
        }
        
        
        return integers;
        
        }
    
    
    public static int thirdMax(int[] nums) {
        /*
            Steps:
            - Initialize three variables all to the max - 
            - run through the array of numbers
            - if the number is greater than the first greatest change the first greatest
              and shift all the elements down.
            - if the number is greater than the second greatest and not greater than the first
              shift them down one
            - if the number is greater than only the thrid then change the third.
            - return the third greatest if its not greater than 0 return the first greatest
            
        */
        
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        
        
        boolean minValueHit = false;
        
        for(int runner = 0; runner < nums.length; runner++){
        
        	if(nums[runner] == Integer.MIN_VALUE) {
        		minValueHit = true;
        	}
        	
            if(first < nums[runner]){
                third = second;
                second = first;
                first = nums[runner];
            }else if((first > nums[runner]) && second != nums[runner] && second < nums[runner]){
                third = second;
                second = nums[runner];
            }else if((first > nums[runner]) && second > nums[runner] && (second != nums[runner]) && third < nums[runner]){
                third = nums[runner];   
            }
        
        }
            
        if(third != Integer.MIN_VALUE && !(minValueHit)){
            return third;
        }if(third == Integer.MIN_VALUE && (minValueHit) && second != Integer.MIN_VALUE) {
        	return third;
        }else{
            return first;
        }
        
        
    }
	public static void main(String[] args) {
		
		//int[] insertionArray = new int[]{0,1,2,3,4,5,0,0,0,0,0,0};
		//int[] insertionArray = new int[]{0,1,2,3,4,5,6,7,8,9};
		//int[] insertionArray = new int[]{};
		//int[] insertionArray = new int[]{0};
		//int[] insertionArray = new int[]{1,1};
		//int[] insertionArray = new int[]{1,1,2};
		//int[] insertionArray = new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
		
		
		//removeAtIndexBackward(insertionArray, 5);
		//removeAtIndexForward(insertionArray,10);
		//removeAtIndexForward(insertionArray,5);
		//removeDuplicates(insertionArray);
		
		//int[] insertionArray = new int[]{0,2,3,4,5,2,1,0};
		//int[] insertionArray = new int[]{0,2,3,4,5,2,1,0};
		//int[] insertionArray = new int[]{1,3,2};
		//int[] insertionArray = new int[]{0,1,2,3,4,5,6,7,8,9};
		//int[] insertionArray = new int[]{10,2,5,10,9,1,1,4,3,7};
		//int[] insertionArray = new int[]{4,3,2,7,8,2,3,1};
		//int[] insertionArray = new int[]{5,4,6,7,9,3,10,9,5,6};
		//int[] insertionArray = new int[]{1,2,2,5,3,5};
		int[] insertionArray = new int[]{1,1,-2147483648};

		//System.out.println(validMountainArray(insertionArray));
		
		System.out.println(thirdMax(insertionArray));
		
		//sortArrayByParity(insertionArray);
		//List<Integer> x = findDisappearedNumbers(insertionArray);
			
		//Iterator run = x.iterator();
		
//		while(run.hasNext()) {
//			System.out.println(run.next());
//		}
//		for(int i : insertionArray) {
//			System.out.println(i);
//		}
		
		
		
		//Single Number and Max Consecutive Ones ========================================================
		
		/*
		System.out.println(singleNumber(new int[]{-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,-336,513,-560,-481,-174,101,-997,40,-527,-784,-283,354}));
		
		System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1}));
		System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
		
		int n = 1000;
		int length = (int)(Math.log10(n)+1);
		*/
		
		//Single Number and Max Consecutive Ones ========================================================
		
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

		
//		[1,2,3,0,0,0]
//				3
//				[2,5,6]
//				3
//		int[] nums1 = new int[] {-1,0,0,3,3,3,0,0,0};
//		int[] nums2 = new int[] {1,2,2};
//		
//		merge(nums1, 6,nums2,3);
//		
//		System.out.println();
//		
//		//merge2(nums1, 6,nums2,3);
//		
//		for(int i : nums1) {
//			System.out.println(i);
//		}
		
		
				
		
//		int[] nums1 = new int[] {0,1,2,2,3,0,4,2};
//		//int[] nums1 = new int[] {1,2};
//		//int[] nums1 = new int[] {2,2};
//		int val = 2;
//		//removeElement(nums1,2);
//		removeElementWithPointers(nums1,val);
//		System.out.println();
//		removeElement2(nums1, val);
		
		
		
		
		
	}

}
