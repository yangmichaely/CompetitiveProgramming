import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UpUpDownDown {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        ArrayList<String> input = new ArrayList<>();
        while(st.hasMoreTokens()){
            input.add(st.nextToken());
        }
        System.out.println(check(input));
    }

    public static int check(ArrayList<String> input){
        if(input.isEmpty()){
            return 0;
        }
        ArrayList<String> konami = new ArrayList<>
                (Arrays.asList("up", "up", "down", "down", "left", "right", "left", "right", "b", "a", "start"));
        int count = 0;
        for(int i = 0; i < 11; i++){
            if(konami.get(i).equals(input.get(i))){
                count++;
            }
        }
        return count;
    }
}
