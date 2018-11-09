package linked;

/**
 * @Author yukai
 * @Date 2018年11月9日
 * 循环链表（单向）
 * 尾节点指向头结点
 * 与单向链表唯一的区别就是判断尾节点的判断条件发生变化了
 * 也可以通过使用尾节点的方式，使得获取第一个元素和最后一个元素的时间复杂度为o(1)
 */
public class LoopLinkedList<T> {
	
	private class Node{
		private T element;
		private Node next;
		
		public Node(T element,Node next){
			this.element = element;
			this.next = next;
		}
		
		public Node(T element){
			this(element,null);
		}
	}
	
	//虚拟头结点
	private Node dummyHead;
	//尾节点
	private Node rear;
	private int size;
	
	public LoopLinkedList(){
		//初始化时指向自己
		this.dummyHead = new Node(null,dummyHead);
		rear = new Node(null,rear);
		this.size = 0;
	}	
	
	/**
	 * 获取某个元素
	* @param index
	* @return
	 */
	public T get(int index){
		if(index < 0 || index > size-1)
			throw new IllegalArgumentException("index is illegal");
		
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
		return cur.element;
	}
	
	/**
	 * 使用尾节点，使得获取最后一个节点的时间复杂度为(1)
	* @return
	 */
	public T getLast(){
		return rear.element;
	}
	
	/**
	 * 获取第一个节点的时间复杂度为o(1)
	* @return
	 */
	public T getFirst(){
		return rear.next.next.element;
	}
	
	/**
	 * 是否包含某个元素
	* @param element
	* @return
	 */
	public boolean contains(T element){
		Node cur = dummyHead;
		//与单向链表的区别
		while(cur.next != dummyHead){
			if(cur.next.element.equals(element))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	
	/**
	 * 在任意位置添加元素
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index > size)
			throw new IllegalArgumentException("index is illegal");
		
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
	
		cur.next = new Node(element,cur.next);
		//判断是否向尾部添加,记录尾节点
		if(cur.next.next == dummyHead)
			rear = new Node(element,cur.next);
				
		size++;
	}
	
	/**
	 * 删除某个位置的节点
	* @param index
	* @return
	 */
	public T remove(int index){
		if(index < 0 || index > size-1)
			throw new IllegalArgumentException("index is illegal");
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
		
		Node ret = cur.next;
		cur.next = ret.next;
		ret.next = null;
		//维护尾节点的位置
		if(ret.next == dummyHead)
			rear = cur;
		size--;
		return ret.element;
	}
	

	/**
	 * 删除某个元素
	* @param element
	 */
	public void removeElement(T element){
		Node cur = dummyHead;
		while(cur.next != dummyHead){
			if(cur.next.element.equals(element)){
				Node ret = cur.next;
				cur.next = ret.next;
				ret.next = null;
				size--;
			}else
				cur = cur.next;			
		}
	}
	
	
}
