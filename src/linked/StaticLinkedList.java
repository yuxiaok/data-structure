package linked;

/**
 * @Author yukai
 * @Date 2018年11月9日
 * 静态链表
 * 针对于没有指针实现的高级编程语言
 */
public class StaticLinkedList {

	private class Node{
		//数据域
		private int data;
		//下一个节点所在的下标，相当于指针域
		private int cur;
		
		public Node(int data,int cur){
			this.data = data;
			this.cur = cur;
		}
	}
	
	//数组的大小
	private static final int MAX_SIZE = 1000;
	private Node[] nodes;
	private int size;
	
	public StaticLinkedList(){
		nodes = new Node[MAX_SIZE];
		size = 0;
		//每一个节点都指向下一个节点
		for(int i=1;i<nodes.length;i++)
			nodes[i].cur = i+1;
		//nodes[0].cur永远用于记录第一个空闲的位置的下标
		nodes[0].cur = 1;
		//nodes[999].cur永远用于记录第一个插入的节点的下标,相当于头结点
		nodes[999].cur = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * 用于获取第一个空闲位置的下标
	* @return
	 */
	private int getFreeIndex(){
		int j = nodes[0].cur;
		//数组是否满了
		if(j != MAX_SIZE-1){
			//记录下一个空闲节点的下标
			nodes[0].cur = nodes[j].cur;
			return j;
		}
		return -1;	
	}
	
	/**
	 * 向任意位置添加元素
	 * 逻辑上是对应的位置，物理上实际不是
	* @param data
	* @param index
	 */
	public void add(int data,int index){
		if(index < 1 || index > size+1)
			throw new IllegalArgumentException("index is illegal");
		
		int free = getFreeIndex();
		if(free != -1){
			//将数据放入空闲位置
			nodes[free].data = data;
			
			//获取第一个节点
			int k = nodes[MAX_SIZE-1].cur;
			//找到要添加位置的前一个元素所在的下标
			for(int i=1;i<index;i++)
				k = nodes[k].cur;
			
			//该节点的下一个节点为要添加位置的节点的下标
			nodes[free].cur = nodes[k].cur;
			//让前一个节点指向新添加的节点
			nodes[k].cur = free;
			size++;
			
			//维护最后一个有元素节点的cur为0
			for(int i=1;i<size;i++)
				k = nodes[k].cur;
			nodes[k].cur = 0;
		}else
			System.out.println("Array is full");
		
	}
	
	public void addFirst(int data){
		add(data,1);
	}
	
	public void addLast(int data){
		add(data,size+1);
	}
	
	/**
	 * 删除任意位置的节点
	* @param index
	* @return
	 */
	public int remove(int index){
		if(index < 1 || index > size+1)
			throw new IllegalArgumentException("index is illegal");
		
		//要删除节点的上一个节点
		int k = nodes[MAX_SIZE-1].cur;
		
		for(int i=1;i<index;i++)
			k = nodes[k].cur;
		
		//要删除的节点下标
		int removeCur = nodes[k].cur;
		
		nodes[k].cur = nodes[removeCur].cur;
		
		//更新空闲节点列表	
		nodes[removeCur].cur = nodes[0].cur;
		nodes[0].cur = removeCur;
		
		return nodes[removeCur].data;
	}
	
	public int removeFirst(){
		return remove(1);
	}
	
	public int removeLast(){
		return remove(size);
	}
	
	
}
