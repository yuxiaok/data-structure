package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author yukai
 * @Date 2018��11��15��
 * ������
 * ǰ�к��������ָ���Ƿ��ʵ�ǰ�ڵ��λ�ã�ÿ���ڵ㶼�ᱻ����3�Σ���һ�εķ����Ƕ�Ӧ�����涨��˳��Ϳ��Բ����ýڵ㣨ǰ����һ�Σ��У��ڶ���,�󣺵����Σ�
 * ��֪ǰ���������������Ľ��������Ψһȷ��һ�Ŷ�����
 * ��֪�����������������Ľ��������Ψһȷ��һ�Ŷ�����
 * ǰ���������У���һ��Ϊ���ڵ㣬�ڶ���Ϊ���ڵ�����ӣ���ȥ�������Ľ��������ڵ������Ϊ������
 * ������������ڵ�ǰ��Ķ�Ϊ�����������ڵ����Ķ�Ϊ����������������
 * �������������һ���ڵ�Ϊ���ڵ㣬������һ���ڵ�Ϊ����������ȥ������֮��Ľ��������ڵ������Ϊ������
 */
public class BinaryTree<T extends Comparable<T>> {

	private class Node{
		private T element;
		private Node left,right;
		//ÿ���ڵ�ĸ߶�
		private int height;
		
		public Node(T element,Node left,Node right){
			this.element = element;
			this.left = left;
			this.right = right;
			this.height = 1;
		}
		
		public Node(T element){
			this(element,null,null);
		}
	}
	
	private Node root;
	private int size;
	
	
	/**
	 * ����ĳ��Ԫ���Ƿ����
	* @param e
	* @return
	 */
	public boolean find(T e){
		Node cur = root;
		while(cur != null){
			if(e.compareTo(cur.element)==0)
				return true;
			else if(e.compareTo(cur.element) > 0)
				cur = cur.right;
			else
				cur = cur.left;
		}
		return false;
	}
	/**
	 * ��ȡĳ���ڵ��ƽ������
	* @param node
	* @return
	 */
	private int getBalanceFactor(Node node){
		return node.left.height-node.right.height;
	}
	
	/**
	 * ��ȡ�ýڵ�ĸ߶�
	* @param node
	* @return
	 */
	private int getHeight(Node node){
		if(node==null)
			return 0;
		return node.height;
	}
	
	/**
	 * �Ըýڵ��������ת���������µĸ��ڵ�LL
	* @param node
	* @return
	 */
	private Node r_rotate(Node node){
		Node left = node.left;
		node.left = left.right;
		left.right = node;
		
		left.height = 1 + Math.max(getHeight(left.left), getHeight(left.right));
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		return left;
	}
	
	/**
	 * �Ըýڵ��������ת���������µĸ��ڵ�RR
	* @param node
	* @return
	 */
	private Node l_rotate(Node node){
		Node right = node.right;
		node.right = right.left;
		right.left = node;
		
		//���¸߶�
		right.height = 1 + Math.max(getHeight(right.left), getHeight(right.right));
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		return right;
	}
	
	public void add(T e){
		root = add(root,e);
	}
	
	private Node add(Node node,T e){
		//��Ӹýڵ㣬�����ظ���һ���ڵ�����
		if(node==null)
			return new Node(e);
		
		//ȥ����������
		if(e.compareTo(node.element) > 0)
			node.right = add(node.right,e);
		//ȥ����������
		else if(e.compareTo(node.element) < 0)
			node.left = add(node.left,e);
		//�Ѿ����ڣ���ֱ�Ӹ���
		else
			node.element = e;
		
		//ȡ����������ߵ�ֵ+1
		node.height = 1 +Math.max(getHeight(node.left), getHeight(node.right));
		
		//��ȡ�ýڵ��ƽ�����ӣ��ж��Ƿ��ƽ�������
		int factor = getBalanceFactor(node);
		
		//��ת�ķ�ʽ
		//LL
		if(factor>1 && getBalanceFactor(node.left) >= 0)
			return r_rotate(node);
		//RR
		if(factor<-1 && getBalanceFactor(node.right) < 0 )
			return l_rotate(node);
			
		//LR
		if(factor>1 && getBalanceFactor(node.left) <= 0){
			node.left = l_rotate(node.left);
			return r_rotate(node);
		}
			
		//RL
		if(factor<-1 && getBalanceFactor(node.right) >0){
			node.right = r_rotate(node.right);
			return l_rotate(node);
		}
			
		
		//���ظ��ڵ�
		return node;
		
	}
	
	public void remove(T e){
		root = remove(root,e);
	}
	
