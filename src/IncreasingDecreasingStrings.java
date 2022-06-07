
public class IncreasingDecreasingStrings {
	
	 public static String sortString(String s) {
	        
		 int[] charArray = new int[26];
	        StringBuilder result = new StringBuilder();
	        
	        for(int runner = 0; runner < s.length(); runner++){
	            //System.out.println(s.charAt(runner)+":"+((int)s.charAt(runner) - 97));
	            charArray[(int)s.charAt(runner) - 97] += 1;
	        }
	        
	        boolean stillBuilding = true;
	        
	        while(stillBuilding){
	           stillBuilding = false;
	            
	           for(int runner = 0; runner < charArray.length; runner++){ 
	               if(charArray[runner] != 0){
	                   charArray[runner] -= 1;
	                   result.append( (char)(runner + 97));
	                   stillBuilding = true;    
	               }
	               
	               
	           }
	            
	           for(int runner = charArray.length - 1; runner >= 0 ; runner--){ 
	               if(charArray[runner] != 0){
	                   charArray[runner] -= 1;
	                   result.append( (char)(runner + 97));
	                   stillBuilding = true;    
	               }
	           }
	            
	        }
	        
	        
	        //System.out.println();
	        
	        // for(int runner = 0; runner < charArray.length; runner++){
	        //     System.out.println("Index: "+runner+" "+charArray[runner]);
	        // }
	        
	        return result.toString();
	    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(sortString("aaaabbbbcccc"));
	}

}
