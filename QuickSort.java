package sort;

public class QuickSort  {
	private static int[] numbers;

	public static void sort(int[] elements) {
		if (elements ==null || elements.length==0){
			return;
		}
		numbers = elements;
		quicksort(0, numbers.length - 1);
		for(int x : numbers) {
			System.out.print(x+"\t");
		}
	}

	private static void quicksort(int start, int end) {
		int forward = start, backward = end;
		int pivot = numbers[start + (end-start)/2];

		while (forward <= backward) {
			while (numbers[forward] < pivot) {
				forward++;
			}
			while (numbers[backward] > pivot) {
				backward--;
			}

			if (forward <= backward) {
				swap(forward, backward);
				forward++;
				backward--;
			}
		}
		if (start < backward)
			quicksort(start, backward);
		if (forward < end)
			quicksort(forward, end);
	}

	private static void swap(int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	public static void main(String a[]){
		int[] numbers = {44,77,66,22,11,99,33,88,55};
		sort(numbers);

	}
}