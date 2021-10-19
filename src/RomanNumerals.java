import java.util.HashMap;

public class RomanNumerals {
	 public int romanToInt(String s) {
	       
	        HashMap<String,Integer> table = new HashMap<String,Integer>();
	        table.put("I",1);
	        table.put("V",5);
	        table.put("X",10);
	        table.put("L",50);
	        table.put("C",100);
	        table.put("D",500);
	        table.put("M",1000);
	        
	        int total = 0;
	        
	        
	        for(int back = 0; back < s.length(); back++){
	            
	            int forward = back + 1;
	            String value = s.charAt(back)+"";
	            int valueToAdd = table.get(s.charAt(back)+"");
	            
	            
	            if(value.equals("I")){
	                 if(forward < s.length()){
	                     if((s.charAt(forward)+"").equals("V")){   
	                         valueToAdd = table.get("V") - table.get("I"); 
	                         back++;
	                     }
	                     
	                     if((s.charAt(forward)+"").equals("X")){
	                    	 valueToAdd = table.get("X") - table.get("I");
	                    	 back++;
	                     }
	                 }  
	                    
	                        
	            }else if(value.equals("X")){
	                if(forward < s.length()){
	                     if((s.charAt(forward)+"").equals("L")){   
	                    	 valueToAdd = table.get("L") - table.get("X");
	                    	 back++;
	                     }
	                     
	                     if((s.charAt(forward)+"").equals("C")){
	                    	 valueToAdd = table.get("C") - table.get("X");
	                    	 back++;
	                     }
	                 }  
	                
	            }else if(value.equals("C")){
	                if(forward < s.length()){
	                     if((s.charAt(forward)+"").equals("D")){   
	                    	 valueToAdd = table.get("D") - table.get("C");
	                    	 back++;
	                     }
	                     
	                     if((s.charAt(forward)+"").equals("M")){
	                    	 valueToAdd = table.get("M") - table.get("C");
	                    	 back++;
	                     }
	                 }  
	            }
	            
	            total += valueToAdd; 
	            
	            
	            
	            
	            
	        }
	        
	        
	        return total;
	    }
	 
	 public static void main(String [] args) {
		 
		 
		 RomanNumerals x =  new RomanNumerals();
		 
		 System.out.println(x.romanToInt("III"));
		 System.out.println(x.romanToInt("IV"));
		 System.out.println(x.romanToInt("IX"));
		 System.out.println(x.romanToInt("LVIII"));
		 System.out.println(x.romanToInt("MCMXCIV"));
	 }
}
