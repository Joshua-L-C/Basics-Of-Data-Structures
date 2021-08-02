
public class AppendandDelete {
	
	 public static String appendAndDelete(String originString, String templateString, int k) {
		    
	        int originStringLeng = originString.length() - 1;
	        int templateStringLeng = templateString.length() - 1;
	        
	        int unequalPoint = 0;
	        
	        
	        
	        for(int runner = 0; originString.charAt(runner) == templateString.charAt(runner) && runner < originStringLeng && runner < templateStringLeng ;runner++){
	            System.out.println(originString.charAt(runner));
	            unequalPoint = runner;
	        }
	        
	        if(unequalPoint == templateStringLeng && unequalPoint == originStringLeng){
	            return "Yes";
	        }
	            
	            int x = originStringLeng - unequalPoint;
	            int y = templateStringLeng - unequalPoint;
	            
	         
	        
	        
	        
	        
	        //System.out.println("Spaces: " +spaces);
	        if(x + y <= k){
	            return "Yes";
	        }else{
	            return "No";    
	        }
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
