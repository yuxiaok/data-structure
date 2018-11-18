package graph;

/**
 * @Author yukai
 * @Date 2018年11月18日
 * 邻接矩阵实现无向图
 * 创建图的时间复杂度为O(n2)
 */
public class MGraph<T> {

	//用于存储顶点
	private T[] vertex;
	//用于存储边(两个顶点的值为true)
	private boolean[][] edge;
	//顶点的数目
	private int size;
	//边的数目
	private int num;
	
	public MGraph(int capacity){
		vertex = (T[]) new Object[capacity];
		//如果边比较少，就会浪费很多存储空间
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
	 * 添加一个顶点
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
	 * 连接两个顶点
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
