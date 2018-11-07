package linked;

/**
 * 无论何种形式表现，链表都是有头有尾
 * @Author yukai
 * @Date 2018年11月7日
 * 单向链表
 * 链式存储结构
 * 与数组链表的区别：
 * 1.存储分配方式：前者链式存储，后者顺序存储
 * 2.时间性能：前者查找o(n),增删o(n)，但是如果我们事先知道了要删除的节点是谁，就可以直接用后面的节点进行覆盖，此时的时间复杂度为o(1)
 * 			后者查找o(1),随机快速访问，增删o(n)
 * 3.空间性能：前者无需关心空间容量，后者需要预分配存储空间，分大了，浪费，分小了，溢出。
 * 4.多查询，顺序存储，多增删，链式存储
 */
public class SingleLinkedList<T> {

	/**
	 * 节点内部类
	 * @Author yukai
	 * @Date 2018年11月7日
	 */
	private class Node{
		//元素
		private T element;
		//下一个节点
		private Node next;
		
		public Node(T element,Node next){
			this.element = element;
			this.next = next;
		}
		
		public Node(T element){
			this(element,null); 
		}
	}
	
	/**
	 * 虚拟头结点统一操作
	 */
	private Node dummyHead;
	private int size;
	
	public SingleLinkedList(){
		dummyHead = new Node(null,null);
		size = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 获取某个位置的元素
	 * 时间复杂度o(n)
	* @param index
	* @return
	 */
	public T get(int index){
		if(index < 0 || index >=size)
			throw new IllegalArgumentException("index is illegal");
		Node cur = dummyHead;
		for(int i=0;i<=index;i++)
			cur = cur.next;
		return cur.element;
	}
	
	//时间复杂度o(1)
	public T getFirst(){
		return get(0);
	}
	
	
	//时间复杂度o(n)
	public T getLast(){
		return get(size-1);
	}
	
	
	
	/**
	 * 是否包含某个元素
	 * 时间复杂度 o(n)
	* @param element
	* @return
	 */
	public boolean contains(T element){
		/*Node cur = dummyHead.next;
		for(int i=1;i<size;i++)
			if(cur.element.equals(element))
				return true;
		return false;*/
		
		Node cur = dummyHead;
		while(cur.next != null){
			if(cur.next.element.equals(element))
				return true;
			cur = cur.next;
		}
		return false;
	}
	
	/**
	 * 在index的位置添加元素
	 * 时间复杂度o(n)
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index > size)
			throw new IllegalArgumentException("index is illegal");
		
		//获取虚拟头结点
		Node cur = dummyHead;
		//找到要添加位置的前驱
		for(int i=0;i<index;i++)
			cur = cur.next;
		//添加节点
		cur.next = new Node(element,cur.next);
		size ++ ;
	}
	
	//时间复杂度o(1)
	public void addFirst(T element){
		add(0,element);
	}
	
	//时间复杂度o(n)
	public void addLast(T element){
		add(size,element);
	}
	
	/**
	 * 删除index位置的节点
	 * 时间复杂度o(n)
	* @param index
	* @return
	 */
	public T remove(int index){
		T ret = get(index);
		//找到待删除节点的前一个节点
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
		//删除节点
		Node removeNode = cur.next;
		cur.next = removeNode.next;
		removeNode.next = null;
		
		size--;
		return ret;
	}
	
	//删除第一个节点，时间复杂度o(1)
	public T removeFirst(){
		return remove(0);
	}
	
	//删除最后一个节点，时间复杂度o(n)
	public T removeLast(){
		return remove(size-1);
	}
	
	/**
	 * 删除某个元素
	* @param element
	 */
	public void removeElement(T element){
		Node cur = dummyHead;
		//最后一个节点的next肯定为空
		while(cur.next != null){
			if(cur.next.element.equals(element)){
				Node removeNode = cur.next;
				cur.next = removeNode.next;
				removeNode.next = null;
				size--;
			}else
			    cur = cur.next;
		}
	}
	
	/**
	 * 更新某个位置的元素
	* @param index
	* @param element
	 */
	public void set(int index,T element){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is illegal");
		
		//找到要更新的节点
		Node cur = dummyHead;
		for(int i=0;i<=index;i++)
			cur = cur.next;
		
		cur.element = element;
	}
	
}
