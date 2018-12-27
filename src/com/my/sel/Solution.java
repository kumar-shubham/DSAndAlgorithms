package com.my.sel;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            
            long completeNode = (n-2)/3;
            long leafNode = (n-completeNode-1);
            int semiLeafNodeNeutrons = (((n-1)%3)^3)%3;
            long totalNeutrons = ((leafNode*3) + semiLeafNodeNeutrons);
            System.out.println(totalNeutrons);
           
        }

    }
}
