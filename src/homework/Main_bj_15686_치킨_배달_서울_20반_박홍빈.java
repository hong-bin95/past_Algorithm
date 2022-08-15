package homework;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_bj_15686_치킨_배달_서울_20반_박홍빈 {
	
	static int N, M;
	static int[][] map;
	
	//static int[] chick;
	//static int[] chickX;
	//static int[] chickY;
	
	// 치킨집
	static ArrayList<Point> chick;
	// 집
	static ArrayList<Point> home;
		
	// 우, 우하, 하, 좌하, 좌, 좌상, 상, 우상
	static int[] dx = {0,1,1,1,0,-1,-1,-1};
	static int[] dy = {1,1,0,-1,-1,-1,0,1};
	
	// 치킨집 수
	static int cCnt = 0;
	static int hCnt = 0;	// 집 수
	
								// 집 x,  집 y,  비교할 x, 비교할 y
	static void 치킨거리를구해라(int hx, int hy, int x, int y) {
		
	}
	
	public static void main(String[] args)  throws Exception {
		System.setIn(new FileInputStream("res/bj15686.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); 
				if(map[i][j] == 1) {
					hCnt++;
				}
				else if(map[i][j] == 2) {
					cCnt++;
				}
			}
		}
		
		
		
		
	}

}
