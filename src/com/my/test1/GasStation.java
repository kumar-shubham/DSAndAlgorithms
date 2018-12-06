package com.my.test1;

import java.util.Arrays;
import java.util.List;

//https://www.interviewbit.com/problems/gas-station/?ref=random-problem
/*
There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.

You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2..
Completing the circuit means starting at i and ending up at i again.

Example :

Input :
      Gas :   [1, 2]
      Cost :  [2, 1]

Output : 1 

If you start from index 0, you can fill in gas[0] = 1 amount of gas. Now your tank has 1 unit of gas. But you need cost[0] = 2 gas to travel to station 1. 
If you start from index 1, you can fill in gas[1] = 2 amount of gas. Now your tank has 2 units of gas. You need cost[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over. You fill in gas[0] = 1 unit of additional gas, making your current gas = 2. It costs you cost[0] = 2 to get to station 1, which you do and complete the circuit. 

*/

public class GasStation {

	public static void main(String[] args) {
		
		Integer[] a = {141, 669, 822, 180, 778, 138, 453, 561, 111, 551, 131, 28, 946, 211, 854, 371, 565, 628, 545, 392, 171, 860, 396, 148, 864, 408, 103, 566, 59, 233, 470, 114, 526, 400, 564, 421, 556, 343, 823, 731, 87, 433, 187, 123, 737, 409, 288, 512, 99, 224, 58, 257, 722, 313, 314, 171, 400, 686, 250, 519, 131, 94, 535, 103, 177, 780, 319, 926, 280, 973, 88, 598, 682, 311, 277, 426, 28, 176, 542, 411, 155, 633, 335, 683, 846, 506, 9, 593, 71, 305, 929, 53, 54, 558, 448, 8, 528};
		Integer[] b = {982, 934, 504, 226, 710, 775, 705, 545, 647, 760, 161, 185, 95, 554, 750, 333, 773, 887, 279, 600, 9, 664, 555, 969, 203, 233, 440, 958, 399, 351, 393, 123, 367, 637, 235, 134, 664, 688, 70, 885, 326, 45, 659, 240, 827, 892, 481, 80, 208, 441, 213, 586, 970, 326, 960, 558, 563, 623, 177, 252, 598, 985, 18, 758, 496, 439, 622, 598, 97, 263, 275, 604, 861, 454, 376, 872, 873, 239, 964, 321, 187, 261, 499, 195, 4, 443, 414, 785, 809, 632, 431, 427, 271, 699, 699, 843, 33};

		Integer[] a1 = {0};
		Integer[] b1 = {0};
		
		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);
		System.out.println(canCompleteCircuit(A, B));
		
	}

	public static int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {

		int start = -1;

		int possible = A.size();
		int n = A.size();
		int i = 0;
		int sum = 0;
		while (possible > 0) {

			if (start == i) {
				break;
			}

			int gas = A.get(i);
			int cost = B.get(i);
			int value = gas - cost;

			if (sum == 0 && value >= 0 && start < 0) {
				start = i;
			}

			if (sum + value < 0) {
				sum = 0;
				if (start < 0) {
					possible--;
				} else {
					if (i < start) {
						System.out.println("possible before: " + possible + ", tbd: " + (n - start + i));
						possible -= (n - start + i);
						System.out.println("possible before: " + possible);
					} else {
						possible -= (i - start);
					}

				}
				start = -1;
			} else {
				sum += value;
			}

			System.out.println("i: " + i + ", sum: " + sum + ", start: " + start + ", possible: " + possible);

			i = (i + 1) % n;

		}

		if (possible <= 0) {
			return -1;
		}

		return start;
	}

}
