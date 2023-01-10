package com.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		int[] testerArray = new int[]{90,80,88,75,72,63,54,1};
		bucketSort(testerArray);
		
		Arrays.stream(testerArray).forEach(num -> System.out.println(num));

	}
	
	public static void bucketSort(int[] input) {
		List<Integer>[] buckets = new List[10];
		
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
			
			//buckets[i] = new LinkedList<Integer>();
		}
		
		for(int indx = 0; indx < input.length; indx++) {
			buckets[hash(input[indx])].add(input[indx]);
		}
		
		for (int i = 0; i < buckets.length; i++) {
			Collections.sort(buckets[i]);
		}
		
		int j = 0;
		for(int indx = 0; indx < buckets.length; indx++) {
			for(int value: buckets[indx]) {
				input[j++] = value;
			}
		}
	}
	
	private static int hash(int value) {
		return value / (int) 10 ;
	}

}
