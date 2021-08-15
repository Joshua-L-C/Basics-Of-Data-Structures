package com.sortAlgorithms;

public class recursionExample {

	public static  int fibo(int n) {
		
		if(n == 1) {
			return 1;
		}
		
		if(n == 0) {
			return 0;
		}
		
		return fibo(n - 1) + fibo(n - 2);
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(iterativeFactorial(6));
		System.out.println(recursiveFactorial(6));
		
		
		System.out.println(fibo(7));
	}
	
	public static int recursiveFactorial(int num) {
		
		
		//Base case
		if(num == 0) {
			return 1;
		}
		
		System.out.println("recursiveFactorial("+num+")");
		return num * recursiveFactorial(num - 1);
	}
	
	public static int go(int n ,int m) {
		return (n * m);
	}
	
	
	public static int iterativeFactorial(int num) {
		if(num == 0) {
			return 1;
		}
		
		int factorial = 1;
		
		for(int i = 1; i <= num; i++) {
			factorial *= i;
		}
		
		return factorial;
	}

}
