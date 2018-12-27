package com.my.test1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPathFromAToB {

	public static void main(String[] args) {
		
		Graph graph = new Graph();
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 6);
		graph.addEdge(6, 5);
//      graph.addEdge(5, 1);
		graph.addEdge(5, 3);

		System.out.println(graph.getAllVertices());
		
		List<Vertex> path = findPathFromAToB(graph.getVertex(2), graph.getVertex(5));
		
		System.out.println(path);
		

	}
	
	
	public static List<Vertex> findPathFromAToB(Vertex A, Vertex B) {
		
		Set<Integer> visited = new HashSet<>();
		List<Vertex> path = new ArrayList<>();
		if(findPath(A, B, visited, path)) {
			path.add(0, A);
		}
		return path;
		
	}


	private static boolean findPath(Vertex a, Vertex b, Set<Integer> visited, List<Vertex> path) {
		
		if(a == b) {
			return true;
		}
		visited.add(a.getId());
		for(Vertex v : a.getAdjVertices()) {
			if(!visited.contains(v.getId())) {
				if(findPath(v, b, visited, path)) {
					path.add(0,v);
					return true;
				}
			}
		}
		
		return false;
	}

}
