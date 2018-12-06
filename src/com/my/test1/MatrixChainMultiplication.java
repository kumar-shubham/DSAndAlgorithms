package com.my.test1;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		
		int[] arr = {40,20,30,10,30};
		System.out.println(MCM(arr));
	}
	
	static int MCM(int[] arr){
		
		int n = arr.length;
		int[][] a = new int[n-1][n-1];
		
		for(int k = 0; k<n-1; k++) {
			
			for(int i = 0, j= k+1; i<n-1 && j<n-1; i++, j++ ) {
				
				int x = a[i][j-1] + (arr[i]*arr[j]*arr[j+1]);
				int y = a[i+1][j] + (arr[i]*arr[i+1]*arr[j+1]);
				
				a[i][j] = Math.min(x, y);
				
			}
			
		}
		
		Printer.printArr2D(a);
		
		return a[0][n-2];
		
	}

}
