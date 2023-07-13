package sorting;

import java.util.Arrays;

public class ImprovedbubbleSort {

	public static void improvedBubbleSort(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {		// execute array length-1 passes
			for (int i = 0; i < arr.length-1; i++) { 		// compare consecutive elements and swap if 
														//	left element>right element
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
		improvedBubbleSort(arr);
		System.out.println("After Sorting: "+Arrays.toString(arr));

	}

}
