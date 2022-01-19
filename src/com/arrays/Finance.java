package com.arrays;

import java.util.Scanner;

public class Finance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		double pay = scan.nextDouble();
		
		System.out.println("RRSP: "+ (pay * 0.35));
		System.out.println("Emergency Fund: "+ (pay * 0.15));
		System.out.println("House Manulife: "+ (pay * 0.15));
		System.out.println("TFSA: "+ (pay * 0.15));
		System.out.println("CIBC: "+ (pay * 0.15));
		System.out.println("Savings: "+ (pay * 0.05));
		

	}

}
