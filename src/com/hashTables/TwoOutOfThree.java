package com.hashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoOutOfThree {
	
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] checkerArray = new boolean[101];
        
        
        recur(nums1,checkerArray,map,0);
        
        checkerArray = new boolean[101];
        
        recur(nums2,checkerArray,map,0);
        
        checkerArray = new boolean[101];
        
        recur(nums3,checkerArray,map,0);
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() >= 2){
                list.add(entry.getKey());
            }
        }
        
        return list;
        
    }
    
    public void recur(int[] array,boolean[] checkerArray, HashMap<Integer,Integer> map, int index){
        
        if(index >= array.length){
            return;
        }
        
        
        if(checkerArray[array[index]] == false){
            map.put(array[index],map.getOrDefault(array[index],0) + 1);    
            checkerArray[array[index]] = true;
        }
        
        index++;
        
        recur(array,checkerArray,map,index);
        
    }
    
    
    public List<Integer> twoOutOfThree1(int[] nums1, int[] nums2, int[] nums3) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] checkerArray = new boolean[101];
        
        for(int x: nums1){
            
            if(checkerArray[x] == false){
                map.put(x,map.getOrDefault(x,0) + 1);    
                checkerArray[x] = true;
            }
            
            //map.put(x,map.getOrDefault(x,0) + 1);
        }
        
        checkerArray = null;
        checkerArray = new boolean[101];
        
        for(int x: nums2){
            
            if(checkerArray[x] == false){
                map.put(x,map.getOrDefault(x,0) + 1);    
                checkerArray[x] = true;
            }
        }
        
        checkerArray = null;
        checkerArray = new boolean[101];
        
        for(int x: nums3){
            
            if(checkerArray[x] == false){
                map.put(x,map.getOrDefault(x,0) + 1);    
                checkerArray[x] = true;
            }
        }
        
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() >= 2){
                list.add(entry.getKey());
            }
        }
        
        return list;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
