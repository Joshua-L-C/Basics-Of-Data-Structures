package com.stack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxAreaOfIsland {
	
	public static int maxAreaOfIsland(int[][] grid) {
		
		
		int biggestIsland = 0;
		int holderArea = 0;
		
		for(int runner = 0; runner < grid.length;runner++) {
			for(int runnerTwo = 0; runnerTwo < grid[0].length;runnerTwo++) {
				
				if(grid[runner][runnerTwo] == 1) {
					holderArea = dfs(grid, runner, runnerTwo,holderArea);
					
					if(holderArea > biggestIsland) {
						biggestIsland = holderArea;
						
					}
					holderArea = 0;
				}
				
				
			}
		}
		
		return biggestIsland;
		
		
    }
	
	public static int dfs(int[][] grid, int x, int y, int area) {
		
		if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == 0) {
			return area;
		}
		
		grid[x][y] = 0;
		area = area + 1;
		
		area = dfs(grid, x + 1, y, area);
		area = dfs(grid, x - 1, y, area);
		area = dfs(grid, x, y + 1, area);
		area = dfs(grid, x, y - 1, area);
		
		
		return area;
	}
	

	 public static int minSteps(String s, String t) {
	        
	        HashMap<String, Integer> tableS = new HashMap<String, Integer>();
	        HashMap<String, Integer> tableT = new HashMap<String, Integer>();
	        
	        
	      for(int runner = 0; runner < s.length(); runner++){
	          
	          
	          if(tableS.get(s.charAt(runner) + "") == null){
	              tableS.put(s.charAt(runner) + "", 1);
	         
	          }else{
	        	  int count = tableS.get(s.charAt(runner) + "");
	              tableS.put(s.charAt(runner) + "", count + 1);
	          }
	          
	          
	          
	      }
	      
	      for(int runner = 0; runner < t.length(); runner++){
	          
	          
	          if(tableT.get(t.charAt(runner) + "") == null){
	        	  tableT.put(t.charAt(runner) + "", 1);
	         
	          }else{
	        	  int count = tableT.get(t.charAt(runner) + "");
	        	  tableT.put(t.charAt(runner) + "", count + 1);
	          }
	          
	          
	          
	      }
	        
	      int total = 0;
	     
	      
	      for(Map.Entry<String, Integer> entry : tableT.entrySet()) {
	    	  	if(tableS.get(entry.getKey()) != null) {
	    	  		if(tableS.get(entry.getKey()) < entry.getValue()) {
	    	  			//System.out.println(entry.getKey() + " " +tableS.get(entry.getKey()));
	    	  			total += Math.abs(tableS.get(entry.getKey()) - entry.getValue());
	    	  		}
	    	  		
	    	  	}else {
	    	  		total += entry.getValue();
	    	  	}
	      }
   

	      
	      
	
	      
	        return total;
	    }
	      
	      
	

	public static List<String> subdomainVisits(String[] cpdomains) {
    
    HashMap<String, Integer> domains = new HashMap<String, Integer>();
    
    for(int runner = 0; runner < cpdomains.length ; runner++){
        int space = cpdomains[runner].indexOf(" ");
        
        int rep = Integer.parseInt(cpdomains[runner].substring(0,space));
        String dom = cpdomains[runner].substring(space + 1,cpdomains[runner].length());
        
        while(dom.indexOf(".") != -1){
            domains.put(dom, domains.getOrDefault(dom,0) + rep);
            int period = dom.indexOf(".");
            
            if(period == -1){
                dom = dom.substring(0,dom.length());    
            }else{
                dom = dom.substring(period + 1,dom.length());    
            }
            
        }
        domains.put(dom, domains.getOrDefault(dom,0) + rep);
        
        //System.out.println(rep+dom);
    }
    
    
    for(Map.Entry<String, Integer> entry : domains.entrySet()) {
    	System.out.println(entry.getKey() + " " + entry.getValue());
    }
    
    
    return null;
}

	public static void main(String[] args) {
		
		

		
//		int[][] array = {{1,1,0,1,0},
//		  		         {0,0,0,1,0},
//		  		         {1,1,0,1,0},
//		  		         {0,0,0,0,1}};
		
//		int[][]array = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
//				        {0,0,0,0,0,0,0,1,1,1,0,0,0},
//				        {0,1,1,0,1,0,0,0,0,0,0,0,0},
//				        {0,1,0,0,1,1,0,0,1,0,1,0,0},
//				        {0,1,0,0,1,1,0,0,1,1,1,0,0},
//				        {0,0,0,0,0,0,0,0,0,0,1,0,0},
//				        {0,0,0,0,0,0,0,1,1,1,0,0,0},
//				        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//		
//		System.out.println(maxAreaOfIsland(array));
		
		minSteps("leetcode","practice");
		
		String[] doms = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
		subdomainVisits(doms);

	}

}
