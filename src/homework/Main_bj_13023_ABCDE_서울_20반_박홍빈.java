package homework;

import java.io.*;
import java.util.*;

public class Main_bj_13023_ABCDE_서울_20반_박홍빈 {
	
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	
	static void dfs(int x, int len) {
        if(len == 4) {
            System.out.println(1);
            System.exit(0);
        }
        
        visited[x] = true;
        for(int i = 0; i < list.get(x).size(); i++) {
            int temp = list.get(x).get(i);
            if(visited[temp] == false) {
                visited[temp] = true;
                dfs(temp, len + 1);
                visited[temp] = false;
            }
        }
    }

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj13023.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		
		list = new ArrayList<>();
		 for (int i = 0; i < N; i++) {
			 list.add(new ArrayList<>());
		    }
		
		for(int i = 0 ; i < M; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 양방향 친구
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		visited = new boolean[N];
	    for (int i = 0; i < N; i++) {
	      Arrays.fill(visited, false);
	      dfs(i,0);
	    }

		System.out.println(0);
		

	}

}
