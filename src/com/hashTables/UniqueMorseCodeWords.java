package com.hashTables;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
	
	public int uniqueMorseRepresentations(String[] words) {
        
        
        //Arrays.sort(words);
        String[] morse = new String[]
        {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuilder holder = null;
        
        //Map<String, Integer> table = new HashMap<String, Integer>();
        Set<String> set = new HashSet<String>();
         
        char[] word = null;
         
        for(int runner = 0; runner < words.length; runner++){
            
            word = words[runner].toCharArray();
            holder = new StringBuilder();
            
            for(int wordIndex = 0; wordIndex < word.length; wordIndex++){
                holder.append(morse[word[wordIndex] - 97]);
            }
            
            //System.out.println(holder);
            //table.put(holder,0);
            set.add(holder.toString());
            holder = null;
            
        }
        
        
        
        
        return set.size();
    }
	
	public int uniqueMorseRepresentations2(String[] words) {
        
        
        
        String[] morse = new String[]
        {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuilder holder = new StringBuilder();
        
        //Map<String, Integer> table = new HashMap<String, Integer>();
        Set<String> set = new HashSet<String>();
         
        char[] word = null;
         
        for(int runner = 0; runner < words.length; runner++){
            
            word = words[runner].toCharArray();
            
            for(int wordIndex = 0; wordIndex < word.length; wordIndex++){
                holder.append(morse[word[wordIndex] - 97]);
            }
            
            //System.out.println(holder);
            //table.put(holder,0);
            set.add(holder.toString());
            holder = null;
            holder = new StringBuilder();
        }
        
        
        
        
        return set.size();
    }
    
    public int uniqueMorseRepresentations1(String[] words) {
        
        
        
        String[] morse = new String[]
        {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        String holder = "";
        
        Map<String, Integer> table = new HashMap<String, Integer>();
        
        for(int runner = 0; runner < words.length; runner++){
            for(int wordIndex = 0; wordIndex < words[runner].length(); wordIndex++){
                holder += morse[words[runner].charAt(wordIndex) - 97];
            }
            
            //System.out.println(holder);
            table.put(holder,0);
            holder = "";
        }
        
        
        
        
        return table.size();
    }
	
	public static void main(String[] args) {
		
		char[][] testerHolder = new char[10][10];
		
		//"gin","zen","gig","msg"
		testerHolder[0] = new char[] {'g','i','n'};
		testerHolder[1] = new char[] {'z','e','n'};
		testerHolder[2] = new char[] {'g','i','g'};
		testerHolder[3] = new char[] {'r','a','k','e'};
		testerHolder[4] = new char[] {'r','a','k','b'};
		
		Arrays.sort(testerHolder, new Comparator<char[]>() {

			
			public int compare(char[] o1, char[] o2) {
				// TODO Auto-generated method stub
				if(o1.length > o2.length) {
					return 1;
				}else if(o1.length < o2.length){
					return -1;
				}else{
					
					for(int runner = 0; runner < o1.length; runner++) {
						if(o1[runner] > o2[runner]) {
							return 1;
						}else if(o1[runner] < o2[runner]) {
							return -1;
						}
					}
					
					
					
					return 0;
				}
			}
			
		});
		
		for(int runner = 0; runner < testerHolder.length; runner++) {
			
			System.out.println(testerHolder[runner]);
		}
		
		
	}

}

