package com.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;




public class NumberOfIslands {
	

	public class Location{
		public int x;
		public int y;
		
		Location(int x , int y){
			this.x = x;
			this.y = y;
		}
	}
	
	/* Function: Finds all the conected  and unique '1's this form an Island
	 * Steps: 
	 *		- Cycle through the array checking every index.
	 *		- If we come upon a 1 and we have not visited that one before on a prior 
	 *        pass we enter into a island checker loop. 
	 *		- The island checker loop will first add the location of the item we first found. 
	 * 		- Then we will run BFS on it
	 * 					- add the initial location to the queue.
	 * 					- dequeue the first node in the queue.
	 * 					- get all the respective neighbours for that position.
	 *  				- if they are equal to 1 add them to the queue 
	 *  				- at the end of this cycle add the initial value to the visited set.
	 */
	
    public static int numIslands(char[][] grid) {
        
    	Queue<Location> queue = new LinkedList();
    	Set<Location> visitedMap = new HashSet<Location>();
    	
    	int step = 0;
    	
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[row].length; col++){
                System.out.print(grid[row][col]);
                
                
                
                while(!queue.isEmpty()) {
                	step += 1;
                	
                	
                	int size = queue.size();
                	
                	for(int runner  = 0; runner < size; runner++) {
                		
                	}
                	
                }
                
                
                
            }
            
            System.out.println();
        }
        
        
        return 0;
    }
	
	public static void main(String[] args) {
		
		char[][] array =         {{'1','1','1','1','0'},
								  {'1','1','0','1','0'},
								  {'1','1','0','0','0'},
								  {'0','0','0','0','0'}};
		
		numIslands(array);
		
		
		Set<Location> s = new HashSet();
		NumberOfIslands.Location loc = new NumberOfIslands().new Location(1, 1);
		s.add(loc);
		
		
		
		NumberOfIslands.Location loc2 = new NumberOfIslands().new Location(1, 1);
		NumberOfIslands.Location loc3 = new NumberOfIslands().new Location(1, 1);
		NumberOfIslands.Location loc4 = new NumberOfIslands().new Location(1, 1);
		NumberOfIslands.Location loc5 = new NumberOfIslands().new Location(1, 1);
		
		System.out.println(s.contains(new NumberOfIslands().new Location(1, 1)));
		
		
	    HashSet<String> set=new HashSet();  
        set.add("One");    
        set.add("Two");    
        set.add("Three");   
        set.add("Four");  
        set.add("Five");  
        
        
        System.out.println(set.contains("Five"));
        
        
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 1);
        map.put(1, 2);
        System.out.println(map.get(1));
        
        
	}

}

