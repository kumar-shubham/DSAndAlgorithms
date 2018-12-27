package com.my.test1;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidBST {

	public static void main(String[] args) {
		
		Integer[] a = {3,2,1,5,6,4};
		
		System.out.println(isValid(Arrays.asList(a)));

	}
	
	
	public static String isValid(List<Integer> a) {
	    
        if(a.size() == 1){
            return "YES";
        }
        
       Stack<Integer> s = new Stack<>();
       
       int root = -1;
       
       for(int current : a){
           
           if(current < root){
               return "NO";
           }
           
           int top = s.isEmpty() ? -1 : s.peek();
           while(!s.isEmpty() && top < current){
               root = s.pop();
               top = root;
           }
           
           s.push(current);
       }
       
       return "YES";

    }

}
