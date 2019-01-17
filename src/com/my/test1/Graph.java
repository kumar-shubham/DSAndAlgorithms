package com.my.test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Graph {

	private List<Edge> allEdges = new ArrayList<>();
	private HashMap<Integer, Vertex> vertexMap = new HashMap<>();
	boolean isDirected = false;

	public Graph(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public Vertex addVertex(int id) {
		if (vertexMap.containsKey(id)) {
			return vertexMap.get(id);
		}

		Vertex v = new Vertex(id);
		vertexMap.put(id, v);
		return v;
	}

	public Vertex getVertex(int v) {
		return vertexMap.get(v);
	}

	public List<Edge> getAllEdges() {
		return this.allEdges;
	}

	public Collection<Vertex> getAllVertices() {
		return this.vertexMap.values();
	}

	public void addEdge(int v1, int v2) {
		addEdge(v1, v2, 0);
	}

	public void addEdge(int v1, int v2, int w) {

		Vertex vertex1 = null;
		Vertex vertex2 = null;
		if (vertexMap.containsKey(v1)) {
			vertex1 = vertexMap.get(v1);
		} else {
			vertex1 = new Vertex(v1);
			vertexMap.put(v1, vertex1);
		}
		if (vertexMap.containsKey(v2)) {
			vertex2 = vertexMap.get(v2);
		} else {
			vertex2 = new Vertex(v2);
			vertexMap.put(v2, vertex2);
		}

		Edge e = new Edge(v1, v2, w);
		allEdges.add(e);
		vertex1.addAdjVertex(e, vertex2);
		if (!isDirected) {
			vertex2.addAdjVertex(e, vertex1);
		}

	}
	
	@Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }

}

class Edge {
	private int vertex1;
	private int vertex2;
	private int weight;

	public Edge(int v1, int v2, int w) {
		this.vertex1 = v1;
		this.vertex2 = v2;
		this.weight = w;
	}

	public int getVertex1() {
		return this.vertex1;
	}

	public int getVertex2() {
		return this.vertex2;
	}

	public int getWeight() {
		return this.weight;
	}
	
	@Override
    public String toString() {
        return "Edge [isDirected=" + true + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }

}

class Vertex {

	private int id;
	private List<Edge> edges = new ArrayList<>();
	private List<Vertex> adjVertices = new ArrayList<>();

	public Vertex(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public void addAdjVertex(Edge e, Vertex v) {
		edges.add(e);
		adjVertices.add(v);
	}

	public List<Vertex> getAdjVertices() {
		return this.adjVertices;
	}

	public List<Edge> getEdges() {
		return this.edges;
	}

	public int getDegree() {
		return this.edges.size();
	}

	public String toString() {
		return id + "";
	}

}
