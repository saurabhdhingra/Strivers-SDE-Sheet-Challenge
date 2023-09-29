//{ Driver Code Starts
import java.util.*;
import java.io.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        boolean negCyc = false;
        int dist[] = new int[V];
        
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[S] = 0;
       
        for (int j = 0; j < edges.size(); ++j) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int weight = edges.get(j).get(2);
            if (dist[u] != Integer.MAX_VALUE
                && dist[u] + weight < dist[v])
                dist[v] = dist[u] + weight;
        }
        
        for (int j = 0; j < edges.size(); ++j) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int weight = edges.get(j).get(2);
            if (dist[u] != Integer.MAX_VALUE
                && dist[u] + weight < dist[v]) {
                negCyc = true;
                break;
            }
        }
        
        if(negCyc) return new int[1];
        return dist;
        
    }
}
