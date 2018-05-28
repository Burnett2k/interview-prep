package structures;

public class QuickSort {

	public static void main(String[] args) {
		//create a sample array
		int arr[] = {3,6,1,45,9,5,3,43,7};
		QuickSort qs = new QuickSort();
		
		qs.quickSort(arr, 0, arr.length - 1);
		printArray(arr);
	}
	
	
	public void quickSort(int[] arr, int left, int right) {
		
		//first step is to choose a partition to start the sort on
		int index = partition(arr, left, right);
		
		//now that we have the index, quick sort the left side
		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}
		
		//now that we have sorted the left side, sort the right side
		if (index < right) {
			quickSort(arr, index, right);
		}
	}
	
	public int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];
		
		while (left <= right) {
			while (arr[left] < pivot) left++;
			
			while (arr[right] > pivot) right--;
			
			if (left <= right) {
				
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				
				left ++;
				right --;
			}
		}
		
		return left;
		
	}
	
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
