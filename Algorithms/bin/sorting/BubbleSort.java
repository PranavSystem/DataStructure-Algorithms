package sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {	
			for (int i = 0; i < arr.length-1-j; i++) { 		
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] arr= {1,56,32,22,95,74};
		System.out.println("Before Sorting: "+Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println("After Sorting: "+Arrays.toString(arr));

	}

}
