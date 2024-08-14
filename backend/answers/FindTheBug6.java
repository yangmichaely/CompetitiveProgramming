import java.io.*;
import java.util.*;

// I coded up a recursive search solution to the following Kattis problem, but I'm getting WA on the sample case...
// https://open.kattis.com/problems/geppetto

public class FindTheBug6
{

    int N, M;
    ArrayList[] bad;
    int ans = 0;

    public void search(HashSet<Integer> cur, int ind)
    {
        if (ind == N)
        {
            ++ans;
            return;
        }

        search(cur, ind + 1);

        boolean canAdd = true;

        for (Object bb : bad[ind])
        {
            Integer b = (Integer) bb;
            if (cur.contains(b))
            {
                canAdd = false;
            }
        }

        if (canAdd)
        {
            cur.add(ind);
            search(cur, ind + 1);
            cur.remove(ind); //here's the bug!
        }
    }

    public void run() throws Exception
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        bad = new ArrayList[N];

        for (int i = 0; i < N; ++i)
        {
            bad[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; ++i)
        {
            int a = in.nextInt(), b = in.nextInt();
            bad[a-1].add(b-1);
            bad[b-1].add(a-1);
        }

        search(new HashSet<Integer>(), 0);

        System.out.println(ans);
        in.close();
    }

    public static void main(String[] args) throws Exception
    {
        new FindTheBug6().run();
    }
}
