package graph;

/**
 * @Author yukai
 * @Date 2018��11��18��
 * �ڽӱ�ʵ������ͼ
 * ����+����
 * ����ͼ��ʱ�临�Ӷ�Ϊo(n)
 */
public class GraphAdjList {

	/**
	 * �����࣬���ڴ洢�ڽӵ�
	 * @Author yukai
	 * @Date 2018��11��18��
	 */
	private class EdgeNode{
		//��һ������ʹ���ֵ
		private int data;
		//�ڽӵ������±�
		private int index;
		/*//Ȩֵ
		private int weight;*/
		//�¸��ڽӵ�
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
	//��
	private int size;
	
	public GraphAdjList(int[] element){
		nodes = new EdgeNode[element.length];
		//��ʼ��ͼ
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
	 * ʱ�临�Ӷ�o(n)
	* @param e1
	* @param e2
	 */
	public void connection(int e1,int e2){
		int index1 = getIndex(e1);
		int index2 = getIndex(e2);
		if(index1 != -1 && index2 != -1){
			//ͷ���룬ʱ�临�Ӷ�o(1)
			nodes[index1].next = new EdgeNode(e1,index1,nodes[index1].next);
			nodes[index2].next = new EdgeNode(e2,index2,nodes[index2].next);
			size++;
		}
	}
}
