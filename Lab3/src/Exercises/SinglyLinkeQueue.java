package Exercises;
public class SinglyLinkeQueue <E> {

	// references to head and tail nodes

	private Node head, tail;

	private int size; // current size of the queue

	// private inner class representing a Node in linked list representation of

	// the queue

	private class Node {

		private E item;

		private Node next;

		// constructor initializing item and next node

		public Node(E item, Node next) {

			this.item = item;

			this.next = next;

		}

	}

	// constructor, creates an empty queue

	public SinglyLinkeQueue(){

		head = null;

		tail = null;

		size = 0;

	}

	// returns true if queue is empty (runs in O(1) time)

	public boolean isEmpty() {

		return size == 0;

	}

	// adds an element to the tail (runs in O(1) time)

	public void enqueue(E item) {

		// creating a new node

		Node newNode = new Node(item, null);

		// if queue is currently empty, adding as both head and tail

		if (isEmpty()) {

			head = newNode;

			tail = newNode;

		} else {

			// appending to tail and updating tail

			tail.next = newNode;

			tail = newNode;

		}

		// updating size

		size++;

	}

	// removes and returns the front value, will return null if queue is empty (runs in O(1) time)

	public E dequeue() {

		if (head != null) {

			// getting item on front

			E item = head.item;

			// updating head

			head = head.next;

			// if head became null, setting tail to null

			if (head == null) {

				tail = null;

			}

			// updating size

			size--;

			// returning removed value

			return item;

		}

		return null;// empty

	}

	// returns the first item on the queue (runs in O(1) time)

	public E front() {

		if (isEmpty()) {

			// empty

			return null;

		}

		return head.item;

	}

	// returns the current size of the queue (runs in O(1) time)

	public int size() {

		return size;

	}

	// returns a String representation of the queue elements, for testing

	// purposes (runs in O(n) time)

	public String toString() {

		String str = "[";

		// appending contents of queue into str, separated by ", "

		for (Node n = head; n != null; n = n.next) {

			str += n.item;

			if (n.next != null) {

				str += ", ";

			}

		}

		str += "]";

		return str;

	}

}