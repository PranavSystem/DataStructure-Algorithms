 package searching;

import java.util.Scanner;

public class LinearSearch {
	
	public static int linearSearch(int[] arr,int num) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==num)
				return i;			
		}
		return -1;
	}

	public static void main(String[] args) {
		 Scanner sc=new Scanner(System.in);
		 int[] arr= {11,34,76,55,76,23,87};
		 System.out.println("Enter number to search:");
		 int num=sc.nextInt();
		 sc.close();
		 int index=linearSearch(arr, num);
		 if(index!=-1)
			 System.out.println("Element found at index : "+index);
		 else
			 System.out.println("Element not found");
	}

}
