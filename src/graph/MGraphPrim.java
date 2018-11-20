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
	//����û������
	private static final int MAX = 65533;
	
	public MGraphPrim(int capacity){
		vertex = new int[capacity];
		edge = new int[capacity][capacity];
		for(int i=0;i<capacity;i++)
			for(int j=0;j<capacity;j++)
				edge[i][j] = MAX;
		
		size = 0;
	}
	
	public void add(int v){
		vertex[size] = v; 
	}
	
	
	public void connection(int v1,int v2,int weight){
		edge[v1][v2] = weight;
		edge[v2][v1] = weight;
	}
	
	/**
	 * Prim�㷨���ڳ���ͼ�����ƣ�Ҳ�����������ڽӾ���
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