package queue;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * �����У�ʹ������ָ��
 * front��Ϊ����ͷ��㣬front.nextΪͷ��㣬rear��¼β�ڵ�
 * front == rear,��
 * ��ʽ�ṹ����������
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
	
	//����ͷ���
	private Node front;
	//��¼β�ڵ�
	private Node rear;
	private int size;
	
	public LinkQueue2(){
		//�������Ϊ�յ�����
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
	 * ʱ�临�Ӷ�o(1)
	* @param element
	 */
	@Override
	public void enqueue(T element){
		rear.next = new Node(element,rear.next);
		rear = rear.next;
		size ++;
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T dequeue(){
		if(front == rear)
			throw new IllegalArgumentException("����Ϊ��");
		Node ret = front.next;
		front.next = ret.next;
		ret.next = null;
		
		//�ж��Ƿ�ɾ���������һ��Ԫ��
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
