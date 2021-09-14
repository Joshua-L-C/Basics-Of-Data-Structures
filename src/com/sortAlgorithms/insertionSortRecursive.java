package com.sortAlgorithms;

public class insertionSortRecursive {

	
	public static void insertionSort(int [] intArray) {
		
		for(int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
			int newElement = intArray[firstUnsortedIndex];
			
			int i;
			
			for(i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
				intArray[i] = intArray[i - 1];
			}
			
			intArray[i] = newElement;
		}
	}
	
	public static void sort(int [] array,int x, int y) {
			
		if(x == -1) {
			
			if(y == array.length)
			return;
			
			x = y;
			System.out.println("Y: " + array[y]);
			System.out.println();
		}
		
		
		
		
		if(x != -1) {
			
			if(x == y) {
				y++;
				
				
				if(y == array.length)
				return;
			}
			
			
			if(array[y] < array[x]) {
				int temp = array[x];
				array[x] = array[y];
				array[y] = temp;
				
				
				sort(array,x,y);
				
			}
			
			//System.out.print(array[x]+ " ");
			
			
			if(array[y] < array[x]) {
				int temp = array[x];
				array[x] = array[y];
				array[y] = temp;
				
				sort(array,x,y);
				
			}
			
			x--;
			sort(array,x,y);
			
		}
		
	}
	
	 public static void insertionSort(int[] input, int numItems) {

	        if (numItems < 2) {
	            return;
	        }

	        insertionSort(input, numItems - 1);

	        int newElement = input[numItems - 1];

	        int i;

	        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
	            input[i] = input[i - 1];
	        }

	        input[i] = newElement;

//	        System.out.println("Result of call when numItems = " + numItems);
//	        for (i = 0; i < input.length; i++) {
//	            System.out.print(input[i]);
//	            System.out.print(", ");
//	        }
//	        System.out.println("");
//	        System.out.println("---------------------");


	    }
	
    public static int gcd(int a, int b) {
        while (b > 0) {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }
    
    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
	
	
	public static void main(String[] args) {
		
		int[] intArray = new int[7];
		
		intArray[0] = 1;
		intArray[1] = 3;
		intArray[2] = 2;
		intArray[3] = 4;
		intArray[4] = 6;
		intArray[5] = 5;
		intArray[6] = -7;

		for(int i = 0; i < intArray.length;i++) {
			System.out.print(intArray[i]+" ");
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
//		System.out.println(gcd(2,19));
//		System.out.println(lcm(2,19));
		
		
		//sort(intArray,0,0);
		
		System.out.println();
		System.out.println();
		
		insertionSort(intArray,intArray.length);
		
		
		System.out.println();
		System.out.println();
		for(int i = 0; i < intArray.length;i++) {
			System.out.print(intArray[i]+" ");
		}
//		for(int i = 0; i < intArray.length;i++) {
//			System.out.println(intArray[i]);
//		}

	}

}
