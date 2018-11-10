package stack;

/**
 * @Author yukai
 * @Date 2018��11��10��
 * �Ѳ���������
 * �ݹ�ʵ��ջʵ�֣�
 * �򵥵�˵��������ǰ�н׶Σ�����ÿһ��ݹ飬�����ľֲ�����������ֵ�Լ����ص�ַ����ѹ��ջ�С�
 * ���˻ؽ׶Σ�λ��ջ���ľֲ�����������ֵ�ͷ��ص�ַ�����������ڷ��ص��ò����ִ�д�������ಿ�֡�
 */
public class Recursion {

	/**
	 * �ݹ�ʵ��
	* @param i
	* @return
	 */
	public int fbi(int i){
		if(i<2)
			return i;
		return fbi(i-1)+fbi(i-2);
	}
	
	public static void main(String[] args){
		//�ǵݹ�ʵ��
		int[] nums = new int[40];
		nums[0] = 0;
		nums[1] = 1;
		for(int i=2;i<40;i++){
			nums[i] = nums[i-1] + nums[i-2];
			System.out.println(nums[i]);
		}
			
	}
}
