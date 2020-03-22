package stacks;

public interface StackFactory<E> {

	public Stack<E> newInstance();

}