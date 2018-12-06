package com.my.test1;

public class MaxDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = {5,6,3,3,2,1};
		
		System.out.println(maxDiff(arr, 5));

	}
	
	static int maxDiff(int arr[], int arr_size)  
    { 
        int max_diff = -1; 
        int min_element = arr[0]; 
        int i; 
        for (i = 0; i < arr_size; i++)  
        { 
        	if(arr[i] == min_element) {
        		continue;
        	}
            if (arr[i] - min_element > max_diff) 
                max_diff = arr[i] - min_element; 
            if (arr[i] < min_element) 
                min_element = arr[i]; 
        } 
        return max_diff; 
    } 

}
