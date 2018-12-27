package com.my.test1;

//https://www.interviewbit.com/problems/painters-partition-problem/?ref=random-problem

public class PaintersPartitionProblem {

	public static void main(String[] args) {

		int arr[] = { 1000000,1000000 };

		// Calculate size of array.
		int n = arr.length;
		int k = 1;
		System.out.println(findMax(1, 1000000, arr));

	}

	// bottom up tabular dp
	static int findMax(int A, int B, int[] C) {
		
		long mod = 10000003;
		int n = C.length;
		// initialize table
		int dp[][] = new int[A + 1][n + 1];
		
		 int sum[] = new int[n+1]; 
		 
		 for (int i = 1; i <= n; i++) 
			   sum[i] = (int) ((sum[i-1] + C[i-1])%mod); 

		// base cases
		// A=1
		for (int i = 1; i <= n; i++)
			dp[1][i] = sum[i];

		// n=1
		for (int i = 1; i <= A; i++)
			dp[i][1] = C[0];

		// 2 to k partitions
		for (int i = 2; i <= A; i++) { // 2 to n boards
			for (int j = 2; j <= n; j++) {

				// track minimum
				int best = Integer.MAX_VALUE;

				// i-1 th separator before position arr[p=1..j]
				for (int p = 1; p <= j; p++) {
					best = Math.min(best, Math.max(dp[i - 1][p], sum[j] - sum[p]));
				}

				dp[i][j] = best;
			}
//			Printer.printArr2D(dp);
		}

		Printer.printArr2D(dp);
		// required
		return (int) (((dp[A][n]%mod) * B)%mod);
	}

}
