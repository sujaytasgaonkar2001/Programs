import java.util.Scanner;
public class krushkal {
    static int parent[] = new int[20];
    static int i,j, noe = 1, u, v, a, b, min, mincost = 0;
    static int cost[][] = new int[10][10];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of nodes ");
        int n = in.nextInt();

        System.out.println("Enter the cost matrix");
        for (i = 1; i<=n; i++){
            for (j =1; j<=n; j++){
                cost[i][j] = in.nextInt();
            }
        }

        System.out.println("The entered cost matrix is ");
        System.out.println("The cost matrix");
        for(i = 1; i<=n; i++){
            for(j = 1; j<=n; j++){
                System.out.print(cost[i][j] + "   ");
            }
            System.out.println();
        }

        while(noe < n){
            min = 999;
            for(i = 1; i<=n; i++){
                for (j=1; j<=n; j++){
                    if(cost[i][j] < min){
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;
                    }
                }
            }
            u = find(u);
            v = find(v);
            union();
            }
         System.out.println("Min cost = " + mincost);
    }
    

    static int find(int w){
        while(parent[w] != 0){
            w = parent[w];
        }
        return w;
    }

    static void union(){
        if(u != v){
            noe++;
            System.out.println(noe-1 + "Edge(" + a + ", " + b + ")= " + min);
            mincost += min;
            parent[v] = u;
        }
        cost[a][b] = cost[b][a] = 999;
    }
}