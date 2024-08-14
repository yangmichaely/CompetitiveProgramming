import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

// https://www.spoj.com/problems/SOCNETC/
// Looks like I'm getting a WA, can you figure out why?
class FindTheBug10 {

	static int[] parent;
	static int[] size;

	// Initialize Union Find to have each component of size 1 by itself
	public static void initialize(int n) {
		parent = new int[n];
		size = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		Arrays.fill(size, 1);
	}

	public static int find(int child) {
		if (parent[child] == child) {
			return child;
		}

		// Path compression to make it quicker to find the parent next time
		parent[child] = find(parent[child]);
		return parent[child];
	}

	public static void union(int childA, int childB, int maxSize) {
		int rootA = find(childA);
		int rootB = find(childB);

		if (rootA == rootB) {
			// Already same component, no need to merge
			return;
		}

		if (size[rootA] + size[rootB] > maxSize) {
			// Cannot create community beyond max size according to the problem

			return;
		}

		if (size[rootA] > size[rootB]) {
			// Swap
			int tmp = rootA;
			rootA = rootB;
			rootB = tmp;
		}

		// We have that size[rootA] <= size[rootB], so it is best to merge rootA into
		// rootB
		size[rootB] += size[rootA];
		parent[rootA] = rootB;
	}

	public static void main(String[] args) {
		// Using FastIO, you can ignore this and the below class, it isn't the bug
		FastScanner scan = new FastScanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		initialize(n);

		int q = scan.nextInt();
		for (int i = 0; i < q; i++) {
			String query = scan.next();

			if (query.equals("S")) {
				// Want to print the size of the community x belongs to, so we look at x's root
				int x = scan.nextInt() - 1;
				System.out.println(size[find(x)]);
			} else if (query.equals("A")) {
				// Want to add friend connection
				int x = scan.nextInt() - 1;
				int y = scan.nextInt() - 1;
				union(x, y, m);
			} else {
				// Want to check if x and y are in the same community
				int x = scan.nextInt() - 1;
				int y = scan.nextInt() - 1;
				if (find(x) == find(y)) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}
			}
		}
	}

	static class FastScanner {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;

		public FastScanner(InputStream stream) {
			this.stream = stream;
		}

		int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}

		boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		boolean isEndline(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String next() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		String nextLine() {
			int c = read();
			while (isEndline(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndline(c));
			return res.toString();
		}
	}
}
