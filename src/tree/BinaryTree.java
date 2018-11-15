package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author yukai
 * @Date 2018年11月15日
 * 二叉树
 * 前中后序遍历：指的是访问当前节点的位置，每个节点都会被访问3次，哪一次的访问是对应遍历规定的顺序就可以操作该节点（前：第一次，中：第二次,后：第三次）
 * 已知前序遍历和中序遍历的结果，可以唯一确定一颗二叉树
 * 已知后序遍历和中序遍历的结果，可以唯一确定一颗二叉树
 * 前序遍历结果中：第一个为根节点，第二个为根节点的左孩子，除去左子树的结果，离根节点最近的为右子树
 * 中序遍历：根节点前面的都为左子树，根节点后面的都为右子树，升序排列
 * 后续遍历：最后一个节点为根节点，倒数第一个节点为右子树，除去右子树之外的结果中离根节点最近的为左子树
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
		//递归
		preOrder(root);
		//非递归
		preOrder1(root);
	}
	
	/**
	 * 前序遍历
	 * 根左右
	* @param node
	 */
	private void preOrder(Node node){
		if(node==null)
			return;
		//也可以是对其他节点的操作
		System.out.println(node.element);
		//再访问左节点
		preOrder(node.left);
		//访问右节点
		preOrder(node.right);
	}
	
	
	
	/**
	 * 前序遍历
	 * 非递归实现
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
	 * 中序遍历
	 * 左根右
	 */
	public void inOrder(){
		inOrder(root);
	}
	
	private void inOrder(Node node){
		if(node == null)
			return;
		//先访问左节点
		inOrder(node.left);
		//访问自己
		System.out.println(node.element);
		//访问右节点
		inOrder(node.right);
	}
	
	/**
	 * 后序遍历
	 * 左右根
	 */
	public void postOrder(){
		postOrder(root);
	}
	
	private void postOrder(Node node){
		if(node == null)
			return;
		//先访问左节点
		postOrder(node.left);
		//再访问右节点
		postOrder(node.right);
		//最后访问自己
		System.out.println(node.element);
	}
	
	/**
	 * 层序遍历
	 *使用队列实现
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
