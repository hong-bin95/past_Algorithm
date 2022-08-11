package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1861_정사각형_방_서울_20반_박홍빈 {
	static int [][] arr;
	static boolean [][] visited;
	static int cnt;
	
	static void 탐색(int x,int y,int N) {
		visited[x][y] = true;
		// 우 하 좌 상
		int [] dx = {0,1,0,-1};
		int [] dy = {1,0,-1,0};
		
		for(int i = 0 ; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			
			if(!visited[nx][ny] && arr[nx][ny] == arr[x][y] + 1) {
				cnt++;
				탐색(nx,ny,N);
			}
		}
		
		visited[x][y] = false;
		
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1861.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			arr = new int [N][N];
			
			visited = new boolean[N][N];	//false로 초기화
			
			for(int i = 0 ; i < N ; i ++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				
				for(int j = 0 ; j < N ; j ++) {
					arr[i][j] = Integer.parseInt(st.nextToken());					
				}
			}
			
			// 처음에 하나 있을 때
			int max = 0;
			int max_c = 0;
			
			for(int i = 0 ; i < N ; i ++) {				
				for(int j = 0 ; j < N ; j ++) {
					cnt = 1;
					탐색(i,j,N);
					
					if(cnt > max ) {
						max = cnt;
						max_c = arr[i][j];
					}					
					else if(cnt != 0 && cnt == max) {
						if(max_c > arr[i][j]) {
							max = cnt;
							max_c = arr[i][j];							
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + max_c + " " + max);
			
			
			
			
		}
		

	}

}
