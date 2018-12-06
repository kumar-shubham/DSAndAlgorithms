package com.my.test1;

public class Knapsack01 {

	public static void main(String[] args) {
		
//		int[] values = {1,4,5,7};
//		int[] weights = {1,3,4,5};
		
		int[] values = {1,2,3};
		int[] weights = {4,5,1};
		
		System.out.println(getMaxValue(values, weights, 4));
		
		System.out.println(knapSack(4, weights, values, 3));

	}
	
	static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int i, w; 
     int K[][] = new int[n+1][W+1]; 
       
     // Build table K[][] in bottom up manner 
     for (i = 0; i <= n; i++) 
     { 
         for (w = 0; w <= W; w++) 
         { 
             if (i==0 || w==0) 
                  K[i][w] = 0; 
             else if (wt[i-1] <= w) 
                   K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]],  K[i-1][w]); 
             else
                   K[i][w] = K[i-1][w]; 
         } 
      } 
       
      return K[n][W]; 
    } 
	
	static int max(int a, int b) { return (a > b)? a : b; } 
	
	public static int getMaxValue(int[] values, int[] weights, int w) {
		
		int n = values.length;
		
		int dp[][] = new int[n][w+1];
		
		for(int i = 0; i<n;i++) {
			dp[i][0] = 0;
		}
		
		for(int i = 0; i<n; i++) {
			
			for(int j = 1; j<=w; j++) {
				int w1 = weights[i];
				System.out.println(j-w1);
				int v1 = (w1 <= j ? values[i] : 0) + (j-w1>=0 && i>0 ? dp[i-1][j-w1] : 0); 
				int v2 = i>0 ? dp[i-1][j] : 0;
				System.out.println(v1 + " : "+ i +" : " + v2);
				dp[i][j] = Math.max(v1, v2);
				
			}
		}
		
		Printer.printArr2D(dp);
		
		
		return dp[n-1][w];
	}

}
