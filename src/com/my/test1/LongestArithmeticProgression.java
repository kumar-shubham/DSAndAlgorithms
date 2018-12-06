package com.my.test1;

import java.util.Arrays;
import java.util.List;

public class LongestArithmeticProgression {

	public static void main(String[] args) {
		
		List<Integer> A = Arrays.asList(9, 4, 7,2,10);
		System.out.println(solve(A));

	}
	
	public static int solve(final List<Integer> A) {
        if (A.size()==0||A.size()==1||A.size()==2){
            return A.size();
        }
        int diff = 0;
        int count =0;
        int prevIndex = 0;
        int maxCount = 0;
        for (int i = 0;i<A.size();i++){
                diff=0;
                count=1;
                for (int j=i+1;j<A.size();j++){
                    diff = A.get(j)-A.get(i);
                    count = 2;
                    prevIndex = j;
                    count =count + solveSub(A,diff,prevIndex,j+1);
                    if (maxCount < count){
                        maxCount = count;
                    }
                }
            
        }
        return maxCount;
    }
    private static int solveSub(final List<Integer> A,int diff,int prevIndex,int curIndex){
        if (curIndex > A.size()-1){
            return 0;
        }
        if (A.get(curIndex) - A.get(prevIndex) == diff){
            return 1 + solveSub(A,diff,curIndex,curIndex+1);
        }
        return solveSub(A,diff,prevIndex,curIndex+1);
    }

}
