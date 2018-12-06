package com.my.test1;

import java.util.ArrayList;
import java.util.Collections;

public class MinSwap {

	public static void main(String[] args) {
		
		int[] A = {5,7,2,18,3,1,23,11,4};
//		int[] A = {4,2,5,6};
		
		System.out.println(minSwap(A));

	}
	
	
	public static int minSwap(int[] A) {
		int sc = 0;
		
		ArrayList<Pair> list = new ArrayList<>();
		
		for(int i = 0; i<A.length; i++) {
			list.add(new Pair(A[i], i));
		}
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		boolean[] b = new boolean[A.length];
		
		for(int i = 0; i<list.size(); i++) {
			int j = i;
			while(!b[j]) {
				printArr(A);
				b[j] = true;
				Pair p = list.get(j);
				if(b[p.index]) {
					break;
				}
				Pair p1 = list.get(p.index);
				System.out.println("Now swapping :: " + p.value + " <=> " + p1.value);
				swap(A, p.index, p1.index);
				sc++;
				j = p.index;
			}
		}
		
		return sc;
	}
	
	static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
	static void printArr(int [] A) {
		for(int i = 0; i<A.length; i++) {
			System.out.print(" " + A[i]);
		}
		System.out.println();
	}

}


class Pair implements Comparable<Pair>{
	
	public int value;
	
	public int index;
	
	Pair(int value, int index){
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(Pair o) {
		
		if(this.value > o.value) {
			return 1;
		}
		return -1;
	}
	
	public String toString(){
		return "(" + value + ", " + index + ")";
	}
	
}
