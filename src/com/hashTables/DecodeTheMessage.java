package com.hashTables;

import java.util.HashMap;

public class DecodeTheMessage {
	 public static String decodeMessage(String key, String message){
	        int[] array = new int[256];
	        StringBuilder result = new StringBuilder();
	        
	        char[] keyArray = key.toCharArray();
	        char[] messageArray = message.toCharArray();
	        
	        for(int runner = 0,index = 97; runner < keyArray.length; runner++){
	            
	            if(keyArray[runner] != ' ' && array[keyArray[runner]] == 0){
	                
	                array[keyArray[runner]] = index;
	                
	                
	                 // System.out.println("Key: "+keyArray[runner]);
	                 // System.out.println("Value: "+((char)index));
	                
	                index++;
	            }
	            
	        }
	        //System.out.println();
	        
	        for(int runner = 0; runner < messageArray.length;runner++){
	            
	            if(messageArray[runner] != ' '){
	                
	                //System.out.println("Search: "+messageArray[runner]);
	                
	                result.append(getChar(array[messageArray[runner] - 0]));
	                    
	            }else{
	                
	                result.append(' ');
	            }
	            
	        }
	        
	        return result.toString();   
	        
	    }
	    
	    
	    public String decodeMessage3(String key, String message){
	        int[] array = new int[256];
	        StringBuilder result = new StringBuilder();
	        
	        for(int runner = 0,index = 97; runner < key.length(); runner++){
	            
	            if(key.charAt(runner) != ' ' && array[key.charAt(runner)] == 0){
	                
	                array[key.charAt(runner)] = index;
	                
	                
	                // System.out.println("Key: "+key.charAt(runner));
	                // System.out.println("Value: "+((char)index));
	                
	                index++;
	            }
	            
	        }
	        
	        for(int runner = 0; runner < message.length();runner++){
	            
	            if(message.charAt(runner) != ' '){
	            
	                result.append(getChar(array[message.charAt(runner)]));
	                    
	            }else{
	                
	                result.append(' ');
	            }
	            
	        }
	        
	        return result.toString();
	    }
	    
	    
	    
	    public String decodeMessage2(String key, String message){
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        
	        String results = "";
	        int holder = 0;
	        char charHolder = 'a';
	        
	        for(int runner = 0,index = 97; runner < key.length(); runner++){
	            
	            if((key.charAt(runner)) != ' ' && !map.containsKey(((int)key.charAt(runner)))){
	                
	                holder = (key.charAt(runner)); 
	                
	                // System.out.println("Key: "+((char)holder));
	                // System.out.println("Value: "+((char)index));
	                
	                map.put(holder,index);
	                
	                index++;
	            }
	        }
	    
	        //System.out.println();
	        
	        for(int runner = 0; runner < message.length(); runner++){
	            
	            if(message.charAt(runner) != ' '){
	                
	                holder = (message.charAt(runner));
	                
	                charHolder = getChar(map.get(holder));
	                
	                //System.out.print(charHolder);
	                
	                results += charHolder;
	                
	            }else{
	                results += " ";
	            }
	            
	        }
	        
	        
	        
	        return results;
	        
	    }
	    
	    public static char getChar(int x){
	        return (char)x;
	    }
	    
	    
	    public String decodeMessage1(String key, String message) {
	        
	        HashMap<Character,Character> map = new HashMap<Character,Character>();
	        String result = "";
	        char alphabet = 'a';
	        
	        
	        for(int runner = 0,index = 97; runner < key.length(); runner++){
	            
	            if((key.charAt(runner)) != ' ' && !map.containsKey((key.charAt(runner)))){
	                
	                alphabet = (char)(index);
	                
	                map.put(key.charAt(runner), alphabet);
	                
	                index++;
	            }
	        }
	        
	        for(int runner = 0; runner < message.length(); runner++){
	            
	            if(message.charAt(runner) != ' '){
	                result += map.get(message.charAt(runner));
	            }else{
	                result += " ";
	            }
	            
	        }

	        return result;        
	    }
	 
	 
	public static void main(String[] args) {
		
		
		
//		"eljuxhpwnyrdgtqkviszcfmabo"
//		"zwx hnfx lqantp mnoeius ycgk vcnjrdb"

		String key = "the quick brown fox jumps over the lazy dog";
		String message = "vkbs bs t suepuv";
		
		System.out.println(decodeMessage(key, message));
	}

}
