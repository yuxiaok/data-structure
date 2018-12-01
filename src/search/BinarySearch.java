package search;

/**
 * @Author yukai
 * @Date 2018年11月30日
 * 二分查找算法：适用于有序的数组，对于需要频繁插入或删除操作的数据集来说不太适用，因为始终要维护数组有序
 * 时间复杂度logn
 */
public class BinarySearch {

	/**
	 * 非递归
	* @param arr
	* @param key
	* @return
	 */
	public boolean binarySearch(int[] arr,int key){
		int low = 0;
		int high = arr.length-1;
		int mid;
		while(low <= high){
			mid = low + (high-low)/2;
			//算法改进，插值查找（公式）,将二分之一换掉，目的是找到更接近于该key的范围
			//mid = low + ((key-arr[low])/(arr[high]-arr[low]))*(high-low);
			if(arr[mid]==key)
				return true;
			else if(arr[mid]<key)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}
	
	
	/**
	 * 递归
	* @param arr
	* @param low
	* @param high
	* @param key
	* @return
	 */
	public boolean binarySearch(int[] arr,int low,int high,int key){
		int mid = low + (high - low) / 2;
		//算法改进，插值查找,将二分之一换掉，目的是找到更接近于该key的范围
		//mid = low + ((key-arr[low])/(arr[high]-arr[low]))*(high-low);
		if(arr[mid] == key)
			return true;
		else if(arr[mid] < key)
			return binarySearch(arr, low, mid-1, key);
		else
			return binarySearch(arr, mid+1, high, key);
	}
}
