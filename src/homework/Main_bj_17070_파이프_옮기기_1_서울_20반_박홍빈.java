package homework;

import java.io.*;
import java.util.*;

public class Main_bj_17070_파이프_옮기기_1_서울_20반_박홍빈 {
	
	static int N;
	static int arr[][];
	static boolean visited[];
	static long min = Integer.MAX_VALUE;
	
	 public static void dfs(int start, int now, long cost){
	        if (allVisited()) {
	            if(arr[now][start]!=0){
	            	min = Math.min(min, cost+arr[now][0]);
	            }
	            return;
	        }

	        for(int i=1; i<N; i++){
	            if (!visited[i] && arr[now][i] != 0) {
	                visited[i] = true;
	                dfs(start, i, cost + arr[now][i]);
	                visited[i] = false;
	            }
	        }
	    }

	    public static boolean allVisited() {
	        for (int i = 0; i < N; i++) {
	            if (!visited[i]) {
	                return false;
	            }
	        }
	        return true;
	    }

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj10971.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		String str;
		StringTokenizer st;
		
		arr = new int[N+1][N+1];
		visited = new boolean[N+1];		
		
		for(int i = 0 ; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for(int j = 0 ; j < N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		 for(int i=0; i<N; i++) {
	            visited = new boolean[N];
	            visited[i] = true;
	            dfs(i, i, 0);
	        }
		
		System.out.println(min);
		

	}

}
