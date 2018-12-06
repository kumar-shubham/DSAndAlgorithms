package com.my.test1;

//https://www.interviewbit.com/problems/kth-row-of-pascals-triangle/?ref=random-problem

/*
Kth Row of Pascal's Triangle

    Asked in:  
    Google

Given an index k, return the kth row of the Pascal’s triangle.

Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

Example:

Input : k = 3

Return : [1,3,3,1]

    NOTE : k is 0 based. k = 0, corresponds to the row [1]. 

Note:Could you optimize your algorithm to use only O(k) extra space?
*/

public class KthRowOfPascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] result = getRow(10);
		Printer.printArr(result);

	}

	public static int[] getRow(int A) {

		int[] result = new int[A + 1];

		result[0] = 1;
		if (A == 0) {
			return result;
		}

		result[A] = 1;

		for (int i = 1; i <= A / 2; i++) {

			if (i == 1) {
				result[i] = A;
				result[A - i] = A;
				continue;
			}

			result[i] = (int) ((result[i - 1] * (A - i + 1)) * 1.0 / (i * 1.0));
			result[A - i] = result[i];
		}

		// printArr(result);

		return result;
	}

}
