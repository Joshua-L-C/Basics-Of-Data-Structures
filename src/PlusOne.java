
public class PlusOne {
	public int[] plusOne(int[] digits) {
        
        String number = "";
        int carry = 0;
        
        
        
        if(digits.length > 1) {
	        for(int run = digits.length - 1; run >= 0;run--){
	            
	        	if(run == digits.length - 1) {
	        		digits[run] = digits[run] + 1;
	        		
	        		
	        		if(digits[run] >= 10){
	                    carry = 1;
	                    digits[run] = digits[run] % 10;
	                }
	        	}
	        	
	        	
	        	if(run != 0 && run < digits.length - 1){
	        		digits[run] = digits[run] + carry;
	        		
	        		if(digits[run] >= 10){
	                    carry = 1;
	                    digits[run] = digits[run] % 10;
	                }else {
	                	carry = 0;
	                }
	        	}
	            
	        	if(run == 0) {
	        		digits[run] = digits[run] + carry;
	        	}
	            
	                
	            number += digits[run];
	        }
	        
	        if(digits[0] >= 10) {
	        	int[] sendBack = new int[digits.length + 1];
	        	sendBack[0] = 1;
	        	digits[0] = digits[0] % 10;
	        	for(int runner = 0,sendRunner = 1; runner < digits.length; runner++) {
	        		sendBack[sendRunner] = digits[runner];
	        		sendRunner++;
	        	}
	        	
	        	return sendBack;
	        }
        }else {
        	digits[0] = digits[0] + 1;
        	
        	
        	if(digits[0] >= 10) {
        		int [] sendBack = new int[digits.length + 1];
        		sendBack[0] = 1;
	        	digits[0] = digits[0] % 10;
	        	sendBack[1] = digits[0];
	        	
	        	return sendBack;
        	}else {
        		
        		return digits;
        	}
        }
        
        

        	
        	
        	
        
        
        
//         int num = Integer.parseInt(number);
//         number = "";
//         number = (num + 1) +"";
        
//         int[] list = new int[number.length()];
        
//         for(int run = 0; run < number.length();run++){
//             list[run] = (Integer.parseInt(number.charAt(run)+""));
//         }
        
        
//         return list;
        
        //System.out.println(number);
        
//        for(int runner = 0; runner < digits.length;runner++) {
//        	System.out.println(digits[runner]);
//        }
        
        return digits;
	}
	
	public static void main(String[] args) {
		PlusOne x = new PlusOne();
		int[] value = x.plusOne(new int[]{9,2,4});

		
		for(int runner = 0; runner < value.length; runner++) {
			System.out.println(value[runner]);
		}
	}

}
