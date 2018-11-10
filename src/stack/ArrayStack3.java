package stack;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 共享内存栈，将一个数组分为两个栈
 */
public class ArrayStack3<T>{

	private T[] data;
	//指向数组下标为0的位置，向中间延伸
	private int top1;
	//指向数组下标为length-1的位置，向中间延伸
	private int top2;
	private int size;
	
	public ArrayStack3(int capacity){
		data = (T[]) new Object[capacity];
		top1 = 0;
		top2 = capacity - 1;
		size = 0;
	}
	
	public ArrayStack3(){
		this(10);
	}
	

	public int getSize(){
		return size;
	}
	

	public boolean isEmpty(){
		return size == 0;
	}
	

	/**
	 * 入栈
	* @param element
	* @param stackNumber 哪个栈
	 */
	public void push(T element,int stackNumber){
		if(top1 + 1 == top2)
			throw new IllegalArgumentException("两个栈已满");
		
		if(stackNumber == 1)
			//入第一个栈
			data[top1++] = element;
		else if(stackNumber == 2)
			//如第二个栈
			data[top2--] = element;
		
		size ++ ;
	}
	
	/**
	 * 出栈
	* @param stackNumber
	* @return
	 */
	public T pop(int stackNumber){
		T ret = null;
		if(stackNumber == 1){
			if(top1 == 0)
				throw new IllegalArgumentException("栈1为空");
			ret = data[--top1];
			data[top1] = null;
		}else if(stackNumber == 2){
			if(top2 == data.length-1)
				throw new IllegalArgumentException("栈2为空");
			ret = data[++top2];
			data[top2] = null;
		}
		size --;
		return ret;
	}
	
	/**
	 * 查看栈顶元素
	* @param stackNumber
	* @return
	 */
	public T peek(int stackNumber){
		T ret = null;
		if(stackNumber == 1){
			if(top1 == 0)
				throw new IllegalArgumentException("栈1为空");
			ret = data[top1-1];
		}else if(stackNumber == 2){
			if(top2 == data.length-1)
				throw new IllegalArgumentException("栈2为空");
			ret = data[top2+1];

		}
		return ret;
	}
}
