package graph;

/**
 * @Author yukai
 * @Date 2018年11月20日
 * 邻接矩阵实现Prim算法
 */
public class MGraphPrim {
	private int[] vertex;
	private int[][] edge;
	private int size;
	//代表没有连接
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
	 * Prim算法对于稠密图有优势，也就是适用于邻接矩阵
	 */
	public void prim(){
		//保存顶点间的权值，用于记录最小生成树，等于0就纳入最小生成树了
		int[] lowcost = new int[vertex.length];
		//下标的值对应于与其连接的上一个顶点的值
		int[] adjvex = new int[vertex.length];
		//初始化该数组为第一个顶点与其他所有顶点的权值
		lowcost[0] = 0;
		adjvex[0] = 0;
		for(int i=1;i<vertex.length;i++){
			//录入所有顶点的权值
			lowcost[i] = edge[0][i];
			//所有下标对应上一个顶点的值
			adjvex[i] = 0;
		}
			
		//每一次找到一条线，所以需要n-1条线
		for(int i=1;i<vertex.length;i++){
			//记录与此顶点连接的权值最小的顶点
			int min = MAX;
			int j=1,k=0;
			//一直遍历，找到与此顶点连接的权值最小的顶点的权值和下标
			while(j<vertex.length){
				//等于0就意味着已经纳入最小生成树了
				if(lowcost[j] != 0 && lowcost[j]<min){
					min = lowcost[j];
					k = j;
				}
				j++;
			}
			
			System.out.println(adjvex[k]+"---->"+k);
			
			//将该点纳入最小生成树
			lowcost[k] = 0;
			//将于该点连接的顶点的权值纳入数组
			for(j=1;j<vertex.length;j++){
				//必须只更新比其小的值，相当于每次都找到最小的权值
				if(lowcost[j] !=0 && edge[k][j] < lowcost[j]){
					lowcost[j] = edge[k][j];
					//记录顶点的上一个顶点
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
