package linked;

/**
 * @Author yukai
 * @Date 2018年11月7日
 * 静态链表
 * 顺序存储链表（物理地址是连续的）
 */
public class ArrayLinkedList<T> {
	/**
	 * 存储元素
	 */
	private T[] data;
	/**
	 * 元素个数
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
	 * 根据索引获取元素
	 * 时间复杂度o(1)，支持随机存取
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
	 * 是否包含某个元素
	 * 时间复杂度o(n)
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
	 * 查找某个元素所在的下标
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
	 * 在index位置添加元素
	 * 时间复杂度o(n-i)
	* @param index
	* @param element
	 */
	public void add(int index,T element){
		if(index < 0 || index >= data.length)
			throw new IllegalArgumentException("index is illegal");
		
		//数组饱和了
		if(size==data.length)
			resize(2 * data.length);
			
		
		//将index以后的元素都向后移动一个位置
		for(int i=size-1;i>=index;i--){
			data[i+1] = data[i];
		}
		
		//空置出来的位置放上对应的元素
		data[index] = element;
		size++;
	}
	
	//时间复杂度o(n)
	public void addFirst(T element){
		add(0,element);
	}
	
	//时间复杂度o(1)
	public void addLast(T element){
		add(size,element);
	}
	
	/**
	 * 删除index位置的元素
	 * 时间复杂度o(n-i)
	* @param index
	* @return
	 */
	public T remove(int index){
		if(index < 0 || index >= data.length)
			throw new IllegalArgumentException("index is illegal");
		
		T ret = get(index);
		//将要后面的元素向前移动，覆盖要删除的元素
		for(int i=index;i<size;i++){
			data[i] = data[i+1];
		}
		size--;
		//进行缩容，避免空间的浪费,懒汉式
		if(size < data.length/4 && data.length / 2 >= 10)
			resize(data.length / 2);
		return ret;
	}
	
	//时间复杂度o(n)
	public T removeFirst(){
		return remove(0);
	}
	
	//时间复杂度o(1)
	public T removeLast(){
		return remove(size-1);
	}
	
	/**
	 * 删除某个元素
	* @param element
	 */
	public void removeElement(T element){
		int index = find(element);
		if(index != -1)
			remove(index);
	}
	
	/**
	 * 修改某个位置的元素
	 * 时间复杂度o(1)
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
	 * 数组扩容或缩容
	* @param newCapacity
	 */
	private void resize(int newCapacity){
		T[] newData = (T[]) new Object[newCapacity];
		System.arraycopy(data, 0, newData, 0, size);
		data = newData;
	}
}
