package string;

import java.util.Arrays;

/**
 * @Author yukai
 * @Date 2018年11月12日
 * 串
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
	 * 返回字符串的长度
	* @return
	 */
	public int length(){
		return arr.length;
	}
	
	/**
	 * 字符串是否为空
	* @return
	 */
	public boolean isEmpty(){
		return arr.length == 0;
	}
	
	
	/**
	 * 返回对应下标的字符串
	* @return
	 */
	public char charAt(int index){
		if(index <=0 || index > arr.length)
			throw new IllegalArgumentException("index is illegal");
		return arr[index];
	}
	
	
	/**
	 * 默认返回第一次出现该字符串的下标
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
	 * 单个字符串的替换
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
	 *从index开始，截取length长度的子串
	* @param index
	* @param length
	* @return
	 */
	public CharString subString(int index,int length){
		if(index <=0 || index > arr.length)
			throw new IllegalArgumentException("index is illegal");
		
		if(length + index > arr.length)
			throw new IllegalArgumentException("截取不合理");
		char[] newChar = Arrays.copyOfRange(arr, index, index+length);
		CharString cs = new CharString(newChar);
		return cs;
	}
	
	/**
	 * 朴素模式匹配算法
	 * 最好：o(1)
	 * 平均：o(n+m)
	 * 最坏：o((n+1+m)*m)
	 * 字符串匹配，返回匹配的字串中第一个字符的位置
	* @param newChar
	* @return
	 */
	public int index(CharString newChar){
		int i=0,j=0;
		//记录上一次匹配主串的位置
		int lastIndex = 0;
		//都从0开始
		while(i<arr.length&&j<newChar.length()){
			//如果相等，都继续下一个字符匹配
			if(arr[i] == newChar.charAt(j)){
				i++;
				j++;
				lastIndex = i;
			//如果不想等，则子串要重新从0开始，主串要退回到上一次匹配的下一个字符串
			}else{
				i = lastIndex + 1;
				j=0;
			}
		}
		
		//循环结束如果有匹配的子串，只需减去子串的长度就是第一个字符的位置
		if(j>0)
			return i-newChar.length();
		return -1;
	} 
}
