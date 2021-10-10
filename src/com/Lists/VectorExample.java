package com.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class VectorExample {

	public static void main(String[] args) {
		
		//If you need thread safety use Vector. If you dont use an arrayList
		
		//NOTE: Its always better to use the interface that the 
		//implementation is using because then you can switch out to another
		//class that uses the same interface without having to change any code.
		List<Employee> v = new Vector<Employee>();
		
		
		int[] input = new int[]{1, 1, 3, 7, 7, 8, 9, 9, 9, 10};
		int current = input[0];
		boolean found = false;

		for (int i = 0; i < input.length; i++) {
		    if (current == input[i] && !found) {
		        found = true;
		    } else if (current != input[i]) {
		        System.out.print(" " + current);
		        current = input[i];
		        found = false;
		    }
		}
		System.out.print(" " + current);
		
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < input.length;i++) {
			
		}
		
		//Sliding Window Assingment.

	}

}
