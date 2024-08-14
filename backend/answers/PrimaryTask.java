import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrimaryTask {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(in.readLine());
			String num = st.nextToken();
			if(num.length() > 3 && num.charAt(0) == '1' && num.charAt(1) == '0' && num.charAt(2) != '0'){
				System.out.println("YES");
			}
			else if(num.length() == 3 && num.charAt(0) == '1' && num.charAt(1) == '0' && num.charAt(2) != '0' && num.charAt(2) != '1'){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
	}
}
