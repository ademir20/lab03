package Fully_Paren;

public class Node<T> {
   private T data;// any data
   private Node<T> next;// next node
  
   // constructor
   public Node(){
       this.setData(null);
       this.setNext(null);
   }
  
   public Node(T ch){
       this.setData(ch);
       this.setNext(null);
   }

   // getter and setter
   public T getData() {
       return data;
   }

   public void setData(T data) {
       this.data = data;
   }

   public Node<T> getNext() {
       return next;
   }

   public void setNext(Node<T> next) {
       this.next = next;
   }
  
  
}