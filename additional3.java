import java.util.*;

public class additional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner read = new Scanner(System.in);
		System.out.print("Enter number of elements in main array: ");
		n = read.nextInt();
		int a[] = new int[n];
		System.out.println("Enter elements of main array:");
		for(int i=0; i<n; i++)
		{
			a[i] = read.nextInt();
		}
		System.out.print("Enter number of elements in subset array: ");
		m = read.nextInt();
		int b[] = new int[m];
		System.out.println("Enter elements of subset array:");
		for(int i=0; i<m; i++)
		{
			b[i] = read.nextInt();
		}
		
		
		System.out.print("The elements of main array are : ");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+"\t");
		System.out.println();
		System.out.print("The elements of subset array are: ");
		for(int i=0;i<m;i++)
			System.out.print(b[i]+"\t");

		int flag[] = new int[m];
		for(int l = 0 ; l<m; l++)
			flag[l] = 0;
		
		for(int j=0; j<m; j++)
		{
			for(int k = 0; k<n; k++)
			{
				if(b[j] == a[k])
					flag[j] = 1;
				if(flag[j] == 1)
					break;
			}
		}
		
		
		
		int comp = 1;
		for(int o = 0; o<m; o++)
		{
			if(flag[o] == 0)
			{
				comp = 0;
				break;
			}
		}
		
		
		System.out.println();
		if(comp == 0)
			System.out.println("It is not a Subset");
		else
			System.out.println("It is a subset");
	}
}