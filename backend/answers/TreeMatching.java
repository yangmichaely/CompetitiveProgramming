import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeMatching {
	static ArrayList<Integer>[] adj;
	static int[][] dp;
	static boolean[] done;
	static int ans;

	static void matchesDP(int node, int parent) {
		for (int child : adj[node]) {
			if (child == parent) {
				continue;
			}
			matchesDP(child, node);
			dp[node][0] += Math.max(dp[child][0], dp[child][1]);
		}
		for (int child : adj[node]) {
			if (child == parent) {
				continue;
			}
			dp[node][1] = Math.max(dp[node][1], 1 + dp[node][0] + dp[child][0] - Math.max(dp[child][0], dp[child][1]));
		}
	}

	static void matchesGreedy(int node, int parent) {
		for (int child : adj[node]) {
			if(child != parent){
				matchesGreedy(child, node);
				if(!done[child] && !done[node]){
					done[node] = done[child] = true;
					++ans;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		done = new boolean[n];
		adj = new ArrayList[n];
		dp = new int[n][2];
		for (int i = 0; i < n; ++i) {
			adj[i] = new ArrayList<>();
		}
		for(int i = 0; i < n - 1; ++i){
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			adj[a].add(b);
			adj[b].add(a);
		}
		//matchesDP(0, -1);
		matchesGreedy(0, -1);
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		//out.println(Math.max(dp[0][0], dp[0][1]));
		out.println(ans);
		out.close();
	}
}
