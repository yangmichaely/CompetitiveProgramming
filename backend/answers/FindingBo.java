import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindingBo {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;
        int r = 0;
        int c = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            String s = st.nextToken();
            for(int j = 0; j < k; j++){
                if(s.charAt(j) != '.'){
                    if(max < s.charAt(j) - '0'){
                        r = i + 1;
                        c = j + 1;
                        max = s.charAt(j) - '0';
                    }
                }
            }
        }
        System.out.println(r + " " + c);
    }
}
