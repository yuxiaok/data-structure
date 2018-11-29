package graph;

import java.util.Stack;

import javax.sound.midi.Soundbank;

/**
 * @Author yukai
 * @Date 2018年11月28日
 * 邻接矩阵实现拓扑排序
 */
public class Topo<T> {

	private class Vertex{
		//数据域
		private T data;
		//入度域
		private int in;
		//第一个邻接点
		private Edge firstEdge;
		
		public Vertex(T data,int in,Edge firstEdge){
			this.data = data;
			this.in = in;
			this.firstEdge = firstEdge;
		}
	}
	
	private class Edge{
		//邻接点的下标
		private int index;
		//邻接点的权重
		private int weight;
		//下一个邻接点
		private Edge next;
		
		public Edge(int index,int weight,Edge next){
			this.index = index;
			this.weight = weight;
			this.next = next;
		}
	}
	
	private Vertex[] vertexs;
	private int num,size;//顶点数量，边的数目
	
	/**
	 * 拓扑排序
	 * 时间复杂度为o(n+e)
	* @return
	 */
	public boolean topoSort(){
		//记录弹出的顶点的数量
		int count = 0;
		//入栈入度为0的顶点
		Stack<Integer> stack = new Stack();
		//初始化栈
		for(int i=0;i<num;i++){
			if(vertexs[i].in == 0)
				stack.push(i);
		}
		
		while(!stack.isEmpty()){
			int index = stack.pop();
			System.out.println(index+"->");
			//增加出栈的顶点
			count++;
			//获取该顶点的邻接点，因为是有向图，所以不会入栈同一个顶点，原本的0都减为-1了
			for(Edge edge = vertexs[index].firstEdge;edge.next != null;edge = edge.next){
				//将该顶点的邻接点的入度都减1
				vertexs[edge.index].in--;
				//如果发现减完之后入度也为0，则入栈 
				if(vertexs[edge.index].in==0)
					stack.push(edge.index);
			}
		}
		
		//如果弹出的顶点数目小于拥有的顶点，则说明形成了回环
		if(count<num)
			return false;
		return true;
	}
}
