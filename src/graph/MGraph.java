package graph;

import java.util.Stack;

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
	
	/**
	 * 深度优先遍历
	 * 相当于每次都找一个顶点开始，将这个顶点选择的一条路径上没有访问过的顶点全部访问，然后再从另一个顶点开始，知道所有的都被访问过
	 */
	public void DFSTraverse(){	
		//使用一个数组默认记录是否访问过，初始都没访问过，此下标与顶点数组的顶点下标一致
		boolean[] visited = new boolean[vertex.length];
		for(int i=0;i<vertex.length;i++){
			visited[i] = false;
		}
		
		//随便选取一个顶点开始遍历，这一步主要是针对有连通分量的，连通图只需要递归的部分即可
		for(int i=0;i<vertex.length;i++){
			if(!visited[i])
				DFS(visited,i);
		}
	}
	
	/**
	 * 图的深度优先遍历相当于树的前序遍历
	 * 递归实现
	* @param visited
	* @param index
	 */
	private void DFS(boolean[] visited,int index){
		//设置顶点访问过了
		visited[index] = true;
		//输出该顶点
		System.out.println(vertex[index]);
		//递归访问该顶点的邻接点
		for(int i=0;i<visited.length;i++)
			if(edge[index][i]==true && !visited[i])
				DFS(visited,i);
	}
	
	/**
	 * 非递归实现
	 */
	public void DFS2(){
		//标识是否访问过
		boolean[] visited = new boolean[vertex.length];
		for(int i=0;i<visited.length;i++)
			visited[i] = false;
			
		Stack<Integer> stack = new Stack();
		/*//针对有连通分量的
		for(int i=0;i<visited.length;i++)
			if(!visited[i])
				stack.push(i);*/
		//压入第一个顶点，默认访问
		stack.push(0);
		visited[0] = true;
		while(!stack.isEmpty()){
			int i=stack.pop();
			System.out.println(vertex[i]);
			
			//找到弹出元素的邻接点，并压入栈，压入就设置为访问过
			for(int j=0;j<visited.length;j++){
				if(edge[i][j]==true && !visited[j]){
					stack.push(j);
					visited[j] = true;
				}
					
			}
		}
	}
	
}
