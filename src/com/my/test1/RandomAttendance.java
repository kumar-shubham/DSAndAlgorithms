package com.my.test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.interviewbit.com/problems/random-attendance/?ref=random-problem




public class RandomAttendance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] arr = {1,2,3,4,10,11,20,19};
		
		List<Integer> list = Arrays.asList(arr);
		
		System.out.println(list);
		
		Collections.sort(list, (a, b) -> String.valueOf(a).compareTo(String.valueOf(b)));
		
		System.out.println(list);

	}
	
	

}
