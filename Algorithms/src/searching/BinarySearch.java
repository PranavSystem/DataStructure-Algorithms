package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static int binarySearch(int[] arr,int num) {
		int left=0,right=arr.length-1,mid;
		while(left <= right) {
			mid=(left+right)/2;
			if(num==arr[mid])
				return mid;
			else if(num<arr[mid])
				right = mid-1;
			else
				left = mid+1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] arr= {21,89,32,62,54,78,124,87};
		Arrays.sort(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println("Enter number to search:");
		int num=sc.nextInt();
		sc.close();
		int index=binarySearch(arr, num);
		if(index!=-1)
			System.out.println("Number found at index : "+index);
		else
			System.out.println("Number not found");
	}
}
