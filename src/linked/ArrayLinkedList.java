package linked;

/**
 * @Author yukai
 * @Date 2018��11��7��
 * ��̬����
 * ˳��洢���������ַ�������ģ�
 */
public class ArrayLinkedList<T> {
	/**
	 * �洢Ԫ��
	 */
	private T[] data;
	/**
	 * Ԫ�ظ���
	 */
	private int size;
	
	
	public ArrayLinkedList(int capacity){
		data = (T[]) new Object[capacity];
		size = 0;
	}
	
	public ArrayLinkedList(){
		this(10);
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0 ;
	}
	
	public int getCapacity(){
		return data.length;
	}
	
	/**
	 * ����������ȡԪ��
	 * ʱ�临�Ӷ�o(1)��֧�������ȡ
	* @param index
	* @return
	 */
	public T get(int index){
		if(index < 0 || index >= data.length)
			throw new IllegalArgumentException("index is illegal");
		return data[index];
	}
	
	public T getFirst(){
		return get(0);
	}
	
	public T getLast(){
		return get(size-1);
	}
	
	/**
	 * �Ƿ����ĳ��Ԫ��
	 * ʱ�临�Ӷ�o(n)
	* @param element
	* @return
	 */
	public boolean contains(T element){
		for(int i=0;i<size;i++)
			if(data[i].equals(element))
				return true;
		return false;
	}
	
	/**
	 * ����ĳ��Ԫ�����ڵ��±�
	* @param element
	* @return
	 */
	public int find(T element){
		for(int i=0;i<size;i++)
			if(data[i].equals(element))
				return i;
		return -1;
	}
	
	/**
	 * ��indexλ�����Ԫ��
	 * ʱ�临�Ӷ�o(n-i)
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index >= data.length)
			throw new IllegalArgumentException("index is illegal");
		
		//���鱥����
		if(size==data.length)
			resize(2 * data.length);
			
		
		//��index�Ժ��Ԫ�ض�����ƶ�һ��λ��
		for(int i=size-1;i>=index;i--){
			data[i+1] = data[i];
		}
		
		//���ó�����λ�÷��϶�Ӧ��Ԫ��
		data[index] = element;
		size++;
	}
	
	//ʱ�临�Ӷ�o(n)
	public void addFirst(T element){
		add(0,element);
	}
	
	//ʱ�临�Ӷ�o(1)
	public void addLast(T element){
		add(size,element);
	}
	
	/**
	 * ɾ��indexλ�õ�Ԫ��
	 * ʱ�临�Ӷ�o(n-i)
	* @param index
	* @return
	 */
	public T remove(int index){
		if(index < 0 || index >= data.length)
			throw new IllegalArgumentException("index is illegal");
		
		T ret = get(index);
		//��Ҫ�����Ԫ����ǰ�ƶ�������Ҫɾ����Ԫ��
		for(int i=index;i<size;i++){
			data[i] = data[i+1];
		}
		size--;
		//�������ݣ�����ռ���˷�,����ʽ
		if(size < data.length/4 && data.length / 2 >= 10)
			resize(data.length / 2);
		return ret;
	}
	
	//ʱ�临�Ӷ�o(n)
	public T removeFirst(){
		return remove(0);
	}
	
	//ʱ�临�Ӷ�o(1)
	public T removeLast(){
		return remove(size-1);
	}
	
	/**
	 * ɾ��ĳ��Ԫ��
	* @param element
	 */
	public void removeElement(T element){
		int index = find(element);
		if(index != -1)
			remove(index);
	}
	
	/**
	 * �޸�ĳ��λ�õ�Ԫ��
	 * ʱ�临�Ӷ�o(1)
	* @param index
	* @param element
	* @return
	 */
	public void set(int index,T element){
		if(index < 0 || index >= data.length)
			throw new IllegalArgumentException("index is illegal");
		
		data[index] = element;
	}
	
	
	
	/**
	 * �������ݻ�����
	* @param newCapacity
	 */
	private void resize(int newCapacity){
		T[] newData = (T[]) new Object[newCapacity];
		System.arraycopy(data, 0, newData, 0, size);
		data = newData;
	}
}
