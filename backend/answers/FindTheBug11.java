import java.io.*;
import java.util.*;

/**
 * Problem is here: https://www.spoj.com/problems/LCASQ/
 *
 * I'm passing the first test case, but not the rest.
 * I thought my LCA finding was correct, maybe something's wrong with my binary lifting?
 * HINT: Try making your own simple test cases
 */
class FindTheBug11 {
	/* 2^14 > 1e4, which is our max n */
	private static final int MAXN = 10000;
	private static final int LOGN = 14;

	public static int[] computeDepths(ArrayList<Integer>[] edges) {
		int[] depth = new int[MAXN];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i = 0; i < edges[node].size(); i++) {
				depth[edges[node].get(i)] = depth[node] + 1;
				q.add(edges[node].get(i));
			}
		}
		return depth;
	}

	public static void main(String[] args) throws IOException {
		int[][] ancestor = new int[MAXN][LOGN];
		ArrayList<Integer>[] edges = new ArrayList[MAXN];

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		int n = Integer.parseInt(st.nextToken());
		// Root points to themself.
		ancestor[0][0] = 0;
		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<>();
			st = new StringTokenizer(bufferedReader.readLine());
			int numChildren = Integer.parseInt(st.nextToken());
			for (int j = 0; j < numChildren; j++) {
				int child = Integer.parseInt(st.nextToken());
				ancestor[child][0] = i;
				edges[i].add(child);
			}
		}
		// We run a BFS to compute depths
		int[] depth = computeDepths(edges);
		for (int i = 1; i < LOGN; i++) {
			for (int j = 0; j < n; j++) {
				int prev = ancestor[j][i - 1];
				ancestor[j][i] = ancestor[prev][i - 1];
			}
		}

		// Begin answering queries
		st = new StringTokenizer(bufferedReader.readLine());
		int q = Integer.parseInt(st.nextToken());
		while (q-- > 0) {
			st = new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// Take a and b to same level
			for (int i = LOGN - 1; i >=0; i--) {
				// If the gap is >= 2^i
				if (depth[a] - depth[b] >= (1 << i)) {
					a = ancestor[a][i];
				}
				//bug here - need to adjust b too in case b is deeper than a
				if (depth[b] - depth[a] >= (1 << i)) {
					b = ancestor[b][i];
				}
			}
			if (a != b) {
				// Binary search for the highest unequal value
				for (int i = LOGN - 1; i >=0; i--) {
					int jumpA = ancestor[a][i];
					int jumpB = ancestor[b][i];
					if (jumpA != jumpB) {
						a = jumpA;
						b = jumpB;
					}
				}
				// Advance one to get the LCA
				a = ancestor[a][0];
			}
			System.out.println(a);
		}
	}
}
