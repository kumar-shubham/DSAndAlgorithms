package com.my.test1;

public class EscapePods {
	
	static int[][] m = null;
	static int[] ent = null;
	static int[] exit = null;

	public static void main(String[] args) {
		
		int[][] m1 = {
				{0, 0, 4, 6, 0, 0},{0, 0, 5, 2, 0, 0},{0, 0, 0, 0, 4, 4},{0, 0, 0, 0, 6, 6},{0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0}
		};
		int a = 2000000;
		int[][] m11 = {
				{a, a, a, a, a, a},{a, a, a, a, a, a},{a, a, a, a, a, a},{a, a, a, a, a, a},{a, a, a, a, a, a},{a, a, a, a, a, a}
		};
		int ent1[] = {0, 1};
		int exit1[] = {4, 5};
		
		int[][] m2 = {
				{0, 7, 0, 0},{0, 0, 6, 0},{0, 0, 0, 8},{9, 0, 0, 0}
		};
		int ent2[] = {0};
		int exit2[] = {3};
		
		m = m2;
		ent = ent2;
		exit = exit2;
		
		printArr1D(ent);
		printArr2D(m1);
		System.out.println(getMaxBunnies(ent1, exit1, m11));
		printArr2D(m1);
	}
	
	private static int getMaxBunnies(int[] entrances, int[] exits, int[][] path) {
		
		int totalCount = 0;
		
		for(int i : entrances) {
			for(int j = 0; j<path.length; j++) {
				if(isEnt(j, entrances)) {
					continue;
				}
				totalCount += updateRoom(j, path[i][j], entrances, exits, path);
			}
		}
		
		
		return totalCount;
		
	}
	
	
	private static int updateRoom(int room, int incoming, int[] entrances, int[] exits, int[][] path) {
		int count = 0;
		if(isExit(room, exits)) {
			return incoming;
		}
		//System.out.println("updating room: " + room + " with incoming: " + incoming);
		
		for(int i = 0; i<path.length;i++) {
			//System.out.println("Now checking outgoing for room: " + i);
			if(incoming == 0) {
				return count;
			}
			if(isEnt(i, entrances)) {
				//System.out.println("room " + i + " is an entrance") ;
				continue;
			}
			int val = path[room][i];
			//System.out.println("Value at m[" + room + "][" + i + "] is " + val);
			if(val > 0) {
				if(val >= incoming) {
					path[room][i] -= incoming;
					int temp = incoming;
					incoming = 0;
					count = updateRoom(i, temp, entrances, exits, path);
					
				}
				else {
					incoming -= val;
					path[room][i] = 0;
					count= updateRoom(i, val, entrances, exits, path);
				}
			}
		}
		return count;
		
	}
	
	private static boolean isExit(int room, int[] exits) {
		for(int i : exits) {
			if(room == i) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isEnt(int room, int[] entrances) {
		for(int i : entrances) {
			if(room == i) {
				return true;
			}
		}
		return false;
	}
	
	private static void printArr1D(int[] a) {
		System.out.print("[");
		for(int i = 0; i<a.length; i++) {
			if(i<a.length-1) {
				System.out.print(a[i] + ", ");
			}
			else {
				System.out.print(a[i] + "]");
			}
		}
		System.out.println();
	}
	
	private static void printArr2D(int[][] a) {
		System.out.println("[");
		for(int i = 0; i<a.length; i++) {
			printArr1D(a[i]);
			if(i<a.length-1) {
			}
			else {
				System.out.println("]");
			}
		}
	}
	
	
	

}
