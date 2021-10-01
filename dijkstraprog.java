import java.util.Scanner;

public class dijkstraprog
{
    public static void main(String[] args) 
    {
        Scanner read = new Scanner(System.in);
        int[][] cost = new int[20][20];
        int dist[] = new int[20];
        int visited[] = new int[20];
        int path[] = new int[20];
        System.out.print("Enter the number of nodes: ");
        int n = read.nextInt();
        System.out.println("Enter the Cost matrix");
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 1; j <= n; j++) 
            {
                cost[i][j] = read.nextInt();
            }
        }
        System.out.println("The Entered Cost Matrix is");
        for (int i = 1; i <= n; i++) 
        {
            for (int j = 1; j <= n; j++) 
            {
                System.out.print(cost[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("Enter the source Vertex: ");
        int sv = read.nextInt();
        dijkstra(cost, dist, n, path, visited, sv);
        printPath(sv, n, dist, visited, path);
        read.close();
    }

    static void dijkstra(int cost[][], int distance[], int n, int path[], int visited[], int startingVertex) {
        int count = 2, min, v = 0;
        for (int i = 1; i <= n; i++) // Finds direct path from source (direct path OR infinity i.e no direct path)
        {
            visited[i] = 0;
            distance[i] = cost[startingVertex][i];
            if (cost[startingVertex][i] == 999) 
            {
                path[i] = 0;
            } else
                path[i] = startingVertex;

        }

        System.out.println("Initial path array");
        for (int i = 1; i <= n; i++) 
        {
           System.out.print( path[i] +" ");
        }
        System.out.println();

        
        visited[startingVertex] = 1;
        while (count <= n) // Finds direct minimum distance from visited node
        {
            min = 999;
            for (int w = 1; w <= n; w++)  //Finds the vertex with min distance
            {
                if ((distance[w] < min) && (visited[w] == 0)) 
                {
                    min = distance[w];
                    v = w;

                }
            }
            visited[v] = 1; //to show the node is visited.
            count++;

            for (int w = 1; w <= n; w++) //Updates path array with minimum distance from visited node from above FOR loop
            {
                if (distance[w] > (distance[v] + cost[v][w])) 
                {
                    distance[w] = distance[v] + cost[v][w];
                    path[w] = v;
                }
            }
            
        }
        System.out.println("Final path array");
        for (int i = 1; i <= n; i++) 
            System.out.print( path[i] +" ");
         

    }

    static void printPath(int startingVertex, int n, int dist[], int visited[], int path[]) {
        for (int w = 1; w <= n; w++) 
        {
            if (visited[w] == 1 && w != startingVertex) 
            {
                System.out.println("\nThe Shortest distance between ");
                System.out.println(startingVertex + " ->" + w + " is " + dist[w]);
                int t = path[w];
                System.out.println("The path is ");
                System.out.print(" " + w);
                while (t != startingVertex) 
                {
                    System.out.print(" <-->" + t);
                    t = path[t];
                }
                System.out.println("<-->" + startingVertex);

            }
        }

    }
}