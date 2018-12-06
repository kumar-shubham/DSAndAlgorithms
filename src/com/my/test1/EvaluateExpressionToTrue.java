package com.my.test1;

public class EvaluateExpressionToTrue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int r = solve("TTTFFFFTFT", "^^^|&^|^^");
		System.out.println(r);
		System.out.println(r%1003);

	}
	
	public static int solve(String operands, String operators) {
		
		int n = operands.length();
		
		int[][] F = new int[n][n];
		int[][] T = new int[n][n];
		
		for(int i =0; i<n; i++) {
			F[i][i] = operands.charAt(i) == 'F' ? 1 : 0;
			T[i][i] = operands.charAt(i) == 'T' ? 1 : 0;
		}
		
		for(int gap = 1; gap<n; gap++) {
			System.out.println("gap: " + gap);
			for(int i = 0, j = gap; j<n; i++, j++) {
				System.out.println("i: " + i + ", j: " + j);
				int sumT = 0;
				int sumF = 0;
				for(int k = i; k<j; k++) {
					char op = operators.charAt(k);
					System.out.println("i: " + i + ", j: " + j + ", k: " + k + ", op: " + op);
					if(op == '&') {
						sumT += (T[i][k] * T[k+1][j]);
						sumF += (F[i][k] * F[k+1][j] + F[i][k] * T[k+1][j] + T[i][k] * F[k+1][j]);
					}
					else if( op == '|') {
						sumT += (T[i][k] * T[k+1][j] + T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j]);
						sumF += (F[i][k] * F[k+1][j]);
					}
					else if(op == '^') {
						sumT += (T[i][k] * F[k+1][j] + F[i][k] * T[k+1][j]);
						sumF += (F[i][k] * F[k+1][j] + T[i][k] * T[k+1][j]);
					}
				}
				
				T[i][j] = sumT;
				F[i][j] = sumF;
				//Printer.printArr2D(T);
				
			}
		}
		
		Printer.printArr2D(T);
		Printer.printArr2D(F);
		
		return T[0][n-1];
	}

}