	private Node remove(Node node,T e){
		if(node == null)
			return null;
		
		Node retNode;
		if(e.compareTo(node.element) > 0){
			node.right = remove(node.right,e);
			retNode = node;
		}else if (e.compareTo(node.element) < 0){
			node.left =  remove(node.left,e);
			retNode =  node;
		}else{
			//���Ҫɾ���Ľڵ�� ������Ϊ��,�����ҽڵ㣬��Ϊ�������ĸ��ڵ�
			if(node.right  != null){
				Node rightNode = node.right;
				node.right = null;
				size--;
				retNode =  rightNode;
			}//���Ҫɾ���Ľڵ��������Ϊ�գ� ������ڵ�
			else if(node.left != null){
				Node leftNode = node.left;
				node.left = null;
				size--;
				retNode =  leftNode;
			}else{
				//�������Ϊ��,Hirebard-delection
				//�ҵ��������е���Сֵ�����ҵ��������е����ֵ����Ҫɾ���Ľڵ�
				Node newNode = getMin(node.right);
				newNode.right = removeMin(node.right);	
				newNode.left = node.left;
				node.left = null;
				node.right = null;
				retNode =  newNode;
			}
			
		}
		
		//���¼���߶�
		retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
		
		//����ƽ������
		int factor = getBalanceFactor(retNode);
		//LL
		if(factor > 1 && getBalanceFactor(retNode.left) >= 0)
			return r_rotate(retNode);
		//LR
		if(factor > 1 && getBalanceFactor(retNode.left) < 0){
			retNode.left = l_rotate(retNode.left);
			return r_rotate(retNode);
		}
			
		//RR
		if(factor < -1 && getBalanceFactor(retNode.right) <=0 )
			return l_rotate(retNode);
		//RL
		if(factor < -1 && getBalanceFactor(retNode.right) > 0){
			retNode.right = r_rotate(retNode.right);
			return l_rotate(retNode);
		}
		
		return retNode;
	}
	/**
	 * ɾ��ĳ���е���Сֵ�����������ø��ڵ�
	* @param node
	* @return
	 */
	private Node removeMin(Node node){
		if(node==null){
			return null;
		}
		if(node.left == null){
			Node retNode = node.right;
			size--;
			return retNode;
		}
		node.left = removeMin(node.left);
		return node;		
	}
	
	/**
	 * ���ĳ�������е� ��Сֵ
	* @param node
	* @return
	 */
	private Node getMin(Node node){
		if(node.left==null){
			return node;
		}
		return getMin(node.left);	
	}
	
	public void preOrder(){
		//�ݹ�
		preOrder(root);
		//�ǵݹ�
		preOrder1(root);
	}
	
	/**
	 * ǰ�����
	 * ������
	* @param node
	 */
	private void preOrder(Node node){
		if(node==null)
			return;
		//Ҳ�����Ƕ������ڵ�Ĳ���
		System.out.println(node.element);
		//�ٷ�����ڵ�
		preOrder(node.left);
		//�����ҽڵ�
		preOrder(node.right);
	}
	
	
	
	/**
	 * ǰ�����
	 * �ǵݹ�ʵ��
	* @param node
	 */
	public void preOrder1(Node node){
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);
		while(!stack.isEmpty()){
			Node retNode = stack.pop();
			System.out.println(retNode.element);
			if(retNode.right != null)
				stack.push(retNode.right);
			if(retNode.left != null)
				stack.push(retNode.left);
		}
	}
	
	
	/**
	 * �������
	 * �����
	 */
	public void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(Node node){
		if(node == null)
			return;
		//�ȷ�����ڵ�
		inOrder(node.left);
		//�����Լ�
		System.out.println(node.element);
		//�����ҽڵ�
		inOrder(node.right);
	}
	
	/**
	 * �������
	 * ���Ҹ�
	 */
	public void postOrder(){
		postOrder(root);
	}
	
	private void postOrder(Node node){
		if(node == null)
			return;
		//�ȷ�����ڵ�
		postOrder(node.left);
		//�ٷ����ҽڵ�
		postOrder(node.right);
		//�������Լ�
		System.out.println(node.element);
	}
	
	/**
	 * �������
	 *ʹ�ö���ʵ��
	 */
	public void levelOrder(){
		levelOrder(root);
	}
	
	private void levelOrder(Node node){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		while(queue.isEmpty()){
			System.out.println(queue.poll().element);
			queue.add(node.left);
			queue.add(node.right);
		}
	}
	
	
	public static void main(String[] args){
		int[] a = {62,88,58,47,35,73,51,99,37,93};
		BinaryTree<Integer> tree = new BinaryTree<>();
		
		for(int i=0;i<a.length;i++)
			tree.add(a[i]);
		
		tree.remove(62);
		tree.inOrder();
		
		System.out.println(tree.find(95));
	}
}
