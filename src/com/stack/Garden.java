package com.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Garden {
	 	public static int[] gardenNoAdj(int n, int[][] paths) {
	        int [] gardens = new int[n];
	        byte flower = 1;
	        
	        
	        for(int runner = 0 ;runner < gardens.length;runner++) {
	        	if(gardens[runner] == 0) {
	        		gardenTraversal(gardens,runner + 1,flower,paths,runner);
	        		
	        	}
	        	if(gardens[runner] == 0) {
	        		gardens[runner] = flower;
	        	}
	        }
	        
	        
	        return gardens;
	        
	    }
	    
	    public static void gardenTraversal(int[] array, int currentGarden, byte flower, int[][] paths, int pos){
	        
	    	//flower = getFlower(flower);
	    	
	    	
	    	
	        for(int runner = 0; runner < paths.length;runner++){
	            if(paths[runner][0] == currentGarden){
	                
	            	if(array[currentGarden - 1] == 0 ) {
	            		array[currentGarden - 1] = getFlower(flower++);
	            		
	            	}
	            	if(array[paths[runner][1] - 1] == 0) {
	            		gardenTraversal(array,paths[runner][1],flower, paths, runner);
	            	}
	            	
	            	
	            	
	            	
	            }else if(paths[runner][1] == currentGarden){
	                
	            	if(array[currentGarden - 1] == 0) {
	            		array[currentGarden - 1] = getFlower(flower++);
	            		
	            	}
	            	if(array[paths[runner][0] - 1] == 0) {
	            		gardenTraversal(array,paths[runner][0],flower, paths, runner);
	            	}
	            	
	            	
	            	
	            }
	        }
	        
	        
	    }
	    
	    
	    public static byte getFlower(int f){
	        
	        byte flower = (byte) (f % 5);
	        
	        if(flower == 0) {
	        	return flower++;
	        }
	        
	        return flower;
	    }
	    
	    public static int[] gardenNoAdj2(int N, int[][] paths) {
	        Map<Integer, List<Integer>> graph = new HashMap();
	        for (int i=1; i<=N; i++) {
	            graph.put(i, new ArrayList());
	        }
	        for (int[] path: paths) {
	            graph.get(path[0]).add(path[1]);
	            graph.get(path[1]).add(path[0]);
	        }
	        Map<Integer, Integer> colors = new HashMap();
	        for (int i=1; i<=N; i++) {
	            dfs(i, graph, colors);
	        }
	        int[] rec = new int[N];
	        for (int i=0; i<N; i++) {
	            rec[i] = colors.get(i+1);
	        }
	        return rec;
	    }
	    
	    public static void dfs(int cur, Map<Integer, List<Integer>> graph, Map<Integer, Integer> colors) {
	        if (colors.containsKey(cur)) return;
	        Set<Integer> exist = new HashSet();
	        for (int neighbor: graph.get(cur)) {
	            if (colors.containsKey(neighbor)) {
	                exist.add(colors.get(neighbor));
	            }
	        }
	        for (int i=1; i<=4; i++) {
	            if (!exist.contains(i)) {
	                colors.put(cur, i);
	                break;
	            }
	        }
	        for (int neighbor: graph.get(cur)) {
	            if (!colors.containsKey(neighbor)) {
	                dfs(neighbor, graph, colors);
	            }
	        }
	    }
	    
	    
	public static void main(String[] args) {
		
				
		//int[] tester = gardenNoAdj2(6, new int[][]{{6,4},{6,1},{3,1},{4,5},{2,1},{5,6},{5,2}});
		int[] tester = gardenNoAdj2(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{2,5},{3,5},{1,4}});
		//int[] tester = gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}});
		//int[] tester = gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}});
		//int[] tester = gardenNoAdj(4, new int[][]{{1,2},{3,4}});

		
		for(int x: tester) {
			System.out.println(x);
		}
	}

}
