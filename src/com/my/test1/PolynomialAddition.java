package com.my.test1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PolynomialAddition {
	
	public static void addPolynomial(Node p1,Node p2)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        
        while(p1 != null){
            if(map.containsKey(p1.pow)){
                map.put(p1.pow, map.get(p1.pow)+p1.coeff);
            }
            else{
                map.put(p1.pow, p1.coeff);
            }
            p1 = p1.next;
            
        }
        
        while(p2 != null){
            if(map.containsKey(p2.pow)){
                map.put(p2.pow, map.get(p2.pow)+p2.coeff);
            }
            else{
                map.put(p2.pow, p2.coeff);
            }
            p2 = p2.next;
        }
        
       Set<Integer> set = map.keySet();
       System.out.println(set);
       StringBuilder sb = new StringBuilder("");
       Iterator<Integer> itr = set.iterator();
       while(itr.hasNext()) {
    	   int pow = itr.next();
    	   int coeff = map.get(pow);
    	   
    	   if(pow == 0) {
    		   continue;
    	   }
    	   String s = coeff + "x^" + pow;
    	   sb.insert(0,s);
    	   if(itr.hasNext()) {
    		   sb.insert(0," + ");
    	   }
       }
       System.out.println(sb.toString());
       
    }
	
	static class Node{
	    int coeff;
	    int pow;
	    Node next;
	    Node(int a,int b)
	    {
	        coeff=a;
	        pow=b;
	        next=null;
	    }
	}
	
	public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node start1=null,cur1=null,start2=null,cur2=null;
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start1==null)
                {
                    start1=ptr;
                    cur1=ptr;
                }
                else{
                    cur1.next=ptr;
                    cur1=ptr;
                }
            }
            n=sc.nextInt();
            while(n-->0)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                Node ptr=new Node(a,b);
                if(start2==null)
                {
                    start2=ptr;
                    cur2=ptr;
                }
                else{
                    cur2.next=ptr;
                    cur2=ptr;
                }
            }
            addPolynomial(start1,start2);
            System.out.println();
        }
    }

}
