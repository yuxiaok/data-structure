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
public class BinaryTree<T> {

	private class Node{
		private T element;
		private Node left,right;
		
		public Node(T element,Node left,Node right){
			this.element = element;
			this.left = left;
			this.right = right;
		}
		
		public Node(T element){
			this(element,null,null);
		}
	}
	
	private Node root;
	private int size;
	
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
			System.out.println(stack.pop().element);
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
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
}
