import java.util.Arrays;
import java.util.Scanner;

public class GravityFlip {
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		int n = myObj.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = myObj.nextInt();
		}
		for (int i = n - 2; i > -1; i--) {
			int r = i;
			int diff = heights[r] - heights[r + 1];
			while (r != n - 1 && diff > 0) {
				heights[r] -= diff;
				heights[r + 1] += diff;
				if (++r > n - 2) {
					break;
				}
				diff = heights[r] - heights[r + 1];
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(heights[i]);
		}
	}
}
