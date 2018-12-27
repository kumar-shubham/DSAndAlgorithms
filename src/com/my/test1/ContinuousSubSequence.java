package com.my.test1;

import java.util.Scanner;

/*
Continuous Sub-sequence

You are given a finite sequence of integers. They can be both positive and negative.

Suppose the number of possible continuous sub-sequences that can be formed from the given sequence is k.

Let A be the set {S1, S2, …, Sk} where Si is the sum of all the elements of the ith continuous subsequence.

Find the minimum value of the elements of set A.
Examples

Suppose the sequence of numbers is -1, -5, 1, -4, 4, 1, -1, 3, -2, -3, -1, -1, 3 and -10.

Here, if you go through all possible continuous subsequences, you will find that the minimum possible sum is -16.

This is the total sum of the original sequence itself!

Another example:

Suppose you have the sequence 1, 1, -2, -1, 2, 4, 2, 1, 0 and -7. Here the minimum possible sum is -7. This is the single element subsequence -7.

Input Format

The first line of input consists of an integer t. This is the number of test cases.

For each test case, there will be two lines of input. The first line of input is an integer n which is the number of elements in the sequence.
The next line of input contains n space-separated integer elements.

Output Format

For each test case, output a single integer which is the minimum possible sum of all continuous subsequences that can be formed from the input sequence.

Constraints

0 < t < 10000 (This is the number of test cases.)

0 < n < 10000 (This is the number of elements in the sequence.)

-1000 < Xi < 1000 (This is the size of each element of the sequence.)
Sample input:

2
14
-1 -5 1 -4 4 1 -1 3 -2 -3 -1 -1 3 -10
10
1 1 -2 -1 2 4 2 1 0 -7

Sample Output:

-16
-7
*/


public class ContinuousSubSequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int j = 0; j<n;j++) {
				arr[j] = sc.nextInt();
			}
			
			solve(arr);
			
		}

	}

	private static void solve(int[] arr) {
		
		int minSum = Integer.MAX_VALUE;
		
		int sum = Integer.MAX_VALUE;
		for(int i = 0; i<arr.length; i++) {
			
			int v = arr[i];
			if(sum > 0) {
				sum = v;
			}
			else {
				sum += v;
			}
			
			if(sum < minSum) {
				minSum = sum;
			}
		}
		
		System.out.println(minSum);
		
	}
	
	

}
