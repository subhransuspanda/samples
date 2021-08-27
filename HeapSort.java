package sort;
public class HeapSort {
    public void sort(int numbers[])
    {
        int n = numbers.length;
 
		/*
		 * Step-1 Construct Heap by heapifying
		 * Heapifying n/2 - 1 nodes(parents) is covering all the elements
		 */
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(numbers, n, i);
        }
        
		/*
		 * Step-2 Sorting 
		 * extract elements one by one from root 
		 * For convinience, we are adding the elements to the end of same array. Not using separate array
		 */       
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = temp;
 
            // Heapifyig the sub-heap after an item removed
            heapify(numbers, i, 0);
        }
    }
 
    public void heapify(int numbers[], int n, int i)
    {
        int largest = i; // Initialize largest as parent index
        int lc = 2 * i + 1; // left child index
        int rc = 2 * i + 2; // right child index
 
        // If left child is larger than parent
        if (lc < n && numbers[lc] > numbers[largest])
            largest = lc;
 
        // If right child is larger than largest so far
        if (rc < n && numbers[rc] > numbers[largest])
            largest = rc;
 
        // If largest is not parent
        if (largest != i) {
            int temp = numbers[i];
            numbers[i] = numbers[largest];
            numbers[largest] = temp;
 
            // Recursively heapify the affected sub-tree
            heapify(numbers, n, largest);
        }
    }
 
    
    static void printArray(int numbers[])
    {
        for(int number : numbers) {
        	System.out.print(number+"\t");
        }
        System.out.println();
    }
 
    public static void main(String args[])
    {
        int numbers[] = { 44, 77, 66, 22, 11, 99, 33, 88, 55 };
 
        HeapSort heapObject = new HeapSort();
        heapObject.sort(numbers);
 
        System.out.println("After Sorting...");
        printArray(numbers);
    }
}