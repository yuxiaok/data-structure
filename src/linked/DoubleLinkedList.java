package linked;

/**
 * @Author yukai
 * @Date 2018年11月9日
 * 双向链表
 * 与单向链表的区别：
 * 1.多维护了一个前驱节点，空间消耗增加
 * 2.增删时，操作依然只需要一个方向，没有太大区别，只是维护节点的操作变得复杂
 * 3.由于双向链表的对称性，使得整体双向链表的时间性能更加优越，用空间换时间
 */
public class DoubleLinkedList<T> {

	private class Node{
		private T element;
		private Node prev,next;
		
		public Node(T element,Node prev,Node next){
			this.element = element;
			this.prev = prev;
			this.next = next;
		}
		
		public Node(T element){
			this(element,null,null);
		}
	}
	
	private Node dummyHead;
	private int size;
	
	public DoubleLinkedList(){
		dummyHead = new Node(null,null,null);
		size = 0;
	}
	
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public T get(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is illegal");
		//找到当前位置的节点
		Node cur = dummyHead;
		for(int i=0;i<=index;i++)
			cur = cur.next;
		return cur.element;
	}
	
	public boolean contains(T element){
		Node cur = dummyHead;
		while(cur.next != null){
			if(cur.next.element.equals(element))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	
	/**
	 * 向任意位置添加元素
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index > size)
			throw new IllegalArgumentException("index is illegal");
		
		//找到要添加位置的前一个节点
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
		
		//找到要添加位置的后一个节点
		Node next = cur.next;
		//前一个节点的后继
		cur.next = new Node(element,cur,next);
		//后一个节点的前驱
		next.prev = cur.next;
		size++;
	}
	
	public void addFirst(T element){
		add(0,element);
	}
	
	public void addLast(T element){
		add(size,element);
	}
	
	/**
	 * 删除任意节点的元素
	* @param index
	* @return
	 */
	public T remove(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is illegal");
		//找到要删除的节点
		Node cur = dummyHead;
		for(int i=0;i<=index;i++)
			cur = cur.next;
		
		//维护上一个节点的后继
		cur.prev.next = cur.next;
		//维护下一个节点的前驱
		cur.next.prev = cur.prev;
		
		cur.prev = null;
		cur.next = null;
		
		size --;
		return cur.element;
	}
	
	/**
	 * 删除某个元素
	* @param element
	 */
	public void removeElement(T element){
		Node cur = dummyHead;
		while(cur.next != null){
			if(cur.next.element.equals(element)){
				Node ret = cur.next;
				ret.prev.next = ret.next;
				ret.next.prev = ret.prev;
			}else
				cur = cur.next;
		}
	}
}
