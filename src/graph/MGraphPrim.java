package graph;

/**
 * @Author yukai
 * @Date 2018��11��20��
 * �ڽӾ���ʵ��Prim�㷨
 */
public class MGraphPrim {
	private int[] vertex;
	private int[][] edge;
	private int size;
	private int num;
	//����û������
	private static final int MAX = 65533;
	
	public MGraphPrim(int capacity){
		vertex = new int[capacity];
		edge = new int[capacity][capacity];
		for(int i=0;i<capacity;i++)
			for(int j=0;j<capacity;j++)
				edge[i][j] = MAX;
		
		size = 0;
		num = 0;
	}
	
	public void add(int v){
		vertex[size] = v; 
	}
	
	
	public void connection(int v1,int v2,int weight){
		edge[v1][v2] = weight;
		edge[v2][v1] = weight;
		num++;
	}
	
	/**
	 * Prim�㷨���ڳ���ͼ�����ƣ������ڶ���
	 */
	public void prim(){
		//���涥����Ȩֵ�����ڼ�¼��С������������0��������С��������
		int[] lowcost = new int[vertex.length];
		//�±��ֵ��Ӧ���������ӵ���һ�������ֵ
		int[] adjvex = new int[vertex.length];
		//��ʼ��������Ϊ��һ���������������ж����Ȩֵ
		lowcost[0] = 0;
		adjvex[0] = 0;
		for(int i=1;i<vertex.length;i++){
			//¼�����ж����Ȩֵ
			lowcost[i] = edge[0][i];
			//�����±��Ӧ��һ�������ֵ
			adjvex[i] = 0;
		}
			
		//ÿһ���ҵ�һ���ߣ�������Ҫn-1����
		for(int i=1;i<vertex.length;i++){
			//��¼��˶������ӵ�Ȩֵ��С�Ķ���
			int min = MAX;
			int j=1,k=0;
			//һֱ�������ҵ���˶������ӵ�Ȩֵ��С�Ķ����Ȩֵ���±�
			while(j<vertex.length){
				//����0����ζ���Ѿ�������С��������
				if(lowcost[j] != 0 && lowcost[j]<min){
					min = lowcost[j];
					k = j;
				}
				j++;
			}
			
			System.out.println(adjvex[k]+"---->"+k);
			
			//���õ�������С������
			lowcost[k] = 0;
			//���ڸõ����ӵĶ����Ȩֵ��������
			for(j=1;j<vertex.length;j++){
				//����ֻ���±���С��ֵ���൱��ÿ�ζ��ҵ���С��Ȩֵ
				if(lowcost[j] !=0 && edge[k][j] < lowcost[j]){
					lowcost[j] = edge[k][j];
					//��¼�������һ������
					adjvex[j] = k;
				}
			}
		}
	}
	
	private class Node{
		private int begin;
		private int end;
		private int weight; 
	}
	
	/**
	 * kruskal����ڱ�
	 * �����еıߣ���һ������洢����Ȩֵ��С����
	 */
	public void kruskal(){
		//���еı�
		Node[] nodes = new Node[num];
		//��¼������С�������Ķ���
		int[] parent = new int[size];
		for(int i=0;i<size;i++)
			parent[i] = 0;
		
		//���ڽӾ���תΪnodes���飬������Ȩֵ�������У��˴�ʡ��
		
		for(int i=0;i<nodes.length;i++){
			//·�����ң����·�������һ������͵�һ��������ͬ��˵���γɻ���
			int n = Find(parent,nodes[i].begin);
			int m = Find(parent,nodes[i].end);
			//û���γɻ�
			if(n!=m){
				parent[n] = m;
				System.out.println(nodes[i].begin+"----->"+nodes[i].end);
			}
		}
	}
	/**
	 * ����ĳ�������Ƿ��Ѿ�������������
	* @param parent
	* @param index
	* @return
	 */
	private int Find(int[] parent,int index){
		while(parent[index]>0) 
			index = parent[index];
		return index;
	}
	
	/**
	 * Dijkstra�㷨��
	 * ���·��
	* @param v0 ��ĳ�����㿪ʼ
	 */
	public void dijkstra(int v0){
		//���ڴ洢��ĳ����������·������
		int[] d = new int[size];
		
		//���ڴ洢���·��p[i]��ʾǰ��������±�
		int[] p = new int[size];
		
		//���ڼ�¼ĳ�������ǹ��Ѿ����������·����0��1�ǣ�
		int[] f = new int[size];
		
		//��ʼ��
		for(int i=0;i<size;i++){
			f[i] = 0;//���ж��㶼û������
			d[i] = edge[v0][i];//����ö������ӵĶ����Ӧ��Ȩֵ
			p[i] = 0;//��ʾû��·��
		}
		
		//v0��v0·��Ϊ0
		d[v0] = 0;
		//v0�Ѿ�����
		f[v0] = 1;
		
		int min = MAX,k=-1;
		//��Ҫsize-1���ߣ����Դ�1��ʼѭ��
		for(int i=1;i<size;i++){
			//Ѱ�Ҿ���v0����Ķ���
			for(int j=0;j<size;j++){
				if(f[j] != 1 && d[j] < min){
					k = j;
					min = d[j];
				}
			}
			
			f[k] = 1;//�������·��
			for(int j=0;j<size;j++){
				//�������i�����·������������·���ĳ��ȶ�
				if(f[j] != 1 && min + edge[k][j] < d[j]){
					//˵���ҵ��˸��̵�·�����޸�
					d[j] = min + edge[k][j];
					p[j] = k;
				}
			}
		}
	}
	public static void main(String[] args){
		MGraphPrim m = new MGraphPrim(4);
		for(int i=0;i<4;i++)
			m.add(i);
		
		m.connection(0, 1, 2);
		m.connection(0, 2, 14);
		m.connection(0, 3, 1);
		m.connection(1, 2, 5);
		m.connection(2, 3, 8);
		
		m.prim();
	}
}
