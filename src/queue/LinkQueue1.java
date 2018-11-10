package queue;

import linked.SingleLinkedList;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * һ��ָ���������
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
	 * ʱ�临�Ӷ�o(n)
	* @param element
	 */
	@Override
	public void enqueue(T element){
		list.addLast(element);
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T dequeue(){
		return (T)list.removeFirst();
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T getFront(){
		return (T)list.getFirst();
	}
}
