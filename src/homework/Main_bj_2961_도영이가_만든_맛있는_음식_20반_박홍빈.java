package homework;

import java.io.*;
import java.util.*;

public class Main_bj_2961_도영이가_만든_맛있는_음식_20반_박홍빈 {

	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int min;

	static ArrayList<Integer> slist;
	static ArrayList<Integer> blist; 
	
	static void dfs(int index, int start, int total) {
		if(index == total) {
			
		}
		
		for(int i = start; i < N; i++) {
			
		}
	}
	
	static void subset(int index) {
		if(index == N) {
			int S = 1;
			int B = 0;
			// 공집합인지 확인
			boolean isEmpty = true;
			for(int i = 0 ; i < N; i++) {
				if(visited[i]) {
					isEmpty = false;
					S *= arr[i][0];
					B += arr[i][1];
				}						
			}
			
			if(!isEmpty && min > Math.abs(S - B)) {
				min =  Math.abs(S - B);
			}
			
			return;
		}		

		visited[index] = true;
		subset(index+1);
		visited[index] = false;
		subset(index+1);
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2961.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			// 신맛
			arr[i][0] = Integer.parseInt(st.nextToken());
			// 쓴맛
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		subset(0);
		
		System.out.println(min);
		
		
	}

}
