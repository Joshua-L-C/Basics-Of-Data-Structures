import java.util.ArrayList;
import java.util.List;

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

        return digits;
	}
	
	
    public List<Integer> addToArrayForm(int[] num, int k) {
        
    	
    	List<Integer> list = new ArrayList<Integer>();
        if(num.length >= (int) (Math.log10(k) + 1)){
            
            int carryOver = 0;
            int[] number = new int[num.length];
            
            for(int runner = num.length - 1; runner >= 0 && k >= 0; runner--){
                
               // System.out.println(num[runner]);
                
                
                num[runner] = num[runner] + (k % 10) + carryOver;
                //System.out.println("K: " + (k % 10));
                k /= 10;
                
                
                carryOver = num[runner] / 10;
                
                if(num[runner] >= 10) {
                	num[runner] = num[runner] % 10;
                }
                
               // System.out.println(carryOver);
            }
            
            
            if(carryOver != 0) {
            	number = new int[num.length + 1];
            	
            	number[0] = carryOver;
            	for(int runner = 1; runner < number.length;runner++) {
            		number[runner] = num[runner - 1];
            	}
            	
            	
            }else {
            	number = num;
            }
            
            
            list = new ArrayList<Integer>();
            for(int runner = 0; runner < number.length;runner++) {
            	list.add(number[runner]);
            }
           
        }else {
        	
        	int[] topNumber = new int[(int) (Math.log10(k) + 1)]; 
        	int[] bottomNumber = new int[(int) (Math.log10(k) + 1)];
        	String numberString = k+"";
        	
        	for(int run = 0; run < numberString.length(); run++) {
        		topNumber[run] = Integer.parseInt(numberString.charAt(run)+ "");
        	}
        	
        	for(int run = topNumber.length - 1, secRun = num.length - 1; run >= 0; run--) {
        		
        		//bottomNumber[run] = 0;
        		
        		if(secRun >= 0) {
        			bottomNumber[run] = num[secRun];
        			secRun--;
        		}else {
        			bottomNumber[run] = 0;
        		}
        		
        		
//        		if(run - 1 == num.length) {
//        			bottomNumber[run] = num[secRun];
//        			secRun++;
//        		}
        	}
        	
        	
        	
        	
        	
        	
        	int carryOver = 0;
        	
        	for(int run = bottomNumber.length - 1; run >= 0; run--) {
        		
        		
        		 topNumber[run] = topNumber[run] + bottomNumber[run] + carryOver;
                 //System.out.println("K: " + (k % 10));
                 
                 carryOver = topNumber[run] / 10;
                 
                 if(topNumber[run] >= 10) {
                	 topNumber[run] = topNumber[run] % 10;
                 }
        		
        	}
        	
        	 int[] number = new int[topNumber.length + 1];
        	 if(carryOver != 0) {
             	number = new int[topNumber.length + 1];
             	
             	number[0] = carryOver;
             	for(int runner = 1; runner < number.length;runner++) {
             		number[runner] = topNumber[runner - 1];
             	}
             	
             	
             }else {
             	number = topNumber;
             }
             
             
             list = new ArrayList<Integer>();
             for(int runner = 0; runner < number.length;runner++) {
             	list.add(number[runner]);
             }
        }
        
       
	        
	        //System.out.println();
	        return list;
        }
    
	
	public static void main(String[] args) {
		PlusOne x = new PlusOne();
		int[] value = x.plusOne(new int[]{9,2,4});

		//List<Integer>li =   x.addToArrayForm(new int[]{1,2,0,0},34);
		List<Integer>li = x.addToArrayForm(new int[]{9,3},636);
		
		for(Integer v : li) {
			System.out.println(v);
		}
		
		
//		for(int runner = 0; runner < value.length; runner++) {
//			System.out.println(value[runner]);
//		}
	}

}
