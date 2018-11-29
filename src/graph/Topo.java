package graph;

import java.util.Stack;

import javax.sound.midi.Soundbank;

/**
 * @Author yukai
 * @Date 2018��11��28��
 * �ڽӾ���ʵ����������
 */
public class Topo<T> {

	private class Vertex{
		//������
		private T data;
		//�����
		private int in;
		//��һ���ڽӵ�
		private Edge firstEdge;
		
		public Vertex(T data,int in,Edge firstEdge){
			this.data = data;
			this.in = in;
			this.firstEdge = firstEdge;
		}
	}
	
	private class Edge{
		//�ڽӵ���±�
		private int index;
		//�ڽӵ��Ȩ��
		private int weight;
		//��һ���ڽӵ�
		private Edge next;
		
		public Edge(int index,int weight,Edge next){
			this.index = index;
			this.weight = weight;
			this.next = next;
		}
	}
	
	private Vertex[] vertexs;
	private int num,size;//�����������ߵ���Ŀ
	
	/**
	 * ��������
	 * ʱ�临�Ӷ�Ϊo(n+e)
	* @return
	 */
	public boolean topoSort(){
		//��¼�����Ķ��������
		int count = 0;
		//��ջ���Ϊ0�Ķ���
		Stack<Integer> stack = new Stack();
		//��ʼ��ջ
		for(int i=0;i<num;i++){
			if(vertexs[i].in == 0)
				stack.push(i);
		}
		
		while(!stack.isEmpty()){
			int index = stack.pop();
			System.out.println(index+"->");
			//���ӳ�ջ�Ķ���
			count++;
			//��ȡ�ö�����ڽӵ㣬��Ϊ������ͼ�����Բ�����ջͬһ�����㣬ԭ����0����Ϊ-1��
			for(Edge edge = vertexs[index].firstEdge;edge.next != null;edge = edge.next){
				//���ö�����ڽӵ����ȶ���1
				vertexs[edge.index].in--;
				//������ּ���֮�����ҲΪ0������ջ 
				if(vertexs[edge.index].in==0)
					stack.push(edge.index);
			}
		}
		
		//��������Ķ�����ĿС��ӵ�еĶ��㣬��˵���γ��˻ػ�
		if(count<num)
			return false;
		return true;
	}
}
