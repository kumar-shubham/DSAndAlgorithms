package com.my.hackerrank;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.my.test1.Printer;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		char c = '1';
		int a = (c-'0');
		System.out.println(a);
		
		String s = "ababacdabab";
		
		int[] a1 = buildPrefixArray(s);
		
		Printer.printArr(a1);
		
		Double d = 1000000007d;
		
		System.out.println(String.class.getClassLoader());
		System.out.println(d.getClass().getClassLoader());
		System.out.println(Test.class.getClassLoader());
		
		
		
		Double count  = 1d;
		
		for(int i = 1; i<10000; i++) {
			count *= i;
			count = count%d;
		}
		
		for(int i = 1; i < a1.length; i++) {
			if(a1[i] == 0) {
				count += a1[i-1];
			}
		}
		
		System.out.println(count);
		
		Runtime r = Runtime.getRuntime();
		
		double mb = 1024*1024;
		
		System.out.println(r.maxMemory()/mb);
		
		String filepath = "/home/kumar/Downloads/apiD_XML_SIX_release_notes_9_0.pdf";
		
		File file = new File(filepath);
		
		System.out.println(Files.probeContentType(file.toPath()));

	}
	
	private static int[] buildPrefixArray(String s) {
		int[] p = new int[s.length()];

		p[0] = 0;
		
		Double d = 1000000007d;
		
		Double count = 1d;

		for (int i = 1, j = 0; i < s.length();) {

			if (s.charAt(i) == s.charAt(j)) {
				p[i] = p[j] + j + 1;
				
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = p[j - 1];
				}
			}

		}
		return p;
	}

}
