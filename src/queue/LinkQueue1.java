package queue;

import linked.SingleLinkedList;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 一个指针的链队列
 */
public class LinkQueue1<T> implements Queue<T>{
	private SingleLinkedList list;
	
	public LinkQueue1(){
		list = new SingleLinkedList();
	}
	
	@Override
	public int getSize(){
		return list.getSize();
	}
	
	@Override
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	/**
	 * 时间复杂度o(n)
	* @param element
	 */
	@Override
	public void enqueue(T element){
		list.addLast(element);
	}
	
	/**
	 * 时间复杂度o(1)
	* @return
	 */
	@Override
	public T dequeue(){
		return (T)list.removeFirst();
	}
	
	/**
	 * 时间复杂度o(1)
	* @return
	 */
	@Override
	public T getFront(){
		return (T)list.getFirst();
	}
}
