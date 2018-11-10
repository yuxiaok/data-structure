package queue;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 链队列，使用两个指针
 * front作为虚拟头结点，front.next为头结点，rear记录尾节点
 * front == rear,空
 * 链式结构，不存在满
 */
public class LinkQueue2<T> implements Queue<T> {

	private class Node{
		private T element;
		private Node next;
		public Node(T element,Node next){
			this.element = element;
			this.next = next;
		}
	}
	
	//虚拟头结点
	private Node front;
	//记录尾节点
	private Node rear;
	private int size;
	
	public LinkQueue2(){
		//满足队列为空的条件
		front = rear = new Node(null,null);
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
	public void enqueue(T element){
		rear.next = new Node(element,rear.next);
		rear = rear.next;
		size ++;
	}
	
	/**
	 * 时间复杂度o(1)
	* @return
	 */
	@Override
	public T dequeue(){
		if(front == rear)
			throw new IllegalArgumentException("队列为空");
		Node ret = front.next;
		front.next = ret.next;
		ret.next = null;
		
		//判断是否删除的是最后一个元素
		if(ret == rear)
			rear = front;	
		size --;
		return ret.element;
	}
	
	@Override
	public T getFront(){
		return front.next.element;
	}
	
	public static void main(String[] args){
		LinkQueue2<Integer> link = new LinkQueue2<>();
		for(int i=0;i<5;i++)
			link.enqueue(i);
		for(int i=0;i<5;i++)
			System.out.println(link.dequeue());
	}
}
