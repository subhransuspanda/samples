package sort;

import java.util.stream.Stream;

public class InsertionSort {

	public static void main(String[] args) {
		Integer numbers[] = {40,60,20,10,90,70,50,30};
		System.out.println("Before sorting : ");
		Stream.of(numbers).forEach(x -> System.out.print(x+"\t"));
		System.out.println("\n");
		//Outer loop is for number of passes
		for(int i=1; i<numbers.length; i++) {
			
			//Inner loop is for inserting the new element in the logical sorted array
			for(int j=0; j<i; j++) {
				if(numbers[i] < numbers[j]) {
					swap(numbers, i, j);
				}
			}
			System.out.println("\n\nPass-"+i);
			Stream.of(numbers).forEach(x -> System.out.print(x+" "));
		}
	}
	private static void swap(Integer numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
