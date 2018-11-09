package linked;

/**
 * @Author yukai
 * @Date 2018��11��9��
 * ѭ����������
 * β�ڵ�ָ��ͷ���
 * �뵥������Ψһ����������ж�β�ڵ���ж����������仯��
 * Ҳ����ͨ��ʹ��β�ڵ�ķ�ʽ��ʹ�û�ȡ��һ��Ԫ�غ����һ��Ԫ�ص�ʱ�临�Ӷ�Ϊo(1)
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
	
	//����ͷ���
	private Node dummyHead;
	//β�ڵ�
	private Node rear;
	private int size;
	
	public LoopLinkedList(){
		//��ʼ��ʱָ���Լ�
		this.dummyHead = new Node(null,dummyHead);
		rear = new Node(null,rear);
		this.size = 0;
	}	
	
	/**
	 * ��ȡĳ��Ԫ��
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
	 * ʹ��β�ڵ㣬ʹ�û�ȡ���һ���ڵ��ʱ�临�Ӷ�Ϊ(1)
	* @return
	 */
	public T getLast(){
		return rear.element;
	}
	
	/**
	 * ��ȡ��һ���ڵ��ʱ�临�Ӷ�Ϊo(1)
	* @return
	 */
	public T getFirst(){
		return rear.next.next.element;
	}
	
	/**
	 * �Ƿ����ĳ��Ԫ��
	* @param element
	* @return
	 */
	public boolean contains(T element){
		Node cur = dummyHead;
		//�뵥�����������
		while(cur.next != dummyHead){
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
		
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
	
		cur.next = new Node(element,cur.next);
		//�ж��Ƿ���β�����,��¼β�ڵ�
		if(cur.next.next == dummyHead)
			rear = new Node(element,cur.next);
				
		size++;
	}
	
	/**
	 * ɾ��ĳ��λ�õĽڵ�
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
		//ά��β�ڵ��λ��
		if(ret.next == dummyHead)
			rear = cur;
		size--;
		return ret.element;
	}
	

	/**
	 * ɾ��ĳ��Ԫ��
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
