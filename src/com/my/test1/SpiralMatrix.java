package com.my.test1;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		int R = 4;
        int C = 4;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
                    };
        
        int b[][] = { {1, 2, 3},
        		{4, 5, 6},
        		{7, 8, 9}
        };
        
        int c[][] = { {1, 2, 3, 4},
        		{5, 6, 7, 8},
        		{9, 10, 11, 12},
        		{13, 14, 15, 16}
        };
        printSpiralMatrix(c, R, C);

	}
	
	private static void printSpiralMatrix(int[][] arr, int m, int n) {
		
		int l = (Math.min(m, n)+1)/2;
		
		System.out.println(l);
		
		int rowStart = 0;
		int rowEnd = m-1;
		int colStart = 0;
		int colEnd = n-1;
		
		for(int loop = 0; loop < l ; loop++) {
			
//			System.out.println(rowStart + ", " + rowEnd + ", " + colStart + ", " + colEnd);
			
			int i = rowStart;
			int j = colStart;
			
			for(;j<=colEnd;j++) {
				System.out.print(arr[i][j] + " ");
			}
			i++;
			j--;
			for(;i<=rowEnd;i++) {
				System.out.print(arr[i][j] + " ");
			}
			j--;
			i--;
			if(rowStart < rowEnd) {
				for(;j>=colStart;j--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			j++;
			i--;
			if(colStart < colEnd) {
				for(;i>rowStart;i--) {
					System.out.print(arr[i][j] + " ");
				}
			}
			
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--;
			
		}
	}

}
