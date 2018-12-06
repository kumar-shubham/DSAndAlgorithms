package com.my.test1;

import java.util.HashMap;

public class ValidString {
	
	// https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = Data1.s1;

		System.out.println(isValid(s));

	}

	static String isValid(String s) {

		int[] charCount = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			charCount[index] += 1;
		}

		HashMap<Integer, Integer> frequencyMap = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			System.out.print(charCount[i] + " ");
			int freq = charCount[i];
			if (freq == 0) {
				continue;
			}
			int freqCount = 1;
			if (frequencyMap.containsKey(freq)) {
				freqCount += frequencyMap.get(freq);
			}
			frequencyMap.put(freq, freqCount);
		}

		System.out.println();
		System.out.println(frequencyMap);

		if (frequencyMap.size() > 2) {
			return "NO";
		} else if (frequencyMap.size() == 1) {
			return "YES";
		}

		int count1 = 0;
		int count2 = 0;
		int count = 0;
		int freq1 = 0;
		int freq2 = 0;
		for (int freq : frequencyMap.keySet()) {
			count++;
			if (count == 1) {
				count1 = frequencyMap.get(freq);
				freq1 = freq;
			} else if (count == 2) {
				count2 = frequencyMap.get(freq);
				freq2 = freq;
			}
		}

		if ((Math.abs(freq2 - freq1) == 1 && (count1 == 1 || count2 == 1)) || (freq1 == 1 && count1 == 1)
				|| (freq2 == 1 && count2 == 1)) {
			return "YES";
		} else {
			return "NO";
		}

	}

}
