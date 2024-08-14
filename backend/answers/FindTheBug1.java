import java.io.*;
import java.util.*;

/**
 * Problem statement here: https://codeforces.com/problemset/problem/279/B
 *
 * I thought my sliding window approach made sense, but I'm not even passing the first test case!
 * NOTE: Getting rid of sliding window isn't the answer (You must maintain the intended efficiency).
 *
 * HINT: Make sure you fully understand what approach I'm trying first!
 */
public class FindTheBug1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int n = Integer.parseInt(stringTokenizer.nextToken());
		int t = Integer.parseInt(stringTokenizer.nextToken());

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int[] books = new int[n];
		for (int i = 0; i < n; i++) books[i] = Integer.parseInt(stringTokenizer.nextToken());

		// Sliding window/Two pointers
		int answer = 0;
		int right = 0;
		int rangeSum = 0;
		for (int left = 0; left < n; left++) {
			// Trying to add the next element to our window
			while (right < n && rangeSum + books[right] <= t) {
				rangeSum += books[right];
				right++;
			}
			if (answer < right - left) answer = right - left;
			rangeSum -= books[left]; //add this line of code here to update the left side of the window
		}
		System.out.println(answer);
	}
}


