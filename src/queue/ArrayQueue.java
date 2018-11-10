package queue;

import linked.ArrayLinkedList;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * ����˳��洢�Ķ���
 * ���У����׳��ӣ���β���
 * ��ͨ���������ǻ���˳��洢������ʽ�洢�������ɾ����������һ��ʱ�临�Ӷ�Ϊo(n)
 * ��ɴ������ԭ�򣬾���Ԫ�ص��ƶ�
 * �����������ǲ���ѭ�����У�ʹ��Ԫ�ز��ƶ������ƶ��α�
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
	 * ʱ�临�Ӷ�o��1��
	* @param element
	 */
	@Override
	public void enqueue(T element){
		arr.addLast(element);
	}
	
	/**
	 * ʱ�临�Ӷ�o(n)
	* @return
	 */
	@Override
	public T dequeue(){
		return (T)arr.removeFirst();
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T getFront(){
		return (T)arr.getFirst();
	}
}
