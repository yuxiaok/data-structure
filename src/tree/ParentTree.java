package tree;

/**
 * @Author yukai
 * @Date 2018年11月14日
 * 顺序存储结构
 * 双亲表示法的结构设计
 * 只能知晓父亲节点是谁，确无法知道孩子节点以及兄弟节点
 */
public class ParentTree<T>{

	private class Node{
		//数据域
		private T data;
		//父亲节点所在的下标
		int index;
	}
	
	private Node[] nodes;
	private int num;
	
}
