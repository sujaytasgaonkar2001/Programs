import java.util.*;
public class dijkstra 
{
	final static int MAX = 20;
	final static int infinity = 9999;
	static int n; // No. of vertices of G
	static int a[][]; // Cost matrix
	static int path[] = new int[20];
	static int visited[] = new int[MAX]; //to store visited vertex
	static int distance[] = new int[MAX]; //distance from source
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		ReadMatrix();
		int startingVertex = 0; // starting vertex
		System.out.println("Enter starting vertex: ");
		startingVertex = scan.nextInt();
		Dijkstras(startingVertex); // find shortest path
		printPath(startingVertex);
        scan.close();
	}
	static void ReadMatrix() 
	{
		a = new int[MAX][MAX];
		System.out.println("Enter the number of vertices:");
		n = scan.nextInt();
		System.out.println("Enter the cost adjacency matrix:");
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				a[i][j] = scan.nextInt();
	}
	static void Dijkstras(int startingVertex) 
	{
		int minimumValueIndex, v;
		int i;
		for (i = 1; i <= n; i++) 
		{
			visited[i] = 0;
			distance[i] = a[startingVertex][i];
			if (a[startingVertex][i] == 999) {
                path[i] = 0;
            } else
                path[i] = startingVertex;
		}
		
		System.out.println("Initial path array");
        for (i = 1; i <= n; i++) {
           System.out.print( path[i] +" ");
        }
        System.out.println();
        
		visited[startingVertex] = 1;
		distance[startingVertex] = 1;
		i = 2;
		while (i <= n) 
		{
			minimumValueIndex = Extract_Min(visited, distance);  //to get minimum value's index
			visited[minimumValueIndex] = 1;
			i++;
			for (v = 1; v <= n; v++) //to check if we can reach any other vertices with less cost
			{
				if (((distance[minimumValueIndex] + a[minimumValueIndex][v] < distance[v]) && (visited[v] == 0)))
					distance[v] = distance[minimumValueIndex] + a[minimumValueIndex][v];
			}
			System.out.println("Final path array");
	        for (i = 1; i <= n; i++) 
	            System.out.print( path[i] +" ");
	        System.out.println();
		}
		  
	}
	
	static void printPath(int startingVertex) {
		for (int i = 1; i <= n; i++)
			if (visited[i] == 1 && i != startingVertex)
			{
				System.out.println("The Shortest Distance Between");
				System.out.println(startingVertex +" -> " + i + " is :" + distance[i]);
				int t = path[i];
				System.out.println("The path is ");
	            System.out.print(" " + i);
	            while (t != startingVertex) {
                    System.out.print("<-->" + t);
                    t = path[t];
                }
                System.out.println("<-->" + startingVertex);
			}
        }
	
	static int Extract_Min(int visited[], int distance[]) 
	{
		int i, j = 1, min;
		min = infinity;
		for (i = 1; i <= n; i++) 
		{
			if ((distance[i] < min) && (visited[i] == 0)) 
			{
				min = distance[i];
				j = i; //new vertex that can be reached with minimum cost
			}
		}
		return (j);
	}
}