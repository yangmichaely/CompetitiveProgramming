import java.io.*;
import java.util.*;

public class ShortestRoutesII {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int connections = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());
        long[][] adj = new long[n][n];
        int src, trg;
        long weight;
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if(i == j){
                    adj[i][j] = 0L;
                }
                else {
                    adj[i][j] = 10000000000L;
                }
            }
        }
        for(int i = 0; i < connections; i++){
            st = new StringTokenizer(in.readLine());
            src = Integer.parseInt(st.nextToken()) - 1;
            trg = Integer.parseInt(st.nextToken()) - 1;
            weight = Long.parseLong(st.nextToken());
            adj[src][trg] = Math.min(weight, adj[src][trg]);
            adj[trg][src] = Math.min(weight, adj[trg][src]);
        }
        for(int k = 0; k < n; k++){
            for(int v = 0; v < n; v++){
                for(int w = 0; w < n; w++){
                    if(adj[v][w] > adj[v][k] + adj[k][w]){
                        adj[v][w] = adj[v][k] + adj[k][w];
                    }
                }
            }
        }
        for(int i = 0; i < queries; i++) {
            st = new StringTokenizer(in.readLine());
            Long ans = adj[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1];
            if(ans == 10000000000L){
                System.out.println("-1");
            }
            else{
                System.out.println(ans);
            }
        }
    }
}