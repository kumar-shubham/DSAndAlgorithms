package com.my.test1;

import java.util.Stack;

public class Staircase {
	
	//https://jtp.io/2016/07/26/dynamic-programming-python.html

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int n = getStaircaseCount(5);
//		System.out.println(n);
		Stack<String> s = new Stack();
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		
		for(String a: s) {
			System.out.println(a);
		}
	}
	
	
	private static int getStaircaseCount(int n) {
		
		
		int[][] b = new int[n+1][n+1];
		
		b[0][0] = 1;
		
		for(int i = 1; i<= n; i++) {
			for(int j = 0; j<=n; j++) {
				b[i][j] = b[i-1][j];
				if(j>=i) {
					b[i][j] += b[i-1][j-i];
				}
			}
		}
		
		for(int i = 0; i<= n; i++) {
			for(int j = 0; j<=n; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		
		return b[n][n]-1;
		
	}

}
