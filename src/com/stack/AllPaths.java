package com.stack;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {
	
	public static List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
		
		
		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> tester1 = new ArrayList<List<Integer>>();
	
		list.add(0);
		List<List<Integer>> tester = dfs(graph,0,0,list,tester1);
		
		
		
	    return tester;
	}
	
	
	public static List<List<Integer>> dfs(int[][] graph, int indx,int forwardIndx, List<Integer> list, List<List<Integer>> main){
		
		if(indx == graph.length - 1) {
			//list.add(forwardIndx);
			main.add(new ArrayList<Integer>(list));
			
			return main;
		}
		
		//list.add(forwardIndx);
		
		for(int runner = 0; runner < graph[indx].length;runner++) {
			
		
			
			forwardIndx = graph[indx][runner];
			
			
			list.add(forwardIndx);
			dfs(graph,forwardIndx,forwardIndx,list,main);
			list.remove(list.size() - 1);
//			list = new ArrayList<Integer>();
//			if(indx != 0) {
//				list.add(0);
//			}
		
		}
		

		
		return main;
		
	}
	
	
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
					
        path.add(0);
        dfsSearch(graph, 0, res, path);
					
        return res;
    }

    private static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }
	public static void main(String[] args) {
		
		//int[][] grid = new int[][] {{}};
		int[][] grid = new int[][] {{4,3,1},{3,2,4},{3},{4},{}};
		//int[][] grid = new int[][] {{1,2,3},{4},{4},{4},{5},{}};
		//int[][] grid = new int[][] {{1,2},{2,3},{3},{4},{}};
		
		List<List<Integer>> list =  allPathsSourceTarget2(grid);
		
		for(List<Integer> l: list) {
			for(int runner = 0; runner < l.size(); runner++) {
				System.out.print(l.get(runner));
			}
			System.out.println();
		}
	}

}
