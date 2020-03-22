package Exercises;
import queues.Deque;

public class CircularDoublyLinkedDeque<E> implements Deque<E> {

      // private inner class representing a Node in linked list representation of

      // the queue

      private class Node {

            E item;

            Node next;

            Node prev;

            // constructor initializing item

            public Node(E item) {

                  this.item = item;

                  next = null;

                  prev = null;

            }

      }

      // pointer to the dummy head node

      private Node head;

      // variable to store current size

      private int size;

      // constructor initializing queue

      public CircularDoublyLinkedDeque() {

            // initializing dummy head node

            head = new Node(null);

            // setting head as both prev and next of head

            head.next = head;

            head.prev = head;

            // size is 0

            size = 0;

      }

      // returns the size

      public int size() {

            return size;

      }

      // returns true if deque is empty

      public boolean isEmpty() {

            return size == 0;

      }

      // clears the contents of the deque

      public void clear() {

            head = new Node(null);

            // setting head as both prev and next of head

            head.next = head;

            head.prev = head;

            size = 0;

      }

      // returns first element without removing

      public E getFirst() {

            // returning null if empty, you may throw an exception if you prefer

            // that.

            if (isEmpty()) {

                  return null;

            }

            // otherwise returning item of first node (head.next is the first)

            return head.next.item;

      }

      // returns last element without removing

      public E getLast() {

            // returning null if empty, you may throw an exception if you prefer

            // that.

            if (isEmpty()) {

                  return null;

            }

            // otherwise returning item of last node (head.prev is the last)

            return head.prev.item;

      }

      // adds an element to the first

      public void addFirst(E element) throws IllegalArgumentException {

            // throwing exception if element is null

            if (element == null) {

                  throw new IllegalArgumentException();

            }

            // creating a new node

            Node node = new Node(element);

            // checking if deque is empty

            if (isEmpty()) {

                  // setting head as next of node

                  node.next = head;

                  // setting head as prev of node

                  node.prev = head;

                  // setting node as next of head

                  head.next = node;

                  // setting node as prev of head

                  head.prev = node;

            } else {

                  // otherwise setting current first node as next of node

                  node.next = head.next;

                  // setting head as prev of node

                  node.prev = head;

                  // setting node as prev of current first

                  head.next.prev = node;

                  // setting node as new first

                  head.next = node;

            }

            // updating size

            size++;

      }

      // adds an element to the last

      public void addLast(E element) throws IllegalArgumentException {

            // throwing exception if element is null

            if (element == null) {

                  throw new IllegalArgumentException();

            }

            Node node = new Node(element);

            // if deque is empty, adding as the first and last in the same way as

            // previous method

            if (isEmpty()) {

                  node.next = head;

                  node.prev = head;

                  head.next = node;

                  head.prev = node;

            } else {

                  // otherwise adding node between head.prev and head

                  Node currLast = head.prev;

                  node.next = head;

                  node.prev = currLast;

                  currLast.next = node;

                  head.prev = node;

            }

            size++;

      }

      // removes and returns the first element

      public E removeFirst() {

            // returning null if empty, you may throw an exception if you prefer

            // that.

            if (isEmpty()) {

                  return null;

            }

            // getting first node

            Node first = head.next;

            // connecting previous and next nodes of first

            first.prev.next = first.next;

            first.next.prev = first.prev;

            // updating size

            size--;

            // returning removed element

            return first.item;

      }

      // removes and returns the last element

      public E removeLast() {

            // returning null if empty, you may throw an exception if you prefer

            // that.

            if (isEmpty()) {

                  return null;

            }

            // getting last node and connecting previous and next nodes of last

            Node last = head.prev;

            last.prev.next = last.next;

            last.next.prev = last.prev;

            size--;

            return last.item;

      }

      //returns queue elements as an array

      public E[] toArray() {

            //creating array of enough size

            @SuppressWarnings("unchecked")

            E[] arr = (E[]) new Object[size];

            //getting reference to first node

            Node node = head.next;

            //adding each item to the array and returning it

            for (int i = 0; i < size; i++) {

                  arr[i] = node.item;

                  node = node.next;

            }

            return arr;

      }

}