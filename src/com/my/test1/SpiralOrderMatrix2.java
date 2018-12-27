package com.my.test1;

//https://www.interviewbit.com/problems/spiral-order-matrix-ii/?ref=random-problem



public class SpiralOrderMatrix2 {

	public static void main(String[] args) {
		
		int[][] a = generateMatrix(5);
		
		Printer.printArr2D(a);

	}
	
	
	public static int[][] generateMatrix(int A) {
        int n = A-1;
        int[][] a = new int[A][A];
        int count = 0;
        int i = 0;
        int j = 0;
        int start = 0;
        int max = A*A;
        while(count < max){
            count++;
            a[i][j] = count;
            System.out.println(start + ", " + n + ", " + i + ", " + j);
            if(i == start && j<n ){
                j++;
                continue;
            }
            if(j == n && i <n){
                i++;
                continue;
            }
            if(i == n && j > start){
                j--;
                continue;
            }
            if(j == start && i > start+1){
                i--;
                continue;
            }
            System.out.println();
            start++;
            n--;
            i = start;
            j = start;
        }
        
        return a;
    }

}
