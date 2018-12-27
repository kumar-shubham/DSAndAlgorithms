package com.my.test1;

public class NextPointerBinaryTree {

	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public static void connect(TreeLinkNode root) {

		while (root != null) {

			TreeLinkNode q = root;

			while (q != null) {

				if (q.left != null) {
					if (q.right != null) {
						q.left.next = q.right;
					} else {
						q.left.next = getNextNode(q);
					}
				}

				if (q.right != null) {
					q.right.next = getNextNode(q);
				}
				q = q.next;

			}

			if (root.left != null) {
				root = root.left;
			} else if (root.right != null) {
				root = root.right;
			} else {
				root = getNextNode(root);
			}

		}

	}

	public static TreeLinkNode getNextNode(TreeLinkNode node) {

		node = node.next;

		while (node != null) {
			if (node.left != null) {
				return node.left;
			}
			if (node.right != null) {
				return node.right;
			}
			node = node.next;
		}

		return null;

	}

	public static void main(String[] args) {
		
		TreeLinkNode a = new TreeLinkNode(1);
		TreeLinkNode b = new TreeLinkNode(2);
		TreeLinkNode c = new TreeLinkNode(3);
		TreeLinkNode d = new TreeLinkNode(4);
		TreeLinkNode e = new TreeLinkNode(5);
		TreeLinkNode f = new TreeLinkNode(6);
		TreeLinkNode g = new TreeLinkNode(7);
		
		a.left = b;
		a.right = e;
		b.left = c;
		b.right = d;
		e.left = f;
		e.right = g;
		
		connect(a);
		

	}

}
