package queue;

/**
 * @Author yukai
 * @Date 2018Äê11ÔÂ10ÈÕ
 */
public interface Queue<T> {

	void enqueue(T element);
	T dequeue();
	T getFront();
	int getSize();
	boolean isEmpty();
}
