package com.my.codeforces;

import java.util.Scanner;

public class DefiniteGame {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		int n = s.nextInt();
		
		if(n == 2) {
			System.out.println(n);
		}
		else {
			System.out.println(1);
		}

	}

}
