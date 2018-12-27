package com.my.test1;

public class RegularExpression2 {

	public static void main(String[] args) {

		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("a", "a*"));

	}

	public static int isMatch(final String A, final String B) {

		if (B.length() == 0) {
			return A.length() == 0 ? 1 : 0;
		}

		if (B.length() == 1) {

			if (A.length() < 0) {
				return 0;
			} else if (A.charAt(0) != B.charAt(0) && B.charAt(0) != '.') {
				return 0;
			} else {
				return isMatch(A.substring(1), B.substring(1));
			}
		}

		if (B.charAt(1) != '*') {

			if (A.charAt(0) != B.charAt(0) && B.charAt(0) != '.') {
				return 0;
			} else {
				return isMatch(A.substring(1), B.substring(1));
			}

		} else {

			if (isMatch(A, B.substring(2)) == 1) {
				return 1;
			}

			int i = 0;
			while (i < A.length() && (A.charAt(i) == B.charAt(0) || B.charAt(0) == '.')) {
				if (isMatch(A.substring(i + 1), B.substring(2)) == 1) {
					return 1;
				}
				i++;
			}
			return 0;

		}

	}

}
