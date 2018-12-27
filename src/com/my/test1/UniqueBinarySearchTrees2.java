package com.my.test1;

public class UniqueBinarySearchTrees2 {

	public static void main(String[] args) {

		System.out.println(numTrees(15));
		System.out.println(numTreesDP(15));
	}

	public static int numTrees(int A) {
		
		return catalan(A);
		
	}
	
	public static int numTreesDP(int A) {
		
		int[] count = new int[A + 1];
		 
		count[0] = 1;
		count[1] = 1;
	 
		for (int i = 2; i <= A; i++) {
			for (int j = 0; j <= i - 1; j++) {
				count[i] = count[i] + count[j] * count[i - j - 1];
			}
		}
	 
		return count[A];
		
	}

	static int binomialCoeff(int n, int k) {
		int res = 1;

		if (k > n - k)
			k = n - k;

		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}

		return res;
	}

	static int catalan(int n) {

		// Calculate value of 2nCn
		int c = binomialCoeff(2 * n, n);
		
		// return 2nCn/(n+1)
		return c / (n + 1);
	}

}
