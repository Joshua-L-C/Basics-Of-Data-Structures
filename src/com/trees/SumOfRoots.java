package com.trees;

import java.util.ArrayList;

public class SumOfRoots {
	
    public static int sumRootToLeaf(TreeNode root) {
        
        //ArrayList<String> list = new ArrayList<String>();
        
        int total = 0;
        int[] runnerArray = new int[3];
        total = rollUp(root,runnerArray)[0];
        
         //rollUp(root,list,"");
        
        //total = rollUp2(root,total,new StringBuilder());
        //total = rollUp1(root,"");
        
        
		
// 		for (String x : list) {

// 			total += convert(x, runnerArray)[0];
			
// 			runnerArray = new int[3];
// 		}
                
        // System.out.println("Total: "+total);
        // System.out.println();
        return total;    
    }

    
    public static int[] rollUp(TreeNode root, int[] valuesArray){
        
        if(root == null){
            valuesArray[1]--;
            valuesArray[2] = valuesArray[1];
            return valuesArray;
        }
        
        int[]currentArray = new int[3];
        currentArray[1] = valuesArray[1] + 1;
        
        int[] fromLeft = rollUp(root.left,currentArray);
        int[] fromRight = rollUp(root.right,currentArray);
        
        if(root.val == 1){
            currentArray[0] += (Math.pow(2,currentArray[1]));
            currentArray[0] += (Math.pow(2,currentArray[1]));
        }else{
            currentArray[0] += fromLeft[0];
            currentArray[0] += fromRight[0];
        }
        
        return currentArray;
    }

	public static int sumRootToLeaf2(TreeNode root) {

		ArrayList<String> list = new ArrayList<String>();

		int total = 0;

		rollUp(root, list, "");
		// total = rollUp2(root,total,new StringBuilder());
		// total = rollUp1(root,"");

		int numberValue = 0;
		int[] runnerArray = new int[3];
		for (String x : list) {

			total += convert(x, runnerArray)[0];
			
			runnerArray = new int[3];
		}

		// System.out.println("Total: "+total);
		// System.out.println();
		return total;
	}

	public static  int sumRootToLeaf1(TreeNode root) {

		ArrayList<String> list = new ArrayList<String>();

		int total = 0;

		rollUp(root, list, "");
		// total = rollUp2(root,total,new StringBuilder());
		// total = rollUp1(root,"");

		int numberValue = 0;
		for (String x : list) {

			for (int runner = 0, exponent = x.length() - 1; runner < x.length(); runner++, exponent--) {

				if (x.charAt(runner) == '1') {
					numberValue += Math.pow(2, exponent);
				}
			}

			total += numberValue;
			numberValue = 0;
		}

		// System.out.println("Total: "+total);
		// System.out.println();
		return total;
	}

	public static  int[] convert(String number, int[] runnerArray) {

		if (runnerArray[1] == number.length() - 1) {
			
			runnerArray[2] = runnerArray[1] ;
			
			if (number.charAt(runnerArray[1]) == '1') {
				runnerArray[0] += Math.pow(2, 0);
			}
			
			runnerArray[1] = 1;
			
			return runnerArray;
		}

		int[] currentArray = new int[3];
		int currentIndex = runnerArray[1];
		runnerArray[1] += 1;
		
		currentArray = convert(number,runnerArray);

		if (number.charAt(currentIndex) == '1') {
			currentArray[0] += Math.pow(2,currentArray[2] - currentIndex);
		}
		
		currentArray[1] -= 1;

		return currentArray;
	}

	public static int rollUp2(TreeNode root, int total, StringBuilder current) {

		if ((root.left == null && root.right == null)) {

			// current += root.val;
			current.append(root.val);

			int numberValue = 0;

			for (int runner = 0, exponent = current.length() - 1; runner < current.length(); runner++, exponent--) {

				if (current.charAt(runner) == '1') {
					numberValue += Math.pow(2, exponent);
				}
			}

			System.out.println("Current: |" + current + "| Function Total: " + total);

			return numberValue;
		}

		// current += root.val;
		current.append(root.val);

		int sum1 = 0;
		int sum2 = 0;

		sum1 = rollUp2(root.left, total, current);
		sum2 = rollUp2(root.right, total, current);

		return sum1 + sum2;
	}

	public static  int rollUp1(TreeNode root, String current) {

		if (root == null) {
			return 0;
		}

		if ((root.left == null && root.right == null)) {
			current += root.val;

			int numberValue = 0;

			for (int runner = 0, exponent = current.length() - 1; runner < current.length(); runner++, exponent--) {

				if (current.charAt(runner) == '1') {
					numberValue += Math.pow(2, exponent);
				}
			}

			// System.out.println("Current: |"+current+"| Function Total: " + total);

			return numberValue;
		}

		current += root.val;

		int sum1 = 0;
		int sum2 = 0;

		sum1 = rollUp1(root.left, current);
		sum2 = rollUp1(root.right, current);

		return sum1 + sum2;
	}

	public static void rollUp(TreeNode root, ArrayList<String> listOfNumbers, String current) {

		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			current += root.val;
			listOfNumbers.add(current);
			return;
		}

		current += root.val;

		rollUp(root.left, listOfNumbers, current);
		rollUp(root.right, listOfNumbers, current);

		return;
	}

		// TODO Auto-generated method stub

	public static void main(String[] args) {
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(0);
		TreeNode three = new TreeNode(1);
		TreeNode four = new TreeNode(0);
		TreeNode five = new TreeNode(1);
		TreeNode six = new TreeNode(0);
		TreeNode seven = new TreeNode(1);
//		TreeNode eight = new TreeNode(8);
//		TreeNode nine = new TreeNode(9);
		
		
		one.left = two;
		one.right = three;
		
		two.left = four;
		two.right = five;
		
		three.left = six;
		three.right = seven;
		
		//System.out.println(sumRootToLeaf(one));
		
		
		System.out.println(Integer.parseInt("111", 2));
	}
	
}




