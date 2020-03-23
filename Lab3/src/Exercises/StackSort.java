package Exercises;

import java.util.Scanner;

import stacks.LinkedListStack;

public class StackSort {
	
	public static LinkedListStack<Double> FirstStack = new LinkedListStack<Double>();
	public static LinkedListStack<Double> SecondStack = new LinkedListStack<Double>();
	
	public static void scan() {
		Double input;
		Scanner sc = new Scanner(System.in);
		String s;
		
		System.out.println("Input value: (Press Enter twice to stop program):");
		s = sc.nextLine(); 

		if(s.equals("")) {
			printSets();
			sc.close();
			System.exit(0);
		}

		if(isValid(s)) {
			input = new Double(s);
			
			if(FirstStack.size() == 0 || SecondStack.size() ==0) {
				populate(input);
			}
			addToStack(input);
		}else {
			System.out.println("\n");
			System.out.println("Please input a valid number \n");
		}
		scan();

	}

	public static void populate(Double input) {
		if(FirstStack.size() == 0) {
			FirstStack.push(input);
			scan();
		}
		if(input<FirstStack.top()) {
			SecondStack.push(FirstStack.pop());
			FirstStack.push(input);
			scan();
		}else {
			SecondStack.push(input);
			scan();
		}
	}
	
	public static void addToStack(Double input) {
		
		if(input < FirstStack.top()) {
			while(input <FirstStack.top()) {
				SecondStack.push(FirstStack.pop());
				if(FirstStack.size() == 0) {
					break;
				}
			}
			FirstStack.push(input);
		}else if(input > SecondStack.top()) {
			while(input > SecondStack.top()) {
				FirstStack.push(SecondStack.pop());
				if(SecondStack.size() == 0) {
					break;
				}
			}
			SecondStack.push(input);
		}else if(input.equals(FirstStack.top())) {
			FirstStack.push(input);
		}else if(input.equals(SecondStack.top())) {
			SecondStack.push(input);
		}else if(input > FirstStack.top() && input < SecondStack.top()) {
			FirstStack.push(input);
		}else if(input > FirstStack.top() && input > SecondStack.top()) {
			SecondStack.push(input);
		}
	}
	
	public static boolean isValid(String s) {

		try {
			double test = Double.parseDouble(s);
		}catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static void printSets() {
		LinkedListStack<Double> testStack = new LinkedListStack<Double>();
		while(FirstStack.size()>0) {
			testStack.push(FirstStack.pop());
		}
		while(testStack.size()> 0) {
			System.out.println(testStack.pop());
		}
		while(SecondStack.size()>0) {
			System.out.println(SecondStack.pop());
		}
	}
	
	
	public static void main(String[] arg) {
		scan();	
	}
}