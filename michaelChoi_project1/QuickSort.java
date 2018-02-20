import java.util.Random;

public class QuickSort {
	
	public static int[] quickSort(int list[], int low, int high) {	//quicksort method
        if (low < high) {	//keep going if
            /* position is partitioning index, arr[position] is 
              now at right place */
            int position = partition(list, low, high);	//pivoting point after using partition to find smaller element
            quickSort(list, low, position - 1);	//sort elements before partition
            quickSort(list, position + 1, high);	//sort elements after partition
        }
        return list;
    }
	public static int partition(int list[], int low, int high) {	//partition method
        int pivot = list[high]; //pivot equals last entry in array
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++) {	//loop from low to high indexes
            if (list[j] <= pivot) {	//if current element is <= pivot
                i++;	//increase index of smaller element by one
                int temp = list[i];	//swap list[i] and list[j] using temp
                list[i] = list[j];
                list[j] = temp;
            }
        }
        int temp = list[i+1];	//swap list[i+1] and list[high] or pivot
        list[i+1] = list[high];
        list[high] = temp;
 
        return i + 1;	//return index of the smaller element
    }
	
	public static void main(String[] args) {	//main method
		Random random = new Random();	//Random class to make random numbers
		int n = 350000000;	//array size
		int[] array = new int[n];	//instantiate array of size n
		for(int i = 0; i < array.length; i++) {	//populate array with random numbers
			array[i] = random.nextInt(n) + 1;
		}
		System.out.println("Quick Sort: ");
		double StartTime = System.nanoTime();	//find starting time
		quickSort(array, 0, array.length - 1);	//perform quicksort on array
		double totalTime = (System.nanoTime() - StartTime) / 1000000000;	//find total time taken to perform quicksort
		System.out.println("time taken to run: " + totalTime);
		
	}
}
