package com.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class SortingWithBits {
	
public static int[] sortByBits(int[] arr) {
        
        Arrays.sort(arr);
        
        TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
        
        map.put(0,new ArrayList<Integer>());
        map.put(1,new ArrayList<Integer>());
        map.put(2,new ArrayList<Integer>());
        map.put(3,new ArrayList<Integer>());
        map.put(4,new ArrayList<Integer>());
        map.put(5,new ArrayList<Integer>());
        map.put(6,new ArrayList<Integer>());
        map.put(7,new ArrayList<Integer>());
        map.put(8,new ArrayList<Integer>());
        map.put(9,new ArrayList<Integer>());
        map.put(10,new ArrayList<Integer>());
        map.put(11,new ArrayList<Integer>());
        map.put(12,new ArrayList<Integer>());
        map.put(13,new ArrayList<Integer>());
        
        int holderValue = 0;
        
        for(int index = 0; index < arr.length; index++){
            holderValue = Integer.bitCount(arr[index]);
            map.get(holderValue).add(arr[index]);
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int index = 0;
        
        for(ArrayList<Integer> val : map.values()){
            
            
            //System.out.println("Current Index: " + index);
            
            for(Integer x: val){
                list.add(x);
                
                
                //System.out.print(x + " ");
            }
            
            index++;
            //System.out.println();
            
        }
        
        
        int[] vals = new int[list.size()];
        for(index = 0; index < list.size(); index++){
            vals[index] = list.get(index);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
        //return list.toArray(new Integer[list.size()]);
        //return vals;
    }
	
    public static int[] sortByBits2(int[] arr) {
        
        
        int[] array = new int[10001];
        int[] occurrence = new int[10001];
        int[] bitChecker = new int[14];
        
        int least = arr[0];
        int greatest = arr[0];
        
        int[] result = new int[arr.length];
        
        Arrays.sort(arr);
        
        for(int runner = 0; runner < arr.length; runner++){
            //System.out.println(arr[runner] + " "+intToBinary(arr[runner]));
            
            array[arr[runner]] = intToBinary(arr[runner]);
            bitChecker[array[arr[runner]]] = 1;
            
            occurrence[arr[runner]] += 1;
            
            if(least > arr[runner]){
                least = arr[runner];
            }
            
            if(greatest < arr[runner]){
                greatest = arr[runner];
            }
            
        }
        
        // System.out.println("Index Number Ouccrrences");
        
        
        /*
            For each possible number of 1 Bits in the array 1 - 13
                cycle through the bitChecker array 
                
                if the currentIndex in the bit checker array is > 0 
                    Cycle through the arr 
                        if the current value at the index is = to the current bitchecking value
                            Cycle thorugh the occurrences array 
                                if the current runner for the array is less than the value in the 
                                ouccorrences array 
                                    add the current value from arr to the result array 
                
        */
        
         // for(int runner = 0; runner < arr.length; runner++){
         //     System.out.println(runner + " " + arr[runner] +" " + array[arr[runner]]+" "+occurrence[arr[runner]]);    
         // }
        
        int resultIndex = 0;
        int currentBit = 0;
        
        
        for(int numbRunner = 0; numbRunner < bitChecker.length && resultIndex < result.length; numbRunner++){
            
            currentBit  = bitChecker[numbRunner];
            
            if(currentBit  > 0){
                
                for(int arrRunner = 0; arrRunner < arr.length; arrRunner++){
                    
                    if(array[arr[arrRunner]] == numbRunner){
                        
                        for(int runner = 0; resultIndex < result.length && runner < occurrence[arr[arrRunner]]; runner++){
                            result[resultIndex] = arr[arrRunner];
                            resultIndex++;
                        }
                        
                        array[arr[arrRunner]] = -1;
                        
//                        if(resultIndex == result.length) {
//                        	return result;
//                        }
                    }
                }
            }
        }
        
        
        return result;
    }
	
    public static int[] sortByBits1(int[] arr) {
        
        
        int[] array = new int[10001];
        int[] occurrence = new int[10001];
        
        int least = arr[0];
        int greatest = arr[0];
        
        int[] result = new int[arr.length];
        
        // for(int runner = 0; runner < array.length; runner++){
        //     array[runner] = -1;
        // }
        
        for(int runner = 0; runner < arr.length; runner++){
            //System.out.println(arr[runner] + " "+intToBinary(arr[runner]));
            
            array[arr[runner]] = intToBinary(arr[runner]);
            occurrence[arr[runner]] += 1;
            
            if(least > arr[runner]){
                least = arr[runner];
            }
            
            if(greatest < arr[runner]){
                greatest = arr[runner];
            }
            
        }
        
        System.out.println("Index Number Ouccrrences");
        
        
        /*
            For each possible number of 1 Bits in the array 1 - 5
                run through the array from the least value to the greatest value
                
                when you are checking for the current number of bits if the current number in the index of array 
                is the current checking bit number 
                
                    cycle through the number of ouccourences adding them to the result array.
        */
        
         for(int runner = 0; runner < arr.length; runner++){
             System.out.println(runner + " " + arr[runner] +" " + array[arr[runner]]+" "+occurrence[arr[runner]]);    
         }
        
        int resultIndex = 0;
        
        for(int numbRunner = 0; numbRunner <= 13 && resultIndex < result.length; numbRunner++){
            
            for(int currentNumber = least; currentNumber <= greatest; currentNumber++){
                if(array[currentNumber] == numbRunner && occurrence[currentNumber] != 0){
                    
                    for(int runner = 0; runner < occurrence[currentNumber]; runner++){
                        result[resultIndex] = currentNumber;
                        resultIndex++;
                    }
                    
                }
            }
            
        }
        
        
        

        
        return result;
    }
    
    public static int intToBinary(int n)
    {
        int s = n;
        int numb = 0;
        while (n > 0) {
            
            if(n % 2 != 0){
                numb++;
            }
        
            n = n / 2;
        }
        
        
        System.out.println(s+" Number of Ones: "+ numb);
        return numb;
    }
    
    public static int recurToBinary(int n, int numb){
        
        if(n <= 0){
            return numb;
        }
        
        
        if(n % 2 != 0){
            numb++;
        }
        
        numb = recurToBinary(n/2,numb++);
        
        return numb;
    }

	public static void main(String[] args) {
		
		int[] testerArray = new int[]{10000,10000};
		//testerArray = new int[]{10,100,1000,10000};
		testerArray = new int[] {1633,2181,7558,2650,1920,809,4903,2223,4271,4110,7564,5428,1730,5970,9640,3185,7564,5040,4344,9479,2070,6569,9849,73,2961,7991,9419,7946,3293,882,4714,3813,278,6121,9244,8248,5424,2377,4270,7656,1983,2928,2876,4746,129,5971,522,349,1239,9493,4777,1421,1763,8419,5696,726,6130,9164,5290,6793,3670,3090,3395,5597,7557,6246,956,7791,677,2284,7280,5309,8274,1760,2383,7003,4094,1681,8885,3010,1551,7419,813,9937,7054,9615,8126,2739,3255,334,587,634,3382,3316,4630,6077,4687,2226,8910,8357,1961,1454,6416,8838,6295,4523,9736,6165,2849,7877};
		//testerArray = new int[] {7557,7558,7564,7564,7991,8126,7991};
		
		/*
		int[]array = sortByBits(testerArray);
		
		
		for(int runner = 0; runner < array.length; runner++) {
			System.out.println(array[runner]);
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		*/
		
//		int[] otherArray = new int[] {129,73,522,278,1920,2070,2181,3090,4110,5696,6416,8248,8274,9736,334,587,677,809,1633,1681,1730,1760,2226,2377,2849,4630,4746,5424,6165,8357,8838,9244,349,634,726,813,882,1421,1551,2284,2650,2928,2961,3010,3185,3395,4270,4344,4714,4777,5040,5290,5428,6246,6793,7280,8419,9479,9493,9640,956,1239,1454,1763,1961,2223,2383,2739,2876,3316,3382,3670,4271,4523,4687,4903,5970,6295,6569,7557,7558,7564,7564,7946,8885,8910,9164,9419,9937,3255,3293,3813,5309,5971,7054,7656,7877,9615,9849,5597,6121,6130,7003,1983,6077,7419,7791,7991,4094,8126};
//		for(int runner = 0; runner < array.length; runner++) {
//			System.out.println(otherArray[runner]);
//		}
		
		
		System.out.println("Regular: "+intToBinary(8126));
		System.out.println("Recur: "+recurToBinary(8126,0));
	}

}




