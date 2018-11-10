package stack;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 链栈
 * 以链表头结点为栈顶
 * 
 * 顺序栈和链栈的相同点和不同点：
 * 1.两者的入栈和出栈时间复杂度都是o(1)
 * 2.顺序栈以数组尾作为栈顶，链栈以头结点作为栈顶
 * 3.顺序栈有空间的限制，链栈没有
 * 4.顺序栈存取时定位很方便，链栈稍微麻烦一点
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
	 * 时间复杂度o(1)
	* @param element
	 */
	@Override
	public void push(T element){
		//总是向头节点添加元素
		dummyHead.next = new Node(element,dummyHead.next);
		size ++ ;
	}
	
	/**
	 * 时间复杂度o(1)
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
