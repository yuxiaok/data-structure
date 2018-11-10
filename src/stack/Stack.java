package stack;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 插入和删除操作都只能在栈顶
 */
public interface Stack<T> {
	/**
	 * 入栈
	 */
	void push(T element);
	/**
	 * 出栈
	* @return
	 */
	T pop();
	/**
	 * 查看栈顶元素
	* @return
	 */
	T peek();
	boolean isEmpty();
	int getSize();
}
