package linked;

/**
 * ���ۺ�����ʽ���֣���������ͷ��β
 * @Author yukai
 * @Date 2018��11��7��
 * ��������
 * ��ʽ�洢�ṹ
 * ���������������
 * 1.�洢���䷽ʽ��ǰ����ʽ�洢������˳��洢
 * 2.ʱ�����ܣ�ǰ�߲���o(n),��ɾo(n)�����������������֪����Ҫɾ���Ľڵ���˭���Ϳ���ֱ���ú���Ľڵ���и��ǣ���ʱ��ʱ�临�Ӷ�Ϊo(1)
 * 			���߲���o(1),������ٷ��ʣ���ɾo(n)
 * 3.�ռ����ܣ�ǰ��������Ŀռ�������������ҪԤ����洢�ռ䣬�ִ��ˣ��˷ѣ���С�ˣ������
 * 4.���ѯ��˳��洢������ɾ����ʽ�洢
 */
public class SingleLinkedList<T> {

	/**
	 * �ڵ��ڲ���
	 * @Author yukai
	 * @Date 2018��11��7��
	 */
	private class Node{
		//Ԫ��
		private T element;
		//��һ���ڵ�
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
	 * ����ͷ���ͳһ����
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
	 * ��ȡĳ��λ�õ�Ԫ��
	 * ʱ�临�Ӷ�o(n)
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
	
	//ʱ�临�Ӷ�o(1)
	public T getFirst(){
		return get(0);
	}
	
	
	//ʱ�临�Ӷ�o(n)
	public T getLast(){
		return get(size-1);
	}
	
	
	
	/**
	 * �Ƿ����ĳ��Ԫ��
	 * ʱ�临�Ӷ� o(n)
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
	 * ��index��λ�����Ԫ��
	 * ʱ�临�Ӷ�o(n)
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index > size)
			throw new IllegalArgumentException("index is illegal");
		
		//��ȡ����ͷ���
		Node cur = dummyHead;
		//�ҵ�Ҫ���λ�õ�ǰ��
		for(int i=0;i<index;i++)
			cur = cur.next;
		//��ӽڵ�
		cur.next = new Node(element,cur.next);
		size ++ ;
	}
	
	//ʱ�临�Ӷ�o(1)
	public void addFirst(T element){
		add(0,element);
	}
	
	//ʱ�临�Ӷ�o(n)
	public void addLast(T element){
		add(size,element);
	}
	
	/**
	 * ɾ��indexλ�õĽڵ�
	 * ʱ�临�Ӷ�o(n)
	* @param index
	* @return
	 */
	public T remove(int index){
		T ret = get(index);
		//�ҵ���ɾ���ڵ��ǰһ���ڵ�
		Node cur = dummyHead;
		for(int i=0;i<index;i++)
			cur = cur.next;
		//ɾ���ڵ�
		Node removeNode = cur.next;
		cur.next = removeNode.next;
		removeNode.next = null;
		
		size--;
		return ret;
	}
	
	//ɾ����һ���ڵ㣬ʱ�临�Ӷ�o(1)
	public T removeFirst(){
		return remove(0);
	}
	
	//ɾ�����һ���ڵ㣬ʱ�临�Ӷ�o(n)
	public T removeLast(){
		return remove(size-1);
	}
	
	/**
	 * ɾ��ĳ��Ԫ��
	* @param element
	 */
	public void removeElement(T element){
		Node cur = dummyHead;
		//���һ���ڵ��next�϶�Ϊ��
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
	 * ����ĳ��λ�õ�Ԫ��
	* @param index
	* @param element
	 */
	public void set(int index,T element){
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("index is illegal");
		
		//�ҵ�Ҫ���µĽڵ�
		Node cur = dummyHead;
		for(int i=0;i<=index;i++)
			cur = cur.next;
		
		cur.element = element;
	}
	
}
