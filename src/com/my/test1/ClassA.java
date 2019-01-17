package com.my.test1;

import java.util.TreeMap;

public class ClassA {

	static int[] num_to_bits = new int[] { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };

	public static void main(String[] args) {
		
		TreeMap<Integer, Integer> map = new TreeMap<>();

		long start = System.currentTimeMillis();
		long x = 1000000000000l;

		long max = x;
		long min = 1;
		for(long i = 1; i<x;) {
			long count = getSetBitsFromOneToN(i); 
			System.out.println("i: " + i + ", count: " + count + ", min: " + min + ", max: " + max);
			if(count < x) {
				i = (max+min)/2;
				min = i;
			}
			else {
				break;
			}
		}
		

		long end = System.currentTimeMillis();

		System.out.println("total time: " + (end - start));

	}
	
	static long getSetBitsFromOneToN(long N) {
		long two = 2, ans = 0;
		long n = N;
		while (n>0) {
			ans += (N / two) * (two >> 1);
			if ((N & (two - 1)) > (two >> 1) - 1)
				ans += (N & (two - 1)) - (two >> 1) + 1;
			two <<= 1;
			n >>= 1;
		}
		return ans;
	}

	static int getBeauty(long num) {
		int beauty = 0;
		while (num > 0) {
			beauty += (num & 1);
			num = num / 2;
		}
		return beauty;
	}

}
