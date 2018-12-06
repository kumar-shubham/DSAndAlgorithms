package com.my.tree;

public class SortedListToBST {

	public static void main(String[] args) {
		
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for(int i = 2; i<21; i++) {
			ListNode n = new ListNode(i);
			temp.next = n;
			temp = n;
		}
		
		temp = head;
		System.out.print(temp.val);
		temp = temp.next;
		while(temp != null) {
			System.out.print(" -> " + temp.val);
			temp = temp.next;
		}
		System.out.println();
		
		TreeNode root = sortedListToBST(head);
		inOrder(root);

	}

	public static TreeNode sortedListToBST(ListNode a) {

		int count = 0;

		ListNode temp = a;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		System.out.println(count);
		
		TreeNode root = buildTree(a, count);

		return root;

	}
	
	public static TreeNode buildTree(ListNode node, int size) {
		
		TreeNode root = null;
		
		if(node == null || size < 1) {
			return null;
		}
		
		System.out.println("node: " + node.val + ", size: " + size);
		
		if(size == 1) {
			root = new TreeNode(node.val);
			return root;
		}
		
		ListNode middle = getMiddle(node, size);
		
		root = new TreeNode(middle.val);
		root.left = buildTree(node, ((size+1)/2)-1);
		root.right = buildTree(middle.next, (size/2));
		
		return root;
	}
	
	public static ListNode getMiddle(ListNode node, int size) {
		ListNode middle = node;
		int i = 1;
		while (i < (size+1) / 2) {
			middle = middle.next;
			i++;
		}
		return middle;
	}
	
	static void inOrder(TreeNode node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.val + " ");
			inOrder(node.right);
		}
	}


}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class ListNode {
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
