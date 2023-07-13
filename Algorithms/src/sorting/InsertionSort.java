package sorting;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {     // arr.length-1 passes:in each pass consider i as last element of array
			int j, temp=arr[i];				// copy last element into temp variable
			// compare temp with all elements before it, find appropriate position for the element and 
			// insert temp at that position
			for(j=i-1; j>=0 && arr[j]>temp; j--) {
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr= {2,9,3,5,7,10};
		System.out.println("Before sorting: "+Arrays.toString(arr));
		insertionSort(arr);
		System.out.println("After sorting: "+Arrays.toString(arr));

	}
}
