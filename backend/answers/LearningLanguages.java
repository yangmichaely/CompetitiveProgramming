import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LearningLanguages {
	public static int max = 101;
	public static int[] parent;
	public static int[] rank;
	public static int[] freq;
	public static void main(String[] args) throws IOException {
		parent = new int[max];
		rank = new int[max];
		freq = new int[max];
		Arrays.fill(freq, 0);
		Arrays.fill(rank, 0);
		for(int i = 0; i < max; i++) {
			parent[i] = i;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int none = 0;
		int count = 0;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if(k == 0){
				none++;
				continue;
			}
			int u = Integer.parseInt(st.nextToken());
			freq[u]++;
			for(int j = 1; j < k; j++) {
				int v = Integer.parseInt(st.nextToken());
				freq[v]++;
				union(u, v);
			}
		}
		int ans = 0;
		for(int i = 1; i <= m; i++) {
			if(freq[i] == 0) {
				count++;
			}
			else if(parent[i] == i){
				ans++;
			}
		}
		ans--;
		if(count == m) {
			pw.println(n);
		}
		else {
			pw.println(ans + none);
		}
		pw.close();
	}
	public static void union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if(pu == pv) {
			return;
		}
		if(rank[pu] < rank[pv]){
			parent[pu] = pv;
		}
		else{
			parent[pv] = pu;
			if(rank[pu] == rank[pv]) {
				rank[pv]++;
			}
		}
	}
	public static int find(int u) {
		if(parent[u] != u) {
			parent[u] = find(parent[u]);
		}
		return parent[u];
	}
}