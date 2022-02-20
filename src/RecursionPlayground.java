
public class RecursionPlayground {
	
	public static void sayHello() {
		
		System.out.println("Hello");
		
		 sayHello();
	}
	
	public static void sayHelloCounter(int count) {
		
		if(count == 0) {
			return;
		}		
		sayHelloCounter(count - 1);
		
		System.out.println("Hello " + count);
	}
	
	public static void countUp(int count) {
		
		if(count == 0) {
			return;
		}
		
		countUp(count - 1);
		System.out.println(count);
	}
	
	              
	public static void countDown(int count) {
		
		if(count == 0) {
			System.out.println("Lift Off!");
			return;
		}
		
		System.out.println(count);
		countDown(count - 1);
		
	}
	
	public static int factorial(int num) {
		
		if(num == 0) {
			return 1;
		}
		
		int x = num * factorial(num - 1);
		
		return x;
	}
	
	public static int pow(int base, int exp) {
		
		if(exp == 0) {
			return 1;
		}
		
		int x = base * pow(base, exp - 1);
		return x;
	}
	
	public static int lucas(int num) {
		
		if(num == 0) {
			return 2;
		}else if(num == 1) {
			return 1;
		}
		
		
		
		return lucas(num - 1) + lucas(num - 2);
	}
	
	public static int sumArray(int[] array , int leng) {
		
		if(leng == 0) {
			return array[leng];
		}
		
		int x = array[leng];
		int y = sumArray(array,leng - 1); 
		
		return x + y;
		
	}
	
	public static String reverseString(String str, int loc) {
		
		if(loc == 1) {
			return str.charAt(0)+"";
		}
		
		str = str.substring(0,str.length() - 1);
		String x = reverseString(str, str.length());
		
		return x;
		
	}
	
	public static void main(String[] args) {
		//sayHello();
		//sayHelloCounter(10);
		System.out.println();
		System.out.println("Count Up:");
		countUp(10);
		
		System.out.println();
		System.out.println("Count Down:");
		countDown(10);
		
		System.out.println();
		System.out.println();
		System.out.println(factorial(5));
		System.out.println(pow(5,3));
		System.out.println(lucas(6));
		System.out.println(sumArray(new int[]{1,2,3,1},3));
		System.out.println(reverseString("wert","wert".length()));//trew
		
	}

}
