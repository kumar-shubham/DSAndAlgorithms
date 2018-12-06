package com.my.tree;

public class AVLTree {

	public Node root;

	public static int height(Node n) {
		return n == null ? 0 : n.height;
	}

	public static int max(int a, int b) {
		return a >= b ? a : b;
	}
	
	public static int size(Node n) {
		return n == null ? 0 : n.size;
	}

	public static Node rightRotate(Node a) {
		Node b = a.left;
		Node t1 = b.right;

		b.right = a;
		a.left = t1;

		a.height = max(height(a.left), height(a.right));
		b.height = max(height(b.left), height(b.right));

		return b;
	}

	public static Node leftRotate(Node a) {
		Node b = a.right;
		Node t1 = b.left;

		b.left = a;
		a.right = t1;

		a.height = max(height(a.left), height(a.right));
		b.height = max(height(b.left), height(b.right));

		return b;
	}

	public static int getBalance(Node n) {
		return n == null ? 0 : (height(n.left) - height(n.right));
	}

	private static Node insert(Node node, int key, int count, int index) {
		
		//System.out.println("inserting: " + key + " with count: " + count);
		/* 1. Perform the normal BST insertion */
		if (node == null) {
			return new Node(key, count, index);
		}

		if (key < node.key) {
			node.left = insert(node.left, key, count+size(node.right)+1, index);
		} else if (key > node.key) {
			node.right = insert(node.right, key, count, index);
		} else {
			return node; // duplication not allowed
		}

		/* 2. Update height of this ancestor node */
		node.height = 1 + max(height(node.left), height(node.right));
		node.size = 1 + size(node.left) + size(node.right);
		/*
		 * 3. Get the balance factor of this ancestor node to check whether this node
		 * became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && key < node.left.key) {
			return rightRotate(node);
		}

		// Right Right Case
		if (balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}

		// Left Right Case
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;

	}

	// A utility function to print preorder traversal
	// of the tree.
	// The function also prints height of every node
	void preOrder(Node node, int[] count) {
		if (node != null) {
			System.out.print(node + " ");
			count[node.index] = node.count;
			preOrder(node.left, count);
			preOrder(node.right, count);
		}
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		int[] arr = {7,2,5,9,3,4,6};
		
		int[] count = new int[arr.length];
		
		for(int i = arr.length-1; i>=0; i--) {
			tree.root = AVLTree.insert(tree.root, arr[i], 0, i);
		}

		/*
		 * The constructed AVL Tree would be 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root, count);
		System.out.println();
		for(int i = 0; i< count.length; i++) {
			System.out.print(count[i] + " ");
		}
	}

}

class Node {

	int key;
	int count;
	int height;
	int size;
	int index;
	Node left;
	Node right;

	Node(int k, int c, int i) {
		key = k;
		height = 1;
		size = 1;
		index = i;
		count = c;
	}
	
	public String toString(){
		return "{key: " + key + ", count: " + count + ", height: " + height + "}";
	}

}
