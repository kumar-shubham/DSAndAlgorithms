package com.my.test1;

public class Stringoholics {

	public static void main(String[] args) {

		String[] a = {"abab"};

		int r = solve(a);

		System.out.println(r);
		
	}

	public static int solve(String[] A) {

		double[] arr = new double[A.length];
		for (int i = 0; i < A.length; i++) {
			String a = A[i];
			if (a.contains("a") && a.contains("b")) {
				double temp = 1d;
				int j = 1;
				while (temp % a.length() != 0) {
					j++;
					temp += j;
				}
				arr[i] = j;

			} else {
				arr[i] = 1;
			}
		}

		double lcm = arr[0];

		for (int i = 1; i < arr.length; i++) {
			lcm = lcm(lcm, arr[i]);
		}

		Printer.printArr(arr);

		return (int) (lcm % 1000000007);
	}

	static double gcd(double a, double b){
	    if( a<0 ) a = -a;
	    if( b<0 ) b = -b;
	    while( b!=0 ){
	        a %= b;
	        if( a==0 ) return b;
	        b %= a;
	    }
	    return a;
	}

	static double lcm(double a, double b) {
		return (a * b) / gcd(a, b);
	}

}
