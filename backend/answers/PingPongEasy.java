import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PingPongEasy {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] intervals = new boolean[100][100];
        int[] x = new int[100];
        int[] y = new int[100];
        int c = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if(op == 2){
                if(intervals[a][b]){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                x[c] = a;
                y[c] = b;
                for(int j = 0; j < c; j++){
                    intervals[c][j] = x[j] < x[c] && x[c] < y[j] ||
                            x[j] < y[c] && y[c] < y[j];
                    intervals[j][c] = x[c] < x[j] && x[j] < y[c] ||
                            x[c] < y[j] && y[j] < y[c];
                }
                for(int l = 0; l <= c; l++){
                    for(int k = 0; k <= c; k++){
                        for(int m = 0; m <= c; m++){
                            if(intervals[k][l] && intervals[l][m]){
                                intervals[k][m] = true;
                            }
                        }
                    }
                }
                c++;
            }
        }
    }
}
