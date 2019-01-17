package com.my.test1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClassT {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int n = s.nextInt();
		
		Graph g = new Graph(true);
		for(int i = 1; i<=n; i++) {
			int t = s.nextInt();
			if(t == 0) {
				g.addVertex(i);
				continue;
			}
			g.addEdge(i, t);
		}
		
		int q = s.nextInt();
		for(int i = 0; i<q; i++) {
			int type = s.nextInt();
			int v = s.nextInt();
			if(type == 1) {
				traverseGraph(g, v);
			}
			else if(type == 2) {
				g.getVertex(v).getAdjVertices().clear();
			}
		}
	
	}
	
	static void traverseGraph(Graph g, int node) {
		
		
		Set<Integer> visited = new HashSet<>();
		visited.add(node);
		Vertex v = g.getVertex(node);
//		System.out.println("start node:  " + node);
		while(true) {
			
//			System.out.println("node: " + v.getId() + ", outgoing edge: " + (v.getAdjVertices().size() != 0));
			if(v.getAdjVertices().size() == 0) {
				System.out.println(v.getId());
				return;
			}
			
			v = v.getAdjVertices().get(0);
			
			if(visited.contains(v.getId())) {
				System.out.println("LOOP");
				return;
			}
			visited.add(v.getId());
		}
		
	}
	

}
