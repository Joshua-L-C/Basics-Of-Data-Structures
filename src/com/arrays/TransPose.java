package com.arrays;

import java.util.HashMap;

public class TransPose {
	
    public static int[][] transpose(int[][] matrix) {
        
        System.out.println("Length of Row: " + matrix[0].length);
        System.out.println("Length of Column: "+matrix.length);
        
        int[][] newMatrix = new int[matrix[0].length][matrix.length];
        
        System.out.println("Length of Row: " + newMatrix[0].length);
        System.out.println("Length of Column: "+newMatrix.length);
        
        
        for(int oldRowRunner = 0; oldRowRunner <= matrix[0].length - 1; oldRowRunner++) {
        	for(int oldColumnRunner = 0; oldColumnRunner <= matrix.length - 1; oldColumnRunner++) {
        		
        		//System.out.println(matrix[oldColumnRunner][oldRowRunner]);
        		
        		newMatrix[oldRowRunner][oldColumnRunner] =  matrix[oldColumnRunner][oldRowRunner];
        	}
        	//System.out.println();
        }
        
        return newMatrix;
    }
    
    public static boolean lemonadeChange(int[] bills) {
        
        HashMap<Integer,Integer> till = new HashMap<Integer,Integer>();
        till.put(20,0);
        till.put(10,0);
        till.put(5,0);
        
        for(int runner = 0; runner < bills.length; runner++){
            int changeToMake = bills[runner] - 5;
            
            if(changeToMake == 0){
                
                till.put(bills[runner], till.get(bills[runner]) + 1);
            }else if(changeToMake > 0){
                
            	if(makeExactChange(till,changeToMake)){
                    
                    if(bills[runner] == 15){
                        till.put(5, till.get(5) + 1);
                        till.put(10, till.get(10) + 1);
                    }else{
                        till.put(bills[runner], till.get(bills[runner]) + 1);
                    }
                    
                }else{
                    return false;
                }	
                
                
                 // if(change - changeToMake >= 0){
                 //  	change +=  bills[runner];
                 //      change = change - changeToMake;
                 //  }else if(change - changeToMake < 0){
                 //      return false;
                 //  }
                
            }
        }
        
        return true;
    }
 
 	public static boolean makeExactChange(HashMap<Integer,Integer> till, int ammountToMake){
     int[] values = new int[]{20,10,5};
     int currentPosition = 0;
     
     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
     map.put(values[0],till.get(values[0]));
     map.put(values[1],till.get(values[1]));
     map.put(values[2],till.get(values[2]));
     
     while(ammountToMake > 0){
         
         if(currentPosition > 2){
             return false;
         }if(map.get(values[currentPosition]) > 0 && values[currentPosition] <= ammountToMake){
             ammountToMake = ammountToMake - values[currentPosition];
             map.put(values[currentPosition],map.get(values[currentPosition]) - 1);
         }else if(map.get(values[currentPosition]) == 0 || values[currentPosition] > ammountToMake){
             currentPosition++;
         }
             
     }
     
     till.put(values[0],map.get(values[0]));
     till.put(values[1],map.get(values[1]));
     till.put(values[2],map.get(values[2]));
     
     
     return true;
     
 	}
	
	public static void main(String[] args) {
		
		
//		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
//		map.put(20, 0);
//		map.put(10,2);
//		map.put(5,2);
//		
//		System.out.println(makeExactChange(map,15));
//		System.out.println(makeExactChange(map,20));
//		System.out.println(makeExactChange(map,5));
		
		
//		int[] change = new int[] {5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,
//				5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,
//				20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,
//				5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10
//				,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10
//				,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10
//				,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,
//				5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,
//				5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,
//				20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20
//				,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,
//				5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,
//				5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,
//				10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10
//				,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5
//				,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,
//				20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20,5,10,5,20};
		
		//int [] change = new int[] {5,5,5,10,20};
		int [] change = new int[] {5,5,10,10,20};
		
		System.out.println(lemonadeChange(change));
		
		//int[][] tester = transpose(new int[][] {{1},{4},{7},{9}});
//		int[][] tester = transpose(new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}});
//		
//		for(int runner = 0; runner < tester.length;runner++) {
//			for(int twoRunner = 0; twoRunner < tester[0].length;twoRunner++) {
//				System.out.print(tester[runner][twoRunner]);
//			}
//			
//			System.out.println();
//		}
		
	}

}
