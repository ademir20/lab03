package Exercises;


public class SinglyLinkedQueue <E> implements queues.Queue<E> {


	private Node header, tail;

	private int currentSize; // Current size of the queue -Ademir



	private class Node {

		private E element;

		private Node next;

		// Constructor -Ademir

		public Node(E element, Node next) {

			this.element = element;

			this.next = next;

		}

	}


	public SinglyLinkedQueue(){

		header = null;

		tail = null;

		currentSize = 0;

	}

	public boolean isEmpty() {

		return currentSize == 0;

	}

	// adds an element to the tail-Ademir

	public void enqueue(E element) {

		Node newNode = new Node(element, null);


		if (isEmpty()) {

			header = newNode;

			tail = newNode;

		} else {

		

			tail.next = newNode;

			tail = newNode;

		}


		currentSize++;

	}



	public E dequeue() {

		if (header != null) {

	

			E element = header.element;

			

			header = header.next;

			// If head isnull, setting tail to null -Ademir

			if (header == null) {

				tail = null;

			}

			// Update Size -Ademir

			currentSize--;

			// Returning removed element -Ademir

			return element;

		}

		return null;

	}

	// Returns the first item on the queue -Ademir

	public E front() {

		if (isEmpty()) {



			return null;

		}

		return header.element;

	}

	// Returns the current size -Ademir

	public int size() {

		return currentSize;

	}

	public String toString() {

		String str = "[";

		// Sperating by commas (,) -Ademir

		for (Node n = header; n != null; n = n.next) {

			str += n.element;

			if (n.next != null) {

				str += ", ";

			}

		}

		str += "]";

		return str;

	}

	

	public static void main(String[] args) {

		// Creating an integer queue, adding numbers from 1 to 9 -Ademir

		SinglyLinkedQueue<Integer> q = new SinglyLinkedQueue<Integer>();

		for (int i = 1; i < 10; i++) {

			q.enqueue(i);

			// Printing queue after each enqueue operation -Ademir

			System.out.println(q);

		}


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