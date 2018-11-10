package queue;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 循环队列（使用空闲单元的方式实现）:
 * 使用两个指针：front记录队首元素的位置，rear记录队尾元素的下一个位置，也就是下一个元素入队的位置
 * 因为是循环队列，所以每个位置的下标都要通过（index） % length计算;
 * 数组为空：front = rear
 * 数组满了：（rear+1） % length = front; 因为是循环的，所以下标需要取模计算，也就是说数组只剩下一个位置时，数组就满了
 */
public class LoopQueue<T> implements Queue<T> {

	private T[] data;
	//第一个元素的下标
	private int front;
	//最后一个入队元素的下一个位置下标(也就是第一个空置的位置)
	private int rear;
	private int size;
	
	public LoopQueue(int capacity){
		//因为用来一个空闲单元来判断队列是否已满，所以需要多开辟一个容量
		data = (T[]) new Object[capacity+1];
		//满足空队列的要求
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
	 * 入队的时间复杂度为o(1)
	* @param element
	 */
	@Override
	public void enqueue(T element){
		
		//判断队列是否已满
		if((rear + 1) % data.length == front)
			throw new IllegalArgumentException("队列已满");
		
		data[rear] = element;
		//rear移动到下一个位置
		rear = (rear + 1) % data.length;
		size++;
	}
	
	/**
	 * 出队的时间复杂度为o(1)
	* @return
	 */
	@Override
	public T dequeue(){
		if(rear == front)
			throw new IllegalArgumentException("队列为空");
		
		T ret = data[front];
		data[front] = null;
		//front移动到下一个位置
		front = (front+1) % data.length;
		size --;
		return ret;
	}
	
	/**
	 * 获取队首元素，时间复杂度为o(1)
	* @return
	 */
	@Override
	public T getFront(){
		if(rear == front)
			throw new IllegalArgumentException("队列为空");
		return data[front];
	}
}
