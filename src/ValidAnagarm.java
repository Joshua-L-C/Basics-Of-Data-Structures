
public class ValidAnagarm {
	
	
	 public static boolean isAnagram(String s, String t) {
	        
	        //String newstr = str.substring(0, idx) + str.substring(idx + 1);
		 
		 
		 if(t.length() != s.length()){
	            return false;
	       }
	        
	        
		int index = 0;
	    for(int runner = 0; !t.equals("");){
	            System.out.println(t.charAt(runner));    
	            
	            index = s.indexOf(t.charAt(runner));
	            
	            if(index == -1){
	                return false;
	            }else{
	            	s = s.substring(0, index) + s.substring(index + 1);
	            	t = t.substring(1);
	            }
	            
	            
	        }
	        
	        
	        return true;
	    }
	
	
	public static void main(String [] args) {
		
		
		System.out.println(isAnagram("aacc","ccac"));
	}
}
