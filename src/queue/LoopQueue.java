package queue;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * ѭ�����У�ʹ�ÿ��е�Ԫ�ķ�ʽʵ�֣�:
 * ʹ������ָ�룺front��¼����Ԫ�ص�λ�ã�rear��¼��βԪ�ص���һ��λ�ã�Ҳ������һ��Ԫ����ӵ�λ��
 * ��Ϊ��ѭ�����У�����ÿ��λ�õ��±궼Ҫͨ����index�� % length����;
 * ����Ϊ�գ�front = rear
 * �������ˣ���rear+1�� % length = front; ��Ϊ��ѭ���ģ������±���Ҫȡģ���㣬Ҳ����˵����ֻʣ��һ��λ��ʱ�����������
 */
public class LoopQueue<T> implements Queue<T> {

	private T[] data;
	//��һ��Ԫ�ص��±�
	private int front;
	//���һ�����Ԫ�ص���һ��λ���±�(Ҳ���ǵ�һ�����õ�λ��)
	private int rear;
	private int size;
	
	public LoopQueue(int capacity){
		//��Ϊ����һ�����е�Ԫ���ж϶����Ƿ�������������Ҫ�࿪��һ������
		data = (T[]) new Object[capacity+1];
		//����ն��е�Ҫ��
		front = 0;
		rear = 0 ;
	}
	
	public LoopQueue(){
		this(10);
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
	 * ��ӵ�ʱ�临�Ӷ�Ϊo(1)
	* @param element
	 */
	@Override
	public void enqueue(T element){
		
		//�ж϶����Ƿ�����
		if((rear + 1) % data.length == front)
			throw new IllegalArgumentException("��������");
		
		data[rear] = element;
		//rear�ƶ�����һ��λ��
		rear = (rear + 1) % data.length;
		size++;
	}
	
	/**
	 * ���ӵ�ʱ�临�Ӷ�Ϊo(1)
	* @return
	 */
	@Override
	public T dequeue(){
		if(rear == front)
			throw new IllegalArgumentException("����Ϊ��");
		
		T ret = data[front];
		data[front] = null;
		//front�ƶ�����һ��λ��
		front = (front+1) % data.length;
		size --;
		return ret;
	}
	
	/**
	 * ��ȡ����Ԫ�أ�ʱ�临�Ӷ�Ϊo(1)
	* @return
	 */
	@Override
	public T getFront(){
		if(rear == front)
			throw new IllegalArgumentException("����Ϊ��");
		return data[front];
	}
}
