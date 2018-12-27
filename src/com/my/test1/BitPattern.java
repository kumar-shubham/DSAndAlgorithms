package com.my.test1;

import java.util.Scanner;

/*
Bit Pattern

You are given a string containing 0’s and 1’s and two numbers m and n. Your work is to check if all the bits in the string can be used to make a new string
such that the new string contains a repeating pattern of m 0’s and n 1’s.

Note:

    No bit should be added or removed from the old string.

    The new string starts with m 0’s.

    The new string can end with m number of 0’s in the end without continuing the n number of 1’s in the string.

Constraints

    1 <= t <= 1000

    0 <=n,m <=1000

    1 <= l <= 10000, where l is the length of the original string

Input Format

The first line of input contains t, which gives the number of test cases. Each test case contains three lines:

    First line contains two space separated integers, m and n.

    Second line contains l, the length of the string.

    Third line contains the string containing 0’s and 1’s.

Output Format

Output contains t lines and each line contains a “YES” if the new string can be created and “NO” otherwise.

Sample Input

2
2 2
8
11101000
3 4
16
0110111000011111

Sample Output

YES
NO

Explanation

The first test case has the string 11101000. It has 4 1’s and 4 0’s. These can be used to create a repeating pattern of 2 0’s and 2 1’s (00110011).
*/

public class BitPattern {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int l = sc.nextInt();
			String s = sc.nextLine().trim();
			if (s == null || s.length() == 0) {
				s = sc.nextLine().trim();
			}
//			System.out.println(m + ", " + n + ", " + l + ", " + s);
			solve(m, n, l, s);
		}

	}

	private static void solve(int m, int n, int l, String s) {

		if (m == 0 && n == 0) {
			System.out.println("NO");
			return;
		}
		int mod = l % (m + n);
//		System.out.println("mod: "  + mod + ", m: "+ m);
		if (mod != 0 && mod != m) {
			System.out.println("NO");
			return;
		}

		int zeros = 0;
		int ones = 0;

		for (int i = 0; i < l; i++) {
			if (s.charAt(i) == '0') {
				zeros++;
			} else {
				ones++;
			}
		}

		if (m == 0 && zeros > 0) {
			System.out.println("NO");
			return;
		}

		if (m == 0 && n > 0 && ones > 0) {
			System.out.println("YES");
			return;
		}

		while (zeros > 0 && ones > 0) {
			zeros -= m;
			ones -= n;
		}

		if (zeros < 0 || ones < 0) {
			System.out.println("NO");
			return;
		}

		if (zeros == 0 && ones > 0) {
			System.out.println("NO");
			return;
		}

		if (zeros == 0 || zeros == m) {
			System.out.println("YES");
			return;
		}

		System.out.println("NO");
	}

}
