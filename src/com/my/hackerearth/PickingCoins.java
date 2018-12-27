package com.my.hackerearth;

import java.util.Scanner;

//https://www.hackerearth.com/challenge/competitive/december-circuits-18/algorithm/picking-the-coins-50470dca/

/*
Picking coins
Max. Marks: 100

Alice and Bob are playing a game of picking coins. They are given a large pile of
coins and an integer . In the move of any player,

coins are picked from the pile. A player who is not able to make the move during his turn loses. You are required to predict the winner of the game.

Note: In every turn, Alice plays first followed by Bob.

Input format

    First line: 

 that represents the total number of test cases
Each line of the test case: Two space-separated integers
and 

     

Output format

For each test case, you are required to print the name of the winner of the game. You have to print either Alice or Bob depending upon who is the winner of the game.

Constraints

             
SAMPLE INPUT

4
10 3
14 2
18 10
37 5

SAMPLE OUTPUT

Bob
Bob
Alice
Alice

Explanation

Test Case 1
In the first move: Alice first removes 3 coins, then Bob also removes 3 coins.
In the second move: Alice has to remove 9 coins but since only 4 are available, Alice loses and Bob wins.

Test Case 2
In the first move: Alice first removes 2 coins, then Bob also removes 2 coins
In the second move: Alice removes 4 coins, then Bob also removes 4 coins and only 2 coins remain.
In the third move: Alice has to remove 8 coins but it is not possible so Bob wins.

Similarly, the other two test cases can be followed.

*/

public class PickingCoins {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {
			long n = s.nextLong();
			long k = s.nextLong();

			if (k == 1) {
				if (n % 2 == 1) {
					System.out.println("Alice");
				} else {
					System.out.println("Bob");
				}
				continue;
			}

			long d = k;
			boolean overflow = false;
			while (n > 0) {
				System.out.println("n: " + n + ", d: " + d);
				n -= (2 * d);
				if (n >= 0) {
					if (d <= Long.MAX_VALUE / k) {
						d *= k;
					} else {
						overflow = true;
						break;
					}
				} else {
					n += (2 * d);
					break;
				}
			}

			System.out.println("n: " + n + ", d: " + d);

			if (n - d > 0 && !overflow) {
				System.out.println("Alice");
			} else {
				System.out.println("Bob");
			}
		}

	}

}
