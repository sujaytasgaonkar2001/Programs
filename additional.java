import java.util.*;
public class additional {
    static int parent[] = new int[20];
    static int deg[] = new int[20];
    
    static int i,j, noe = 1, u, v, a, b, min, mincost = 0,maxd;
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

        System.out.println("The cost matrix");
        for(i = 1; i<=n; i++){
            for(j = 1; j<=n; j++){
                System.out.print(cost[i][j] + "   ");
            }
            System.out.println();
        }
        for(i = 1; i<=n; i++){
            for(j = 1; j<=n; j++){
                if(cost[i][j] == 1)  //if the cost is 1 then the 2 edges are connected, else infinity(999)
                    deg[i]++;
            }
        }

        while(noe < n){
            maxd = 0; //
            for(i = 1; i<=n; i++){
                 if(deg[i]>maxd) {                     
                     maxd = deg[i];
                     a = u = i;
                 }                 
            }
            for (j=1; j<=n; j++){               
                  if(cost[a][j]  != 999) {                           
                        b = v = j;
                        u = find(u);
                        v = find(v);
                        union();
                }
                
            }           
        }
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
            System.out.println(noe-1 + "Edge(" + a + ", " + b + ") ");
            parent[v] = u;
        }
        cost[a][b] = cost[b][a] = 999;
        deg[a] = 0;
        
    }
}