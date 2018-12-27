package com.my.test1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

//https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/

/*
Largest Distance between nodes of a Tree

    Asked in:  
    Facebook
    Google

Problem Setter: ulugbek_adilbekov Problem Tester: raghav_aggiwal

Find largest distance
Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes. The goal of the problem is to find largest distance between two nodes in a tree. Distance between two nodes is a number of edges on a path between the nodes (there will be a unique path between any pair of nodes since it is a tree). The nodes will be numbered 0 through N - 1.

The tree is given as an array P, there is an edge between nodes P[i] and i (0 <= i < N). Exactly one of the i’s will have P[i] equal to -1, it will be root node.

    Example:
    If given P is [-1, 0, 0, 0, 3], then node 0 is the root and the whole tree looks like this: 

          0
       /  |  \
      1   2   3
               \
                4  

    One of the longest path is 1 -> 0 -> 3 -> 4 and its length is 3, thus the answer is 3. Note that there are other paths with maximal distance. 

*/

public class LargestDistanceBetweenNodesOfATree {

	public static void main(String[] args) {

		int[] a = { -1, 0, 0, 0, 3 };

		solve(a);
	}

	public static int solve(int[] A) {

		if (A == null || A.length <= 1) {
			return 0;
		}

		Graph g = new Graph();

		Vertex root = null;
		int rootIndex = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == -1) {
				rootIndex = i;
				continue;
			}
			g.addEdge(i, A[i]);
		}

		root = g.getVertex(rootIndex);

		HashMap<Integer, Integer> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		map.put(rootIndex, 0);

		getDistance(g, root, map, visited);

		System.out.println(map);
		System.out.println(visited);

		int maxDist = 0;
		int maxNodeId = 0;
		for (int id : map.keySet()) {
			if (map.get(id) > maxDist) {
				maxDist = map.get(id);
				maxNodeId = id;
			}
		}

		map.clear();
		visited.clear();
		map.put(maxNodeId, 0);

		getDistance(g, g.getVertex(maxNodeId), map, visited);

		int maxNode2 = 0;
		for (int id : map.keySet()) {
			if (map.get(id) > maxDist) {
				maxDist = map.get(id);
				maxNode2 = id;
			}
		}

		System.out.println(
				"Maximum distance is: " + maxDist + " and is between node " + maxNodeId + " and node " + maxNode2);

		return maxDist;
	}

	public static void getDistance(Graph g, Vertex node, HashMap<Integer, Integer> map, Set<Integer> visited) {

		Stack<Integer> stack = new Stack<>();

		// Push the current source node
		stack.push(node.getId());
		
		while(!stack.isEmpty()) {
			
			Vertex v = g.getVertex(stack.pop());
			
			visited.add(v.getId());
			
			List<Vertex> adjVertices = v.getAdjVertices();
			
			for (int i = 0; i < adjVertices.size(); i++) {
				Vertex adj = adjVertices.get(i);
				int value = map.get(v.getId()) + 1;
				if (map.containsKey(adj.getId())) {
					value = Math.min(value, map.get(adj.getId()));
					map.put(adj.getId(), value);
				} else {
					map.put(adj.getId(), value);
				}
				if(!visited.contains(adj.getId())) {
					stack.push(adj.getId());
				}
			}
			
			
		}

	}

}
