package com.my.test1;

//https://www.interviewbit.com/problems/longest-valid-parentheses/

/*
Longest valid Parentheses

    Asked in:  
    Google

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/

public class LongestvalidParentheses {

	public static void main(String[] args) {
		
		String s = "(()()))(()";
		System.out.println(longestValidParentheses(s));

	}

	public static int longestValidParentheses(String A) {
		
		int count = 0;
		int maxLength = 0;
		int length = 0;
		for(int i = 0; i<A.length(); i++) {
			
			int c = A.charAt(i);
			
			
			
			if(c == '(') {
				if(count < 0) {
					count = 1;
				}
				else {
					count++;
				}
			}
			else {
				count--;
			}
			
			if(count == 1 && length == 0) {
				length = 1;
			}
			else if(count >= 0) {
				length++;
			}else {
				length= 0;
			}
			
			maxLength = Math.max(maxLength, length);
			System.out.println(c + ", " + maxLength + ", " + length + ", " + count);
		}
		
		if(maxLength == length) {
			maxLength -= count;
		}
		return maxLength;
	}

}
