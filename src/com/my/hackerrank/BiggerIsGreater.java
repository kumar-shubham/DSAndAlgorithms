package com.my.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/bigger-is-greater/problem
public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        
            if(w.length() == 1){
                return "no answer";
            }
    
            List<Character> list = new ArrayList<>();
            char[] arr = w.toCharArray();
            char lastChar = w.charAt(w.length()-1);
            list.add(lastChar);
            for(int i = w.length()-2; i>=0; i--){
                char c = w.charAt(i);
                //System.out.println("char: " + c + " at index: " + i);
                if(c>=lastChar){
                    list.add(c);
                    lastChar = c;
                }
                else{
                    list.add(c);
                    ListIterator<Character> itr = list.listIterator();
                    while(itr.hasNext()){
                        Character ch = itr.next();
                        if(ch > c){
                            arr[i] = ch;
                            itr.remove();
                            Collections.sort(list);
                            String s = "";
                            for(int j = 0; j<=i; j++){
                                s += arr[j];
                            }
                            Character[] arr1 = list.toArray(new Character[0]);
                            for(int j = 0; j<arr1.length; j++){
                                s += arr1[j];
                            }
                            //System.out.println(s);
                            return s;
                        }
                    }
                }
            }
        
        return "no answer";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);
            System.out.println(result);
        }


        scanner.close();
    }
}
