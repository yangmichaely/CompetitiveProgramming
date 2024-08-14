import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoadConstruction {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] dj;
		dj = new int[n];
		Arrays.fill(dj, -1);
		int largest = 1;

		while (m > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int newSize = union(a, b, dj);
			if (newSize != 0) {
				n--;
				largest = Integer.max(largest, newSize);
			}
			pw.println(n + " " + largest);
			m--;
		}
		pw.close();
	}

	public static int find(int v, int[] dj) {
		if (dj[v] < 0) {
			return v;
		}
		dj[v] = find(dj[v], dj);
		return dj[v];
	}

	public static int union(int u, int v, int[] dj) {
		u = find(u, dj);
		v = find(v, dj);
		if (u == v) {
			return 0;
		}
		if (dj[u] < dj[v]) {
			int tempU = u;
			u = v;
			v = tempU;
		}
		dj[v] += dj[u];
		dj[u] = v;
		return -dj[v];
	}
}