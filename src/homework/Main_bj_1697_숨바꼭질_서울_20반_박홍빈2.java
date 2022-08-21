package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1697_숨바꼭질_서울_20반_박홍빈2 {

	static int N,K;
	
	static final int MAX = 12;
	
	// 순간이동 = 0, 앞으로 걷기 = 1, 뒤로 걷기 = 2
	static int[] arr;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	
	static void per(int depth) {
		if(depth == MAX) {
			int cnt = 0;
			int current = N;
			for(int i = 0 ; i < MAX ; i++) {
				if(arr[i] == 0) {
					current *= 2;
				}
				else if(arr[i] == 1)  {
					current += 1;
				}
				else if(arr[i] == 2)  {
					current -= 1;
				}
				
				cnt++;
				
				if(current == K) {
					if(min > cnt) {
						min = cnt;
					}
					//break;
				}
			}
			return;
		}
		
		for(int i = 0 ; i < 3 ; i++) {
			visited[depth] = true;
			arr[depth] = i;
			per(depth+1);
			visited[depth] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj_1967.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		// 수빈 위치
		N = Integer.parseInt(st.nextToken());
		// 동생 위치
		K = Integer.parseInt(st.nextToken());
		
		if(N >= K) {
			System.out.println(N - K);
		}
		else {
			arr = new int[MAX];
			visited = new boolean[MAX+1];
			
			per(0);
			
			System.out.println(min);
		}
		
	}

}
