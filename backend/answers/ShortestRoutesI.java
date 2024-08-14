import java.io.*;
import java.util.*;

public class ShortestRoutesI {
    public static class node {
        long weight;
        int trg;
        node(int t, long w){
            trg = t;
            weight = w;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int connections = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<node>> adj = new ArrayList<>();
        int src, trg;
        long weight;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < connections; i++){
            st = new StringTokenizer(in.readLine());
            src = Integer.parseInt(st.nextToken()) - 1;
            trg = Integer.parseInt(st.nextToken()) - 1;
            weight = Long.parseLong(st.nextToken());
            adj.get(src).add(new node(trg, weight));
        }
        dijkstras(adj, n);
    }

    public static void dijkstras(ArrayList<ArrayList<node>> adj, int n){
        long[] dist = new long[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<node> p = new PriorityQueue<>(Comparator.comparingLong(a -> a.weight));
        p.add(new node(0, 0));
        while(!p.isEmpty()){
            node cur = p.poll();
            if(!visited[cur.trg]){
                visited[cur.trg] = true;
                for (node a : adj.get(cur.trg)) {
                    if (dist[cur.trg] + a.weight < dist[a.trg] && !visited[a.trg]) {
                        dist[a.trg] = a.weight + dist[cur.trg];
                        p.add(new node(a.trg, dist[a.trg]));
                    }
                }
            }
        }
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        out.print("0");
        for(int i = 1; i < n; i++){
            out.print(" " + dist[i]);
        }
        out.close();
    }
}