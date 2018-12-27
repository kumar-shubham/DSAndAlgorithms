package com.my.test1;

import java.util.ArrayList;
import java.util.Collections;

//https://www.interviewbit.com/problems/stepping-numbers/

/*
Stepping Numbers

    Asked in:  
    Epic systems

Given N and M find all stepping numbers in range N to M

The stepping number:

A number is called as a stepping number if the adjacent digits have a difference of 1.
e.g 123 is stepping number, but 358 is not a stepping number

Example:

N = 10, M = 20
all stepping numbers are 10 , 12 

Return the numbers in sorted order.

*/

public class SteppingNumbers {

	public static void main(String[] args) {

		stepnum(890, 1000);

	}

	public static int[] stepnum(int A, int B) {

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {

			if (i >= A && i <= B) {
				list.add(i);
			}
			if (i < B && i > 0) {
				findStepNum(A, B, i, list);
			}

		}

		Collections.sort(list);

		int[] result = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}

	public static void findStepNum(int A, int B, int num, ArrayList<Integer> result) {
		int lastDigit = num % 10;

		int x = lastDigit + 1;
		int y = lastDigit - 1;

		if (x < 10) {
			int j = num * 10 + x;
			if (j >= A && j <= B) {
				result.add(j);
			}
			if (j < B) {
				findStepNum(A, B, j, result);
			}
		}

		if (y >= 0) {
			int j = num * 10 + y;
			if (j >= A && j <= B) {
				result.add(j);
			}
			if (j < B) {
				findStepNum(A, B, j, result);
			}
		}
	}

}
