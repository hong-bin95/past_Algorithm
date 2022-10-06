package homework;

import java.io.*;
import java.util.*;

public class Main_bj_9205_맥주마시면서걸어가기_서울_20반_박홍빈2 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/bj9205.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			int n = Integer.parseInt(br.readLine());
			List<int[]> list = new ArrayList<>();
			for(int i=0; i<n+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[]{x,y});
			}
			
			boolean[][] flag = new boolean[n+2][n+2];
			for(int i=0; i<n+2; i++) {
				for(int j=0; j<n+2; j++) {
					int[] pos = list.get(i), next = list.get(j);
					int dis = Math.abs(pos[0] - next[0]) + Math.abs(pos[1]-next[1]);
					
					if(dis <= 1000) flag[i][j] =true;
				}
			}
			
			for(int k=0; k<n+2; k++) {
				for(int i=0; i<n+2; i++) {
					for(int j=0; j<n+2; j++) {
						if(flag[i][k] && flag[k][j]) {
							flag[i][j] = true;
						}
					}
				}
			}
			bw.write(flag[0][n+1] ? "happy\n": "sad\n");
		}
		bw.flush();
		bw.close();
		
	}

}
