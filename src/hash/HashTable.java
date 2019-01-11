package hash;

/**
 * @Author yukai
 * @Date 2018年12月4日
 * 哈希表
 * 链地址法
 */
public class HashTable<T> {

	private class Link{
		private T data;
		private Link next;
		
		public Link(T data,Link next){
			this.data = data;
			this.next = next;
		}
	}
	
	private T[] links;
	private int num;
	
	public HashTable(int capacity){
		this.links = (T[])new Object[capacity];
		this.num = 0;
	}
	
	public int hash(T key){
		return key.hashCode()%links.length;
	}
	
	
}
