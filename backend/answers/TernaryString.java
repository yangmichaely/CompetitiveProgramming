import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TernaryString {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());

		for(int i = 0; i < n; i++){
			StringTokenizer s = new StringTokenizer(in.readLine());
			String input = String.valueOf(s.nextToken());
			out.println(count(input));
		}
		out.close();
	}

	public static int count(String input){
		if(!(input.contains("1") && input.contains("2") && input.contains("3"))){
			return 0;
		}
		int smallest = Integer.MAX_VALUE;
		int[] values = new int[3];
		int left = 0;
		for(int right = 0; right < input.length(); right++){
			values[input.charAt(right) - 49]++;
			while(values[input.charAt(left) - 49] > 1){
				values[input.charAt(left) - 49]--;
				left++;
			}
			if(values[1] != 0 && values[0] != 0 && values[2] != 0) {
				smallest = Math.min(smallest, right - left + 1);
			}
		}
		return smallest;
	}
}