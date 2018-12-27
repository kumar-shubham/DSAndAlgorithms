package com.my.codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class FarewellParty {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		
		int n = s.nextInt();
		
		int[] a = new int[n];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		int rem = n;
		int[] result = new int[n];
		int counter = 1;
		int index = 0;
		for(int i = 0; i<n; i++) {
			a[i] = s.nextInt();
			int same = n-a[i];
			if(map.containsKey(a[i])) {
				same = map.get(a[i]);
				same--;
			}
			else {
				for(int j = index; j<index+same; j++) {
					if(j >= n) {
						System.out.println("Impossible");
						return;
					}
					result[j] = counter;
				}
				index += same;
				counter++;
				rem -= same;
				map.put(a[i], same);
			}
			if(same == 1) {
				map.remove(a[i]);
			}
		}
		
		
		if(rem != 0) {
			System.out.println("Impossible");
		}else {
			System.out.println("Possible");
			for(int i = 0; i<result.length;i++) {
				System.out.print(result[i] + " ");
			}
		}
		
		

	}

}
