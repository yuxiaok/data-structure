package linked;

/**
 * @Author yukai
 * @Date 2018��11��9��
 * ��̬����
 * �����û��ָ��ʵ�ֵĸ߼��������
 */
public class StaticLinkedList {

	private class Node{
		//������
		private int data;
		//��һ���ڵ����ڵ��±꣬�൱��ָ����
		private int cur;
		
		public Node(int data,int cur){
			this.data = data;
			this.cur = cur;
		}
	}
	
	//����Ĵ�С
	private static final int MAX_SIZE = 1000;
	private Node[] nodes;
	private int size;
	
	public StaticLinkedList(){
		nodes = new Node[MAX_SIZE];
		size = 0;
		//ÿһ���ڵ㶼ָ����һ���ڵ�
		for(int i=1;i<nodes.length;i++)
			nodes[i].cur = i+1;
		//nodes[0].cur��Զ���ڼ�¼��һ�����е�λ�õ��±�
		nodes[0].cur = 1;
		//nodes[999].cur��Զ���ڼ�¼��һ������Ľڵ���±�,�൱��ͷ���
		nodes[999].cur = 0;
	}
	
	public int getSize(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	/**
	 * ���ڻ�ȡ��һ������λ�õ��±�
	* @return
	 */
	private int getFreeIndex(){
		int j = nodes[0].cur;
		//�����Ƿ�����
		if(j != MAX_SIZE-1){
			//��¼��һ�����нڵ���±�
			nodes[0].cur = nodes[j].cur;
			return j;
		}
		return -1;	
	}
	
	/**
	 * ������λ�����Ԫ��
	 * �߼����Ƕ�Ӧ��λ�ã�������ʵ�ʲ���
	* @param data
	* @param index
	 */
	public void add(int data,int index){
		if(index < 1 || index > size+1)
			throw new IllegalArgumentException("index is illegal");
		
		int free = getFreeIndex();
		if(free != -1){
			//�����ݷ������λ��
			nodes[free].data = data;
			
			//��ȡ��һ���ڵ�
			int k = nodes[MAX_SIZE-1].cur;
			//�ҵ�Ҫ���λ�õ�ǰһ��Ԫ�����ڵ��±�
			for(int i=1;i<index;i++)
				k = nodes[k].cur;
			
			//�ýڵ����һ���ڵ�ΪҪ���λ�õĽڵ���±�
			nodes[free].cur = nodes[k].cur;
			//��ǰһ���ڵ�ָ������ӵĽڵ�
			nodes[k].cur = free;
			size++;
			
			//ά�����һ����Ԫ�ؽڵ��curΪ0
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
	 * ɾ������λ�õĽڵ�
	* @param index
	* @return
	 */
	public int remove(int index){
		if(index < 1 || index > size+1)
			throw new IllegalArgumentException("index is illegal");
		
		//Ҫɾ���ڵ����һ���ڵ�
		int k = nodes[MAX_SIZE-1].cur;
		
		for(int i=1;i<index;i++)
			k = nodes[k].cur;
		
		//Ҫɾ���Ľڵ��±�
		int removeCur = nodes[k].cur;
		
		nodes[k].cur = nodes[removeCur].cur;
		
		//���¿��нڵ��б�	
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
