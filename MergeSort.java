package sort;

public class MergeSort {

	public static void main(String[] args) {
		Integer numbers[] = { 87, 57, 370, 110, 90, 610, 02, 710, 140, 203, 150 };
		int start = 0;
		int end = numbers.length;
		mergeSort(numbers, start, end);
	}
	
	public static void divide(Integer[] numbers, int start, int end) {
		int mid = (start+end)/2;
		if(start > end) {
			divide(numbers, start, mid);
			divide(numbers, mid+1, end);
		}
		int result = merge(numbers, start, end);
	}

}
