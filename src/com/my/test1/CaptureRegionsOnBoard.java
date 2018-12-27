package com.my.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CaptureRegionsOnBoard {

	public static void main(String[] args) {
		
		Character[] a1 = {'O', 'X', 'X', 'X'};
		Character[] a2 = {'X', 'O', 'O', 'X'};
		Character[] a3 = {'X', 'X', 'O', 'X'};
		Character[] a4 = {'X', 'O', 'X', 'X'};
		ArrayList<Character> a11 = new ArrayList<>();
		ArrayList<Character> a12 = new ArrayList<>();
		ArrayList<Character> a13 = new ArrayList<>();
		ArrayList<Character> a14 = new ArrayList<>();
		a11.addAll(Arrays.asList(a1));
		a12.addAll(Arrays.asList(a2));
		a13.addAll(Arrays.asList(a3));
		a14.addAll(Arrays.asList(a4));
		
		ArrayList<ArrayList<Character>> a = new ArrayList<>();
		a.add(a11);
		a.add(a12);
		a.add(a13);
		a.add(a14);
		System.out.println(a);
		solve(a);
		
		for(ArrayList<Character> l : a) {
			System.out.println(l);
		}
		System.out.println();

	}

	public static void solve(ArrayList<ArrayList<Character>> a) {

		Queue<Node> q = new LinkedList<>();
		int r = a.size();
		int c = a.get(0).size();
		
		for(int i = 0; i<c; i++) {
			char ch1 = a.get(0).get(i);
			char ch2 = a.get(r-1).get(i);
			if(ch1 == 'O') {
				q.add(new Node(0,i));
				a.get(0).set(i, 'Z');
			}
			if(ch2 == 'O') {
				q.add(new Node(r-1,i));
				a.get(r-1).set(i, 'Z');
			}
		}
		for(int i = 1; i<r-1; i++) {
			char ch1 = a.get(i).get(0);
			char ch2 = a.get(i).get(c-1);
			if(ch1 == 'O') {
				q.add(new Node(i,0));
				a.get(i).set(0, 'Z');
			}
			if(ch2 == 'O') {
				q.add(new Node(i,c-1));
				a.get(i).set(c-1, 'Z');
			}
		}
		
		for(ArrayList<Character> l : a) {
			System.out.println(l);
		}
		System.out.println();

		System.out.println(q);
		
		while(!q.isEmpty()) {
			
			Node n = q.remove();
			
			int i = n.i;
			int j = n.j;
			
			if(i>0 && a.get(i-1).get(j) == 'O') {
				q.add(new Node(i-1, j));
				a.get(i-1).set(j, 'Z');
			}
			if(i<r-1 && a.get(i+1).get(j) == 'O') {
				q.add(new Node(i+1, j));
				a.get(i+1).set(j, 'Z');
			}
			if(j>0 && a.get(i).get(j-1) == 'O') {
				q.add(new Node(i, j-1));
				a.get(i).set(j-1, 'Z');
			}
			if(j<c-1 && a.get(i).get(j+1) == 'O') {
				q.add(new Node(i, j+1));
				a.get(i).set(j+1, 'Z');
			}
			System.out.println(q);
		}
		
		for(ArrayList<Character> l : a) {
			System.out.println(l);
		}
		System.out.println();

		
		for(int i = 0; i<r; i++) {
			for(int j = 0; j<c; j++) {
				if(a.get(i).get(j) == 'Z') {
					a.get(i).set(j, 'O');
				}
				else if(a.get(i).get(j) == 'O') {
					a.get(i).set(j, 'X');
				}
			}
		}
		

	}
	
	static class Node{
		
		int i;
		int j;
		Node(int a, int b){
			i = a;
			j = b;
		}
		
		public String toString() {
			return "(" + i + ", " + j + ")";
		}
		
	}

}
