package com.my.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreProblem {
	
	private static int total = 0;
	private static int totalCall = 0;

	public static void main(String[] args) {
		
		int[] nums = {3,5,10};
		List<Integer> scores = new ArrayList<>();
		
//		findSol(22, nums, scores);
		
//		System.out.println(total);
//		System.out.println(totalCall);
		
		//System.out.println(findDynamicSol(20, nums));
		
		String s = "hello. de.ar";
		String s1 = s.replaceAll("\\.", "");
		System.out.println(s1);

	}
	
	private static int findDynamicSol(int sum, int[] nums) {
		
		int[] table = new int[sum+1];
		int i;
		
		Arrays.fill(table, 0);
		
		table[0] = 1;
		printArr(table);
		for(i = 3;i<= sum; i++) {
			table[i] += table[i-3];
			printArr(table);
		}
		for(i = 5; i<= sum; i++) {
			table[i] += table[i-5];
			printArr(table);
		}
		for(i = 10; i<sum; i++) {
			table[i] += table[i-10];
			printArr(table);
		}
		
		return table[i];
		
	}
	
	static void printArr(int[] arr) {
		System.out.print("[");
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
	
	
	private static void findSol(int sum, int[] nums, List<Integer> scores) {
		totalCall++;
		if(sum == 0) {
			System.out.println(scores);
			total++;
			return;
		}
		if(sum < 0) {
			return;
		}
		
		for(int num : nums) {
			scores.add(num);
			findSol(sum-num, nums, scores);
			scores.remove(scores.size()-1);
		}
		
	}

}
