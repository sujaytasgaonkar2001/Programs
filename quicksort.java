package project4;
import java.util.*;
class Pg8{
	static void quicksort(int a[], int p, int q)
	{
		int j;
		if(p < q)
		{
			j = partition(a, p, q);
			quicksort(a, p, j-1);
			quicksort(a, j+1, q);
		}
	}
	
	static int partition(int a[], int m, int p)
	{
		int i, j;
		int v = a[m]; 
		i = m;
		j = p;
		while(i <= j) 
		{
			while(a[i] <= v)
			{
				i++;
			}
			while(a[j] > v)
			{
				j--;
			}
			if(i<j)
			{
				swap(a, i, j); 
			}
		}
		a[m] = a[j];
		a[j] = v;  
		return j;	
	}
	
	static void swap(int a[], int i, int j)
	{
		int p;
		p = a[i];
		a[i] = a[j];
		a[j] = p;
	}


	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = new int[10000];
		long start, end;
		Scanner read = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Enter number of elements:");
		int n = read.nextInt();
		System.out.println("\nElements generated");
		for(int h = 0; h<n; h++)
		{
			a[h] = rand.nextInt(10000);
			System.out.print(a[h]+" ");
		}
		a[n] = 9999;
		
		start = System.nanoTime();
		quicksort(a, 0, n-1);
		end = System.nanoTime();
		
		System.out.println("\n\nThe sorted elements are");
		for(int k = 0; k<n; k++)
			System.out.print(a[k]+" ");
		System.out.println("\n\ntime taken = "+(end-start)+"ns");
		}
		
		
		

	}