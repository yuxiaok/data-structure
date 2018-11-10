package stack;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * ��ջ
 * ������ͷ���Ϊջ��
 * 
 * ˳��ջ����ջ����ͬ��Ͳ�ͬ�㣺
 * 1.���ߵ���ջ�ͳ�ջʱ�临�Ӷȶ���o(1)
 * 2.˳��ջ������β��Ϊջ������ջ��ͷ�����Ϊջ��
 * 3.˳��ջ�пռ�����ƣ���ջû��
 * 4.˳��ջ��ȡʱ��λ�ܷ��㣬��ջ��΢�鷳һ��
 */
public class LinkStack<T> implements Stack<T> {

	private class Node{
		private T element;
		private Node next;
		public Node(T element,Node next){
			this.element = element;
			this.next = next;
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public LinkStack(){
		dummyHead = new Node(null,null);
		size = 0;
	}
	
	@Override
	public int getSize(){
		return size;
	}
	
	@Override
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @param element
	 */
	@Override
	public void push(T element){
		//������ͷ�ڵ����Ԫ��
		dummyHead.next = new Node(element,dummyHead.next);
		size ++ ;
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T pop(){
		if(dummyHead.next == null)
			throw new IllegalArgumentException("Stack is empty");
		
		Node ret = dummyHead.next;
		dummyHead.next = ret.next;
		ret.next = null;
		size -- ;
		return ret.element;
	}
	
	@Override
	public T peek(){
		if(dummyHead.next == null)
			throw new IllegalArgumentException("Stack is empty");
		return dummyHead.next.element;
	}
}
