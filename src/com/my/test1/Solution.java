package com.my.test1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}



class Result {

    /*
     * Complete the 'getSum' function below.
     *
     * The function is expected to return an INTEGER_SINGLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_SINGLY_LINKED_LIST num1
     *  2. INTEGER_SINGLY_LINKED_LIST num2
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static SinglyLinkedListNode getSum(SinglyLinkedListNode num1, SinglyLinkedListNode num2) {
    	
    	SinglyLinkedListNode result = null;
    	
    	SinglyLinkedListNode temp = result;
    	SinglyLinkedListNode prev = result;
    	int carry = 0;
    	while(num1 != null && num2 != null) {
    		temp = new SinglyLinkedListNode(carry);
    		if(result == null) {
    			result = temp;
    		}
    		if(prev != null) {
    			prev.next = temp;
    		}
    		int sum = 0;
    		int a = num1.data;
    		int b = num2.data;
    		sum = a + b + carry;
    		temp.data = sum%10;
    		carry = sum/10;
    		num1 = num1.next;
    		num2 = num2.next;
    		prev = temp;
    	}
    	
    	while(num1 != null) {
    		temp = new SinglyLinkedListNode(carry);
    		if(result == null) {
    			result = temp;
    		}
    		if(prev != null) {
    			prev.next = temp;
    		}
    		int sum = num1.data + carry;
    		temp.data = sum%10;
    		carry = sum/10;
    		num1 = num1.next;
    		prev = temp;
    	}
    	
    	while(num2 != null) {
    		temp = new SinglyLinkedListNode(carry);
    		if(result == null) {
    			result = temp;
    		}
    		if(prev != null) {
    			prev.next = temp;
    		}
    		int sum = num2.data + carry;
    		temp.data = sum%10;
    		carry = sum/10;
    		num2 = num2.next;
    		prev = temp;
    	}
    	
    	if(carry == 1) {
    		temp = new SinglyLinkedListNode(carry);
    		if(prev != null) {
    			prev.next = temp;
    		}
    	}
    	
    	
		return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        SinglyLinkedList num1 = new SinglyLinkedList();

        int num1Count = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < num1Count; i++) {
            int num1Item = Integer.parseInt(bufferedReader.readLine().trim());

            num1.insertNode(num1Item);
        }

        SinglyLinkedList num2 = new SinglyLinkedList();

        int num2Count = Integer.parseInt(bufferedReader.readLine().trim());

        for (int i = 0; i < num2Count; i++) {
            int num2Item = Integer.parseInt(bufferedReader.readLine().trim());

            num2.insertNode(num2Item);
        }

        SinglyLinkedListNode result = Result.getSum(num1.head, num2.head);
        
        

        bufferedReader.close();
    }
}