package tree;

/**
 * @Author yukai
 * @Date 2018��11��14��
 * ˳��洢�ṹ
 * ���ӱ�ʾ���ṹ
 */
public class ChildTree<T> {

	private class Node{
		private T data;
		//ָ��ýڵ㺢�ӽڵ������
		private Child child; 
	}
	
	//�ڵ�����
	private class Child{
		private T data;
		//���ӽڵ�
		private Child child;
	}
	
	//ÿ���ڵ�
	private Node[] nodes;
}
