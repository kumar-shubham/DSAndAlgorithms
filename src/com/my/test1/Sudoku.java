package com.my.test1;

public class Sudoku {
	
	public static void print(int[][] board, int N) 
	{ 
	    // we got the answer, just print it 
	    for (int r = 0; r < N; r++) 
	    { 
	        for (int d = 0; d < N; d++) 
	        { 
	            System.out.print(board[r][d]); 
	            System.out.print(" "); 
	        } 
	        System.out.print("\n"); 
	          
	        if ((r + 1) % (int) Math.sqrt(N) == 0)  
	        { 
	            System.out.print(""); 
	        } 
	    } 
	} 
	  
	// Driver Code 
	public static void main(String args[]) 
	{ 
	  
	    int[][] board = new int[][] 
	    { 
	            {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
	            {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
	            {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
	            {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
	            {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
	            {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
	            {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
	            {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
	            {0, 0, 5, 2, 0, 6, 3, 0, 0} 
	    }; 
	    int N = board.length; 
	    
	    boolean result = solveSudoku(board, N);
	    
	    System.out.println(result);
	  
	    if (result) 
	    { 
	        print(board, N); // print solution 
	    }  
	    else
	    { 
	        System.out.println("No solution"); 
	    } 
	} 
	
	
	public static boolean solveSudoku(int[][] board, int n) {
//		System.out.println(n);
		boolean isEmpty = true;
		int row = -1;
		int col = -1;
		
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(board[i][j] == 0) {
					row = i;
					col = j;
					isEmpty = false;
					break;
				}
			}
			if(!isEmpty) {
				break;
			}
		}
		
		if(isEmpty) {
			return true;
		}
		
		for(int num = 1; num<=n; num++) {
			
			if(isSafe(board, row, col, num)) {
				board[row][col] = num;
				
				if(solveSudoku(board, n)) {
					return true;
				}
				else {
					board[row][col] = 0;
				}
				
			}
			
		}
		
		return false;
		
	}
	
	
	public static boolean isSafe(int[][] board, int row, int col, int num) {
		
		for(int i = 0; i<9;i++) {
			if(board[row][i] == num) {
				return false;
			}
			if(board[i][col] == num) {
				return false;
			}
		}
		
		int startRow = row - row%3;
		int startCol = col - col%3;
		
		for(int i = startRow; i<(startRow+3); i++) {
			for(int j = startCol;j<(startCol+3);j++) {
				if(board[i][j] == num) {
					return false;
				}
			}
		}
		
		
		return true;
	}

}
