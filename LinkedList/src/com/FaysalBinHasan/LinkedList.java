package com.FaysalBinHasan;

public class LinkedList {
	public Node head;
	public int size;

	public LinkedList(Object[] a) {
		// TO DOpublic LinkedList(Object [] a){
		head = new Node(a[0], null);
		Node tail = head;
		for (int i = 1; i < a.length; i++) {
			Node n = new Node(a[i], null);
			tail.next = n;
			tail = tail.next;
		}
		size = a.length;
		// TO DO

	}

	/*
	 * Second Constructor: Sets the value of head. head will refer to the given
	 * LinkedList
	 */
	public LinkedList(Node h) {
		// TO DO
		head = h;
		size++;
	}

	/* Counts the number of Nodes in the list */
	public int countNode() {
		// TO DOpublic static int count(Node head) {
		int count = 0;
		System.out.println("Print count");
		for (Node n = head; n != null; n = n.next)
			count++;

		return count;
		// please remove this line!
	}

	/* prints the elements in the list */
	public void printList() {

		// TO DO
		for (Node h = head; h != null; h = h.next) {
			System.out.println(h.element);
		}

	}

	// returns the reference of the Node at the given index. For invalid index
	// return null.
	public Node nodeAt(int idx) {
		// TO DOpublic static Node nodeAt(Node head, int size, int index) { // invalid
		// index.
		int k = 0;
		for (Node h = head; h != null; h = h.next) {
			if (k == idx) {
				return h;
			}
			k++;
			// please remove this line!
		}
		return null;
	}

	// returns the element of the Node at the given index. For invalid idx return
	// null.
	public Object get(int idx) {
		// TO DO/**
		if (idx < 0) {
			return null;
		}
		// invalid index.
		int i = 0;
		System.out.println("Print get");
		for (Node n = head; n != null; n = n.next) {
			if (i == idx)
				return n.element;
			else
				i++;
		}
		return null;// index out of bounds. // please remove this line!
	}

	/*
	 * updates the element of the Node at the given index. Returns the old element
	 * that was replaced. For invalid index return null. parameter: index, new
	 * element
	 */
	public Object set(int idx, Object newelem) {
		// TO DO
		System.out.println("Print set");
		Node node = nodeAt(idx);
		if (node == null) {
			return null;
		} else {
			Object oldElement = node.element;
			node.element = newelem;
			return oldElement;// please remove this line!
		}
	}

	/*
	 * returns the index of the Node containing the given element. if the element
	 * does not exist in the List, return -1.
	 */
	public int indexOf(Object elem) {
		// TO DO
		int i = 0;
		for (Node n = head; n != null; n = n.next, i++) {
			if (n.element.equals(elem)) {
				return i;
			}
			// return -1;
		} // please remove this line!
		return -1;
	}

	// returns true if the element exists in the List, return false otherwise.
	public boolean contains(Object elem) {
		// TO DO
		int i = 0;
		for (Node n = head; n != null; n = n.next, i = i++) {
			if (n.element.equals(elem)) {
				return true;
			} // please remove this line!
		}
		return false;
	}

	// Makes a duplicate copy of the given List. Returns the reference of the
	// duplicate list.
	public Node copyList() {
		// TO DO
		Node h = null;
		Node t = null;
		System.out.println("Copying List");
		for (Node n = head; n != null; n = n.next) {
			Node newNode = new Node(n.element, null);
			if (h == null) {
				h = newNode;
				t = newNode;
			} else {
				t.next = newNode;
				t = newNode;
			}
		}
		return h; // please remove this line!
	}

	// Makes a reversed copy of the given List. Returns the head reference of the
	// reversed list.
	public Node reverseList() {
		// TO DO
		Node newHead = null;
		Node n = head;
		System.out.println("Reversing List");
		while (n != null) {
			Node nextNode = n.next;
			n.next = newHead;
			newHead = n;
			n = nextNode;
		}
		return newHead; // please remove this line!
	}

	/*
	 * inserts Node containing the given element at the given index Check validity
	 * of index.
	 */
	public void insert(Object elem, int idx) {
		// TO DO
		// if(idx<0||idx>size)
		// {
		// throw new IndexOutOfBoundsException();
		// }
		System.out.println("Printing Insert");
		Node newNode = new Node(elem, null);
		if (idx == 0) {
			newNode.next = head;
			head = newNode;
		} else {
			Node pred = nodeAt(idx - 1);
			newNode.next = pred.next;
			pred.next = newNode;
		}
	}

	/*
	 * removes Node at the given index. returns element of the removed node. Check
	 * validity of index. return null if index is invalid.
	 */
	public Object remove(int index) {
		// TO DO
		Node removedNode = null;
		if (index == 0) {
			removedNode = head;
			head = head.next; // please remove this line!
		} else {
			Node pred = nodeAt(index - 1);
			removedNode = pred.next;
			pred.next = removedNode.next;
		}
		removedNode.element = null;
		removedNode.next = null;
		return removedNode;
	}

	// Rotates the list to the left by 1 position.
	public void rotateLeft() {
		// TO DO
		Node oldHead = head;
		head = head.next;
		Node tail = head;
		System.out.println("Rotate left");
		while (tail.next != null) {
			tail = tail.next;
		}
		tail.next = oldHead;
		oldHead.next = null;
	}

	// Rotates the list to the right by 1 position.
	public void rotateRight() {
		// TO DO
		Node p = null;
		Node q = head;
		System.out.println("Rotate right");
		while (q.next != null) {
			p = q;
			q = q.next;
		}
		q.next = head;
		head = q;
		p.next = null;
	}
}
