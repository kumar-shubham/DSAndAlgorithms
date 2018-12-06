package com.my.test1;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		String a = "ABC";
		String b = "AC";
		System.out.println(solve(a, b));
	}
	
	public static int solve(String a, String b) {
		
		int l1 = a.length();
		int l2 = b.length();
		
		int dp[][] = new int[l1+1][l2+1];
		
		for(int i = 0;i<=l1; i++) {
			dp[i][0] = 0;
		}
		
		for(int i = 0; i<l2; i++) {
			dp[0][i] = 0;
		}
		
		for(int i = 1; i<=l1; i++) {
			for(int j = 1; j<=l2; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		Printer.printArr2D(dp);
		
		return dp[l1][l2];
	}

}
