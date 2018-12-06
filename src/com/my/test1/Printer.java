package com.my.test1;

public class Printer {
	
	
	public static void printArr(Object[] a) {
		System.out.print("[");
		for(int i = 0; i<a.length; i++) {
			if(i<a.length-1) {
				System.out.print(a[i] + ", ");
			}
			else {
				System.out.print(a[i] + "]");
			}
		}
		System.out.println();
	}
	
	public static void printArr2D(Object[][] a) {
		System.out.println("[");
		for(int i = 0; i<a.length; i++) {
			printArr(a[i]);
			if(i<a.length-1) {
			}
			else {
				System.out.println("]");
			}
		}
	}
	
	public static void printArr(int[] a) {
		System.out.print("[");
		for(int i = 0; i<a.length; i++) {
			if(i<a.length-1) {
				System.out.print(a[i] + ", ");
			}
			else {
				System.out.print(a[i] + "]");
			}
		}
		System.out.println();
	}
	
	public static void printArr2D(int[][] a) {
		System.out.println("[");
		for(int i = 0; i<a.length; i++) {
			printArr(a[i]);
			if(i<a.length-1) {
			}
			else {
				System.out.println("]");
			}
		}
	}

	
	public static void printArr(double[] a) {
		System.out.print("[");
		for(int i = 0; i<a.length; i++) {
			if(i<a.length-1) {
				System.out.print(a[i] + ", ");
			}
			else {
				System.out.print(a[i] + "]");
			}
		}
		System.out.println();
	}
	
	public static void printArr2D(double[][] a) {
		System.out.println("[");
		for(int i = 0; i<a.length; i++) {
			printArr(a[i]);
			if(i<a.length-1) {
			}
			else {
				System.out.println("]");
			}
		}
	}

}
