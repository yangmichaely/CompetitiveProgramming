import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeforeAnExam {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int n = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(st.nextToken());
		ArrayList<Integer> ans = new ArrayList<>();
		ArrayList<Integer> left = new ArrayList<>();
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max = Integer.parseInt(st.nextToken());
			left.add(max - min);
			ans.add(min);
			sum -= min;
		}
		if(sum == 0){
			System.out.println("YES");
			for(int i = 0; i < n; i++){
				System.out.print(ans.get(i) + " ");
			}
		}
		else if (sum < 0){
			System.out.println("NO");
		}
		else{
			for(int i = 0; i < n; i++){
				if(sum > left.get(i)){
					sum -= left.get(i);
					ans.set(i, ans.get(i) + left.get(i));
				}
				else{
					ans.set(i, ans.get(i) + sum);
					sum = 0;
					System.out.println("YES");
					for(int j = 0; j < n; j++){
						System.out.print(ans.get(j) + " ");
					}
					break;
				}
			}
			if(sum > 0){
				System.out.println("NO");
			}
		}
	}
}
