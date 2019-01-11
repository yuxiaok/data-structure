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
public class BinaryTree<T extends Comparable<T>> {

	private class Node{
		private T element;
		private Node left,right;
		//每个节点的高度
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
	 * 查找某个元素是否存在
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
	 * 获取某个节点的平衡因子
	* @param node
	* @return
	 */
	private int getBalanceFactor(Node node){
		return node.left.height-node.right.height;
	}
	
	/**
	 * 获取该节点的高度
	* @param node
	* @return
	 */
	private int getHeight(Node node){
		if(node==null)
			return 0;
		return node.height;
	}
	
	/**
	 * 对该节点进行右旋转，并返回新的根节点LL
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
	 * 对该节点进行左旋转，并返回新的根节点RR
	* @param node
	* @return
	 */
	private Node l_rotate(Node node){
		Node right = node.right;
		node.right = right.left;
		right.left = node;
		
		//更新高度
		right.height = 1 + Math.max(getHeight(right.left), getHeight(right.right));
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		return right;
	}
	
	public void add(T e){
		root = add(root,e);
	}
	
	private Node add(Node node,T e){
		//添加该节点，并返回给上一个节点链接
		if(node==null)
			return new Node(e);
		
		//去右子树查找
		if(e.compareTo(node.element) > 0)
			node.right = add(node.right,e);
		//去左子树查找
		else if(e.compareTo(node.element) < 0)
			node.left = add(node.left,e);
		//已经存在，则直接覆盖
		else
			node.element = e;
		
		//取左右子树最高的值+1
		node.height = 1 +Math.max(getHeight(node.left), getHeight(node.right));
		
		//获取该节点的平衡因子，判断是否非平衡二叉树
		int factor = getBalanceFactor(node);
		
		//旋转的方式
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
			
		
		//返回根节点
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
			//如果要删除的节点的 左子树为空,返回右节点，作为该子树的根节点
			if(node.right  != null){
				Node rightNode = node.right;
				node.right = null;
				size--;
				retNode =  rightNode;
			}//如果要删除的节点的右子树为空， 返回左节点
			else if(node.left != null){
				Node leftNode = node.left;
				node.left = null;
				size--;
				retNode =  leftNode;
			}else{
				//如果都不为空,Hirebard-delection
				//找到右子树中的最小值或者找到左子树中的最大值代替要删除的节点
				Node newNode = getMin(node.right);
				newNode.right = removeMin(node.right);	
				newNode.left = node.left;
				node.left = null;
				node.right = null;
				retNode =  newNode;
			}
			
		}
		
		//重新计算高度
		retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
		
		//计算平衡因子
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
	 * 删除某树中的最小值，并返回晓得根节点
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
	 * 获得某个子树中的 最小值
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
			Node retNode = stack.pop();
			System.out.println(retNode.element);
			if(retNode.right != null)
				stack.push(retNode.right);
			if(retNode.left != null)
				stack.push(retNode.left);
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
