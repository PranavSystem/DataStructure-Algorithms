package sorting;

import java.util.Arrays;

public class PracticeSelectionSort {
	
	public static void selSortAge(People[] people) {
		for(int i=0; i<people.length-1; i++) {
			for(int j=i+1; j<people.length; j++) {
				if( people[i].age > people[j].age ) {
					People temp=people[i];
					people[i]=people[j];
					people[j]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		People[] peeps= { new People(1, "Ram", 25), new People(5,"Shyam",22), new People(3, "Roy", 20), new People(7, "Sam", 32)};
		System.out.println("Before sorting as per age: "+Arrays.toString(peeps));
		selSortAge(peeps);
		System.out.println("After sorting as per age: "+Arrays.toString(peeps));
	}
}
