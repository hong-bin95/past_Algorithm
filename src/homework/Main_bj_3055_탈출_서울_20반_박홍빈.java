package homework;

import java.io.*;
import java.util.*;

public class Main_bj_3055_탈출_서울_20반_박홍빈 {

	static int R,C;
	static int now;
	static char[][] map;

	static int[] dx =  { 0, 1, 0, -1 };
	static int[] dy =  { 1, 0, -1, 0 };
	
	static void water(int x, int y) {
/*		System.out.println();
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();*/
		
		
		
		// 물찬다.
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(map[x][y] == '*') {
				if(nx >=0 && ny >= 0 && nx < C && ny < R && map[nx][ny] == '.') {
					map[nx][ny] = '*'; 
					water(nx,ny);
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj3055.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		
		for(int i = 0 ; i < R; i++) {
			str = br.readLine();
			for(int j = 0 ; j < C; j++) {
				map[i][j]  = str.charAt(j);
			}
		}
		
		for(int i = 0 ; i < R; i++) {
			for(int j = 0 ; j < C; j++) {
				if(map[i][j] == '*') {
					water(i,j);					
				}
			}
		}

	}

}
