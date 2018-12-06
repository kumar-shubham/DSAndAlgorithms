package com.my.hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class SherlockAndAnagram {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        
        HashMap<Long, Long> countMap = new HashMap<>();
        
        long count = 0;
        
        for(int i = 0; i<arr.size(); i++){
            Long num = arr.get(i);
            if(countMap.containsKey(num)){
                countMap.put(num, countMap.get(num)+1);
            }
            else{
                countMap.put(num, Long.valueOf(1));
            } 
        }
        
        if(r == 1){
            Set<Long> keys = countMap.keySet();
            for(Long key : keys){
                Long c = countMap.get(key);
                double temp = ((c)*(c-1)*(c-2)/6);
                double temp1 = c*(c-1);
                double temp2 = temp*(c-2);
                System.out.println("key is : " + key);
                System.out.println("c is : " + c);
                System.out.println("temp1 is : " + String.valueOf(temp1));
                System.out.println("temp2 is : " + String.valueOf(temp2));
                count += temp;
            }
            System.out.println(count);
            return count;
        }
        
        for(int i = 0; i<arr.size(); i++){
            long num = arr.get(i);
            long num1 = num*r;
            long num2 = num1*r;
            
            if(countMap.containsKey(num1) && countMap.containsKey(num2)){
                count += (countMap.get(num1)*countMap.get(num2));
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);
        
        bufferedReader.close();
    }
}
