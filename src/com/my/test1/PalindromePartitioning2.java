package com.my.test1;


//https://www.interviewbit.com/problems/palindrome-partitioning-ii/


/*
Palindrome Partitioning II

    Asked in:  
    Amazon
    Google

Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example :
Given
s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/



public class PalindromePartitioning2 {

	public static void main(String[] args) {
		
		String s = "xzxz";
		System.out.println(s.length());
		System.out.println(minCut(s));

	}
	
	
	public static int minCut(String A) {
		
		int n = A.length();
		
		int dp[] = new int[n];
		
		for(int i = 0; i<n;i++) {
			dp[i] = 1;
		}
		
		for(int i = 1; i<n;i++) {
			
			int x = 1, y = 1,z=1;
			
			if(A.charAt(i) == A.charAt(i-1)) {
				x = 2;
			}
			
			if(i>(dp[i-1]) && A.charAt(i) == A.charAt(i-dp[i-1]-1)) {
				y = dp[i-1] + 2;
			}
			int mid = (i-dp[i-1]/2 -1);
//			System.out.println(i + ", " + mid + ", " + A.charAt(i) + ", " + A.charAt(mid));
			if(A.charAt(i) == A.charAt(i-dp[i-1]) && A.charAt(i) == A.charAt(mid)) {
				z = dp[i-1]+1;
			}
			
			dp[i] = Math.max(x, y);
			dp[i] = Math.max(dp[i], z);
		}
		
		int[] c = new int[n];
		for(int i = 1; i<n;i++) {
			int x = c[i-1] + 1;
			int y;
			if(dp[i] > i) {
				y = 0;
			}
			else {
				y = c[i-dp[i]] + 1;
			}
			c[i] = Math.min(x, y);
		}
		
		Printer.printArr(dp);
		Printer.printArr(c);
		
		return c[n-1];
    }
	
	
	

}
