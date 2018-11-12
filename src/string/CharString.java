package string;

import java.util.Arrays;

/**
 * @Author yukai
 * @Date 2018��11��12��
 * ��
 */
public class CharString {

	private char[] arr;
	
	public CharString(String str){
		arr = new char[str.length()];
		for(int i=0;i<str.length();i++)
			arr[i] = str.charAt(i);
	}
	
	public CharString(char[] arr){
		this.arr = arr;
	}
	
	/**
	 * �����ַ����ĳ���
	* @return
	 */
	public int length(){
		return arr.length;
	}
	
	/**
	 * �ַ����Ƿ�Ϊ��
	* @return
	 */
	public boolean isEmpty(){
		return arr.length == 0;
	}
	
	
	/**
	 * ���ض�Ӧ�±���ַ���
	* @return
	 */
	public char charAt(int index){
		if(index <=0 || index > arr.length)
			throw new IllegalArgumentException("index is illegal");
		return arr[index];
	}
	
	
	/**
	 * Ĭ�Ϸ��ص�һ�γ��ָ��ַ������±�
	* @param c
	* @return
	 */
	public int indexOf(char c){
		for(int i=0;i<arr.length;i++)
			if(arr[i]==c)
				return i;
		return -1;
	}
	
	/**
	 * �����ַ������滻
	* @param oldC
	* @param newC
	* @return
	 */
	public CharString replace(char oldC,char newC){
		char[] copy = Arrays.copyOf(arr, arr.length);
		
		for(int i=0;i<copy.length;i++)
			if(copy[i]==oldC)
				copy[i] = newC;
		
		CharString cs = new CharString(copy);
		return cs;
	}
	
	/**
	 *��index��ʼ����ȡlength���ȵ��Ӵ�
	* @param index
	* @param length
	* @return
	 */
	public CharString subString(int index,int length){
		if(index <=0 || index > arr.length)
			throw new IllegalArgumentException("index is illegal");
		
		if(length + index > arr.length)
			throw new IllegalArgumentException("��ȡ������");
		char[] newChar = Arrays.copyOfRange(arr, index, index+length);
		CharString cs = new CharString(newChar);
		return cs;
	}
	
	/**
	 * ����ģʽƥ���㷨
	 * ��ã�o(1)
	 * ƽ����o(n+m)
	 * ���o((n+1+m)*m)
	 * �ַ���ƥ�䣬����ƥ����ִ��е�һ���ַ���λ��
	* @param newChar
	* @return
	 */
	public int index(CharString newChar){
		int i=0,j=0;
		//��¼��һ��ƥ��������λ��
		int lastIndex = 0;
		//����0��ʼ
		while(i<arr.length&&j<newChar.length()){
			//�����ȣ���������һ���ַ�ƥ��
			if(arr[i] == newChar.charAt(j)){
				i++;
				j++;
				lastIndex = i;
			//�������ȣ����Ӵ�Ҫ���´�0��ʼ������Ҫ�˻ص���һ��ƥ�����һ���ַ���
			}else{
				i = lastIndex + 1;
				j=0;
			}
		}
		
		//ѭ�����������ƥ����Ӵ���ֻ���ȥ�Ӵ��ĳ��Ⱦ��ǵ�һ���ַ���λ��
		if(j>0)
			return i-newChar.length();
		return -1;
	} 
}
