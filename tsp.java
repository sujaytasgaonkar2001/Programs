import java.util.Scanner;

public class tsp
{
    public static void main(String[] args) {
    	int i,j,cost;
		int c[][] = new int[10][10],tour[] = new int[10];
    	Scanner in = new Scanner(System.in);
    	 System.out.println("Enter the number of Cities ");
         int n = in.nextInt();
         
         if(n==1)
         {
        	 System.out.println("Path is not possible ");
        	 System.exit(0);
         }
         System.out.println("Enter distance between the Cities");
         for(i=1;i<=n;i++)
				for(j=1;j<=n;j++)
					c[i][j] = in.nextInt();
         
         System.out.println("distance between the Cities");
         for(i=1;i<=n;i++)
         {
        	 for(j=1;j<=n;j++) 
        	 {
        		 System.out.print(c[i][j] + "  ");
        	 }
        	 System.out.println();
         }
         for(i=1;i<=n;i++)
        	 tour[i]=i;
         
         cost = tsp(c, tour, 1, n);
         
         System.out.println("The accurate Path is ");
         for(i=1;i<=n;i++)
        	 System.out.print(tour[i] + "-->");
         
         System.out.println("1");
         System.out.println("The Minimum distance for tour is " +cost);
    	}
         static int tsp(int c[][],int tour[],int start,int n)
         {
        	 int i,j,k,ccost,temp[]= new int[10],mincost=999,mintour[]=new int[10];
        	 if(start == n-1) //When there are 2 cities only
        	 {
        		 return (c[tour[n-1]][tour[n]] + c[tour[n]][1]);
        	 }
        	 for(i=start+1;i<=n;i++)
        	 {
        		 for(j=1;j<=n;j++)
        			 temp[j] = tour[j];
        		 
        		 temp[start+1]=tour[i];  //Incrementing to next node
        		 temp[i]=tour[start+1];
        		 
        		 if((c[tour[start]][tour[i]]+(ccost = tsp(c,temp,start+1,n))) < mincost)  //Checking which route is giving 
        			 																	  // minimum cost.
        		 {
        			 mincost = c[tour[start]][tour[i]] + ccost;
        			 
        			 for(k=1;k<=n;k++)
        				 mintour[k]=temp[k];
        		 }
        	 }
        		 for(i=1;i<=n;i++)
        			 tour[i]=mintour[i];
        		 
        		 return mincost;
         }
				
    }