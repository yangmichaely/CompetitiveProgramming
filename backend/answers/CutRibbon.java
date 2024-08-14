import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CutRibbon {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = 0;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                int total = a*i + b*j;
                if(total == n){
                    max = Math.max(max, i + j);
                }
                else if(total < n){
                    int diff = n - total;
                    if(diff % c == 0){
                        int h = diff / c;
                        max = Math.max(max, i + j + h);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
