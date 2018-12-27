package com.my.test1;

import java.util.HashSet;
import java.util.Set;

public class TestClass1 {

	public static void main(String[] args) {

//		int[] a = {1,2,3,4,5,7};

//		System.out.println(solve(a));

		String s = "eebdafcbbdfcgccfgcdbdefgfbffcccbdadgdaeaffeffbdcgcgbgggfceabcdacegagfbgdgcbabcbadcgaabfeceacgccccdcdaeabgdfcefbeagbfagacfdafeccabadecgfeaaffdcegeecfeacgfcadgacbegdcgbadbegeegdfbbfeefgbgdafbbffcacffeecgacbebecbffbbgbfegbcaaeafdbceeaaaggfbacddecabgbafgebbebeacbabgbfdeddaadabeafacaddgcegaffeaedfeccbecedaggffgfdfbgbagcgggbaagdbgbfafaebbgagddbgbfaggcgcbcaccgdbeafddggcfabccffabaaeccadadccacgbefbfaeeccagedccccaffdceccgafaafbdebbcgfgeageaagffcfefgefdbebfddbgccbdcadbccaaeagafgafdfebbeegcfbbebegfdaagfgcdedgaefdacfafbgdegcdggcedbagcbedcgbgbebabggdabgafccddfabbadgebbaaedecbbdabbbdcgaacfccgeagegdaaacdcegceafbfdgbgdgcfcgdgbebadgeaaccbgfaebecgbbacgeacecedfadeaebffdgcebaeccagbaaaecffffgagbcbgaddfadafceebefdgfgbbdcfgecaaaceggceagdcfdadegfddgegeeeddgcbfbaegcegfcgebeecbgbeacacefdgeceaecggdgagedfegagcbbaecddebbcggaegcdafaffgdeeedfgfccaacgcegddgfbdbdacgggdcfebfecefgegdcaffdfbdbbcbaeebeaedce";

		int[] r = buildPrefixArray(s);
		Printer.printArr(r);
		
		solvePrefix(s);

	}
	
	private static int[] buildPrefixArray(String s) {
		int[] p = new int[s.length()];

		p[0] = 0;

		for (int i = 1, j = 0; i < s.length();) {

			if (s.charAt(i) == s.charAt(j)) {
				p[i] = j + 1;
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = p[j - 1];
				}
			}

		}
		return p;
	}

	private static int[] solvePrefix(String s) {
		int[] p = new int[s.length()];

		p[0] = 0;

		long mod = 1000000007;

		long count = 1;

		Set<Integer> visited = new HashSet<>();

		for (int i = 0; i < s.length();i++) {
			if(visited.contains(i)) {
				continue;
			}
			count = (count * getCount(s, i, visited))%mod;
		}

		System.out.println(count);
		return p;
	}

	public static int getCount(String s, int start, Set<Integer> visited) {

		int[] p = new int[s.length()];
		long mod = 1000000007;

		long count = 1;
		
		for (int i = start, j = 0; i < s.length();) {

			if(visited.contains(i)) {
				break;
			}
			if (s.charAt(i) == s.charAt(j)) {
				p[i] = j + 1;
				count = (count * p[i]) % mod;
				if(p[i] == 1) {
					visited.add(i);
				}
//				System.out.println(count);
				i++;
				j++;
			} else {
				if (j == 0) {
					break;
				} else {
					j = p[j - 1];
				}
			}
		}
		
//		System.out.print("start: " + start + " and array is: ");
//		Printer.printArr(p);
		
		return (int) count;

	}

}
