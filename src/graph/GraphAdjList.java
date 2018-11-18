package graph;

/**
 * @Author yukai
 * @Date 2018年11月18日
 * 邻接表实现无向图
 * 数组+链表
 * 创建图的时间复杂度为o(n)
 */
public class GraphAdjList {

	/**
	 * 链表类，用于存储邻接点
	 * @Author yukai
	 * @Date 2018年11月18日
	 */
	private class EdgeNode{
		//第一个顶点就代表值
		private int data;
		//邻接点所在下标
		private int index;
		/*//权值
		private int weight;*/
		//下个邻接点
		private EdgeNode next;
		
		public EdgeNode(int data,int index,EdgeNode next){
			this.data = data;
			this.next = next;
			this.index = index;
		}
		
		public EdgeNode(int data,int index){
			this(data,index,null);
		}
	}
	
	private EdgeNode[] nodes;
	//边
	private int size;
	
	public GraphAdjList(int[] element){
		nodes = new EdgeNode[element.length];
		//初始化图
		for(int i=0;i<nodes.length;i++)
			nodes[i] = new EdgeNode(element[i],i);
	}
	
	private int getIndex(int e){
		for(int i=0;i<size;i++)
			if(nodes[i].data == e)
				return i;
		return -1;
	}
	
	/**
	 * 时间复杂度o(n)
	* @param e1
	* @param e2
	 */
	public void connection(int e1,int e2){
		int index1 = getIndex(e1);
		int index2 = getIndex(e2);
		if(index1 != -1 && index2 != -1){
			//头插入，时间复杂度o(1)
			nodes[index1].next = new EdgeNode(e1,index1,nodes[index1].next);
			nodes[index2].next = new EdgeNode(e2,index2,nodes[index2].next);
			size++;
		}
	}
}
