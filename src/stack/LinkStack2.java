package stack;

import linked.SingleLinkedList;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * ���ڵ�������
 */
public class LinkStack2<T> implements Stack<T> {

	private SingleLinkedList list;
	
	public LinkStack2(){
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
	
	@Override
	public void push(T element){
		list.addFirst(element);
	}
	
	@Override
	public T pop(){
		return (T) list.removeFirst();
	}
	
	@Override
	public T peek(){
		return (T) list.getFirst();
	}
}
