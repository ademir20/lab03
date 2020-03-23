package Fully_Paren;

public class Expression {

	// user expression
	   private String expr;
	  
	   public Expression(){
	   this.expr="";
	   }
	     
	   // set expression
	     
	   public void setExpression(String s){
	   this.expr=s;
	   }
	     
	     
	     
	   // valid checking
	   public boolean isValid(){
	         
	   String [] splt=this.expr.split("=|:");
	   if(splt.length!=2){
	   return false;
	   }
	     
	   if(this.expr.charAt(1)==':' && !(splt[1].charAt(0)=='(' || splt[1].charAt(0)=='{' || splt[1].charAt(0)=='[')){
	   return false;
	   }
	     
	   StackExpression<Character> stack = new StackExpression<Character>();
	     
	   for (int i = 0; i<splt[1].length(); i++) {
	       char c = splt[1].charAt(i);
	               if(!(c=='(' || c=='{' || c=='[' || c==')' || c=='}' || c==']' || c=='+' || c=='-' || c=='*' || c=='/' || c=='^' || (c>='A' && c<='Z') || (c>='0' && c<='9') )){
	                   return false;
	               }
	               if (c == ')'){
	                   if(stack.isEmpty()==true) {
	                   return false;
	                   }
	                  
	                   while(stack.isEmpty()!=true){
	                       if(stack.top()=='(') {
	                           stack.pop();
	                           break;
	                       }
	                   stack.pop();
	                   }
	               }
	               if (c == '}'){
	               if(stack.isEmpty()==true) {
	               return false;
	               }
	               while(stack.isEmpty()!=true && stack.top()!='{' ){
	                   if(stack.top()=='{') {
	                           stack.pop();
	                           break;
	                       }
	                   stack.pop();
	                   }
	               }
	               if (c == ']'){
	               if(stack.isEmpty()==true) {
	               return false;
	               }
	               while(stack.isEmpty()!=true && stack.top()!='[' ){
	                   if(stack.top()=='[') {
	                           stack.pop();
	                           break;
	                       }
	                   stack.pop();
	                   }
	               }
	              
	               if(c=='(' || c=='{' || c=='['){
	                   stack.push(c);
	               }
	           }
	          
	          
	           if(stack.isEmpty()!=true) {
	               return false;
	           }
	           return true;
	   }
	     
	   // upper operator
	     
	   public int prec(char c){
	       if(c == '^')
	       return 3;
	       else if(c == '*' || c == '/')
	       return 2;
	       else if(c == '+' || c == '-')
	       return 1;
	       else
	       return -1;
	   }
	     
	   // convert infix To Postfix
	   public String infixToPostfix(String exp) {
	           String result = new String("");
	          
	           StackExpression<Character> stack = new StackExpression<Character>();
	          
	           for (int i = 0; i<exp.length(); i++){
	               char c = exp.charAt(i);
	               if (Character.isLetterOrDigit(c)){
	                   result += c;
	               }
	               else if (c == '(' || c == '{' || c == '['){
	                   stack.push(c);
	               }
	              
	               else if (c == ')' || c == '}' || c == ']')
	               {
	                   while (!stack.isEmpty() && !(stack.top() == '(' || stack.top() == '{' || stack.top() == '['))
	                       result += stack.pop();
	              
	                   if (!stack.isEmpty() && !(stack.top() == '(' || stack.top() == '{' || stack.top() == '['))
	                       return "" ;
	                   else
	                       stack.pop();
	               }
	               else
	               {
	                   while (!stack.isEmpty() && prec(c) <= prec(stack.top())){
	                       if(stack.top() == '(' || stack.top() == '{' || stack.top() == '[')
	                           return "" ;
	                       result += stack.pop();
	                   }
	                   stack.push(c);
	               }
	           }
	          
	           while (!stack.isEmpty()){
	               if(stack.top() == '(' || stack.top() == '{' || stack.top() == '[')
	               return "" ;
	               result += stack.pop();
	           }
	           return result;
	       }
	     
	   // Evaluate expression
	   public int eval(int [] val){
	   int ret=-1;
	   if(this.isValid()){
	         
	       if(this.expr.charAt(1)=='='){
	           String [] epr=this.expr.split("=");
	           val[(int)( epr[0].charAt(0)-'A')]=Integer.parseInt(epr[1]);
	           }
	         
	       if(this.expr.charAt(1)==':'){
	           String [] epr=this.expr.split(":");
	           String exp=this.infixToPostfix(epr[1]);
	     
	             
	               StackExpression<Integer> stack=new StackExpression<Integer>();
	              
	               for(int i=0;i<exp.length();i++) {
	                   char c=exp.charAt(i);
	                  
	                   if(Character.isAlphabetic(c)) {
	                   int add=val[(int)( c-'A')];
	                   stack.push(add);
	                   }
	                   else
	                   {
	                       int val1 = stack.pop();
	                       int val2 = stack.pop();
	                      
	                       switch(c)
	                       {
	                           case '+':
	                               stack.push(val2+val1);
	                               break;
	                      
	                           case '-':
	                               stack.push(val2- val1);
	                               break;
	                      
	                           case '/':
	                               stack.push(val2/val1);
	                               break;
	                      
	                           case '*':
	                               stack.push(val2*val1);
	                               break;
	                       }
	                   }
	               }
	               val[(int)( epr[0].charAt(0)-'A')]=stack.pop();
	       }
	       ret=0;
	   }
	  
	   return ret;
	   }
	     
	}

