package com.my.test1;

import java.util.Arrays;
import java.util.Scanner;

public class GameOfCricket {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int r = sc.nextInt();
			int w = sc.nextInt();
			solve(r,w);
		}

	}

	private static void solve(int r, int w) {
		
		if(r == 0 || r%2 == 1) {
			System.out.println(0);
			return;
		}
		
		int d = 60-w;
		
		if(r > d*6) {
			System.out.println(0);
			return;
		}
		
		int col = r/2;
		
		long dp[][] = new long[d][col];
		
		long mod = 1000000007;
		
		for(int i = 0; i<d; i++) {
			for(int j = 0; j<col;j++) {
				
				if(i == 0 && j<3) {
					dp[i][j] = 1;
					continue;
				}
				if(i == 0 && j>=3) {
					continue;
				}
				
				if(j == 0) {
					continue;
				}
				
				if(j == 1) {
					dp[i][j] = dp[i-1][j-1];
					continue;
				}
				
				if(j == 2) {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2];
					continue;
				}
				
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j-2] + dp[i-1][j-3];
				dp[i][j] %= mod;
				
			}
		}
		
		Printer.printArr2D(dp);
		long a = dp[d-1][col-1]%mod;
		long b = nCrModp(60, w, mod);
		System.out.println(((a*b)%mod));
		
	}
	
	
	static long nCrModp(int n, int r, long p) 
    { 
        // The array C is going to store last  
        // row of pascal triangle at the end. 
        // And last entry of last row is nCr 
        int C[]=new int[r+1]; 
        Arrays.fill(C,0); 
      
        C[0] = 1; // Top row of Pascal Triangle 
      
        // One by constructs remaining rows of Pascal 
        // Triangle from top to bottom 
        for (int i = 1; i <= n; i++) 
        { 
            // Fill entries of current row using previous 
            // row values 
            for (int j = Math.min(i, r); j > 0; j--) 
      
                // nCj = (n-1)Cj + (n-1)C(j-1); 
                C[j] = (int) ((C[j] + C[j-1])%p); 
        } 
        return C[r]; 
    } 
	
	

}
