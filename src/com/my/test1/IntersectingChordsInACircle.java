package com.my.test1;

public class IntersectingChordsInACircle {

	public static void main(String[] args) {
		
		for(int i = 0; i<22; i++) {
			System.out.println(chordCnt(i+1));
		}
		
		System.out.println( +7);

	}

	public static int chordCnt(int A) {

		// n = no of points required
		int n = 2 * A;
		
		int mod = 1000000007;
		// dp array containing the sum
		double[] dpArray = new double[n + 1];
		dpArray[0] = 1;
		dpArray[2] = 1;
		for (int i = 4; i <= n; i += 2) {
			for (int j = 0; j < i - 1; j += 2) {
				dpArray[i] += (((dpArray[j]%mod) * (dpArray[i - 2 - j]%mod)) % mod);
				dpArray[i] = dpArray[i] % mod;
			}
		}

		// returning the required number
		return (int) dpArray[n]%mod;

	}

}
