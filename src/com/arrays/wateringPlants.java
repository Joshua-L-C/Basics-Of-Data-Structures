package com.arrays;

public class wateringPlants {
	
	
	public static int wateringPlants(int[] plants, int capacity) {
        
        int originalCapacity = capacity;
        int position = -1;
        int steps = 0;
        
        
        
        for(int runner = 0; runner < plants.length; runner++){
            
            System.out.println("Plant: " + plants[runner]);
            
            if(capacity >= plants[runner]){
                capacity -= plants[runner];
                steps +=  1;
                
                //System.out.println("+1");
                
            }else if(capacity < plants[runner]){
            	 
            	 steps += (runner) * 2;
            	
                 capacity = originalCapacity;
                 capacity -= plants[runner];
                 
                 steps +=  1;
            }
            
        }
        
        System.out.println();
        
        return steps;
    }
	
	 public static int[][] flipAndInvertImage(int[][] image) {
	        
	        int[] workerArray = new int [image.length];
	        int size = image[0].length - 1;
	        int[][] otherImage = new int [image.length][image.length];
	        
	        
	        for(int runner = 0 ; runner < image.length; runner++){
	            
	            
	            for(int innerRunner = 0, backRunner = size; innerRunner < size + 1; innerRunner++,backRunner--){
	                System.out.print(image[runner][innerRunner]);
	                //System.out.print(image[runner][backRunner]);
	                
	                if(image[runner][innerRunner] == 0){
	                    workerArray[backRunner]  = 1;
	                }else{
	                    workerArray[backRunner]  = 0;
	                }
	            }
	            
	            
	            
	            
	           System.out.println();
	            
	            for(int x = 0 ; x < image.length; x++){
	                System.out.print(workerArray[x]);
	            }
	            System.out.println();
	           
	           image[runner] = workerArray;
	        }
	        
	        return image;
	    }
	 
	 public static int[] shortestToChar(String S, char C) {
	        
		 	int N = S.length();
	        int[] ans = new int[N];
	        int prev = Integer.MIN_VALUE / 2;

	        for (int i = 0; i < N; ++i) {
	            if (S.charAt(i) == C) prev = i;
	            ans[i] = i - prev;
	        }

	        prev = Integer.MAX_VALUE / 2;
	        for (int i = N-1; i >= 0; --i) {
	            if (S.charAt(i) == C) prev = i;
	            ans[i] = Math.min(ans[i], prev - i);
	        }

	        return ans;
	    }
	
	public static void main(String[]ag) {
		
		/*
				[2,2,3,3]
				5
				[1,1,1,4,2,3]
				4
				[7,7,7,7,7,7,7]
				8
		*/
		
//		int[] plants = new int[]{2,2,3,3};
//		int[] plants1 = new int[]{1,1,1,4,2,3};
//		int[] plants2 = new int[]{7,7,7,7,7,7,7};
//		System.out.println(wateringPlants(plants, 5));
//		System.out.println(wateringPlants(plants1, 4));
//		System.out.println(wateringPlants(plants2, 8));
		
		//[[1,1,0],[1,0,1],[0,0,0]]

		int[][] image = new int[][] {{1,1,0},{1,0,1},{0,0,0}};
		flipAndInvertImage(image);
		
		shortestToChar("loveleetcode",'e');
		
	}
}
