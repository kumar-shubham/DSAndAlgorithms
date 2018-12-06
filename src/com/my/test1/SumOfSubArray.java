package com.my.test1;

import java.util.List;

public class SumOfSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = { 1, 2, 3 };
		System.out.println("Sum of SubArray " + SubArraySum(arr));

		System.out.println(countHoles(1208));

		int[] b = { 1, 2, 4, 6 };
		int[] c = { 10, 1 };
		System.out.println(maxDiff(c));
		System.out.println(maxDiff1(c));

	}

	static int roverMove(int matrixSize, List<String> cmds) {

		int r = 0;
		int c = 0;

		for (String cmd : cmds) {
			if ("LEFT".equals(cmd)) {
				if(c-1 >= 0) {
					c--;
				}
			} else if ("RIGHT".equals(cmd)) {
				if(c+1 < matrixSize) {
					c++;
				}
			} else if ("UP".equals(cmd)) {
				if(r-1 >= 0) {
					r--;
				}
			} else if ("DOWN".equals(cmd)) {
				if(r+1 < matrixSize) {
					r++;
				}
			}
		}
		
		return (r*matrixSize + c);

	}

	public static long SubArraySum(int arr[]) {
		int n = arr.length;
		long result = 0;

		for (int i = 0; i < n; i++)
			result += (arr[i] * (i + 1) * (n - i));

		return result;
	}

	private static int countHoles(int num) {

		String s = num + "";

		int sum = 0;

		int[] holes = { 1, 0, 0, 0, 1, 0, 1, 0, 2, 1 };

		for (int i = 0; i < s.length(); i++) {
			int a = Integer.parseInt(s.charAt(i) + "");
			sum += holes[a];
		}

		return sum;
	}

	private static int maxDiff(int[] arr) {

		int n = arr.length;

		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < n; i++) {
			if (arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}

		if (max_diff <= 0) {
			max_diff = -1;
		}
		return max_diff;
	}

	static int maxDiff1(int arr[]) {
		// Initialize diff, current
		// sum and max sum
		int n = arr.length;
		int diff = arr[1] - arr[0];
		int curr_sum = diff;
		int max_sum = curr_sum;

		for (int i = 1; i < n - 1; i++) {
			// Calculate current diff
			diff = arr[i + 1] - arr[i];

			// Calculate current sum
			if (curr_sum > 0)
				curr_sum += diff;
			else
				curr_sum = diff;

			// Update max sum, if needed
			if (curr_sum > max_sum)
				max_sum = curr_sum;
		}

		if (max_sum <= 0) {
			max_sum = -1;
		}

		return max_sum;
	}

}
