package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * @Author yukai
 * @Date 2018��11��18�� �ڽӾ���ʵ������ͼ ����ͼ��ʱ�临�Ӷ�ΪO(n2)
 */
public class MGraph<T> {

	// ���ڴ洢����
	private T[] vertex;
	// ���ڴ洢��(���������ֵΪtrue)
	private boolean[][] edge;
	// �������Ŀ
	private int size;
	// �ߵ���Ŀ
	private int num;

	public MGraph(int capacity) {
		vertex = (T[]) new Object[capacity];
		// ����߱Ƚ��٣��ͻ��˷Ѻܶ�洢�ռ�
		edge = new boolean[capacity][capacity];
		for (int i = 0; i < capacity; i++)
			for (int j = 0; j < capacity; j++)
				edge[i][j] = false;
		size = 0;
		num = 0;
	}

	public MGraph() {
		this(10);
	}

	/**
	 * ���һ������
	 * 
	 * @param element
	 */
	public void add(T element) {
		vertex[size] = element;
		size++;
	}

	private int getIndex(T e) {
		for (int i = 0; i < size; i++) {
			if (vertex[i].equals(e))
				return i;
		}
		return -1;
	}

	/**
	 * ������������
	 * 
	 * @param e1
	 * @param e2
	 */
	public void connection(T e1, T e2) {
		int index1 = getIndex(e1);

		int index2 = getIndex(e2);
		if (index1 != -1 && index2 != -1) {
			edge[index1][index2] = true;
			edge[index2][index1] = true;
			num++;
		}
	}

	/**
	 * ������ȱ��� �൱��ÿ�ζ���һ�����㿪ʼ�����������ѡ���һ��·����û�з��ʹ��Ķ���ȫ�����ʣ�Ȼ���ٴ���һ�����㿪ʼ��֪�����еĶ������ʹ�
	 */
	public void DFSTraverse() {
		// ʹ��һ������Ĭ�ϼ�¼�Ƿ���ʹ�����ʼ��û���ʹ������±��붥������Ķ����±�һ��
		boolean[] visited = new boolean[vertex.length];
		for (int i = 0; i < vertex.length; i++) {
			visited[i] = false;
		}

		// ���ѡȡһ�����㿪ʼ��������һ����Ҫ���������ͨ�����ģ���ͨͼֻ��Ҫ�ݹ�Ĳ��ּ���
		for (int i = 0; i < vertex.length; i++) {
			if (!visited[i])
				DFS(visited, i);
		}
	}

	/**
	 * ͼ��������ȱ����൱������ǰ����� �ݹ�ʵ��
	 * 
	 * @param visited
	 * @param index
	 */
	private void DFS(boolean[] visited, int index) {
		// ���ö�����ʹ���
		visited[index] = true;
		// ����ö���
		System.out.println(vertex[index]);
		// �ݹ���ʸö�����ڽӵ�
		for (int i = 0; i < visited.length; i++)
			if (edge[index][i] == true && !visited[i])
				DFS(visited, i);
	}

	/**
	 * ��Ҳ��֪�������ɶ�����ˣ��Լ�д�ģ��о��������ȱ���
	 *//*
	public void DFS2() {
		// ��ʶ�Ƿ���ʹ�
		boolean[] visited = new boolean[vertex.length];
		for (int i = 0; i < visited.length; i++)
			visited[i] = false;

		Stack<Integer> stack = new Stack();
		// �������ͨ������
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				stack.push(i);
				while (!stack.isEmpty()) {
					int k = stack.pop();
					System.out.println(vertex[k]);

					// �ҵ�����Ԫ�ص��ڽӵ㣬��ѹ��ջ��ѹ�������Ϊ���ʹ�
					for (int j = 0; j < visited.length; j++) {
						if (edge[k][j] == true && !visited[j]) {
							stack.push(j);
							visited[j] = true;
						}

					}
				}
			}
		}
	}
*/
	/**
	 * ������ȱ���
	 * ���������Ĳ�α���
	 */
	public void BFSTraverse(){
		boolean[] visited = new boolean[vertex.length];
		for(int i=0;i<visited.length;i++)
			visited[i] = false;
		
		Queue<Integer> queue = new LinkedList<>();
		//�������ͨ����
		for(int i=0;i<vertex.length;i++){
			if(!visited[i]){
				visited[i] = true;
				System.err.println(vertex[i]);
				
				queue.add(i);
				
				while(!queue.isEmpty()){
					queue.poll();
					
					for(int j=0;j<vertex.length;j++){
						if(edge[i][j]==true && !visited[j]){
							visited[j] = true;
							System.err.println(vertex[j]);
							
							queue.add(j);
						}
					}
						
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		MGraph<Integer> m = new MGraph<>(100);
		for (int i = 0; i < 100; i++) {
			m.add(i);
		}

		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			m.connection(r.nextInt(49) + 50, r.nextInt(49));
		}

		m.DFSTraverse();
	}
}
