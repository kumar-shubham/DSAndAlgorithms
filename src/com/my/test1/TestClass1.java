package com.my.test1;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class TestClass1 {

	public static void main(String[] args) throws ParseException {

		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(5);
		s.add(10);
		s.add(4);
		s.add(8);
		s.add(7);
		
		System.out.println(s);

	}

	

}
