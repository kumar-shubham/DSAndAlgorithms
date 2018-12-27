package com.my.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Scores {

	public static void main(String[] args) {
		
		Integer[] a = {4336, 24047, 24846, 25681, 28597, 30057, 32421, 34446, 48670, 67750, 68185, 69661, 85721, 89013};
		Integer[] b = {8751, 10576, 14401, 22336, 22689, 35505, 38649, 43073, 43176, 44359, 44777, 50210, 50408, 51361, 53181, 60095, 65554, 68201, 68285, 68801, 72501, 75881, 80251, 80509, 83306, 93167, 95365, 95545, 97201, 97731};
		
		List<Integer> A = Arrays.asList(a);
		List<Integer> B = Arrays.asList(b);
		
		
		System.out.println(solve(A, B));

	}
	
	public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
		
		int l1 = A.size();
		int l2 = B.size();
		int maxDiff = l1*3 - l2*3;
		int scoreA = l1*3;
		int scoreB = l2*3;
		int j = 0;
		int i = 0;
		
		Collections.sort(A);
		Collections.sort(B);
		
		for(i = 0; i<A.size(); i++) {
			
			int a = A.get(i);
			
			while(j<l2 && B.get(j) < a) {
				j++;
			}
			
			System.out.println(i + ", " + j);
			
			
			int scoreA1 = (i*2) + (l1-i)*3;
			int scoreB1 = (j*2) + (l2-j)*3;
			
			
			int diff = scoreA1-scoreB1;
			if(diff > maxDiff) {
				maxDiff = diff;
				scoreA = scoreA1;
				scoreB = scoreB1;
			}
			
			if(j == l2) {
				break;
			}
			
		}
		
		int temp = l1*2 - l2*2;
		if(temp > maxDiff) {
			maxDiff = temp;
			scoreA = l1*2;
			scoreB = l2*2;
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		result.add(scoreA);
		result.add(scoreB);
		
		return result;
    }

}
