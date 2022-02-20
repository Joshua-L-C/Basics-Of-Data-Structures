package com.arrays;

import java.util.ArrayList;

public class KeyboardWords {
	
	 public String[] findWords(String[] words) {
	        
	        int numberRow = -1;
	        ArrayList<String> list = new ArrayList<String>();
	        
	        for(String word: words){
	            
	            numberRow = rowOne(word);
	            
	            if(numberRow != -1) {
	            	list.add(word);
	            	continue;
	            }
	            
	            numberRow = rowTwo(word);
	            
	            if(numberRow != -1) {
	            	list.add(word);
	            	continue;
	            }
	            
	            numberRow = rowThree(word);
	            
	            if(numberRow != -1) {
	            	list.add(word);
	            	continue;
	            }
	        }
	        
	        
	        return list.toArray(new String[list.size()]);
	    }
	    
	    public int rowOne(String word){
	        
	        String row = "QqWwEeRrTtYyUuIiOoPp";
	        
	        for(char c: word.toCharArray()){
	            if(row.indexOf(c+"") == -1) {
	            	return -1;
	            }
	        }
	        
	            
	        return 1;
	    }
	    
	    public int rowTwo(String word){
	        
	        String row = "AaSsDdFfGgHhJjKkLl";
	        
	        for(char c: word.toCharArray()){
	        	if(row.indexOf(c+"") == -1) {
	            	return -1;
	            }
	        }
	        
	            
	        return 2;
	        
	    }
	    
	    public int rowThree(String word){
	        
	        
	        String row = "ZzXxCcVvBbNnMm";
	        
	        for(char c: word.toCharArray()){
	        	if(row.indexOf(c+"") == -1) {
	            	return -1;
	            }
	        }
	        
	            
	        return 3;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
