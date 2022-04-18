package common.util;

import java.util.Scanner;

class BinaryNode {
	BinaryNode left;
	BinaryNode right;
	int data;
	BinaryNode(int val) {
		this.data = val;
	}
	
	public String toString() {
		return ""+this.data;
	}
}

public class BinaryTree {
	BinaryNode head;
	int size = 0;
	
	public static void main(String...args) {
		BinaryNode root = createTree();
		inOrder(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		postOrder(root);
	}
	
	
	static BinaryNode createTree() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter data:");
		int data = in.nextInt();
		if(data == -1) return null;
		BinaryNode node = new BinaryNode(data);
		System.out.println("Enter left for: "+node);
		node.left = createTree();
		System.out.println("Enter Right for: "+node);
		node.right = createTree();
		return node;
	}
	
	static  void inOrder(BinaryNode root) {
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	 static void preOrder(BinaryNode root) {
		if(root == null) return;
		System.out.print(root.data+" ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	static void postOrder(BinaryNode root) {
		if(root == null) return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
}
