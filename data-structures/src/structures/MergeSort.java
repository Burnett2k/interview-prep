package structures;

public class MergeSort {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {3,6,1,45,9,5,3,43,7, 914, 23,1234, 1234, 4, 3,1 ,3,77};
		MergeSort ms = new MergeSort();
		int left = 0;
		int right = arr.length - 1;
		
		ms.sort(arr, new int[arr.length], 0, arr.length - 1);
		printArray(arr);
		
		
	}
	
	public void sort(int[] arr, int[] temp, int left, int right) {

		if (left < right) {
			int middle = (left + right) / 2;
			
			sort(arr, temp, left, middle);
			sort(arr, temp, middle + 1, right);
			
			mergeHalves(arr, temp, left, right);
			
		}
		
	
	}
	
	public void mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
		//difficult to do in place
		
		int leftEnd = (rightEnd + leftStart) / 2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while (left <= leftEnd && right <= rightEnd) {
			if (arr[left] <= arr[right]) {
				temp[index] = arr[left];
				left++;
			} else {
				temp[index] = arr[right];
				right++;
			}
			index++;
		}
		
		System.arraycopy(arr,  left,  temp,  index,  leftEnd - left + 1);
		System.arraycopy(arr,  right,  temp,  index,  rightEnd - right + 1);
		System.arraycopy(temp,  leftStart,  arr,  leftStart,  size);
		
	}

	
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
