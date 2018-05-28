package structures;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,5,6,7,8};
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.binarySearch(arr, 4));
	}
	
	public int binarySearch(int[] arr, int x) {
		//determine midpoint to split on
		
		int low = 0;
		int high = arr.length - 1;
		int mid;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (x == arr[mid]) {
				return mid;
			} else if (x > arr[mid]) {
				low = mid + 1;
			} else if (x < arr[mid]) {
				high = mid - 1;
			}
			
			
			
		}
		
		return -1;
	}

}
