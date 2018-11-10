package queue;

/**
 * @Author yukai
 * @Date 2018��11��10��
 */
public interface Queue<T> {

	void enqueue(T element);
	T dequeue();
	T getFront();
	int getSize();
	boolean isEmpty();
}
