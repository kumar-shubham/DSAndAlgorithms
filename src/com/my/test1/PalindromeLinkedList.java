package com.my.test1;

public class PalindromeLinkedList {
	
	public static void main(String[] args) {
		
		Node root = new Node(1);
		Node a = new Node(2);
		Node b = new Node(3);
		Node c = new Node(4);
		Node d = new Node(5);
		Node d1 = new Node(5);
		Node e = new Node(4);
		Node f = new Node(3);
		Node g = new Node(2);
		Node h = new Node(1);
		root.next = a;
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = d1;
		d1.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		
		System.out.println(isPalindrome(root));
		
	}
	
	static boolean isPalindrome(Node root) {
		
		int l = 0;
		
		Node temp = root;
		while(temp != null) {
			temp = temp.next;
			l++;
		}
		
		Node middle = root;
		for(int i = 0; i<(l+1)/2; i++) {
			middle = middle.next;
		}
		
		Node last = reverse(middle);
		
		for(int i = 0; i<(l)/2; i++) {
			if(root.value != last.value) {
				return false;
			}
			System.out.println(root.value + ", " + last.value);
			root = root.next;
			last = last.next;
		}
		
		return true;
		
	}
	
	private static Node reverse(Node root) {
		
		Node temp = root;
		Node prev = temp;
		while(temp != null) {
			
			if(temp.next == null) {
				root = temp;
				root.next = prev;
				break;
			}
			
			if(temp == prev) {
				temp = temp.next;
				prev.next = null;
				continue;
			}
			
			Node temp1 = temp.next;
			temp.next = prev;
			prev = temp;
			temp = temp1;
		}
		
		return root;
		
	}

	static class Node{
		int value;
		Node next;
		Node(int v){
			value = v;
		}
	}

}
