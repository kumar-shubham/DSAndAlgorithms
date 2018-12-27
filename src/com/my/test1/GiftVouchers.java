package com.my.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GiftVouchers {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int m = s.nextInt();
		int k = s.nextInt();
		
		DisjointSet2 ds = new DisjointSet2();
		
		for(int i = 1; i<=n; i++) {
			ds.makeSet(i);
		}
		
		for(int i = 0; i<m; i++) {
			
			int a = s.nextInt();
			int b = s.nextInt();
			
			ds.union(a, b);
			
		}
		
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		
		List<Integer> result = new ArrayList<>();
		
		for(int i = 1; i<=n ;i++) {
			int x = ds.findSet(i);
			List<Integer> list = null;
			if(map.containsKey(x)) {
				list = map.get(x);
			}
			else {
				list = new ArrayList<>();
				map.put(x, list);
			}
			list.add(i);
		}
		
		for(Integer key : map.keySet()) {
			List<Integer> list = map.get(key);
			if(list.size() >= k) {
				Collections.sort(list);
				result.add(list.get(k-1));
			}
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for(Integer i : result) {
			System.out.print(i + " ");
		}
		
		System.out.println(map);

	}

}

class DisjointSet2 {

	private HashMap<Integer, Node> map = new HashMap<>();

	class Node {
		int data;
		Node parent;
		int rank;
	}

	public void makeSet(int data) {
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.parent = node;
		map.put(data, node);
	}

	public boolean union(int data1, int data2) {
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

	public int findSet(int data) {
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
}
