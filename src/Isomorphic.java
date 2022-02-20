import java.util.HashMap;

public class Isomorphic {
	
	 public static boolean isIsomorphic(String s, String t) {
	        
	        //HashMap<Character,Character> map = new HashMap<Character,Character>();
	        int[] letters = new int[26];
	        
	        for(int runner = 0; runner < letters.length; runner++){
	            letters[runner] = -1;
	        }
	        
	        for(int runner = 0; runner < s.length(); runner++){
	            
	            char firstChar =  s.charAt(runner);
	            char secondChar = t.charAt(runner);
	        
	            
	            if(letters[firstChar - 'a'] != -1){
	                if(letters[firstChar - 'a'] != (secondChar - 'a')){
	                    return false;
	                }
	            }else if(letters[secondChar - 'a'] != -1){
	                if(letters[secondChar - 'a'] != (firstChar - 'a')){
	                    return false;
	                }
	            }else if(letters[firstChar - 'a'] == -1){
	                if(letters[secondChar - 'a'] == -1){
	                    letters[firstChar - 'a'] = (secondChar - 'a');
	                    letters[secondChar - 'a'] = (firstChar - 'a');
	                }
	            }
	          
	            
	        }
	        
	        
	        
	        return true;
	        
	    }
	 
	 public static boolean isIsomorphic2(String s , String t) {
	        
	        HashMap<Character,Character> map = new HashMap<Character,Character>();
	        
	        for(int runner = 0; runner < s.length(); runner++){
	            
	            char firstChar = s.charAt(runner);
	            char secondChar = t.charAt(runner);
	            
	            
	            if(map.containsKey(firstChar)){
	                if(map.get(firstChar).toString().charAt(0)  !=  secondChar){
	                    return false;
	                }
	            }else{
	                map.put(firstChar,secondChar);    
	            }
	            
	            
	        }
	        
	        
	        
	        return true;
	 }

	public static void main(String[] args) {
		//System.out.println(isIsomorphic("bacd", "baba"));
		System.out.println(isIsomorphic2("paper", "title"));
		System.out.println(isIsomorphic2("paper", "title"));

	}

}
