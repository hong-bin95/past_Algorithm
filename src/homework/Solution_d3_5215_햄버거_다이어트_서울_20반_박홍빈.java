package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_5215_햄버거_다이어트_서울_20반_박홍빈 {
	
	static int N;
	static int L;
	static int max;
	static boolean[] visited;
	// 점수 리스트
	static int[] srr;
	// 칼로리 리스트
	static int[] krr;
	
	static void subset(int index) {
		if(index == N) {
			// 맛의 합
			int sum = 0;
			// 칼로리의 합
			int ksum = 0;
			boolean isEmpty = true;
			String str = "";
			for(int i = 0 ; i < N ; i++) {
				if(visited[i]) {
					str += "[" + srr[i] + "\t" + krr[i] + "]";
					isEmpty = false;
					sum += srr[i];
					ksum += krr[i];
				}
			}
			System.out.println(str);
			if(isEmpty != true && ksum <= L && sum >= max) {
				max = sum;
			}
			return;
		}
		
		visited[index] = true;
		subset(index+1);
		visited[index] = false;
		subset(index+1);
	}
	
	public static void main(String[] args) throws Exception {
		 System.setIn(new FileInputStream("res/input_5215.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 
		 for(int tc = 1; tc <= T; tc++) {
			 String str = br.readLine();
			 StringTokenizer st = new StringTokenizer(str);
			 N = Integer.parseInt(st.nextToken());
			 L = Integer.parseInt(st.nextToken());

			 srr = new int[N];
			 krr = new int[N];
			 
			 visited = new boolean[N];	 
			 max = Integer.MIN_VALUE;
			 
			 for(int i = 0 ; i < N ; i++) {
				 str = br.readLine();
				 st = new StringTokenizer(str);
				 srr[i] =  Integer.parseInt(st.nextToken());
				 krr[i] =  Integer.parseInt(st.nextToken());
			 }
			 
			 subset(0);
			 
			 System.out.println("#" + tc + " " + max);
		 }
		 
		 
	}

}
