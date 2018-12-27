package com.my.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SchedulingClasses {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		s.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		int t = s.nextInt();

		for (int i = 0; i < t; i++) {

			int n = s.nextInt();

			List<Lecture> list = new ArrayList<>();
//			System.out.println("n: " + n);
			for (int j = 0; j < n; j++) {
				String str = s.nextLine();
				if(str == null || str.trim().length() == 0) {
					str = s.nextLine();
				}
//				System.out.println("str: " + str);
				String[] arr = str.split(" ");
				String st = arr[1];
				String et = arr[2];

				list.add(new Lecture(st, et));
			}

			Collections.sort(list);

			int count = 1;
			Lecture prev = list.get(0);

			for (int j = 1; j < n; j++) {
				Lecture l = list.get(j);
				if (l.getStartTime().compareTo(prev.getEndTime()) >= 0) {
					count++;
					prev = l;
				}
			}

			System.out.println(count);
		}
	}
}

class Lecture implements Comparable<Lecture> {

	private String startTime;
	private String endTime;

	public Lecture(String st, String ed) {
		this.startTime = st;
		this.endTime = ed;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	@Override
	public int compareTo(Lecture that) {
		return this.endTime.compareTo(that.endTime);
	}

}
