package tree;

/**
 * @Author yukai
 * @Date 2018��11��14��
 * ˳��洢�ṹ
 * ˫�ױ�ʾ���Ľṹ���
 * ֻ��֪�����׽ڵ���˭��ȷ�޷�֪�����ӽڵ��Լ��ֵܽڵ�
 */
public class ParentTree<T>{

	private class Node{
		//������
		private T data;
		//���׽ڵ����ڵ��±�
		int index;
	}
	
	private Node[] nodes;
	private int num;
	
}
