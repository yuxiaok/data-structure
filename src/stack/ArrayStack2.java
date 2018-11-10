package stack;

import linked.ArrayLinkedList;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 基于数组链表实现栈
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
	 * 时间复杂度o(1)
	* @param element
	 */
	@Override
	public void push(T element){
		arr.addLast(element);
	}
	
	/**
	 * 时间复杂度o(1)
	* @return
	 */
	@Override
	public T pop(){
		return arr.removeLast();
	}
	
	/**
	 * 时间复杂度o(1)
	* @return
	 */
	@Override
	public T peek(){
		return arr.getLast();
	}
	
}
