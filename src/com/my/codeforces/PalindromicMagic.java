package com.my.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PalindromicMagic {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String A = s.nextLine();
		String B = s.nextLine();

		Set<String> set1 = allPalindromicSubStrings(A);
		Set<String> set2 = allPalindromicSubStrings(B);
		
		Set<String> set = new HashSet<>();
		
		for(String str1 : set1) {
			for(String str2 : set2) {
				String str = str1+str2;
				set.add(str);
			}
		}

		System.out.println(set.size());

	}

	// expand in both directions of low and high to find all palindromes
	public static void expand(String str, int low, int high, Set<String> set) {
		// run till str[low.high] is a palindrome
		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			// push all palindromes into the set
			set.add(str.substring(low, high + 1));

			// expand in both directions
			low--;
			high++;
		}
	}

	// Function to find all unique palindromic substrings of given string
	public static Set<String> allPalindromicSubStrings(String str) {
		// create an empty set to store all unique palindromic substrings
		Set<String> set = new HashSet<>();

		for (int i = 0; i < str.length(); i++) {
			// find all odd length palindrome with str[i] as mid point
			expand(str, i, i, set);

			// find all even length palindrome with str[i] and str[i+1]
			// as its mid points
			expand(str, i, i + 1, set);
		}

		// print all unique palindromic substrings
//		System.out.print(set);
		return set;
	}

}
