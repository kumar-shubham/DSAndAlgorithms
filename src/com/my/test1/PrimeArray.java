package com.my.test1;

import java.util.Arrays;

public class PrimeArray {

	static int cost = 0;
	static int costPS = 0;

	public static void main(String[] args) {

		int[] a = { 1, 1, 2, 4, 4, 6, 7, 8, 9, 11, 11, 13 };

		Printer.printArr(a);
		primearr(a);
		Printer.printArr(a);
		System.out.println(cost);
		System.out.println(costPS);

	}

	public static int primearr(int[] A) {

		if (A.length == 0) {
			return 0;
		}
		int n = A.length;
		Arrays.sort(A);

		int cost = solve(0, 0, A);
		Printer.printArr(A);
		Arrays.sort(A);
		solvePerfectSquare(0, 0, A);
		Printer.printArr(A);
		Arrays.sort(A);
		Printer.printArr(A);
		solvePerfectSquare(0, 0, A);
		return cost;

	}

	private static int solvePerfectSquare(int d, int start, int[] A) {
		
		double sr = Math.sqrt(A[start]);
		
		boolean isPS = false;
//		System.out.println(sr*sr + " :: " + A[start]);
		if(sr%1 == 0 && A[start] != 1) {
			isPS = true;
		}

		if (start == A.length - 1) {
			if(isPS) {
				costPS++;
				return 1;
			}
			if(isPS(A[start])) {
				return 2;
			}
			return 1;
		}

		int d1 = A[start + 1] - A[start] - 1;
		
		if(d1 <= 0 && d>0) {
			d1 = d+1;
		}
		int temp = d1;
		boolean foundNumber = false;
		int count = 0;
		while(temp > 0) {
			if(!isPS(A[start]+temp)) {
				foundNumber = true;
			}
			count++;
			temp--;
		}
		if(count > 0) {
			d1 = count;
		}
		

		int d2 = solvePerfectSquare(d1, start + 1, A);
		
		if (isPS) {
//			System.out.println(A[start] + " :: " + d + " :: " + d2);
			if (d > 0 && d < d2) {
				costPS += d;
				A[start] -= d;
			} else {
				A[start] += d2;
				costPS += d2;
			}
		}

		System.out.println("returnng from step " + start + " with values(" + d + ", " + d1 + ", " + d2 + ") " + A[start]);
		if (d1 <= 0) {
			return d2 + 1;
		} else {
			return 1;
		}

	}
	
	private static boolean isPS(int a) {
		double b = Math.sqrt(a);
		if(b%1 == 0) {
			return true;
		}
		return false;
	}

	private static int solve(int d, int start, int[] A) {

		if (start == A.length - 1) {
			return 1;
		}

		int d1 = A[start + 1] - A[start];

		int d2 = solve(d1, start + 1, A);

		if (A[start] == A[start + 1]) {
			if (d1 > 0 && d1 < d2) {
				cost += d1;
				A[start] -= d1;
			} else {
				A[start + 1] += d2;
				cost += d2;
			}
		}

		if (d1 == 1) {
			return d2 + 1;
		} else {
			return 1;
		}

	}

}
