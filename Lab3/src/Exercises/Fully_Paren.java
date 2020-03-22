package Exercises;
import java.util.Scanner;

import java.util.*;

public class Fully_Paren {

	@SuppressWarnings("resource")
	public static void main(String[] args)

	{

		Scanner readin = new Scanner(System.in);

		Map< Character,Integer> symb =new HashMap< Character,Integer>();

		while(1>0)

		{

			String exp = readin.nextLine();

			int length = exp.length();

			int valexp=1;

			if(length==0)

				break;

			if(exp.charAt(1)=='=')

			{

				symb.put(exp.charAt(0), new Integer(Integer.parseInt(exp.substring(2))));

			}

			else

			{

				Stack<Integer> oprand_stk = new Stack<Integer>();

				Stack<Character> operator_stk = new Stack<Character>();

				Stack<Character> parenth_stk = new Stack<Character>();

				int i;

				for(i=2;i<length;i+=1)

				{

					if(Character.isUpperCase(exp.charAt(i)))

					{

						oprand_stk.push(symb.get(exp.charAt(i)));

					}

					else if(Character.isDigit(exp.charAt(i)))

					{

						oprand_stk.push(Character.getNumericValue(exp.charAt(i)));

					}

					else if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*' || exp.charAt(i)=='/')

					{

						operator_stk.push(exp.charAt(i));

					}

					else if(exp.charAt(i)=='(' || exp.charAt(i)=='{' || exp.charAt(i)=='[')

					{

						parenth_stk.push(exp.charAt(i));

					}

					else

					{

						if(parenth_stk.size()==0)

						{

							//System.out.println(exp+" is invalid");

							valexp=0;

							break;

						}

						if(exp.charAt(i)==')')

						{

							char rpth=parenth_stk.pop();

							if(rpth!='(')

							{

								//System.out.println(exp+" is invalid");

								valexp=0;

								break;

							}

							else

							{

								Integer v2=oprand_stk.pop();

								Integer v1=oprand_stk.pop();

								Character o=operator_stk.pop();

								Integer v=0;

								if(o=='+')

								{

									v=v1+v2;

								}

								else if(o=='-')

								{

									v=v1-v2;

								}

								else if(o=='*')

								{

									v=v1*v2;

								}

								else if(o=='/')

								{

									v=v1/v2;

								}

								oprand_stk.push(v);

							}

						}

						else if(exp.charAt(i)==']')

						{

							char rpth=parenth_stk.pop();

							if(rpth!='[')

							{

								//System.out.println(exp+" is invalid");

								valexp=0;

								break;

							}

							else

							{

								Integer v2=oprand_stk.pop();

								Integer v1=oprand_stk.pop();

								Character o=operator_stk.pop();

								Integer v=0;

								if(o=='+')

								{

									v=v1+v2;

								}

								else if(o=='-')

								{

									v=v1-v2;

								}

								else if(o=='*')

								{

									v=v1*v2;

								}

								else if(o=='/')

								{

									v=v1/v2;

								}

								oprand_stk.push(v);

							}

						}

						else if(exp.charAt(i)=='}')

						{

							char rpth=parenth_stk.pop();

							if(rpth!='{')

							{

								//System.out.println(exp+" is invalid");

								valexp=0;

								break;

							}

							else

							{

								Integer v2=oprand_stk.pop();

								Integer v1=oprand_stk.pop();

								Character o=operator_stk.pop();

								Integer v=0;

								if(o=='+')

								{

									v=v1+v2;

								}

								else if(o=='-')

								{

									v=v1-v2;

								}

								else if(o=='*')

								{

									v=v1*v2;

								}

								else if(o=='/')

								{

									v=v1/v2;

								}

								oprand_stk.push(v);

							}

						}

						else

						{

							//System.out.println(exp+" is invalid");

							valexp=0;

							break;

						}

					}

				}

				if(operator_stk.size()==0 && parenth_stk.size()==0 && oprand_stk.size()==1 && valexp==1)

				{

					symb.put(exp.charAt(0), new Integer(oprand_stk.pop()));

				}

				// the below else if will be good for evaluating parenthesis less expressions



				else if(operator_stk.size()>0 && parenth_stk.size()==0 && oprand_stk.size()>1 && valexp==1)

				{

					while(oprand_stk.size()>1)

					{

						if(oprand_stk.size()>1 && operator_stk.size()>0)

						{

							Integer v1=oprand_stk.pop();

							Integer v2=oprand_stk.pop();

							Character o=operator_stk.pop();

							Integer v=0;

							if(o=='+')

							{

								v=v1+v2;

							}

							else if(o=='-')

							{

								v=v1-v2;

							}

							else if(o=='*')

							{

								v=v1*v2;

							}

							else if(o=='/')

							{

								v=v1/v2;

							}

							oprand_stk.push(v);

						}

						else

						{

							System.out.println(exp+" is invalid");

							valexp=0;

							break;

						}

					}

					if(valexp==1)

					{

						Integer xx=oprand_stk.pop();

						System.out.println(exp.charAt(0)+" :=: "+xx);

						symb.put(exp.charAt(0), new Integer(xx));

					}

				}



				else

				{

					System.out.println(exp+" is invalid");

					valexp=0;

				}

			}

		}

		System.out.println("\nThe Final Symbol Table is :\n\n");

		System.out.println("\nVariable\tValue");

		ArrayList<Character> sortedKeys = new ArrayList<Character>(symb.keySet());

		Collections.sort(sortedKeys);

		for (Character x : sortedKeys)

		{

			System.out.println(x + "\t\t"+ symb.get(x));

		}

	}

}