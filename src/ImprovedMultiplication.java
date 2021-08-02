import java.util.ArrayList;

public class ImprovedMultiplication {

	public static String multiplicationExplaied(int first, int second) {
		
		int lengthOfFirst = (int)Math.log10(first) + 1;
		int lengthOfSecond = (int)Math.log10(second) + 1;
		
		int top;
		int bottom;
	
		if(((first % 10) > (second % 10)) && lengthOfFirst == lengthOfSecond ) {
			top = first;
			bottom = second;
		}else if(((first % 10) < (second % 10)) && lengthOfFirst == lengthOfSecond) {
			top = second;
			bottom = first;
		}else {
			
			if(first > second) {
				top = first;
				bottom = second;
			}else if(first < second) {
				top = second;
				bottom = first;
			}else{
				HumanSquaringObject x = new HumanSquaringObject();
				x.humanSquaring(first);
				return x.calculationRoll;
			}
			
			
		}
		
		System.out.println("TOP: " + top);
		System.out.println("BOTTOM: " + bottom);
		
	
		int lengthOfTop = (int)Math.log10(top) + 1;
		int lengthOfBottom = (int)Math.log10(bottom) + 1;
	
		int multiplier = 0;
		int calculatedValue = 0;
		int totalCalculatedValue = 0;
		int spaceZero = 0;
		String repeated = "";
		
		
		for(int outer = lengthOfBottom ;outer >= 1; outer--) {
			
			multiplier = (bottom / (int)Math.pow(10, outer - 1) % 10);
			
			//System.out.println(multiplier);
			
			spaceZero = ((outer % 10) - 1);
			
			
			
			for(int runner = lengthOfTop, spaces = 1 ;runner >= 1; runner-- , spaces++) {
				
				//System.out.println((top / (int)Math.pow(10, runner - 1) % 10) * multiplier + " Zeros:" +(runner - 1)) ;
				
				calculatedValue = (top / (int)Math.pow(10, runner - 1) % 10) * multiplier * (int)Math.pow(10, (runner -1) + (spaceZero))  ;
				
				totalCalculatedValue += calculatedValue;
			
				repeated += calculatedValue;
				repeated += "\n";
				
			
			}
			
			repeated += "\n";
			repeated += totalCalculatedValue;
			repeated += "\n";
			
			totalCalculatedValue = 0;
			System.out.println();
		}

		
		
		
		//repeated = new String(new char[n]).replace("\0", s);
		
		System.out.println(repeated);
		return"";
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println(multiplicationExplaied(912, 9));
//		System.out.println((275 - (275 % 100))/ 100  );
//		System.out.println((275 % 10) );
		//System.out.println(multiplicationExplaied(55, 55));
		
		

	}

}
