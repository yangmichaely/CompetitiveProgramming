import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StickLengths {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[] sticks = new long[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			sticks[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(sticks);
		long median = sticks[n/2];
		long count = 0;
		for(long i : sticks){
			count += (Math.abs(i - median));
		}
		System.out.println(count);
	}
}