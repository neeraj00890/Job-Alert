package common.util;

class Node {
	int data;
	Node next;

	Node(int value) {
		this.data = value;
	}

	public String toString() {
		return "" + this.data;
	}
}

class Stack {
	int size = 0;
	Node head = null;
	Node tail = null;

	void push(int value) {
		if (size == 0) {
			head = new Node(value);
			tail = head;
			size++;
		} else {
			Node newNode = new Node(value);
			newNode.next = head;
			head = newNode;
			size++;
		}
	}

	Node pop() {
		if (head == null) {
			return null;
		}
		Node temp = head;
		head = head.next;
		--size;
		return temp;

	}

	int size() {
		return this.size;
	}

	boolean isEmpty() {
		return this.size == 0;
	}

	void print() {
		Node current = head;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}



class Queue {
	Node front;
	Node rear;
	int size = 0;

	void enque(int value) {
		Node node = new Node(value);
		if (size == 0) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
		size++;
	}

	Node deque() {
		Node temp = front;
		front = front.next;
		size--;
		return temp;
	}
	
	int size() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}

	void print() {
		Node current = front;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}


class DoublyLinkListNode {
	DoublyLinkListNode next;
	DoublyLinkListNode prev;
	int data;
	
	public String toString() {
		if(prev!=null && next !=null) {
			return "Prev:" + prev.data+ " Current: "+ this.data+ "Next: "+next.data;
		}
		if(prev!=null) {
			return "Prev:" + prev.data+ " Current: "+ this.data;
		}
		if(next!=null) {
			return "Next:" + next.data+ " Current: "+ this.data;
		}
		
		if(prev == null && next == null) {
			return "Current: "+ this.data;
		}
		
		return "Bank";
		
	}
	
	DoublyLinkListNode(int val) {
		this.data =  val;
	}
	
	DoublyLinkListNode() {
	}
}



class DLinkList {
	int size;
	DoublyLinkListNode head;
	DoublyLinkListNode tail; 
	void insert(int value) {
		DoublyLinkListNode node = new DoublyLinkListNode(value);
		if(size == 0) {
			head = node;
			tail = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	void print() {
		DoublyLinkListNode current = head;
		while(current!=null) {
			System.out.println("Value: "+current);
			current = current.next;
		}
	}
	
	void deleteAt(int index) {
		if(index > size -1) throw new RuntimeException("Invalid Index");
		int counter = 0;
		DoublyLinkListNode current = head;
		
		while(current != null) {
			if(counter == index) {
				DoublyLinkListNode prev = current.prev;
				DoublyLinkListNode next = current.next; 
				prev.next = next;
				next.prev = prev;
			}
			current = current.next;
			counter++;
		}
		--size;
	}
	
	void deleteFirst() {
		head = head.next;
		--size;
	}
	
	void deleteEnd() {
		tail.prev.next = null;
		--size;
	}
}
public class CommonUtil {
	public static void main(String... args) {
//		Stack stack = new Stack();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);
//		stack.push(5);
//		stack.push(6);
//		stack.print();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		stack.pop();
//		System.out.println(stack.isEmpty());
//
//		Queue q = new Queue();
//		q.enque(1);
//		q.enque(2);
//		q.enque(3);
//		q.enque(4);
//		q.enque(5);
//		q.enque(6);
//		q.deque();

//		q.print();
//		System.out.println(q.size());
		
		DLinkList l = new DLinkList();
		l.insert(6);
		l.insert(8);
		l.insert(3);
		l.insert(7);
		l.insert(90);
		l.print();
		
		l.deleteAt(100);
		System.out.println("After Delete");
		l.print();
		l.deleteEnd();
		System.out.println("After Delete First");
		l.print();
	}
}
