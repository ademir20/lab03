package Exercises;


public class SinglyLinkedQueue <E> implements queues.Queue<E> {

	// references to head and tail nodes

	private Node header, tail;

	private int currentSize; // current size of the queue

	// private inner class representing a Node in linked list representation of

	// the queue

	private class Node {

		private E element;

		private Node next;

		// constructor initializing item and next node

		public Node(E element, Node next) {

			this.element = element;

			this.next = next;

		}

	}

	// constructor, creates an empty queue

	public SinglyLinkedQueue(){

		header = null;

		tail = null;

		currentSize = 0;

	}

	// returns true if queue is empty (runs in O(1) time)

	public boolean isEmpty() {

		return currentSize == 0;

	}

	// adds an element to the tail (runs in O(1) time)

	public void enqueue(E element) {

		// creating a new node

		Node newNode = new Node(element, null);

		// if queue is currently empty, adding as both head and tail

		if (isEmpty()) {

			header = newNode;

			tail = newNode;

		} else {

			// appending to tail and updating tail

			tail.next = newNode;

			tail = newNode;

		}

		// updating size

		currentSize++;

	}

	// removes and returns the front value, will return null if queue is empty (runs in O(1) time)

	public E dequeue() {

		if (header != null) {

			// getting item on front

			E element = header.element;

			// updating head

			header = header.next;

			// if head became null, setting tail to null

			if (header == null) {

				tail = null;

			}

			// updating size

			currentSize--;

			// returning removed value

			return element;

		}

		return null;// empty

	}

	// returns the first item on the queue (runs in O(1) time)

	public E front() {

		if (isEmpty()) {

			// empty

			return null;

		}

		return header.element;

	}

	// returns the current size of the queue (runs in O(1) time)

	public int size() {

		return currentSize;

	}

	// returns a String representation of the queue elements, for testing

	// purposes (runs in O(n) time)

	public String toString() {

		String str = "[";

		// appending contents of queue into str, separated by ", "

		for (Node n = header; n != null; n = n.next) {

			str += n.element;

			if (n.next != null) {

				str += ", ";

			}

		}

		str += "]";

		return str;

	}

	// a simple main method for testing. remove if you don't need.

	public static void main(String[] args) {

		// creating an integer queue, adding numbers from 1 to 9

		SinglyLinkedQueue<Integer> q = new SinglyLinkedQueue<Integer>();

		for (int i = 1; i < 10; i++) {

			q.enqueue(i);

			// printing queue after each enqueue operation

			System.out.println(q);

		}

		// looping and calling dequeue method, printing the queue until queue is

		// empty

		while (!q.isEmpty()) {

			q.dequeue();

			System.out.println(q);

		}

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
		@SuppressWarnings("unchecked")
		@Override
		public E[] toArray() {
			// TODO Auto-generated method stub
			E[] theArray = (E[]) new Object[size()];
			if(currentSize>0) {
				
				int i = 0;
				Node transfer = header;
				while(i<currentSize) {
					theArray[i++] = transfer.element;
					transfer = transfer.next;
				}
			}
			return theArray;
		}


}