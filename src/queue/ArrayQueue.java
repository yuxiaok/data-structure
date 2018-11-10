package queue;

import linked.ArrayLinkedList;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 基于顺序存储的队列
 * 队列：队首出队，队尾入队
 * 普通队列无论是基于顺序存储还是链式存储，插入和删除操作总有一个时间复杂度为o(n)
 * 造成此问题的原因，就是元素的移动
 * 解决该问题就是采用循环队列，使得元素不移动，而移动游标
 */
public class ArrayQueue<T> implements Queue<T>{

	private ArrayLinkedList arr;
	public ArrayQueue(){
		arr = new ArrayLinkedList();
	}
	
	@Override
	public int getSize(){
		return arr.getSize();
	}
	
	@Override
	public boolean isEmpty(){
		return arr.isEmpty();
	}
	
	/**
	 * 时间复杂度o（1）
	* @param element
	 */
	@Override
	public void enqueue(T element){
		arr.addLast(element);
	}
	
	/**
	 * 时间复杂度o(n)
	* @return
	 */
	@Override
	public T dequeue(){
		return (T)arr.removeFirst();
	}
	
	/**
	 * 时间复杂度o(1)
	* @return
	 */
	@Override
	public T getFront(){
		return (T)arr.getFirst();
	}
}
