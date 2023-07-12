package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchUsingRecursion {

	public static int recursionBinary(int[] arr,int left,int right,int num) {
		if(left>right)
			return -1;
		int mid=(left + right)/2;
		if( num == arr[mid] )
			return mid;
		else if( num < arr[mid] )
			return  recursionBinary(arr, left, mid-1, num);
		else
			return  recursionBinary(arr, mid+1, right, num);
//		return index;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr= {23,78,23,87,234,776,21,36};
		Arrays.sort(arr);
		System.out.println("Enter number to search: ");
		int num=sc.nextInt();
		sc.close();
		int index = recursionBinary(arr, 0, arr.length-1, num);
		if(index!=-1)
			System.out.println("Element found at index : "+index);
		else
			System.out.println("Element not found");
		
	}

}
