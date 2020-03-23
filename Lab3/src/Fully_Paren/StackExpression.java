package Fully_Paren;

public class StackExpression<E> {
  
   // Bottom node -Ademir
   private Node<E> root;
  
  
   // Constructor -Ademir
   public StackExpression(){
       this.root=null;
   }
  
  
   // add an element in header -Ademir
   public void push(E d) {
       Node<E> node=new Node<E>(d);
       node.setNext(this.root);
       this.root=node;
      
   }

   public E top(){
       E ret=null;
      
       if(this.root!=null){
           ret=this.root.getData();
       }
      
       return ret;
   }
  
   // Set next element in bottom -Ademir
   public E pop(){
       E ret=null;
      
       if(this.root!=null){
           ret=this.root.getData();
           this.root=this.root.getNext();
       }
      
       return ret;
   }
  
   public boolean isEmpty(){
       return this.root==null;
   }
}