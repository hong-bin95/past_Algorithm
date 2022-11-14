package homework;

import java.io.*;
import java.util.*;

public class Solution_d4_1486_장훈이의_높은_선반_서울_20반_이해은 {

static boolean v[];
static int N, B, answer;
static int[] worker;

public static void main(String[] args) throws Exception {
	System.setIn(new FileInputStream("res/input_1486.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();
    
    int T = Integer.parseInt(br.readLine());
    
    for(int tc = 1; tc <= T; tc++) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // 점원 수
        B = Integer.parseInt(st.nextToken()); // 물건이 놓인 높이
        
        v = new boolean[N];
        worker = new int[N];
        
        st = new StringTokenizer(br.readLine(), " ");
        for(int n = 0; n < N; n++) {
            worker[n] = Integer.parseInt(st.nextToken());
        }
        
        answer = Integer.MAX_VALUE;
        
        subset(0, 0);
        
        int total = Math.abs(B - answer);
        
        sb.append("#").append(tc).append(" ").append(total).append("\n");
    }
    
    System.out.println(sb.toString());
    br.close();
    
}

	static void subset(int cnt, int sum) {
	    if(sum >= B) {
	        if(answer > sum) answer = sum;
	        return;
	    }
	    
	    if(cnt == N) return;
	    
	    v[cnt] = true;
	    subset(cnt + 1, sum + worker[cnt]);
	    v[cnt] = false;
	    subset(cnt + 1, sum);
	}
}

