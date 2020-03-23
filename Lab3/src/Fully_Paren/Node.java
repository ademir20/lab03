package Fully_Paren;

public class Node<T> {
   private T element;
   private Node<T> next;
  
   //Constructor -Ademir
   public Node(){
       this.setData(null);
       this.setNext(null);
   }
  
   public Node(T ch){
       this.setData(ch);
       this.setNext(null);
   }

   public T getData() {
       return element;
   }

   public void setData(T data) {
       this.element = data;
   }

   public Node<T> getNext() {
       return next;
   }

   public void setNext(Node<T> next) {
       this.next = next;
   }
  
  
}