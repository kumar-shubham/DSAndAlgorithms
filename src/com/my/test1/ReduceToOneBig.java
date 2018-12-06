package com.my.test1;

import java.math.BigInteger;

public class ReduceToOneBig {

	public static void main(String[] args) {

		String s = "12345678987654321123456789876543321111111111111111111"
				+ "11111111111111111122222222222222222222222222222222"
				+ "3333333333333333333333333333333333333333333333333333333"
				+ "444444444444444444444444444444444444444444444444444444"
				+ "5555555555555555555555555555555555555555555555555555555";

		 System.out.println(countSteps("123456789"));

//		System.out.println(bigDivision(s, 2));
		
		//System.out.println(bigAdditionOne(s));

	}

	private static int countSteps(String s) {

		BigInteger n = new BigInteger(s);

		int count = 0;

		while (n.compareTo(BigInteger.ONE) == 1) {
			if (n.remainder(BigInteger.TWO).compareTo(BigInteger.ONE) == 0) {
				if (isPowerOfTwo(n.add(BigInteger.ONE))) {
					n = n.add(BigInteger.ONE);
				} else {
					n = n.subtract(BigInteger.ONE);
				}
				count++;
			}
			n = n.divide(BigInteger.TWO);
			count++;
		}
		return count;

	}

	private static boolean isPowerOfTwo(BigInteger x) {
		return x.and(x.subtract(BigInteger.ONE)).equals(BigInteger.ZERO);
	}
	
	private static String bigSubstractOne(String num) {
		String ans = "";
		
		int borrow = 0;
		
		int temp = num.charAt(num.length()-1) - '0';
		if(temp == 0) {
			borrow = 1;
		}
		int sum = temp-1;
		
		return ans;
	}

	private static String bigAdditionOne(String num) {
		String ans = "";

		int overflow = 0;

		int temp = num.charAt(num.length()-1) - '0';
		int sum = temp + 1;
		if (sum >= 10) {
			overflow = 1;
			ans = (sum - 10) + "";
		}
		else {
			ans = sum+"";
			ans = num.substring(0, num.length()-1) + ans;
		}
		for (int i = num.length() - 2; i >= 0; i--) {
			System.out.println("i: " + i);
			if (overflow > 0) {
				sum = (num.charAt(i) - '0') + 1;
				if (sum >= 10) {
					sum = sum - 10;
					ans = sum + ans;
				} else {
					overflow = 0;
					ans = sum + ans;
					ans = num.substring(0, i) + ans;
					break;
				}
			}else {
				break;
			}

		}
		System.out.println("overflow: " + overflow);
		if(overflow > 0) {
			ans = "1" + ans;
		}

		return ans;
	}

	private static String bigDivision(String num, int divisor) {

		String ans = "";

		int index = 0;
		int temp = num.charAt(index) - '0';
		while (temp < divisor) {
			if (num.length() == index + 1) {
				break;
			}
			temp = temp * 10 + (num.charAt(++index) - '0');
		}

		while (num.length() > index) {

			// Store result in answer i.e. temp / divisor
			ans += (char) ((temp / divisor) + '0');

			if (num.length() == index + 1) {
				break;
			}

			// Take next digit of number
			temp = (temp % divisor) * 10 + num.charAt(++index) - '0';
		}

		if (ans.length() == 0) {
			return "0";
		}

		return ans;

	}

}
