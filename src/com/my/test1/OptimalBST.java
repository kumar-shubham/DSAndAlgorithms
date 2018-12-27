package com.my.test1;

public class OptimalBST {

	public static void main(String[] args) {

		int[] k = {10,12,20};
		int[] f = {34,8,50};

		System.out.println(findOptimalBST(k, f));
	}

	public static int findOptimalBST(int[] k, int[] f) {

		int n = k.length;
		int[][] dp = new int[n + 1][n + 1]; // create 2D array of size n+1*n+1

		for (int l = 1; l <= n; l++) { // loop for tree with size starting from 1 to n

			int sum = 0; // calculating sum of frequency of elements from 1 to l initially
			for (int i = 0; i < l; i++) {
				sum += f[i];
			}
			for (int i = 0, j = i + l; j <= n; i++, j++) { // i is for row and j is for column

				if (j - i == 1) { // for tree with size 1 the freq will be the min weight of the tree
					dp[i][j] = f[i];
					continue;
				}

				if (i > 0) { // calculating sum for the next group by adding next element and subtracting prev element
					sum += f[j - 1];
					sum -= f[i - 1];
				}

				int min = Integer.MAX_VALUE;
				for (int m = 0; m < l; m++) { // if the tree has n element then checking for all the possible arrangement of tree

					// if the tree has 3 nodes and root is node 2 then weight of that tree will be 
					// c(0 to 1) + c(2,3) + sum of freq from (start to end)(here 0 to 2)
					min = Math.min(dp[i][j - l + m] + dp[j - l + m + 1][j], min);

				}
				dp[i][j] = min + sum;
			}
		}

		Printer.printArr2D(dp);

		return dp[0][n];
	}

}
