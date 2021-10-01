import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class quicksort {
	static final int MAX = 10005;
	static int[] a = new int[MAX];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Max array size: ");
		int n = input.nextInt();
		Random random = new Random();
		System.out.println("Enter the array elements: ");
		for (int i = 0; i < n; i++)
		{
			//a[i] = input.nextInt();   	                         
			a[i] = random.nextInt(5000); // generate 
			// random numbers – uniform distribution
		}
		//a = Arrays.copyOf(a, n); // keep only non zero elements
		//Arrays.sort(a); // for worst-case time complexity
		System.out.println("Input Array:");
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		// set start time
		long startTime = System.nanoTime();
		QuickSortAlgorithm(0, n - 1);
		long stopTime = System.nanoTime();
		long elapsedTime = stopTime - startTime;
		System.out.println("\nSorted Array:");
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		System.out.println("Time Complexity in ms for n=" + n + " is: " + (double) elapsedTime / 1000000);
	}

	public static void QuickSortAlgorithm(int lowerBound, int upperBound) {
		int start, end, temp, pivot;
		if (lowerBound < upperBound) {
			start = lowerBound;
			end = upperBound + 1;
			pivot = a[lowerBound]; // mark first element as pivot
			while (true) {
				start++;
				while (a[start] < pivot && start < upperBound)
					start++;
				end--;
				while (a[end] > pivot)
					end--;
				if (start < end) {
					temp = a[start];
					a[start] = a[end];
					a[end] = temp;
				} else
					break; // partition is over
			}
			a[lowerBound] = a[end];
			a[end] = pivot;
			QuickSortAlgorithm(lowerBound, end - 1);
			QuickSortAlgorithm(end + 1, upperBound);
		}
	}
}