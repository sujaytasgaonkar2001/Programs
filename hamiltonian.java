import java.util.Scanner;

public class hamiltonian {
   static int []X = new int[25] ;
   static boolean found = false;
    public static void main(String[] args) 
    {
        int i, j, n;
        int [][]G = new int[25][25];
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the no of vertices of the graph");
        n = reader.nextInt();
        System.out.println("Enter the path adjacency matrix");
        for (i = 1; i <= n; i++)
        {
            for(j =1 ; j<=n; j++)
            {
                G[i][j] = reader.nextInt();
                X[i] = 0;
            }
        }
        X[1] = 1;
        H_cycle(G, n, 2); 
        if(X[i] == 0)
        if(found == false)	
        {
            System.out.println("\nNo Hamiltonian Cycles");
        }
        else
        	System.out.println();
    }

    static void H_cycle(int G[][], int n, int k)
    {
        while(true)
        {
            next_vertex(G, n, k);

            if(X[k] == 0) 
                return;

            if(k==n)   //Value not 0 & If it has reached last Node THEN PRINT
            {
                System.out.println("\n");
                found = true;
                for( int i = 1; i<=n ; i++)
                {
                    System.out.print(X[i] + "-->");
                }
                System.out.println(X[1]); 
                
            } 
            else
            {
                H_cycle(G, n, k+1);
            }
        }
    }

    static void next_vertex(int G[][], int n, int k)
    {
        int j;
        while (true)
        {
            X[k] = (X[k] + 1) % (n+1);
            if(X[k] == 0)   //To check if the next value becomes 0
            {
                return;
            }

            if(G[X[k-1]][X[k]] != 0)   //To check if there any unattended edge
            {
                for(j = 1; j<=k; j++)  //To check for duplicate values
                {
                    if(X[j] == X[k])
                        break;
                }

                if(j==k)
                {
                    if((k<n) || ((k==n) && (G[X[n]][X[1]] != 0)))  //To check if there is a path back to Origin from the last node
                        return;
                }
            }
        }
    }
}