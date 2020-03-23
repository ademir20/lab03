package Exercises;
import java.util.Scanner;

import queues.DoublyLinkedQueue;
import stacks.LinkedListStack;

public class isPalindrome  {


		public static void scan() {
			
			String s;
			
			System.out.println("Input value: (Press Enter twice to stop program):");
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			s = sc.nextLine();
			
			if(s.equals("")) {
				System.exit(0);
			}
			
			printConfirmedPalindrome(s);
			scan();
		}
		
		public static void printConfirmedPalindrome(String s) {
			if(isPalindrome(s)) {
				System.out.println("Palindrome");
			}else {
				System.out.println("Not a Palindrome");
			}
		}
		
		public static boolean isPalindrome(String s) {
			s = s.toLowerCase().replaceAll("[^a-zA-Z]","");

			DoublyLinkedQueue<Character> queue = new DoublyLinkedQueue<>();
			LinkedListStack<Character> stack = new LinkedListStack<>();

			for(int i = 0; i < s.length(); i++) {
				queue.enqueue(s.charAt(i));
				stack.push(s.charAt(i));
			}

			return isPalindrome(queue, stack);
		}

		public static boolean isPalindrome(DoublyLinkedQueue<Character> q , LinkedListStack<Character> s) {

			if(q.size() == 0 && s.size() == 0) {
				return true;
			}else if(q.dequeue().equals(s.pop())) {
				return isPalindrome(q, s);
			}
			return false;
		}

		public static void main(String[] args) {
			scan();
		}
	}