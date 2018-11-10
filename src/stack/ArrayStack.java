package stack;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * ˳��洢�ṹջ
 * ���±�Ϊ0��λ��Ϊջ��
 */
public class ArrayStack<T> implements Stack<T> {

	private T[] data;
	private int size;
	
	public ArrayStack(int capacity){
		data = (T[])new Object[capacity];
		size = 0;
	}
	
	public ArrayStack(){
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
	 * ʱ�临�Ӷ�o(1)
	* @param element
	 */
	@Override
	public void push(T element){
		if(size > data.length-1)
			throw new IllegalArgumentException("Stack is full");
		data[size++] = element;
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T pop(){
		if(size == 0)
			throw new IllegalArgumentException("Stack is empty");
		T ret = data[--size];
		data[size] = null;
		return ret;
	}
	
	/**
	 * ʱ�临�Ӷ�o(1)
	* @return
	 */
	@Override
	public T peek(){
		if(size == 0)
			throw new IllegalArgumentException("Stack is empty");
		return data[size-1];
	}
}
