package graph;

/**
 * @Author yukai
 * @Date 2018��11��18��
 * �ڽӾ���ʵ������ͼ
 * ����ͼ��ʱ�临�Ӷ�ΪO(n2)
 */
public class MGraph<T> {

	//���ڴ洢����
	private T[] vertex;
	//���ڴ洢��(���������ֵΪtrue)
	private boolean[][] edge;
	//�������Ŀ
	private int size;
	//�ߵ���Ŀ
	private int num;
	
	public MGraph(int capacity){
		vertex = (T[]) new Object[capacity];
		//����߱Ƚ��٣��ͻ��˷Ѻܶ�洢�ռ�
		edge = new boolean[capacity][capacity];
		for(int i=0;i<capacity;i++)
			for(int j=0;j<capacity;j++)
				edge[i][j] = false;
		size = 0;
		num = 0;
	}
	
	public MGraph(){
		this(10);
	}
	
	/**
	 * ���һ������
	* @param element
	 */
	public void add(T element){
		vertex[size] = element;
		size++;
	}
	
	
	private int getIndex(T e){
		for(int i=0;i<size;i++){
			if(vertex[i].equals(e))
				return i;
		}
		return -1;
	}
	
	/**
	 * ������������
	* @param e1
	* @param e2
	 */
	public void connection(T e1,T e2){
		int index1=getIndex(e1);
		
		int index2=getIndex(e2);
		if(index1 != -1 && index2 != -1){
			edge[index1][index2] = true;
			edge[index2][index1] = true;
			num++;
		}	
	}
	
	
}
