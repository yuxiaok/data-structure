package tree;

/**
 * @Author yukai
 * @Date 2018年11月14日
 * 顺序存储结构
 * 孩子兄弟表示法
 * 对于每一个节点，如果存在孩子节点，其第一个孩子节点是唯一的，它的有兄弟如果存在，也是唯一的。
 */
public class ChildBrotherTree<T> {

	private class Node{
		private T data;
		//第一个孩子节点，右兄弟节点
		private Node firstChild,rightBro;
	}
	
	//存储每个节点
	private Node[] nodes;
}
