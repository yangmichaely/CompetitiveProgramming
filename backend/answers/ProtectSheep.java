import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProtectSheep {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int max = 0;
        char[][] pos = new char[n][k];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(in.readLine());
            String s = st.nextToken();
            for(int j = 0; j < k; j++){
                pos[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < k; j++){
                if(pos[i][j] == 'S'){
                    if(j + 1 < k && pos[i][j + 1] == '.'){
                        pos[i][j + 1] = 'D';
                    }
                    else if(j + 1 < k && pos[i][j + 1] == 'W'){
                        System.out.println("No");
                        System.exit(0);
                    }
                    if(j - 1 >= 0 && pos[i][j - 1] == '.'){
                        pos[i][j - 1] = 'D';
                    }
                    else if(j - 1 >= 0 && pos[i][j - 1] == 'W'){
                        System.out.println("No");
                        System.exit(0);
                    }
                    if(i + 1 < n && pos[i + 1][j] == '.'){
                        pos[i + 1][j] = 'D';
                    }
                    else if(i + 1 < n && pos[i + 1][j] == 'W'){
                        System.out.println("No");
                        System.exit(0);
                    }
                    if(i - 1 >= 0 && pos[i - 1][j] == '.'){
                        pos[i - 1][j] = 'D';
                    }
                    else if(i - 1 >= 0 && pos[i - 1][j] == 'W'){
                        System.out.println("No");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("Yes");
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(pos[i][j]);
            }
            System.out.print("\n");
        }
    }
}
