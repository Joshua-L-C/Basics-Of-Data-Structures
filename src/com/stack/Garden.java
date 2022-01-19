package com.stack;

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
	    
	    
	public static void main(String[] args) {
		
		
		
		int[] tester = gardenNoAdj(5, new int[][]{{1,2},{2,3},{3,4},{4,5},{2,5},{3,5},{1,4}});
		//int[] tester = gardenNoAdj(4, new int[][]{{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}});
		//int[] tester = gardenNoAdj(3, new int[][]{{1,2},{2,3},{3,1}});
		//int[] tester = gardenNoAdj(4, new int[][]{{1,2},{3,4}});

		
		for(int x: tester) {
			System.out.println(x);
		}
	}

}
