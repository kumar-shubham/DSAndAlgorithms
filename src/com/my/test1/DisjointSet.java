package com.my.test1;

import java.util.HashMap;

public class DisjointSet {

	private HashMap<Long, Node> map = new HashMap<>();

	class Node {
		long data;
		Node parent;
		int rank;
	}

	public void makeSet(long data) {
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.parent = node;
		map.put(data, node);
	}

	public boolean union(long data1, long data2) {
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);

		Node p1 = findSet(node1);
		Node p2 = findSet(node2);

		if (p1 == p2) {
			return false;
		}

		if (p1.rank >= p2.rank) {
			p1.rank = p1.rank == p2.rank ? p1.rank + 1 : p1.rank;
			p2.parent = p1;
		} else {
			p1.parent = p2;
		}

		return true;
	}

	public long findSet(long data) {
		return findSet(map.get(data)).data;
	}

	private Node findSet(Node node) {

		Node parent = node.parent;
		if (node == parent) {
			return node;
		}
		node.parent = findSet(node.parent);

		return node.parent;
	}

	public static void main(String args[]) {
		DisjointSet ds = new DisjointSet();
		ds.makeSet(1);
		ds.makeSet(2);
		ds.makeSet(3);
		ds.makeSet(4);
		ds.makeSet(5);
		ds.makeSet(6);
		ds.makeSet(7);

		ds.union(1, 2);
		ds.union(2, 3);
		ds.union(4, 5);
		ds.union(6, 7);
		ds.union(5, 6);
		ds.union(3, 7);

		System.out.println(ds.findSet(1));
		System.out.println(ds.findSet(2));
		System.out.println(ds.findSet(3));
		System.out.println(ds.findSet(4));
		System.out.println(ds.findSet(5));
		System.out.println(ds.findSet(6));
		System.out.println(ds.findSet(7));
	}

}
