package search;

/**
 * @Author yukai
 * @Date 2018��11��30��
 * ���ֲ����㷨����������������飬������ҪƵ�������ɾ�����������ݼ���˵��̫���ã���Ϊʼ��Ҫά����������
 * ʱ�临�Ӷ�logn
 */
public class BinarySearch {

	/**
	 * �ǵݹ�
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
			//�㷨�Ľ�����ֵ���ң���ʽ��,������֮һ������Ŀ�����ҵ����ӽ��ڸ�key�ķ�Χ
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
	 * �ݹ�
	* @param arr
	* @param low
	* @param high
	* @param key
	* @return
	 */
	public boolean binarySearch(int[] arr,int low,int high,int key){
		int mid = low + (high - low) / 2;
		//�㷨�Ľ�����ֵ����,������֮һ������Ŀ�����ҵ����ӽ��ڸ�key�ķ�Χ
		//mid = low + ((key-arr[low])/(arr[high]-arr[low]))*(high-low);
		if(arr[mid] == key)
			return true;
		else if(arr[mid] < key)
			return binarySearch(arr, low, mid-1, key);
		else
			return binarySearch(arr, mid+1, high, key);
	}
}
