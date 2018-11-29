package graph;

import java.util.Stack;

/**
 * @Author yukai
 * @Date 2018��11��29��
 * �ڽӱ�ʵ��
 * �ؼ�·���㷨
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
	 * �������緢��ʱ��
	* @param etv ���緢��ʱ������
	* @param stack2 ����Ļջ
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
			//�ѵ����Ķ���ѹ��
			stack2.push(index);
			
			for(Edge edge = vertexs[index].firstEdge;edge.next != null;edge = edge.next){
				vertexs[edge.index].in--;
				if(vertexs[edge.index].in==0){
					stack.push(edge.index);
				}

				//�������緢��ʱ��Ĺ�ʽ�����л���ȡ���ֵ
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
	 * �ؼ�·���㷨
	 * ������ʱ��=���緢��ʱ�� �ö���Ϊ�ؼ������·��Ϊ�ؼ�·��
	 */
	public void criticalPath(){
		//����ʱ������
		int[] etv = new int[vertexNum];
		//����ʱ�����飬Ҫ��n-1�Ķ��㿪ʼ��������Ҫstack2�����
		int[] ltv = new int[vertexNum];
		Stack<Integer> stack2 = new Stack<>();
		int ete,lte;
	
		//�����������򣬻��etv��stack2
		topo(etv, stack2);
		
		//��ʼ��ltv����,Ϊ���һ����ķ���ʱ��
		for(int i=0;i<vertexNum;i++){
			ltv[i] = etv[vertexNum-1];
		}
		
		//��ÿ�����������ʱ��
		while(!stack2.isEmpty()){
			int index = stack2.pop();
			//������������ʱ��Ĺ�ʽ�����л���ȥ��Сֵ
			for(Edge edge = vertexs[index].firstEdge;edge.next != null;edge = edge.next){
				if(ltv[edge.index] - edge.weight < ltv[index]){
					ltv[index] = ltv[edge.index] - edge.weight;
				}
			}
		}
		
		
		for(int j=0;j<vertexNum;j++){
			for(Edge edge = vertexs[j].firstEdge;edge.next != null;edge = edge.next){
				ete = etv[j];//���ÿ����������緢��ʱ��
				lte = ltv[edge.index] - edge.weight;//���ÿ�������������ʱ��
				if(ete == lte){
					System.out.println("<v"+vertexs[j].data+",v"+vertexs[edge.index].data+"> length:"+edge.weight+"");
				}
			}
		}
 	}
}
