package homework;

import java.io.*;
import java.util.*;
 
public class Solution_d4_1249_보급로_서울_20반_박홍빈 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input1249.txt"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        int T = Integer.parseInt(in.readLine());
        for(int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(in.readLine());
            int[][] g = new int[N][N];
            int[][] dist = new int[N][N];
            boolean[][] v = new boolean[N][N];
            for(int i=0;i<N;i++) {
                String str = in.readLine();
                for(int j=0;j<N;j++) {
                    g[i][j] = str.charAt(j) - '0';
                }
            }
            int start = 0;
            int end = N-1;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
             
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->Integer.compare(o1[2], o2[2]));
            dist[start][start] = g[start][start];
            pq.offer(new int[] {start, start, dist[start][start]});
            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                int min = cur[2];
                int mini = cur[0];
                int minj = cur[1];
                if(v[mini][minj]) continue;
                 
                v[mini][minj] = true;
                if(mini == N-1 && minj == N-1) break;
                 
                for(int d=0;d<4;d++) {
                    int ni = mini + di[d];
                    int nj = minj + dj[d];
                    if(ni>=0 && ni<N && nj>=0 && nj<N && !v[ni][nj] && dist[ni][nj] > min + g[ni][nj]) {
                                                                       dist[ni][nj] = min + g[ni][nj];
                                                                       pq.offer(new int[] {ni, nj, min + g[ni][nj]});
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(dist[end][end]).append("\n");
        }
        System.out.print(sb.toString());
        in.close();
    }
}