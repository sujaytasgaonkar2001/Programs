import java.util.Random;
import java.util.Scanner;

public class mergesort {
	static final int MAX = 10005;

	// the main array 'a' containing the elements to be sorted
	static int[] a = new int[MAX];

	public static void main(String[] args) 	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter Max array size: ");
		int n = input.nextInt();
		Random random = new Random();
		System.out.println("Enter the array elements: ");
		for (int i = 0; i < n; i++) {
			//a[i] = input.nextInt();
			a[i] = random.nextInt(10000); // generate random numbers
		}
		
		System.out.println("Array Elements are : ");
		for(int i = 0; i<n; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		// the start time for sorting
		long startTime = System.nanoTime();

		// sort the array
		mergeSort(0, n - 1);

		// the end time of sorting
		long stopTime = System.nanoTime();

		// calculate the total elapsed time taken for sorting
		long elapsedTime = stopTime - startTime;

		// print the elapsed time and the sorted array
		System.out.println("Time Complexity (ms) for n = " + n + " is : " + (double) elapsedTime / 1000000);
		System.out.println("Sorted Array (Merge Sort):");
		for (int i = 0; i < n; i++)	{
			System.out.print(a[i] + " ");
		}
		
		input.close();
	}

	// The merge sort function
	public static void mergeSort(int low, int high) {
		int mid;
		if (low < high) {
			mid = (low + high) / 2;
			mergeSort(low, mid);
			mergeSort(mid + 1, high);
			merge(low, mid, high);
		}
	}

	public static void merge(int low, int mid, int high) {
		int[] b = new int[MAX];
		int i, h, j, k;
		h = i = low;
		j = mid + 1;

		// compare the values in the left array and the right array
		// and copy them in the new array b
		while ((h <= mid) && (j <= high))
		{
			if (a[h] < a[j])
			{
				b[i++] = a[h++];
			}
			else
			{
				b[i++] = a[j++];
			}
		}


		if (h > mid)
		{
			// we have copied all the elements of the
			// left array. There could be few extra
			// elements in the right array. Copy them
			// to the array b
			for (k = j; k <= high; k++)
			{
				b[i++] = a[k];
			}
		}
		else
		{
			// we have copied all the elements of the right
			// array. There could be few extra elements in
			// the left array. Copy them to array b
			for (k = h; k <= mid; k++)
			{
				b[i++] = a[k];
			}
		}

		// copy the sorted array 'b' in to the
		// main array 'a'
		for (k = low; k <= high; k++)
		{
			a[k] = b[k];
		}
	}
}