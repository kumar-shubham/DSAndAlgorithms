package com.my.test1;

//https://www.interviewbit.com/problems/the-sequence-game/?ref=random-problem?\



public class PowerWithMod {

	public static void main(String[] args) {
		
		System.out.println(solve(425289961, 922369394));

	}
	
	public static int solve(int A, int B) {

		long mod = 1000000007;
		long x = A%mod;
		long ans = 1;
		while(B > 0) {
			if((B & 1) == 1) {
				ans = (ans*x)%mod;
			}
			
			B = B>>1;
			x = (int) ((x*x)%mod);
		}

		return (int) ans;
	}


}
