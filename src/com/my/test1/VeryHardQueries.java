package com.my.test1;

public class VeryHardQueries {

	public static void main(String[] args) {
		
		int[] A = {1, 2, 3};
		int[][] B = {{2, 1, 1}, {2, 1, 2}, {1, 3, 1}, {2, 1, 3}};
		
		System.out.println(solve(A, B));

	}

	public static int solve(int[] A, int[][] B) {
		
		int n = A.length;
		int[] ps = new int[n];
		
		for(int i = 0; i<n; i++) {
			ps[i] = Math.abs(findNearestPerfectSquare(A[i]) - A[i]);
		}
		
		int sum = 0;
		for(int i = 0; i<B.length; i++) {
			int[] b = B[i];
			int q = b[0];
			int x = b[1];
			int y = b[2];
			
			if(q == 1) {
				A[x-1] = y;
				ps[x-1] = Math.abs(findNearestPerfectSquare(y) - y);
			}
			else if(q == 2) {
				
				for(int j = x-1; j<y;j++) {
					sum += ps[j];
				}
			}
		}
		
		return sum;
	}
	
	private static int findNearestPerfectSquare(int a) {
		
		double b = Math.sqrt(a);
		double modulo = b%1;
		if(modulo == 0) {
			return a;
		}
		else if(modulo > 0.5) {
			int c = (int) b;
			return (c+1)*(c+1);
		}
		else {
			int c = (int) b;
			return (c)*(c);
		}
		
	}

}
