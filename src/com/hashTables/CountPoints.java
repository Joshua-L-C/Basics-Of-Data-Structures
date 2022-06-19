package com.hashTables;

import java.util.HashMap;
import java.util.Map;

public class CountPoints {
	
	public static int countPoints(String rings) {
        
        char[] ringsCharArray = rings.toCharArray();
	    char[][] table = new char[101][123];
	    int result = 0;
        
        for (int positionIndex = ringsCharArray.length - 1, ringColor = positionIndex
			- 1; positionIndex >= 0; positionIndex -= 2, ringColor -= 2) {
         
        	//System.out.println(positionIndex);
        	
            table[Integer.parseInt(String.valueOf(ringsCharArray[positionIndex]))][ringsCharArray[ringColor]] = 1;
            
            
        }
        
        
        //System.out.println("EE");
        
        for(int indexRunner = 0; indexRunner < table.length;indexRunner++) {
        	
        	if(table[indexRunner][82] + table[indexRunner][66] + table[indexRunner][71] == 3) {
        		result++;
        	}
        	
        	
        	//System.out.println(indexRunner + " "+table[indexRunner][82]+" "+table[indexRunner][66]+" "+table[indexRunner][71]+" ");
        	
//        	for(int indexRunner2 = 0; indexRunner2 < table[0].length;indexRunner2++) {
        		
        		//System.out.print(table[indexRunner][indexRunner2] + " ");
        		
        	//}
        	
        	
        }
        
        
        
        
        return result;
    }
	
	public static int countPoints3(String rings) {
		
		char[] ringsCharArray = rings.toCharArray();
		Map<Integer, char[]> rods = new HashMap<Integer, char[]>();
		
		int result = 0;
		char[] x = null;

		for (int positionIndex = ringsCharArray.length - 1, ringColor = positionIndex
				- 1; positionIndex >= 0; positionIndex -= 2, ringColor -= 2) {

			int index = Integer.parseInt(String.valueOf(ringsCharArray[positionIndex]));

			if (rods.containsKey(index)) {
				if (rods.get(index)[ringsCharArray[ringColor]] == 0) {
					rods.get(index)[ringsCharArray[ringColor]] = 1;
					//rods.put(index,( ));
				}

			} else {
				
				x = new char[125];
				x[ringsCharArray[ringColor]] = 1;
				rods.put(index, x);
				
			}
		}

		for(Map.Entry<Integer, char[]> entry : rods.entrySet()) {
			
			
//			for(int runner = 0; runner < entry.getValue().length; runner++) {
//				System.out.println(runner + " : "+entry.getValue()[runner]);
//			}
			
			if(entry.getValue()[82] == 1 && entry.getValue()[66] == 1 && entry.getValue()[71] == 1) {
				result++;
			}
			
		}

		return result;
	}
	
	
	
	public static int countPoints2(String rings) {

		char[] ringsCharArray = rings.toCharArray();
		Map<Integer, StringBuilder> rods = new HashMap<Integer, StringBuilder>();
		
		int result = 0;
		StringBuilder x = null;

		for (int positionIndex = ringsCharArray.length - 1, ringColor = positionIndex
				- 1; positionIndex >= 0; positionIndex -= 2, ringColor -= 2) {

			int index = Integer.parseInt(String.valueOf(ringsCharArray[positionIndex]));

			if (rods.containsKey(index)) {
				if (rods.get(index).indexOf(Character.toString(ringsCharArray[ringColor])) == -1) {
					rods.put(index, rods.get(index).append(ringsCharArray[ringColor]));
				}

			} else {
				
				x = new StringBuilder();
				x.append(ringsCharArray[ringColor]);
				rods.put(index, x);
				
			}
		}

		for(Map.Entry<Integer, StringBuilder> entry : rods.entrySet()) {
			
			if(entry.getValue().length() == 3) {
				result++;
			}
			
		}

		return result;

	}
	
	public static void main(String[] args) {
		
		//String rings = "B0B6G0R6R0R6G9";
		String rings = "B0R0G0R9R0B0G0";
		//String rings = "G4";

		System.out.println(countPoints(rings));
		
	}

}
