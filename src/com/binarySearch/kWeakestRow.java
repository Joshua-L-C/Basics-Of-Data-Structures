package com.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class kWeakestRow {
	
	static boolean hitRowBottom = false;
	
	
	 public static int[] kWeakestRows(int[][] mat,int k){
	        int[] result = new int[k];
	        
	        int[][] holder = new int[mat.length][2];
	        
	        
	        holder = drillDown(mat,holder,0,0,0,hitRowBottom);
//	         for(int runner = 0; runner < mat.length; runner++){
	            
//	             holder[runner][0] = runner;
//	             holder[runner][1] = drillDown(mat[runner],0);
//	         }
	        
	        Arrays.sort(holder,new Comparator<int[]>(){
	            public int compare(int[] a , int[]b){
	                return Integer.compare(a[1],b[1]);
	            }
	        });
	        
	        for(int runner = 0; runner < k; runner++){
	            result[runner] = holder[runner][0];
	        }
	        
	        // for(int runner = 0; runner < holder.length; runner++){
	        //     System.out.println(holder[runner][0] + " : " + holder[runner][1]);   
	        // }
	        
	        return result;
	    }
	    
	    public static int[][] drillDown(int[][] matrix,int[][] result,int rowIndex,int columnIndex,int soldiers,boolean bottom){
	        
	        if(rowIndex >= matrix.length){
	        	
	        	bottom = true;
	        	
	            if(columnIndex >= matrix.length || rowIndex >= matrix.length || matrix[rowIndex][columnIndex] == 0){
	                return null;
	            }    
	            
	            return null;
	        }
	        
	        
	        drillDown(matrix,result,rowIndex + 1,columnIndex,soldiers,bottom);
	        result[rowIndex][0] = rowIndex;
	        
	        
	        drillDown(matrix,result,rowIndex, columnIndex + 1,soldiers,bottom);
	        soldiers =  1 + soldiers;
	        
	        return result;
	    }
	
	    public static int[] kWeakestRows4(int[][] mat,int k){
	        int[] result = new int[k];
	        
	        int[][] holder = new int[mat.length][2];
	        
	        for(int runner = 0; runner < mat.length; runner++){
	            
	            holder[runner][0] = runner;
	            holder[runner][1] = drillDown1(mat[runner],0);
	        }
	        
	        Arrays.sort(holder,new Comparator<int[]>(){
	            public int compare(int[] a , int[]b){
	                return Integer.compare(a[1],b[1]);
	            }
	        });
	        
	        for(int runner = 0; runner < k; runner++){
	            result[runner] = holder[runner][0];
	        }
	        
	        // for(int runner = 0; runner < holder.length; runner++){
	        //     System.out.println(holder[runner][0] + " : " + holder[runner][1]);   
	        // }
	        
	        return result;
	    }
	    
	    public static int drillDown1(int[] matrix,int columnIndex){
	        
	        if(columnIndex == matrix.length || matrix[columnIndex] == 0){
	            return 0;
	        }
	        
	        int soldiers =  1 + drillDown1(matrix, columnIndex + 1);
	        
	        return soldiers;
	    }
	    
	    
	
	public static int[] kWeakestRows3(int[][] mat, int k) {
        
        int[] result = new int[k];
        int[][] holder = new int[mat.length][2];
        int curSolNum = 0;
        
        for(int runner = 0; runner < mat.length; runner++){
	                
	            curSolNum = 0;
	        
	            for(int indexRunner = 0;  indexRunner < mat[0].length && mat[runner][indexRunner] == 1; indexRunner++){
	                curSolNum++;
	            }
	            
                holder[runner][0] = runner;
	            holder[runner][1] = curSolNum;
	    }
        
        Arrays.sort(holder,new Comparator<int[]>(){
            public int compare(int[] a , int[]b){
                return Integer.compare(a[1],b[1]);
            }
        });
        
        
        // for(int runner = 0; runner < holder.length; runner++){
        //     System.out.println(holder[runner][0] + " : " + holder[runner][1]);   
        // }
        
        for(int runner = 0; runner < k; runner++){
            result[runner] = holder[runner][0];
        }
     
        
        return result;
    }
	
	public static int[] kWeakestRows2(int[][] mat, int k) {
	        
	        int[] result = new int[k];
	        int[] holder = new int[mat.length];
	        int[] holder2 = new int[mat.length];        
	        
	       
	        int curSolNum = 0;
	        
	        for(int runner = 0; runner < mat.length; runner++){
	                
	            curSolNum = 0;
	            
	            for(int indexRunner = 0;  indexRunner < mat[0].length && mat[runner][indexRunner] == 1; indexRunner++){
	                curSolNum++;
	            }
	            
	            holder[runner] = curSolNum;
	            holder2[runner] = curSolNum;
	        }
	        
	        
	        Arrays.sort(holder);
	        
	        for(int runner = 0; runner < k; runner++){
	            
	            System.out.println("Searching Holder: " + holder[runner]);
	            for(int index = 0; index < holder.length; index++){
	                
	                System.out.println("Searching: " + holder2[index]);
	                
	                if(holder[runner] == holder2[index]){
	                	holder2[index] = -1;
	                    result[runner] = index;
	                    break;
	                }
	            }
	        }
	        
	        
	        // for(int runner = 0; runner < holder.length; runner++){
	        //     System.out.println(runner+" "+holder[runner]);
	        // }
	        return result;
	    }
	 
	 
	 public static int[] kWeakestRows1(int[][] mat, int k) {
	        
	        int[] result = new int[k];
	        int[] holder = new int[mat.length];
	        //int[] holder2 = new int[mat.length];        
	        
	        
	        
	        int curSolNum = 0;
	        
	        for(int runner = 0; runner < mat.length; runner++){
	                
	            curSolNum = 0;
	            
	            for(int indexRunner = 0;  indexRunner < mat[runner].length && mat[runner][indexRunner] == 1; indexRunner++){
	                curSolNum++;
	            }
	            
	            holder[runner] = curSolNum;
	            mat[runner] = null;
	            mat[runner] = new int[]{curSolNum};
	        }
	        
	        
	        Arrays.sort(holder);
	        
	        for(int runner = 0; runner < k; runner++){
	            
	            System.out.println("Searching Holder: " + holder[runner]);
	            for(int index = 0; index < mat.length; index++){
	                
	                System.out.println("Searching: " + mat[index][0]);
	                
	                if(holder[runner] == mat[index][0]){
	                    mat[index][0] = -1;
	                    result[runner] = index;
	                    break;
	                }
	            }
	        }
	        
	        
	        // for(int runner = 0; runner < holder.length; runner++){
	        //     System.out.println(runner+" "+holder[runner]);
	        // }
	        return result;
	    }
	
	public static void main(String[] args) {
		
		int[][] mat = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
		
		kWeakestRows(mat, 3);
//		kWeakestRows2(mat, 3);
		

	}

}
