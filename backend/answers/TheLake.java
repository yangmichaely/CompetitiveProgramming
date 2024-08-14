import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class TheLake {
	public static class coord {
		int j;
		int h;

		coord(int x, int y) {
			j = x;
			h = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int b = Integer.parseInt(st.nextToken());
		for (int i = 0; i < b; i++) {
			st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long[][] adj = new long[n][m];
			int[][] connection = new int[n][m];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(in.readLine());
				for (int h = 0; h < m; h++) {
					adj[j][h] = Integer.parseInt(st.nextToken());
					connection[j][h] = 0;
				}
			}
			long max = Long.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				for (int h = 0; h < m; h++) {
					if(adj[j][h] != 0 && connection[j][h] == 0){
						max = Math.max(dfs(adj, connection, n, m, j, h), max);
					}
				}
			}
			if(max == Long.MIN_VALUE){
				out.println(0);
			}
			else{
				out.println(max);
			}
		}
		out.close();
	}
	public static long dfs (long[][] adj, int[][] connection, int n, int m, int j, int h){
		Stack<coord> stack = new Stack<>();
		coord a = new coord(j, h);
		stack.push(a);
		long c = 0;
		while (!stack.empty()) {
			coord d = stack.pop();
			if(connection[d.j][d.h] == 0){
				c += adj[d.j][d.h];
			}
			connection[d.j][d.h] = 1;
			if(d.j + 1 < n && adj[d.j + 1][d.h] != 0 && connection[d.j + 1][d.h] == 0){
				stack.push(new coord(d.j + 1, d.h));
			}
			if(d.j - 1 >= 0 && adj[d.j - 1][d.h] != 0 && connection[d.j - 1][d.h] == 0){
				stack.push(new coord(d.j - 1, d.h));
			}
			if(d.h + 1 < m && adj[d.j][d.h + 1] != 0 && connection[d.j][d.h + 1] == 0){
				stack.push(new coord(d.j, d.h + 1));
			}
			if(d.h - 1 >= 0 && adj[d.j][d.h - 1] != 0 && connection[d.j][d.h - 1] == 0){
				stack.push(new coord(d.j, d.h - 1));
			}
		}
		return c;
	}
}
