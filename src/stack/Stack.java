package stack;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * �����ɾ��������ֻ����ջ��
 */
public interface Stack<T> {
	/**
	 * ��ջ
	 */
	void push(T element);
	/**
	 * ��ջ
	* @return
	 */
	T pop();
	/**
	 * �鿴ջ��Ԫ��
	* @return
	 */
	T peek();
	boolean isEmpty();
	int getSize();
}
