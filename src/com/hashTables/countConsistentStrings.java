package com.hashTables;

import java.util.ArrayList;
import java.util.Arrays;

public class countConsistentStrings {
	
	public static int countConsistentStrings(String allowed, String[] words) {
		
		//ArrayList<String> list = new ArrayList();
        char[] arr = null;
		
        int result = words.length;
        
		for(String s: words){
			arr = s.toCharArray();
            Arrays.sort(arr);
            s = new String(arr);
	        
			 for(int runner = 0;runner < allowed.length();runner++){
	              s = s.replace(allowed.charAt(runner)+"","");
	              //s = ;
	         }
	           
			 
			 System.out.println(s);
			 
			 if(s.length() > 0) {
				 result--;
			 }
	            
	    }
	    
	        
	    return result;
	    
	    //return list.size();
		
		
	}
	
	
	
	  public static int countConsistentStringsBROKEN(String allowed, String[] words) {
	        
	        ArrayList<String> list = new ArrayList();
	        char[] arr = null;
	        
	        for(String s: words){
	            arr = s.toCharArray();
	            Arrays.sort(arr);
	            
	            list.add(new String(arr));
	        }
	        
	        for(int runner = 0; runner < allowed.length();runner++){
	            for(int runner2 = 0; runner2 <= list.size() - 1; runner2++){
	                
                    if(list.get(runner2).charAt(0) != allowed.charAt(runner)){
                        if(runner2 > 0){
                            list.remove(runner2);
                            runner2--;
                            //break;
                        }else{
                            list.remove(runner2);
                            //break;
                        }
                    }
                    
	            }
	        }
	        
	        
	        
	        
	        return list.size();
	    }
	
	public static void main(String[] args) {
//		String allowed = "ab";
//		String[] words = new String[] {"ad","bd","aaab","baa","badab"};
		
//		String allowed = "abc";
//		String[] words = new String[] {"a","b","c","ab","ac","bc","abc"};
//		
		String allowed = "cad";
		String[] words = new String[] {"cc","acd","b","ba","bac","bad","ac","d"};
		
		
		System.out.println(countConsistentStrings(allowed, words));
	}

}
