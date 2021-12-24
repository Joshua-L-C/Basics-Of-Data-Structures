package com.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KeysAndRooms {
	
	
    public static boolean canVisitAllRooms(ArrayList<ArrayList<Integer>> rooms) {
        
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        
        // for(int runner = 0; runner < rooms.size(); runner++){
        //     System.out.println(rooms.get(runner));
        // }
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            
            
            int size = queue.size();
            
            for(int itemRunner = 0; itemRunner < size; itemRunner++){
                
                int currentRoom = queue.poll();
                visited.add(currentRoom);
                for(int runner = 0; runner < rooms.get(currentRoom).size(); runner++){
                    
                    if(!visited.contains(rooms.get(currentRoom).get(runner))){
                        queue.add(rooms.get(currentRoom).get(runner));
                    }    
                    
                }
                
            }
        }
        
        
        
        return rooms.size() - visited.size() == 0;
    }
    
	public static void main(String[] args) {
		//[[2],[4,3],[1],[],[]]

		ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
		test.add(new ArrayList<Integer>(Arrays.asList(2)));
		test.add(new ArrayList<Integer>(Arrays.asList(4,3)));
		test.add(new ArrayList<Integer>(Arrays.asList(1)));
		test.add(new ArrayList<Integer>(Arrays.asList()));
		test.add(new ArrayList<Integer>(Arrays.asList()));
		
		System.out.println(canVisitAllRooms(test));

	}

}
