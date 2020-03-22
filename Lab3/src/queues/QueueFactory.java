package queues;

public interface QueueFactory<E> {

	public Queue<E> newInstance();

}