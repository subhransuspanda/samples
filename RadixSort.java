package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RadixSort {
	static final int totalBuckets = 10;

	public static void main(String[] args) {

		List<Integer> buckets[] = new ArrayList[totalBuckets];

		for(int i=0; i<totalBuckets; i++) {
			buckets[i] = new ArrayList();
		}

		Integer numbers[] = {6,12, 142, 45, 76, 44, 28766, 91, 54, 259};
		System.out.println("\nBefore sorting : ");
		print(numbers);
		
		int radian = 10;
		int maxDigits = maxNumberOfDigits(numbers);
		while(maxDigits !=0) {
			for(int i=0; i<numbers.length; i++) {
				int n = (numbers[i] % radian)/(radian/10);
				buckets[n].add(numbers[i]);
			}


			collect(numbers, buckets);
			flushBuckets(buckets);
			System.out.println("\nPass : ");
			print(numbers);
			radian = radian*10;
			maxDigits--;
		}
		System.out.println("\nAfter sorting : ");
		print(numbers);
		
	}

	private static void flushBuckets(List<Integer> buckets[]) {
		Stream.of(buckets).forEach(x -> x.clear());
	}

	private static void collect(Integer numbers[], List<Integer> buckets[]) {
		int k=0;
		for(int i=0; i<buckets.length; i++) {
			for(int j=0; j<buckets[i].size(); j++) {
				numbers[k++] = buckets[i].get(j);
			}
		}

	}

	private static int maxNumberOfDigits(Integer numbers[]) {
		int max = 0;
		for(int number : numbers) {
			if(number > max) {
				max = number;
			}
		}
		int count = 0;
		while(max != 0) {
			max = max/10;
			count++;
		}
		return count;
	}
	
	private static void print(Integer numbers[]) {
		Stream.of(numbers).forEach(x -> System.out.print(x+"\t"));
	}
}
