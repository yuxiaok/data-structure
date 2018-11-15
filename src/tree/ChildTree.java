package tree;

/**
 * @Author yukai
 * @Date 2018年11月14日
 * 顺序存储结构
 * 孩子表示法结构
 */
public class ChildTree<T> {

	private class Node{
		private T data;
		//指向该节点孩子节点的链表
		private Child child; 
	}
	
	//节点链表
	private class Child{
		private T data;
		//孩子节点
		private Child child;
	}
	
	//每个节点
	private Node[] nodes;
}
