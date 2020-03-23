package Fully_Paren;

import java.util.ArrayList;
import java.util.Scanner;

public class Fully_Paren {


	@SuppressWarnings("resource")
	public static void main(String [] args){
		Scanner sc=new Scanner(System.in);
		ArrayList<String> lst=new ArrayList<String>();


		int [] vlist=new int[26];

		for(int i=0;i<26;i++){
			vlist[i]=0;
		}

		Expression expression=new Expression();


		while(true){
			System.out.print("Enter expression values(Press ! to stop program): ");
			String s=sc.next();
			s=s.toUpperCase();

			if(s.equals("!")){
				break;
			}

			expression.setExpression(s);
			int val=expression.eval(vlist);

			if(val==-1){
				lst.add(s);
			}
		}

		for(int i=0;i<lst.size();i++){
			System.out.println(lst.get(i)+" is invalid");
		}

		System.out.println("\nThe final symbol table is:\n");

		for(int i=0;i<26;i++){
			if(vlist[i]!=0){
				System.out.println((char)('A'+i)+"\t"+vlist[i]);
			}
		}
	}
}