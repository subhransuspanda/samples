package sort;

import java.util.stream.Stream;

public class BubbleSort {

	public static void main(String[] args) {
		Integer numbers[] = {40,60,20,10,90,70,50,30};
		int n = numbers.length;
		System.out.println("Before sorting : ");
		Stream.of(numbers).forEach(x -> System.out.print(x+"\t"));
		
		// n-1 iteration(passes) for the i-loop
		// each iteration it fixes one element(the max element) at its right place
		for(int i=0; i<n-1; i++) {
			
			//j-loop should not include already sorted element, so it is n-1-i
			for(int j=0; j<n-1-i; j++) {
				if(numbers[j] > numbers[j+1]) {
					swap(numbers, j, j+1);
				}
			}
			System.out.println("\n\nPass-"+(i+1));
			Stream.of(numbers).forEach(x -> System.out.print(x+" "));
		}
		
	}
	
	private static void swap(Integer numbers[], int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}	
} 
