package com.my.test1;

public class ReduceToOne {

	public static void main(String[] args) {
		
		System.out.println(countSteps(34));
		

	}
	
	private static int countSteps(int n) {
		
		int count = 0;
		
		while(n>1) {
			if(n%2 == 1) {
				if(isPowerOfTwo(n+1)) {
					n = n+1;
				}
				else {
					n = n-1;
				}
				count++;
			}
			n = n>>1;
			count++;
		}
		return count;
		
	}
	
	private static boolean isPowerOfTwo(int n) {
		
		int a = 2;
		while(a < n) {
			a = a<<1;
			if(a == n) {
				return true;
			}
		}
		return false;
	}

}
