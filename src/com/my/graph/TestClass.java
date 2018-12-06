package com.my.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;

class TestClass {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			map.put(i, s.nextInt());
		}

		HashMap<Integer, Set<Integer>> nodeChildMap = new HashMap<>();

		HashMap<Integer, ArrayList<Integer>> nodeChildValueMap = new HashMap<>();

		for (int i = 1; i < n; i++) {
			int p = s.nextInt();
			int c = s.nextInt();

			if (nodeChildMap.containsKey(p)) {
				nodeChildMap.get(p).add(c);
				nodeChildValueMap.get(p).add(map.get(c));
			} else {
				Set<Integer> set = new HashSet<>();
				set.add(c);
				nodeChildMap.put(p, set);
				ArrayList<Integer> list = new ArrayList<>();
				list.add(map.get(c));
				nodeChildValueMap.put(p, list);
			}
		}

		// for(int i = 1; i<=n; i++){
		// if(nodeChildValueMap.containsKey(i)){
		// Collections.sort(nodeChildValueMap.get(i));
		// }
		// }

		int q = s.nextInt();

		for (int i = 0; i < q; i++) {
			int type = s.nextInt();
			int x = s.nextInt();
			int y = s.nextInt();

			if (type == 1) {
				int oldValue = map.get(x);
				map.put(x, y);
				int p = getParent(nodeChildMap, x);
				updateValueMap(nodeChildValueMap, p, oldValue, y);
			} else {
				if (hasChild(nodeChildValueMap, x, y)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}

	}

	private static int getParent(HashMap<Integer, Set<Integer>> nodeChildMap, int n) {

		for (Integer i : nodeChildMap.keySet()) {
			if (nodeChildMap.containsKey(i) && nodeChildMap.get(i).contains(n)) {
				return i;
			}
		}
		return -1;
	}

	private static boolean hasChild(HashMap<Integer, ArrayList<Integer>> nodeChildValueMap, int p, int value) {

		if (nodeChildValueMap.containsKey(p)) {
			ArrayList<Integer> list = nodeChildValueMap.get(p);

			for (int i : list) {
				if (i == value) {
					return true;
				}
			}
		}
		return false;
	}

	private static void updateValueMap(HashMap<Integer, ArrayList<Integer>> nodeChildValueMap, int p, int oldValue,
			int newValue) {

		if (nodeChildValueMap.containsKey(p)) {
			ArrayList<Integer> list = nodeChildValueMap.get(p);

			ListIterator<Integer> itr = list.listIterator();
			while (itr.hasNext()) {
				int i = itr.next();
				if (i == oldValue) {
					itr.remove();
					itr.add(newValue);
				}
			}
		}

	}
}
