package stack;

import linked.ArrayLinkedList;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * ������������ʵ��ջ
 */
public class ArrayStack2<T> implements Stack<T> {
	
	private ArrayLinkedList<T> arr;
	
	public ArrayStack2(){
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
	 * ʱ�临�Ӷ�o(1)
	* @param element
	 */
	@Override
	public void push(T element){
		arr.addLast(element);
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T pop(){
		return arr.removeLast();
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T peek(){
		return arr.getLast();
	}
	
}
