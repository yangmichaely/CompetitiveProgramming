import java.io.*;
import java.util.*;

/**
 * Hmm, I can't figure this out. My code seems to run in time and I get the
 * correct output on the sample, but I'm getting a Wrong Answer (WA) when
 * uploading to the online judge!
 *
 * Problem statement can be found here:
 * https://open.kattis.com/problems/hauntedgraveyard
 */
public class FindTheBug3
{

    final int[] dx = {1, 0, -1, 0};
    final int[] dy = {0, 1, 0, -1};
    final long INF = (long) 1e12;

    int R, C, G, E;
    boolean[][] graves;
    boolean[][] holes;
    int[][] portals;
    long[][] distance;

    boolean readInput(BufferedReader br) throws IOException
    {
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        if (R == 0 || C == 0)
            return false;
        distance = new long[R][C];
        graves = new boolean[R][C];
        holes = new boolean[R][C];
        G = Integer.parseInt(br.readLine());
        for (int i = 0; i < G; ++i)
        {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graves[r][c] = true;
        }
        E = Integer.parseInt(br.readLine());
        portals = new int[5][E];
        for (int i = 0; i < E; ++i)
        {
            st = new StringTokenizer(br.readLine());
            portals[0][i] = Integer.parseInt(st.nextToken());
            portals[1][i] = Integer.parseInt(st.nextToken());
            portals[2][i] = Integer.parseInt(st.nextToken());
            portals[3][i] = Integer.parseInt(st.nextToken());
            portals[4][i]  = Integer.parseInt(st.nextToken());
            holes[portals[1][i]][portals[0][i]] = true;
        }
        return true;
    }

    boolean relax()
    {
        boolean relaxed = false;
        // 1. Edges between adjacent cells in a grid
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (holes[i][j] || graves[i][j] || (i == R - 1 && j == C - 1))
                    continue;
                for (int d = 0; d < 4; d++) {
                    int newI = i + dx[d];
                    int newJ = j + dy[d];
                    if (newI < 0 || newI >= R || newJ < 0 || newJ >= C || graves[newI][newJ])
                        continue;
                    if(distance[i][j] + 1 < distance[newI][newJ]) {
                        relaxed = true;
                        distance[newI][newJ] = distance[i][j] + 1;
                    }
                }
            }
        }
        // 2. Haunted hole edges
        for (int i = 0; i < E; ++i)
        {
            if (distance[portals[1][i]][portals[0][i]] < INF && distance[portals[1][i]][portals[0][i]] + portals[4][i] < distance[portals[3][i]][portals[2][i]])
            {
                relaxed = true;
                distance[portals[3][i]][portals[2][i]] = distance[portals[1][i]][portals[0][i]] + portals[4][i];
            }
        }

        return relaxed;
    }

    void bellmanFord() {
        for (int i = 0; i < R; ++i)
            Arrays.fill(distance[i], INF);
        distance[0][0] = 0;
        for (int iter = 0; iter < R * C - 1; iter++)
            if (!relax())
                break;
        if (relax())
            distance = null;
    }

    public void run() throws IOException
    {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final PrintWriter out = new PrintWriter(System.out);
        while (true)
        {
            if (!readInput(br))
                break;
            bellmanFord();
            if (distance == null)
                out.println("Never");
            else if (distance[R-1][C-1] == INF)
                out.println("Impossible");
            else
                out.println(distance[R-1][C-1]);
        }
        out.close();
    }

    public static void main(String[] args) throws IOException
    {
        new FindTheBug3().run();
    }
}