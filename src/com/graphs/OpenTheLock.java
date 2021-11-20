package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
	
	public static int openLock(String[] deadends, String target) {
		
		
		Queue<String> queue = new LinkedList<String>();
		char [] lock = {'0','0','0','0'};
		
		for(int runner = 0; runner < 4; runner++) {
			if(lock[runner] == '0') {
				int val = Integer.parseInt(lock[runner]+"");
				val++;
				lock[runner] = (char) (val + '0');  
			}
			
		}
		
		for(int runner = 0; runner < lock.length; runner++) {
			System.out.println(lock[runner]);
		}
		
		return 0;
	}

	public static void main(String[] args) {
		
		
		String[] array = {"0201","0101","0102","1212","2002"};
		openLock(array,"0202");

	}

}
