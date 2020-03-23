package Exercises;

import queues.Deque;

public class CircularDoublyLinkedDeque<E> implements Deque<E> {

	static class Elem<E> {

		final E value;

		Elem<E> previous;
		Elem<E> next;

		private Elem(E value, Elem<E> previous, Elem<E> next) {
			this.value = value;
			this.previous = previous;
			this.next = next;
		}
	}

	private Elem<E> head;
	private int size;

	public CircularDoublyLinkedDeque() {
		// dummy node
		head = new Elem<E>(null, null, null);
		head.next = head;
		head.previous = head;
		size = 0;
	}

	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		head = new Elem<E>(null, null, null);
		head.next = head;
		head.previous = head;
		size = 0;
	}
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		E result[] = (E []) new Object[size];
		int i = 0;
		Elem<E> current;
		current = head.next;
		while (i < size) {
			result[i++] = current.value;
			current = current.next;
		}
		return result;
	}

	// Helper method. Adds an element to the list after the specified -Ademir

	private void addAfter(Elem<E> before, E obj) {
		Elem<E> after = before.next;

		before.next = new Elem<E>(obj, before, after);
		after.previous = before.next;

		size++;
	}

	// Helper method. Removes the specified node.
	private void remove(Elem<E> current) {
		Elem<E> before = current.previous, after = current.next;
		before.next = after;
		after.previous = before;
		size--;
	}

	public String toString() {

		StringBuffer str = new StringBuffer("{");
		Elem<E> p = head.next;

		while (p != head) {
			str.append(p.value);
			if (p.next != head) {
				str.append(",");
			}
			p = p.next;
		}
		str.append("}");
		return str.toString();
	}
	//Small Test -Ademir
	public static void main(String[] args) {
		CircularDoublyLinkedDeque<Integer> list = new CircularDoublyLinkedDeque<>();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list);
	}

	@Override
	public E getFirst() {
		if (size == 0) {
			return null;
		}
		return head.next.value;
	}

	@Override
	public E getLast() {
		if (size == 0) {
			return null;
		}
		return head.previous.value;
	}

	@Override
	public void addFirst(E element) throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		addAfter(head, element);        
	}

	@Override
	public void addLast(E element) throws IllegalArgumentException {
		if (element == null) {
			throw new IllegalArgumentException();
		}
		addAfter(head.previous, element);
	}

	@Override
	public E removeFirst() {
		if (size == 0) {
			return null;
		}
		Elem<E> x = head.next;
		remove(head.next);
		return x.value;
	}

	@Override
	public E removeLast() {
		if (size == 0) {
			return null;
		}
		Elem<E> x = head.previous;
		remove(head.previous);
		return x.value;
	}
}