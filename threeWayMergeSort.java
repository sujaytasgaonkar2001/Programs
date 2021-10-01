import java.util.Random;
import java.util.Scanner;

public class threeWayMergeSort{

	public static void main(String[] args) {
	
		int a[] = new int[10000];
		long start, end;
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the number of elements to be sorted");
		int n = read.nextInt();
		
		Random rand = new Random();
		for(int i = 0; i < n; i++) 
			a[i] = rand.nextInt(10000);
			
		System.out.println("Array Elements are : ");
		for(int j = 0; j<n; j++)
			System.out.print(a[j] + " ");
	
		start = System.nanoTime();
		mergesort(a, 0, n-1);
		end = System.nanoTime();
		
		System.out.println("");
		System.out.println("Sorted Elements are : ");
		for(int m = 0; m<n; m++)
			System.out.print(a[m] + " ");
		
		System.out.println("");
		System.out.println("The time taken to sort the elements are : "+(end-start) + " ns");

		

	}
	
	
	 static void mergesort(int a[],int low,int high)
    {
        int mid1,mid2;
        if(low<high) {
        	mid1=low+((high-low)/3);
            mid2=low+2*((high-low)/3)+1;
            mergesort(a,low,mid1);
            mergesort(a,mid1+1,mid2);
            mergesort(a,mid2+1,high);
            merge(a,low,mid1,mid2,high);
        }  
    }
    static void merge(int a[],int low,int mid1,int mid2,int high)
    {
        int h=low,i=low,j=mid1+1,m=mid2+1,k;
        int b[]=new int[10000];
        while((h<=mid1)&&(m<=high)&&(j<=mid2))
        {
            if(a[h]<=a[j])
            {
            	//to compare all three sorted array
            	if(a[h]<=a[m]) {
            		b[i]=a[h];
                    h++;               
            	}
            	else {
            		b[i]=a[m];
            		m++;
            	}
            }
            else
            {
            	if(a[j]<=a[m]) {
            		b[i]=a[j];
                    j++;               
            	}
            	else {
            		b[i]=a[m];
            		m++;
            	}
            }
            i++;
        }
        while((h<=mid1)&&(j<=mid2)) {
        	if(a[h]<=a[j]) {
        		b[i]=a[h];
        		h++;
        	}
        	else {
        		b[i]=a[j];
        		j++;
        	}
        	i++;
        }
        while((m<=high)&&(j<=mid2)) {
        	if(a[j]<=a[m]) {
        		b[i]=a[j];
        		j++;
        	}
        	else {
        		b[i]=a[m];
        		m++;
        	}
        	i++;
        }
        while((h<=mid1)&&(m<=high)) {
        	if(a[h]<=a[m]) {
        		b[i]=a[h];
        		h++;
        	}
        	else {
        		b[i]=a[m];
        		m++;
        	}
        	i++;
        }
        if(h<=mid1)
        {
            for(k=h;k<=mid1;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        if(j<=mid2){
            for(k=j;k<=mid2;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        if(m<=high) {
        	for(k=m;k<=high;k++)
            {
                b[i]=a[k];
                i++;
            }
        }
        for(k=low;k<=high;k++)
            a[k]=b[k];
    }
}