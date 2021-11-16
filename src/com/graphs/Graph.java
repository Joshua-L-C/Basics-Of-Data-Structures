package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	
	private int Vertexes;
	private LinkedList<Integer> adjacentList[];
	private Queue<Integer> queue;
	
	
	public Graph(int v){
		
		this.Vertexes = v;
		this.adjacentList = new LinkedList[v];
		
		for(int runner = 0; runner < v ;runner++) {
			this.adjacentList[runner] = new LinkedList<>();
		}
		
		this.queue = new LinkedList<Integer>();
		
		
	}
	
	
	public void addEdge(int v, int w) {
		this.adjacentList[v].add(w);
	}
	
	public void BFS(int number, int toFind) {
		
		boolean nodes[] = new boolean[this.Vertexes];
		int a = 0;
		
		nodes[number] = true;
		queue.add(number);
		
		
		while(this.queue.size() != 0) {
			
			number = this.queue.poll();
			System.out.println();
			System.out.println("Current Node: " + number + " ");
			System.out.println();
			
			if(number == toFind) {
				return;
			}
			
			System.out.println("Neighbours:");
			for(int run = 0; run < this.adjacentList[number].size(); run++) {
				
				
				
				a = this.adjacentList[number].get(run);
				
				
				
				if(!nodes[a]) {
					System.out.println(a + " ");
					nodes[a] = true;
					queue.add(a);
				}
				
			}
			
		}
		
		
	}
	
	
	public static void main (String [] args) {
		 Graph graph = new Graph(7);
		 
	        graph.addEdge(0, 1);
	        graph.addEdge(0, 3);
	        graph.addEdge(0, 4);
	        graph.addEdge(4, 5);
	        graph.addEdge(3, 5);
	        graph.addEdge(1, 2);
	        graph.addEdge(1, 6);
	        graph.addEdge(1, 0);
	        graph.addEdge(2, 1);
	        graph.addEdge(2, 4);
	        graph.addEdge(2, 3);
	        graph.addEdge(4, 1);
	        graph.addEdge(3, 1);
	        graph.addEdge(3, 2);
	        graph.addEdge(5, 4);
	        graph.addEdge(5, 3);
	        graph.addEdge(6, 1);
	        graph.addEdge(6, 0);
	        
	        graph.BFS(5,0);
	}
}
