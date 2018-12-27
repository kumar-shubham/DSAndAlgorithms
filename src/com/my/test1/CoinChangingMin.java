package com.my.test1;

public class CoinChangingMin {

	public static void main(String[] args) {

		int[] set = { 9,6,5,1 };

		System.out.println(minCoinsRecursion(set, 11));
		
		System.out.println(minCoinsDP(set, 11));

	}
	
	static int minCoinsDP(int[] set, int value) {
		
		int[] t = new int[value+1];
		
		for(int i = 1; i<=value; i++) {
			t[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 1; i<=value;i++) {
			for(int j = 0; j<set.length;j++) {
				int c = set[j];
				if(c <= i) {
					int s = t[i-c];
					if(s != Integer.MAX_VALUE) {
						t[i] = Math.min(t[i], s+1);
					}
				}
			}
		}
		
		Printer.printArr(t);
		return t[value];
	}

	static int minCoinsRecursion(int[] set, int value) {

		if (value <= 0) {
			return 0;
		}

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < set.length; i++) {

			if (set[i] <= value) {
//				System.out.println("set[i]: " + set[i] + ", new Value: " + (value-set[i]));
				int res1 = minCoinsRecursion(set, value - set[i]);
				if (res1 < Integer.MAX_VALUE) {
					res = Math.min(res, 1 + res1);
				}
			}

		}
		return res;
	}

}
