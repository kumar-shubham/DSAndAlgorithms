package com.my.test1;

public class KMPSearch {

	public static void main(String[] args) {

		String s = "abcxabcdabxabcdabcdabcy";
//		String p = "abcdabcy";
		String p = "aaacaaaaaa";
		System.out.println(matchSubstring(s, p));
		System.out.println(s.indexOf(p));
		int a = 1000000;
		long l = Long.valueOf(a)*a;
		System.out.println(l);
	}

	private static int matchSubstring(String s, String p) {
		int[] prefix = buildPrefixArray(p);
		Printer.printArr(prefix);
		int pLen = p.length();
		for (int i = 0, j = 0; i < s.length();) {
			System.out.println("i: " + i + ", j: " + j);
			if (s.charAt(i) == p.charAt(j)) {
				j++;
				i++;
				if(j == pLen) {
					return (i-j);
				}
			} else {
				if (j == 0) {
					i++;
				} else {
					j = prefix[j-1];
				}
			}
		}
		return -1;
	}

	private static int[] buildPrefixArray(String s) {
		int[] p = new int[s.length()];

		p[0] = 0;

		for (int i = 1, j = 0; i < s.length();) {

			if (s.charAt(i) == s.charAt(j)) {
				p[i] = j + 1;
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = p[j - 1];
				}
			}

		}
		return p;
	}

}
