package com.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
	
	public static int openLock(String[] deadends, String target) {
		
		
		Queue<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>();
		HashSet<String> deadEnds = new HashSet<String>(Arrays.asList(deadends));
		
		
		char [] lock = {'0','0','0','0'};
		char [] incrementLock = {'0','0','0','0'};
		char [] decrementLock = {'0','0','0','0'};
		
		int step = 0;
		
		queue.add(new String(lock));
		visited.add(new String(lock));
		
		while(!queue.isEmpty()) {
			
			step += 1;
			
			
			for(int runner = 0; runner < queue.size();runner++) {
				
				
				
				lock = queue.poll().toCharArray();
				visited.add(new String(lock));
				
				
				if(Arrays.equals(lock, target.toCharArray())) {
					return step;
				}
				
				for(int secondRunner = 0; secondRunner < 4; secondRunner++) {
					
					
					incrementLock = lock.clone();
					decrementLock = lock.clone();
					
					int val = Integer.parseInt(incrementLock[secondRunner]+"");
					int val2 = Integer.parseInt(decrementLock[secondRunner]+"");
					
					val++;
					val2--;
					
					if(val == 10) {
						val = 0;
					}
					
					if(val2 == -1) {
						val2 = 9;
					}
					
					incrementLock[secondRunner] = (char) (val + '0');
					decrementLock[secondRunner] = (char) (val2 + '0');
					
					if(!visited.contains(new String(incrementLock))) {
						System.out.println(incrementLock);
						queue.add(new String(incrementLock));
						visited.add(new String(incrementLock));
					}
					
					if(!visited.contains(new String(decrementLock))) {
						System.out.println(decrementLock);
						queue.add(new String(decrementLock));
						visited.add(new String(decrementLock));
					}
				
				}
			}
			
			
			
		}
		
		
	
		
		return 0;
	}

	public static void main(String[] args) {
		
		
		String[] array = {"0201","0101","0102","1212","2002"};
		System.out.println(openLock(array,"0202"));
		
		

	}

}
