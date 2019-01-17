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

		// Get the length of the string
		int n = A.length();

		/*
		 * Create two arrays to build the solution in bottom up manner C[i] = Minimum
		 * number of cuts needed for palindrome partitioning of substring str[0..i]
		 * P[i][j] = true if substring str[i..j] is palindrome, else false Note that
		 * C[i] is 0 if P[0][i] is true
		 */
		int[] C = new int[n];
		boolean[][] P = new boolean[n][n];

		int i, j, k, L; // different looping variables

		// Every substring of length 1 is a palindrome
		for (i = 0; i < n; i++) {
			P[i][i] = true;
		}

		/*
		 * L is substring length. Build the solution in bottom up manner by considering
		 * all substrings of length starting from 2 to n.
		 */
		for (L = 2; L <= n; L++) {
			// For substring of length L, set different
			// possible starting indexes
			for (i = 0; i < n - L + 1; i++) {
				j = i + L - 1; // Set ending index

				// If L is 2, then we just need to
				// compare two characters. Else need to
				// check two corner characters and value
				// of P[i+1][j-1]
				if (L == 2)
					P[i][j] = (A.charAt(i) == A.charAt(j));
				else
					P[i][j] = (A.charAt(i) == A.charAt(j)) && P[i + 1][j - 1];
			}
		}

		for (i = 0; i < n; i++) {
			if (P[0][i] == true)
				C[i] = 0;
			else {
				C[i] = Integer.MAX_VALUE;
				for (j = 0; j < i; j++) {
					if (P[j + 1][i] == true && 1 + C[j] < C[i])
						C[i] = 1 + C[j];
				}
			}
		}

		// Return the min cut value for complete
		// string. i.e., str[0..n-1]
		return C[n - 1];

	}

}
