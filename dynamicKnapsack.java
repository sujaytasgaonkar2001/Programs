import java.util.*;

class dynamicKnapsack
{
    public static void main(String[] args)
    {
        int w[] = new int[10], i, j, p[] = new int[10];
        int v[][] = new int[15][15];  		//Profit table
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the total number of items");
        int n = in.nextInt();
        
        System.out.println("Enter the weights of each item");
        for(i=1;i<=n;i++)
            w[i] = in.nextInt();
        System.out.println("Enter the profit of each item");
        for(i=1;i<=n;i++)
            p[i] = in.nextInt();
        System.out.println("Enter the knapsack capacity");
        int m = in.nextInt();
        
        displayinfo(m,n,w,p);
        knapsack(m,n,w,p,v);
        
         System.out.println("The content of the knapsack table are");
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)
            {
              System.out.print(v[i][j]+" ");  
            }
            System.out.println();
        }
        optimal(m,n,w,v);
    }
    
    static void displayinfo(int m,int n,int w[],int p[])
    {
        System.out.println("Entered information about knapsack problem:");
        System.out.println("ITEM \t WEIGHT \t PROFIT");
        for(int i=1;i<=n;i++)
            System.out.println(i +"\t"+ w[i] +"\t" + p[i]);
        System.out.println("Capacity =" +m);
        
    }
    static void knapsack(int m,int n,int w[],int p[],int v[][])       //Formation of Profit Table
    {
        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=m;j++)   //Implementing the 3 conditions while creating the Table
            {
                if(i==0 || j==0)
                    v[i][j] = 0;
                else if(j<w[i])    //weight less or greater than j
                    v[i][j] = v[i-1][j];
                else
                    v[i][j] = Math.max(v[i-1][j], v[i-1][j-w[i]]+p[i]);
            }
        }
    }
   
    static void optimal(int m,int n,int w[],int v[][])
    {
        int i=n;					//Total no. of object
        int j = m;					//knapsack Capacity
        int item=0;
        int x[] = new int[10];		//Optimal solution
        while(i!=0 && j!=0)			//Bottom Up approach
        {
            if(v[i][j]!=v[i-1][j])
            {
                x[i]=1;
                j = j-w[i];   //Reducing the knapsack capacity after considering the item
            }
            i--;
        }
        System.out.println("The optimal solution is:" +v[n][m]);	//Print the last row and last column of 
        															//the profit table
        System.out.println("Selected items are: ");
        for(i=1;i<=n;i++)
	        if(x[i] == 1)
	        {
	            System.out.print(i+" ");
	            item = 1;
	        }
        if(item==0)
        {
            System.out.println("No items can be placed in knapsack");
        }
    }
}