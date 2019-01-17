package com.my.test1;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphTraversal {

	public static void main(String[] args) {

		Graph graph = new Graph(false);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 6);
		graph.addEdge(6, 5);
//      graph.addEdge(5, 1);
		graph.addEdge(5, 3);

		System.out.println(graph.getAllVertices());

		GraphTraversal g = new GraphTraversal();
		g.BFS(graph);
		System.out.println();
		g.DFS(graph);

	}

	public void DFS(Graph g) {
		Set<Integer> visited = new HashSet<>();
		for (Vertex v : g.getAllVertices()) {
			if (!visited.contains(v.getId())) {
				DFSUtil(v, visited);
			}
		}
	}

	private void DFSUtil(Vertex v, Set<Integer> visited) {
		
		System.out.print(v.getId() + " ");
		visited.add(v.getId());
		for(Vertex v1 : v.getAdjVertices()) {
			if(!visited.contains(v1.getId())) {
				DFSUtil(v1, visited);
			}
		}
	}

	public void BFS(Graph g) {

		Collection<Vertex> vertices = g.getAllVertices();
		Set<Integer> visited = new HashSet<>();
		Queue<Vertex> q = new LinkedList<>();

		for (Vertex v : vertices) {
			if (!visited.contains(v.getId())) {
				q.add(v);
				visited.add(v.getId());
				while (!q.isEmpty()) {
					Vertex v1 = q.poll();
					System.out.print(v1.getId() + " ");
					for (Vertex v2 : v1.getAdjVertices()) {
						if (!visited.contains(v2.getId())) {
							q.add(v2);
							visited.add(v2.getId());
						}
					}
				}
			}
		}

	}

}
