import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OrderingCupcakes {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int guests = Integer.parseInt(st.nextToken());
		int flavors = Integer.parseInt(st.nextToken());
		int[] cupcakes = new int[flavors];
		st = new StringTokenizer(in.readLine());
		for(int i = 0; i < guests; i++) {
			int guestFlavor = Integer.parseInt(st.nextToken());
			cupcakes[guestFlavor - 1]++;
		}
		for(int i = 0; i < flavors; i++) {
			if(cupcakes[i] % 12 != 0){
				cupcakes[i] += (12 - cupcakes[i] % 12);
			}
			System.out.println(cupcakes[i] / 12);
		}
	}
}
