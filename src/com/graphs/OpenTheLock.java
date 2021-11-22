package com.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpenTheLock {
	
	public static int openLock(String[] deadends, String target) {
		
		
		Queue<String> queue = new LinkedList<String>();
		HashSet<String> visited = new HashSet<String>(Arrays.asList(deadends));
		
		if (target == "0000")
            return 0;
             
        if (visited.contains("0000"))
            return -1;
		
        
		char [] lock = {'0','0','0','0'};
		char [] incrementLock = {'0','0','0','0'};
		char [] decrementLock = {'0','0','0','0'};
		
		int step = 0;
		
		queue.add(new String(lock));
		visited.add(new String(lock));
		
		while(!queue.isEmpty()) {
			
			
			//The size variable must be outside of the loop because
			//this will determine how many steps we take by going to the queues
			//prior end and putting in a new end to restart a cycle of new values. 
			int size = queue.size();
			
			for(int runner = 0; runner < size;runner++) {
				
				
				
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
					
					if(Arrays.equals(lock, target.toCharArray())) {
						return step + 1;
					}
					
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
			
			step += 1;
			
		}
		
		
	
		
		return -1;
	}

	public static void main(String[] args) {
		
		
		String[] array = {"0201","0101","0102","1212","2002"};
		System.out.println(openLock(array,"0202"));
		
		

	}

}
