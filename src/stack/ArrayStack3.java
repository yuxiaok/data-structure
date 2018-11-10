package stack;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * �����ڴ�ջ����һ�������Ϊ����ջ
 */
public class ArrayStack3<T>{

	private T[] data;
	//ָ�������±�Ϊ0��λ�ã����м�����
	private int top1;
	//ָ�������±�Ϊlength-1��λ�ã����м�����
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
	 * ��ջ
	* @param element
	* @param stackNumber �ĸ�ջ
	 */
	public void push(T element,int stackNumber){
		if(top1 + 1 == top2)
			throw new IllegalArgumentException("����ջ����");
		
		if(stackNumber == 1)
			//���һ��ջ
			data[top1++] = element;
		else if(stackNumber == 2)
			//��ڶ���ջ
			data[top2--] = element;
		
		size ++ ;
	}
	
	/**
	 * ��ջ
	* @param stackNumber
	* @return
	 */
	public T pop(int stackNumber){
		T ret = null;
		if(stackNumber == 1){
			if(top1 == 0)
				throw new IllegalArgumentException("ջ1Ϊ��");
			ret = data[--top1];
			data[top1] = null;
		}else if(stackNumber == 2){
			if(top2 == data.length-1)
				throw new IllegalArgumentException("ջ2Ϊ��");
			ret = data[++top2];
			data[top2] = null;
		}
		size --;
		return ret;
	}
	
	/**
	 * �鿴ջ��Ԫ��
	* @param stackNumber
	* @return
	 */
	public T peek(int stackNumber){
		T ret = null;
		if(stackNumber == 1){
			if(top1 == 0)
				throw new IllegalArgumentException("ջ1Ϊ��");
			ret = data[top1-1];
		}else if(stackNumber == 2){
			if(top2 == data.length-1)
				throw new IllegalArgumentException("ջ2Ϊ��");
			ret = data[top2+1];

		}
		return ret;
	}
}
