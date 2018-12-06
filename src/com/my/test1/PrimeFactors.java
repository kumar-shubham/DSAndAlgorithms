package com.my.test1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrimeFactors {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(2,3,6);
		
		System.out.println(solve(list));
		
	}
	
	static int solve(List<Integer> a) {
		
		Set<Integer> set = new HashSet<>(a);
		Set<Integer> primeSet = new HashSet<>();
		DisjointSet ds = new DisjointSet();
		int ones = 0;
		
		for(Integer i : a) {
			if( i == 1) {
				ones++;
			}
		}
		for(Integer i : set) {
			ds.makeSet(i);
		}
		
		for(Integer i : set) {
			
			Set<Integer> factors = primeFactors(i);
			
			for(Integer j : factors) {
				if(set.contains(j)) {
					ds.union(i, j);
				}
				else {
					if(primeSet.contains(j)) {
						ds.union(i, j);
					}
					else {
						ds.makeSet(j);
						ds.union(i, j);
						primeSet.add(j);
					}
					
				}
			}
		}
		
		primeSet.clear();
		
		for(Integer i : set) {
			int j = (int) ds.findSet(i);
			primeSet.add(j);
		}
		
		System.out.println("total actual numbers: " + primeSet.size());
		int x = primeSet.size() + (ones -1);
		int mod = 1000000007;
		double total = 1;
		double power2 = Math.pow(2, 10);
		for(double i = 0; i< x;) {
			
			if(x-i < 10) {
				total = total * Math.pow(2, x-i);
				total %= mod;
				break;
			}
			else {
				total = total * power2;
				total %= mod;
			}
			
		}
		
		if(total == 1) {
			total = 2;
		}
		
		//System.out.println("ans: " + (total-2));
		
		return (int) (total-2);
    }
	
	public static Set<Integer> primeFactors(int n) 
    { 
		Set<Integer> factors = new HashSet<>();
        // Print the number of 2s that divide n 
        while (n%2==0) 
        { 
           // System.out.print(2 + " "); 
            factors.add(2);
            n /= 2; 
        } 
  
        // n must be odd at this point.  So we can 
        // skip one element (Note i = i +2) 
        for (int i = 3; i <= Math.sqrt(n); i+= 2) 
        { 
            // While i divides n, print i and divide n 
            while (n%i == 0) 
            { 
               // System.out.print(i + " "); 
                factors.add(i);
                n /= i; 
            } 
        } 
  
        // This condition is to handle the case whien 
        // n is a prime number greater than 2 
        if (n > 2) {
        	//System.out.print(n);
        	factors.add(n);
        }
        //System.out.println();
            
        
        
        return factors;
    } 

}
