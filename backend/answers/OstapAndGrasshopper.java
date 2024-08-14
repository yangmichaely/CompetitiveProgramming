import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class OstapAndGrasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int n = Integer.parseInt(st.nextToken());
        int jump = Integer.parseInt(st.nextToken());
        int target = 0;
        int grasshopper = 0;
        StringTokenizer s = new StringTokenizer(in.readLine());
        String line = s.nextToken();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            if(line.charAt(i) == 'T'){
                target = i;
            }
            else if(line.charAt(i) == 'G'){
                grasshopper = i;
            }
            arr[i] = line.charAt(i);
        }
        ArrayList<Integer> valid = new ArrayList<>();
        int pointer = grasshopper - jump;
        while(pointer > -1){
            if(arr[pointer] != '#'){
                valid.add(pointer);
                pointer -= jump;
            }
            else{
                break;
            }
        }
        pointer = grasshopper + jump;
        while(pointer < n){
            if(arr[pointer] != '#'){
                valid.add(pointer);
                pointer += jump;
            }
            else{
                break;
            }
        }
        if(valid.contains(target)){
            out.println("YES");
        }
        else{
            out.println("NO");
        }
        out.close();
    }
}
