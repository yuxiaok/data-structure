package linked;

/**
 * @Author yukai
 * @Date 2018��11��9��
 * ˫������
 * �뵥�����������
 * 1.��ά����һ��ǰ���ڵ㣬�ռ���������
 * 2.��ɾʱ��������Ȼֻ��Ҫһ������û��̫������ֻ��ά���ڵ�Ĳ�����ø���
 * 3.����˫������ĶԳ��ԣ�ʹ������˫�������ʱ�����ܸ�����Խ���ÿռ任ʱ��
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
		//�ҵ���ǰλ�õĽڵ�
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
	 * ������λ�����Ԫ��
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index > size)
			throw new IllegalArgumentException("index is illegal");
		
		//�ҵ�Ҫ���λ�õ�ǰһ���ڵ�
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
		
		//�ҵ�Ҫ���λ�õĺ�һ���ڵ�
		Node next = cur.next;
		//ǰһ���ڵ�ĺ��
		cur.next = new Node(element,cur,next);
		//��һ���ڵ��ǰ��
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
	 * ɾ������ڵ��Ԫ��
	* @param index
	* @return
	 */
	public T remove(int index){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is illegal");
		//�ҵ�Ҫɾ���Ľڵ�
		Node cur = dummyHead;
		for(int i=0;i<=index;i++)
			cur = cur.next;
		
		//ά����һ���ڵ�ĺ��
		cur.prev.next = cur.next;
		//ά����һ���ڵ��ǰ��
		cur.next.prev = cur.prev;
		
		cur.prev = null;
		cur.next = null;
		
		size --;
		return cur.element;
	}
	
	/**
	 * ɾ��ĳ��Ԫ��
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
