package stack;

/**
 * @Author yukai
 * @Date 2018年11月10日
 * 费伯拉切数列
 * 递归实现栈实现：
 * 简单的说，就是在前行阶段，对于每一层递归，函数的局部变量，参数值以及返回地址都被压入栈中。
 * 在退回阶段，位于栈顶的局部变量，参数值和返回地址被弹出，用于返回调用层次中执行代码的其余部分。
 */
public class Recursion {

	/**
	 * 递归实现
	* @param i
	* @return
	 */
	public int fbi(int i){
		if(i<2)
			return i;
		return fbi(i-1)+fbi(i-2);
	}
	
	public static void main(String[] args){
		//非递归实现
		int[] nums = new int[40];
		nums[0] = 0;
		nums[1] = 1;
		for(int i=2;i<40;i++){
			nums[i] = nums[i-1] + nums[i-2];
			System.out.println(nums[i]);
		}
			
	}
}
