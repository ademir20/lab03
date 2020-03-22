package Exercises;
import queues.DoublyLinkedQueue;
import stacks.LinkedListStack;

public class Palidnromes  {


	public static boolean isPalindrome(String s) {
		s.toLowerCase().trim();
		queues.DoublyLinkedQueue<Character> queue = new DoublyLinkedQueue<>();
		stacks.LinkedListStack<Character> stack = new LinkedListStack<>();

		for( int i =0 ; i < s.length(); i++) {
			queue.enqueue(s.charAt(i));
			stack.push(s.charAt(i));

		}
		System.out.println();

		return palindormeHelper (queue , stack);
	}

	public static boolean palindormeHelper (DoublyLinkedQueue <Character>q, LinkedListStack <Character> s) {


		if(q.size() == 0 && s.size() == 0) {


			return true;
		}
		else if (q.dequeue().equals(s.pop())) {
			return palindormeHelper (q,s);
		}

		return false;
	}
	public static void main (String[] args) {
		String s = "AMOR";
		System.out.println(isPalindrome(s));
		s = "Race Car";
		System.out.println(isPalindrome(s));
		s = "civic";
		System.out.println(isPalindrome(s));
		
	}
	
}