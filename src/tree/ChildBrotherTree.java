package tree;

/**
 * @Author yukai
 * @Date 2018��11��14��
 * ˳��洢�ṹ
 * �����ֵܱ�ʾ��
 * ����ÿһ���ڵ㣬������ں��ӽڵ㣬���һ�����ӽڵ���Ψһ�ģ��������ֵ�������ڣ�Ҳ��Ψһ�ġ�
 */
public class ChildBrotherTree<T> {

	private class Node{
		private T data;
		//��һ�����ӽڵ㣬���ֵܽڵ�
		private Node firstChild,rightBro;
	}
	
	//�洢ÿ���ڵ�
	private Node[] nodes;
}
