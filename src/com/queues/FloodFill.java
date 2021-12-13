package com.queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
	
	public class Location{
		public int x;
		public int y;
		
		Location(int x , int y){
			this.x = x;
			this.y = y;
		}
	}
	
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
    	Queue<Location> queue = new LinkedList<Location>();
    	
    	int step = 0;
    	
    	queue.add(new FloodFill().new Location(sr,sc));
    	
    	int valueToChange = image[sr][sc];
    	
    	while(!queue.isEmpty()) {
    		step++;
    		
    		int size = queue.size();
    		
    		
    		for(int counter = 0; counter < size; counter++) {
    			Location currentLocation = queue.poll();
    			
    			if(image[currentLocation.x][currentLocation.y] == valueToChange) {
    				image[currentLocation.x][currentLocation.y] = newColor;
    			}
    			
    			
    				
    				Location x;
    				if(currentLocation.x- 1 >= 0 && image[currentLocation.x - 1][currentLocation.y] == valueToChange) {
    					x = new FloodFill().new Location(currentLocation.x - 1, currentLocation.y);
    					queue.add(x);
    				}
    				
    				if(currentLocation.x + 1 < image.length  && image[currentLocation.x + 1][currentLocation.y] == valueToChange) {
    					x = new FloodFill().new Location(currentLocation.x + 1, currentLocation.y);
    					queue.add(x);
    					
    				}
    				
    				if(currentLocation.y - 1 >= 0 && image[currentLocation.x][currentLocation.y - 1] == valueToChange) {
    					x = new FloodFill().new Location(currentLocation.x, currentLocation.y - 1);
    					queue.add(x);
    				}
    				
    				if(currentLocation.y + 1 < image[0].length && image[currentLocation.x][currentLocation.y + 1] == valueToChange) {
    					x = new FloodFill().new Location(currentLocation.x, currentLocation.y  + 1);
    					queue.add(x);
    				}

    			
    			
    		}
    		
    	}
    	
    	
    	
    	return image;
    }
    
    public static int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
    	
    	
//    	int count = 0;
//    	
//    	for(int width = 0; width < image.length; width++) {
//    		for(int length = 0; length < image[0].length; length++) {
//    			
//    			if(image[width][length] == 1) {
//    				count++;
    				dfs(image,sr,sc,newColor,image[sr][sc]);
//    			}
//    			
//    		}
//    	}
    	
    	return image;
    }
    
    
    public static void dfs(int[][] image, int i , int j,int newColor,int oldColor) {
    	
    	if(i < 0 || i >= image.length || j < 0 || j >= image[0].length 
    			|| image[i][j] == newColor || image[i][j] != oldColor) {
    		return;
    	}
    	
    	
    	image[i][j] = newColor;
    	
    	dfs(image,i + 1, j,newColor,oldColor);
    	dfs(image,i - 1, j,newColor,oldColor);
    	dfs(image,i, j + 1,newColor,oldColor);
    	dfs(image,i , j - 1,newColor,oldColor);
    }
	
	public static void main(String[] args) {
		
		
		int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
		
		System.out.println(Arrays.deepToString(image));
		
		image = floodFill(image, 0,0,-1);
		
		System.out.println(Arrays.deepToString(image));
		
		image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
		
		//image = new int[][]{{0,0,0},{0,0,0}};
		image = floodFillDFS(image, 0,0,2);
		System.out.println(Arrays.deepToString(image));
		
		for(int runner = 0 ; runner < 10 ; runner++) {
			
			if(runner == 3) continue;
			System.out.println("Test "+ runner);
			
		}
	}

}
