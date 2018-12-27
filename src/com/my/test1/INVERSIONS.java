package com.my.test1;

//https://www.interviewbit.com/problems/inversions/

/*

Given an array A, count the number of inversions in the array.

Formally speaking, two elements A[i] and A[j] form an inversion if A[i] > A[j] and i < j

Example:

A : [2, 4, 1, 3, 5]
Output : 3

as the 3 inversions are (2, 1), (4, 1), (4, 3).

*/

public class INVERSIONS {

	public static void main(String[] args) {
		
		int[] a = {2,4,1,3,5};
		
		int count = solve(a);
		
		//Printer.printArr(a);
		
		System.out.println(count);

	}

	private static int solve(int[] a) {
		return mergeSort(a, 0, a.length-1);
	}
	
	static int mergeSort(int[] a, int left, int right) {
		
		if(left >= right) {
			return 0;
		}
		
		int mid = (left + right)/2;
		
		//System.out.println(left + ", " + mid + ", " + right);
		
		int l = mergeSort(a, left, mid);
		int r = mergeSort(a, mid+1, right);
		
		int t = merge(a, left,right);
		
		return (l+r+t);
	}
	
	static int merge(int[] a, int left, int right) {
		
		int mid = (left+right)/2;
		int n = right-left+1;
		int temp[] = new int[n];
		int l = left;
		int r = mid+1;
		int i = 0;
		int count = 0;
		while(l<=mid && r <=right) {
			
			if(a[l] <= a[r]) {
				temp[i] = a[l];
				l++;
			}
			else {
				temp[i] = a[r];
				r++;
				count += (mid-l+1);
			}
			i++;
		}
		
		while(l<=mid) {
			temp[i] = a[l];
			l++;
			i++;
		}
		
		while(r<=right) {
			temp[i] = a[r];
			r++;
			i++;
		}
		
		for(int k = 0; k<n;k++) {
			a[left+k] = temp[k];
		}
		
		return count;
	}
	
	

}
