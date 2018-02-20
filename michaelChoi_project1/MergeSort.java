import java.util.Random; //used for generating random numbers for list

public class MergeSort {

	public static int[] mergeSort(int list[], int low, int high) {	//mergesort method
        if (low < high) {	//keep going if
            int mid = (low + high )/ 2;	// Find the middle point
            mergeSort(list, low, mid); // Sort first half
            mergeSort(list , mid + 1, high);	// Sort second half
            merge(list, low, mid, high);	// Merge the sorted halves
        }
        return list;	//return sorted array
    }
	public static void merge(int list[], int low, int mid, int high) {	//merging method
        int n1 = mid - low + 1;	// Find sizes of two sub lists to be merged
        int n2 = high - mid;
        int left[] = new int [n1];	//create temp array for list side
        int right[] = new int [n2];	//create temp array for list side
        for (int i=0; i<n1; ++i)	//copy data to left temp array
            left[i] = list[low + i];
        for (int j=0; j<n2; ++j)	//copy data to left temp array
            right[j] = list[mid + 1+ j];
        
        //gerge the temp arrays
        int i = 0, j = 0;	//Initial indexes of first and second sub lists
        int k = low;	// Initial index of merged subarry array
        while (i < n1 && j < n2) {	//when neither array is finished
            if (left[i] <= right[j]) {	//if left entry is smaller or equal
                list[k] = left[i];	//add left entry to merged list
                i++;	//increase left pointer by one
            }
            else {	//if right entry is smaller
                list[k] = right[j];	//add right entry to merged list
                j++;	//increase right pointer by one
            }
            k++;	//increase merged pointer by one, due to adding an entry
        }
        while (i < n1) {	 //copy remaining elements of left array if any entries are left
            list[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {	//copy remaining elements of right array if any entries are left
            list[k] = right[j];
            j++;
            k++;
        }
    }
	
	public static void main(String[] args) {	//main method
		Random random = new Random();	//Random class to make random numbers
		int n = 10000000;	//array size
		int[] array = new int[n];	//instantiate array of size n
		for(int i = 0; i < array.length; i++) {	//populate array with random numbers
			array[i] = random.nextInt(n) + 1;
		}
		System.out.println("Merge Sort: ");
		double startTime = System.nanoTime();	//find starting time
		mergeSort(array, 0, array.length - 1);	//perform mergesort on array
		double totalTime = (System.nanoTime() - startTime) / 1000000000;	//find total time taken to perform mergesort
		System.out.println("time taken to run: " + totalTime);
		
	}
}
