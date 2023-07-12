package sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void selectionSort(int[] arr) {
		for(int i=0 ; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if( arr[i] > arr[j] ) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));  //for understanding only
		}
	}
	
	public static void main(String[] args) {
		int[] arr= {2,5,3,9,7,6,4};
		System.out.println("Before Sorting: "+Arrays.toString(arr));
		selectionSort(arr);
		System.out.println("After Sorting: "+Arrays.toString(arr));
	}

}
