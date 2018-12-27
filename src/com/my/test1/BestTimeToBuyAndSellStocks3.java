package com.my.test1;

import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-iii/
//https://www.youtube.com/watch?v=oDhu5uGq_ic


/*

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example :

Input : [1 2 1 2]
Output : 2

Explanation : 
  Day 1 : Buy 
  Day 2 : Sell
  Day 3 : Buy
  Day 4 : Sell

*/

public class BestTimeToBuyAndSellStocks3 {

	public static void main(String[] args) {
		
		Integer a[] = {2,5,7,1,4,3,1,3};
		List<Integer> l = Arrays.asList(a);
		
		System.out.println(maxProfit(l));

	}
	
	
	public static int maxProfit(final List<Integer> A) {
		
		if(A.size() <= 1) {
			return 0;
		}
		int n = A.size();
		int dp[][] = new int[3][n];
		
		for(int i = 1; i<3;i++) {
			int maxDiff = 0-A.get(0);
			for(int j = 1; j<n;j++) {
				
				int x = dp[i][j-1];
				int y = A.get(j)+maxDiff;
				dp[i][j] = Math.max(x, y);
				
				maxDiff = Math.max(maxDiff, dp[i-1][j]-A.get(j));
				
			}
		}
		
		Printer.printArr2D(dp);
		return dp[2][n-1];
    }

}
