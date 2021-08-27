package sort;

import java.util.stream.Stream;

public class SelectionSort {

	public static void main(String[] args) {
		Integer numbers[] = {40,60,20,10,90,100,80,70,50,30};
		
		System.out.println("Before sorting : ");
		print(numbers);

		for(int i=0; i<numbers.length; i++) { 
			int minValueIndex = i;
			for(int j=i+1; j<numbers.length; j++) {
				if(numbers[j] < numbers[minValueIndex]) {
					minValueIndex = j;
				}
			}
			if(numbers[i] != numbers[minValueIndex]) {
				int temp = numbers[i];
				numbers[i] = numbers[minValueIndex];
				numbers[minValueIndex] = temp;
			}
		}
		System.out.println("\nAfter sorting : ");
		print(numbers);

	}
	
	private static void print(Integer numbers[]) {
		Stream.of(numbers).forEach(x -> System.out.print(x+"\t"));
	}
}
