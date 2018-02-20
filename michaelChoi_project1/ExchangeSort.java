import java.util.Random;

public class ExchangeSort {

	public static int[] exchangeSort(int[] list) {	//exchangesort method
		int temp;	//temp int for future swaps
		for(int i = 0; i < list.length; i++) {	//loop from 0 index to end of array
			for(int j = i + 1; j < list.length; j++) {	//loop from i + 1 until end of array
				if(list[i] > list[j]) {	//ascending order
					temp = list[i];	//swap list[i] and list[j]
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
		return list;	//return sorted array
	}
	
	public static void main(String[] args) {	//main method
		Random random = new Random();	//Random class to make random numbers
		int n = 500000;	//array size
		int[] array = new int[n];	//instantiate array of size n
		for(int i = 0; i < array.length; i++) {	//populate array with random numbers
			array[i] = random.nextInt(n) + 1;
		}
		System.out.println("Exchange Sort: ");
		double StartTime = System.nanoTime();	//find starting time
		exchangeSort(array);	//perform exchangesort on array
		double totalTime = (System.nanoTime() - StartTime) / 1000000000;	//find total time taken to perform exchangesort
		System.out.println("time taken to run: " + totalTime);
		
	}
}
