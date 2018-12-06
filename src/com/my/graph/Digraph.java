package com.my.graph;

import java.io.InputStream;

public class Digraph {
	
	private final int V;
	
	private int E;
	
	private Bag<Integer>[] adj;
	
	private int[] indegree; 
	
	
	/**
	 * Create an empty graph with V vertices
	 * @param V
	 */
	@SuppressWarnings("unchecked")
	public Digraph(int V) {
		if (V < 0) throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int v = 0; v<V; v++) {
			adj[v] = new Bag<Integer>();
		}
		
	}
	
	/**
	 * Create a graph from input stream
	 * @param in
	 */
	public Digraph(InputStream in) {
		this.V = 0;
	}
	
	/**
	 * add an edge v->w
	 * @param v
	 * @param w
	 */
	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}
	
	/**
	 * vertices adjacent to v
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	/**
	 * number of vertices
	 * @return
	 */
	public int V() {
		return this.V;
	}
	
	/**
	 * number of edges
	 * @return
	 */
	public int E() {
		return this.E;
	}
	
	public String toString() {
		return "";
	}
}
