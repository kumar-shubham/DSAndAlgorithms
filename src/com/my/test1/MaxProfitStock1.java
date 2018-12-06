package com.my.test1;

import java.util.Arrays;
import java.util.List;

public class MaxProfitStock1 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3);
		System.out.println(maxProfit(list));
	}

	public static int maxProfit(final List<Integer> A) {

		if (A.size() <= 1) {
			return 0;
		}

		int n = A.size();
		int[] txn = new int[n];

		int count = 0;
		int i = 0;
		while (i < n) {

			while (i < n - 1 && A.get(i) >= A.get(i + 1)) {
				i++;
			}

			if (i == n - 1) {
				break;
			}

			txn[count] = A.get(i);
			count++;

			while (i < n - 1 && A.get(i) <= A.get(i + 1)) {
				i++;
			}

			txn[count] = A.get(i);
			count++;
		}

		int profit = 0;
		if (count == 0) {
			return 0;
		} else {
			for (int j = 0; j < count;) {
				profit += (txn[j + 1] - txn[j]);
				j += 2;
			}
		}

		Printer.printArr(txn);

		return profit;
	}

}
