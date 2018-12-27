package com.my.test1;

public class InterleavingStrings {

	public static void main(String[] args) {

		String a = "B";
		String b = "e";
		String c = "Be";

		System.out.println(isInterleave(a, b, c));

	}

	public static int isInterleave(String A, String B, String C) {

		System.out.println(A + " :: " + B + " :: " + C);
		if ((A == null && B == null) || C == null || (A.length() + B.length() != C.length())) {
			return 0;
		}
		
//		System.out.println(A + " :: " + B + " :: " + C);

		int l1 = A.length();
		int l2 = B.length();
		int l3 = C.length();
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < l1 && j < l2 && k < l3) {
			char a = A.charAt(i);
			char b = B.charAt(j);
			char c = C.charAt(k);
			if (a == b && a == c) {
				int x = isInterleave(A.substring(i + 1), B.substring(j), C.substring(k + 1));
				int y = isInterleave(A.substring(i), B.substring(j + 1), C.substring(k + 1));
				if (x == 1 || y == 1) {
					return 1;
				} else {
					return 0;
				}
			} else if (a == c) {
				i++;
				k++;
			} else if (b == c) {
				j++;
				k++;
			} else {
				return 0;
			}
		}
		
		System.out.println(i + " :: " + j + " :: " + k);

		while (i < l1 && k < l3) {
			char a = A.charAt(i);
			char c = C.charAt(k);
			if (a == c) {
				i++;
				k++;
			} else {
				return 0;
			}
		}
		
		System.out.println(i + " :: " + j + " :: " + k);

		while (j < l2 && k < l3) {
			char b = B.charAt(j);
			char c = C.charAt(k);
			if (b == c) {
				j++;
				k++;
			} else {
				return 0;
			}
		}
		
		System.out.println(i + " :: " + j + " :: " + k);

		return 1;
	}

}
