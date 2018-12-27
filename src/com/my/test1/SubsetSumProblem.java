package com.my.test1;

public class SubsetSumProblem {

	public static void main(String[] args) {
		
		int[] set = {3, 34, 4, 12, 5, 2};
		
		System.out.println(isSubSet(set, 9));
		

	}
	
	public static boolean isSubSet(int[] set, int sum) {
		
		int n = set.length;
		
		int dp[][] = new int[n+1][sum+1];
		
		
		for(int i = 1; i<=n; i++) {
			
			for(int j = 1; j<=sum; j++) {
				
				if(set[i-1] == j) {
					dp[i][j] = 1;
					continue;
				}
				
				if(set[i] < j) {
					dp[i][j] = dp[i-1][j-set[i]];
				}
				
				if(j == sum && dp[i][j] == 1) {
					return true;
				}
				
			}
			
		}
		
		
		return false;
	}

}
