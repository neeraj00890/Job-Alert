package common.util;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "" + this.data;
	}
}

class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;

	BinaryNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "" + this.data;
	}
}

class MyList {
	int size;
	Node head;
	Node tail;

	void insert(int data) {
		if (size == 0) {
			head = new Node(data);
			tail = head;
		} else {
			Node temp = new Node(data);
			tail.next = temp;
			tail = temp;
		}
		++size;
	}

	void print() {
		Node current = head;
		while (current != null) {
			System.out.println(current);
			current = current.next;
		}
	}

	Node elementAt(int index) {
		Node current = head;
		int count = 0;
		while (current != null) {
			if (count == index) {
				break;
			}
			current = current.next;
			count++;
		}

		return current;
	}

}

public class ListToBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyList m = new MyList();
		m.insert(1);
		m.insert(2);
		m.insert(3);
		m.insert(4);
		m.insert(5);
		m.insert(6);
		// inOrder(convertListToBinaryTree(m));
		
		for (int i = 0; i < m.size; i++) {

		}

		// 4251631
	}

	static void inOrder(BinaryNode root, MyList m) {
		if (root == null)
			return;
		inOrder(root.left, m);
		System.out.print(root.data + " ");
		inOrder(root.right, m);
	}

	static BinaryNode convertListToBinaryTree(MyList m) {
		int index = 0;
		BinaryNode root = createTree(m.head, ++index, m);
		return root;
	}

	static BinaryNode createTree(Node node, int index, MyList m) {
		if (node == null)
			return null;
		BinaryNode root = new BinaryNode(node.data);
		root.left = createTree(m.elementAt(2 * index - 1), ++index, m);
		root.right = createTree(m.elementAt(2 * index), ++index, m);
		return root;
	}

}
