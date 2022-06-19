package com.hashTables;

import java.util.HashMap;

public class checkIfPangram {
	public boolean checkIfPangram(String sentence) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        
        for(int runner = 0; runner < alphabets.length(); runner++){
            if(!sentence.contains(""+alphabets.charAt(runner))){
                return false;
            }
        }
        
        return true;
    }
    
    public boolean checkIfPangram2(String sentence) {
        int[] vals = new int[123];
        char[] sent = sentence.toCharArray();
        
        int count = 0;
        for(int runner = 0; runner < sent.length;runner++){
            if(vals[sent[runner]] > 0){
                
                if(count == 26){
                    return true;
                }
            }else{
                vals[sent[runner]] = 1;
                count++;
            }
        }
        
        
        
        return count == 26;
    }
    
    public boolean checkIfPangram1(String sentence) {
        char[] sent = sentence.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char ch: sent){
            map.put(ch,1);
        }
        
        
        return map.size() == 26;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
