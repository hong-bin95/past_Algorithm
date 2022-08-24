package homework;

import java.io.*;
import java.util.*;

public class Main_bj_16236_아기상어_서울_20반_박홍빈 {
	
	static int N;

	static int[][] space;
	
	static int[] dx =  {-1,0,0,1};
	static int[] dy =  {0,-1,1,0};
	static int totalTime = 0;
	static int eatFish = 0;	// 아기상어가 먹은 물고기 수
	static int canFish = 0;	// 아기상어가 먹을 수 있는 물고기 수
	static int[] canFishList = new int[7];	// 1~6 크기 별 물고기 수
	static boolean[][] visited;
	static int sharkSize = 2;
	static int time = 0;
	
	static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		q.offer( new int[] { x, y } );
		
		loop1 :
		while(q.isEmpty() == false) {
			int[] temp = q.poll();
			//time += 1;
			for(int i = 0 ; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && space[nx][ny] <= sharkSize && visited[nx][ny] == false) {					
					if(space[nx][ny] > 0 && space[nx][ny] < sharkSize) {
						// 먹을 수 있는 물고기라면
						totalTime += Math.abs(nx - x) + Math.abs(ny - y);
						//time = 0;	// time 초기화
						// 먹은 물고기 수 증가
						eatFish += 1;
						// 물고기 먹은 자리는 0
						space[nx][ny] = 0;
						// 먹을 수 있는 물고기 수 줄여주고
						canFish -= 1;
						if(eatFish == sharkSize) {
							// 자기 몸만큼 먹었으면
							sharkSize += 1;	// 1만큼 크기 키워주고
							eatFish = 0 ;	// 다시 처음부터 먹이통 채워라!
							if(sharkSize <= 7) {
								// 상어의 사이즈가 7보다 작으면 하나 작은 크기 물고기도 먹을 수 있다.
								canFish += canFishList[sharkSize - 1];
							}
						}
						break loop1;
					}
					visited[nx][ny] = true;
					q.offer(new int[] { nx, ny });
				}
				
				
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj16236.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		space = new int[N][N];
		visited = new boolean[N][N];
				
		for(int i = 0 ; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for(int j = 0 ; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] != 0 && space[i][j] != 9) {
					canFishList[space[i][j]] += 1;
					// 크기별로 물고기가 먹을 수 있는 숫자
				}				
				if(space[i][j] > 0 && space[i][j] < 2) {
					// 처음 아기상어가 먹을 수 있는 물고기의 숫자
					canFish += 1;
				}
			
			}
		}
		
		while(canFish > 0) {
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(space[i][j] == 9) {
						bfs(i,j);							
					}
				}				
			}
		}
		
		System.out.println(totalTime);
		
	}

}
