package com.my.test1;

import java.util.Arrays;

public class TestClass2 {

	public static void main(String[] args) {
		
		int A = 1;
		int B = 2;
		int C = 2;
		int D = 10;
//		int[] arr = {A,B,C};
//		
//		Arrays.sort(arr);
//		
//		
//		if(B%A == 0) {
//			arr[1] = D;
//		}else if(C%B == 0) {
//			arr[2] = D;
//		}
//		
//		if(C%A == 0) {
//			arr[2] = D;
//		}
//		A = arr[0];
//		B = arr[1];
//		C = arr[2];
		
		int count = 0;
		count += (D-1)/A;
		if(A != B)
			count += (D-1)/B;
		if(A != C || B != C)
			count += (D-1)/C;
		
		if(A != B)
			count -= (D-1)/(lcm(A,B));
		if(A != C)
			count -= (D-1)/(lcm(A,C));
		if(B != C)
			count -= (D-1)/(lcm(B,C));
		System.out.println(count);

	}
	
	static long gcd(long a, long b) 
    { 
        // Everything divides 0  
        if (a == 0 || b == 0) 
           return 0; 
       
        // base case 
        if (a == b) 
            return a; 
       
        // a is greater 
        if (a > b) 
            return gcd(a-b, b); 
        return gcd(a, b-a); 
    } 
      
    // method to return LCM of two numbers 
    static long lcm(long a, long b) 
    { 
        return (a*b)/gcd(a, b); 
    } 
	
}
