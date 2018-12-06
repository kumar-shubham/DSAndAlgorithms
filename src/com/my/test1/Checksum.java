package com.my.test1;

public class Checksum {

	public static void main(String[] args) {

		System.out.println(findChecksum(17, 4));

		System.out.println();

	}

	private static int findChecksum(int start, int length) {

		int checksum = 0;

		for (int i = 0; i < length; i++) {
				int a = start-1;
				int b = a+length-i;
				start += length;
				checksum = checksum^findXOR(a)^findXOR(b);
		}
		return checksum;

	}

	private static int findXOR(int n) {
		
		int r = n%4;
		// If n is a multiple of 4
		if (r == 0)
			return n;

		// If n%4 gives remainder 1
		if (r == 1)
			return 1;

		// If n%4 gives remainder 2
		if (r == 2)
			return n + 1;
		
		

		// If n%4 gives remainder 3
		return 0;
	}

}
