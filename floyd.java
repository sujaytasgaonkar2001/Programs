import java.util.Scanner;
public class floyd {
	public static void main(String[] args) {
		int i,j;
		int a[][] = new int[10][10];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of Vertices ");
	    int n = in.nextInt();
	    System.out.println("Enter adjacency matrix ");
	    for(i=1;i<=n;i++)
	    {
	    	for(j=1;j<=n;j++)
	    	{
	    		a[i][j] = in.nextInt();
	    	}
	    }
	    System.out.println(" adjacency matrix: ");
	    for(i=1;i<=n;i++)
	    {
	    	for(j=1;j<=n;j++)
	    	{
	    		System.out.print(a[i][j] + "\t");
	    	}
	    	 System.out.println();
	    }
	    floydalgo(a,n);
	    
	    System.out.println("All pair shortest path matrix ");
	    for(i=1;i<=n;i++)
	    {
	    	for(j=1;j<=n;j++)
	    	{
	    		System.out.print(a[i][j] + "\t");
	    	}
	    	 System.out.println();
	    }
	}
	static void floydalgo(int a[][],int n)
	{
		for(int k=1;k<=n;k++)
		{
			for(int i=1;i<=n;i++)
				for(int j=1;j<=n;j++)
					a[i][j] = min(a[i][j],a[i][k] + a[k][j]);   //Checks for minimum distance from either direct or indirect path
		}
	}
	static int min(int a,int b)
	{
		if(a>b)
			return b;
		else 
			return a;
		
	}

}
