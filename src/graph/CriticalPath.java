package graph;

import java.util.Stack;

/**
 * @Author yukai
 * @Date 2018年11月29日
 * 邻接表实现
 * 关键路径算法
 */
public class CriticalPath {

	private class Edge{
		private int index;
		private int weight;
		private Edge next;
		
		public Edge(int index,int weight,Edge next){
			this.index = index;
			this.weight = weight;
			this.next = next;
		}
	}
	
	private class Vertex{
		private int data;
		private int in;
		private Edge firstEdge;
		
		public Vertex(int data,int in,Edge firstEdge){
			this.data = data;
			this.in = in;
			this.firstEdge = firstEdge;
		}
		
	}
	
	private Vertex[] vertexs;
	private int vertexNum;
	private int edgeNum;

	/**
	 * 求活动的最早发生时间
	* @param etv 最早发生时间数组
	* @param stack2 倒序的活动栈
	* @return
	 */
	public boolean topo(int[] etv,Stack<Integer> stack2){
		
		int count = 0;
		
		Stack<Integer> stack = new Stack();
		for(int i=0;i<vertexNum;i++){
			if(vertexs[i].in==0){
				stack.push(i);
			}
		}
		
		for(int i=0;i<vertexNum;i++){
			etv[i] = 0;
		}
		
		
		while(!stack.isEmpty()){
			int index = stack.pop();
			count++;
			//把弹出的顶点压入
			stack2.push(index);
			
			for(Edge edge = vertexs[index].firstEdge;edge.next != null;edge = edge.next){
				vertexs[edge.index].in--;
				if(vertexs[edge.index].in==0){
					stack.push(edge.index);
				}

				//计算活动最早发生时间的公式，所有弧中取最大值
				if(etv[index]+edge.weight>etv[edge.index]){
					etv[edge.index] = etv[index] + edge.weight;
				}
					
			}
		}
		
		if(count < vertexNum)
			return false;
		return true;
	}
	
	/**
	 * 关键路径算法
	 * 最晚发生时间=最早发生时间 该顶点为关键活动，该路径为关键路径
	 */
	public void criticalPath(){
		//最早时间数组
		int[] etv = new int[vertexNum];
		//最晚时间数组，要从n-1的顶点开始，所以需要stack2的配合
		int[] ltv = new int[vertexNum];
		Stack<Integer> stack2 = new Stack<>();
		int ete,lte;
	
		//调用拓扑排序，获得etv和stack2
		topo(etv, stack2);
		
		//初始化ltv数组,为最后一个活动的发生时间
		for(int i=0;i<vertexNum;i++){
			ltv[i] = etv[vertexNum-1];
		}
		
		//求每个活动的最晚发生时间
		while(!stack2.isEmpty()){
			int index = stack2.pop();
			//倒序，求活动最晚发生时间的公式，所有弧中去最小值
			for(Edge edge = vertexs[index].firstEdge;edge.next != null;edge = edge.next){
				if(ltv[edge.index] - edge.weight < ltv[index]){
					ltv[index] = ltv[edge.index] - edge.weight;
				}
			}
		}
		
		
		for(int j=0;j<vertexNum;j++){
			for(Edge edge = vertexs[j].firstEdge;edge.next != null;edge = edge.next){
				ete = etv[j];//获得每个顶点的最早发生时间
				lte = ltv[edge.index] - edge.weight;//获得每个顶点的最晚发生时间
				if(ete == lte){
					System.out.println("<v"+vertexs[j].data+",v"+vertexs[edge.index].data+"> length:"+edge.weight+"");
				}
			}
		}
 	}
}
