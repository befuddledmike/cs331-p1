import java.util.Random;

public class Sorting {
	
	public static int[] exchangeSort(int[] array) {
		int temp;
		for(int i = 0; i < array.length; i++) {
			for(int j = i + 1; j < array.length; j++) {
				if(array[i] < array[j]) {	//descending order
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	static int[] mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;
 
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
        return arr;
    }
	static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];
 
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
	static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high]; 
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;
 
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        return i + 1;
    }
 
 
    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    public static int[] quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is 
              now at right place */
            int pi = partition(arr, low, high);
 
            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }
	
	public static void print(int[] array) {
		String output = "{";
		for(int i = 0; i < array.length; i++) {
			output += array[i] + ", ";
		}
		if(output.length() > 1) {
			output = output.substring(0, output.length() - 2);
			output += "}";
			System.out.println(output);
		}
	}
	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[900000];
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(900000) + 1;
		}
		int[] test = {84, 69, 76, 86, 94, 91};
		System.out.print("Quick Sort: ");
		double quickStartTime = System.nanoTime();
		quickSort(array, 0, array.length - 1);
		double quickTime = (System.nanoTime() - quickStartTime) / 1000000000;
		System.out.println(" time taken to run: " + quickTime);
		
		System.out.print("Merge Sort: ");
		double mergeStartTime = System.nanoTime();
		mergeSort(array, 0, array.length - 1);
		double mergeTime = (System.nanoTime() - mergeStartTime) / 1000000000;
		System.out.println(" time taken to run: " + mergeTime);
		
		System.out.print("Exchange Sort: ");
		double exchangeStartTime = System.nanoTime();
		exchangeSort(array);
		double exchangeTime = (System.nanoTime() - exchangeStartTime) / 1000000000;
		System.out.println(" time taken to run: " + exchangeTime);
		
	}

}
