package com.my.test1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class OptimalConnectivity {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int n = s.nextInt();
		
		Graph g = new Graph();
		for(int i = 0; i<n-1; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			int w = s.nextInt();
			
			Edge e = new Edge(u, v, w);
			g.addEdge(u, e);
			g.addEdge(v, e);
		}
		
		int q = s.nextInt();
		for(int i = 0; i<q; i++) {
			int u = s.nextInt();
			int v = s.nextInt();
			int w = s.nextInt();
			Edge e = new Edge(u, v, w);
			if(isOptimal(g, e)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}

	}
	
	private static boolean isOptimal(Graph g, Edge e) {
		
		int start = e.vertex1;
		int end  = e.vertex2;
		int weight = e.weight;
		
		return false;
	}
	
	public void DFS(Graph graph){
        Set<Integer> visited = new HashSet<>();
        for(Vertex vertex : graph.map.values()){
            if(!visited.contains(vertex.id)){
                DFSUtil(vertex,visited);
            }
        }
        
    }
    
    private void DFSUtil(Vertex v,Set<Integer> visited){
        visited.add(v.id);
        for(Vertex vertex : v.edges){
            if(!visited.contains(vertex.getId()))
                DFSUtil(vertex,visited);
        }
    }
	
	
	static class Graph{
		
		HashMap<Integer, Vertex> map = new HashMap<>();
		List<Vertex> vertices = new ArrayList<>();
		
		public void addEdge(int v, Edge e) {
			if(map.containsKey(v)) {
				map.get(v).edges.add(e);
			}
			else {
				Vertex v1 = new Vertex();
				v1.id = v;
				v1.edges.add(e);
				map.put(v, v1);
			}
		}
		
	}
	
	static class Vertex{
		int id;
		List<Edge> edges = new ArrayList<>();
	}
	
	
	
	static class Edge{
		int vertex1;
		int vertex2;
		int weight;
		
		public Edge(int v1, int v2, int w) {
			vertex1 = v1;
			vertex2 = v2;
			weight = w;
		}
		
	}
	
	static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge edge1, Edge edge2) {
            if (edge1.weight <= edge2.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }


}
