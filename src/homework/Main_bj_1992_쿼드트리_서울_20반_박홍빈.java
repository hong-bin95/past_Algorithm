package homework;

import java.io.*;

public class Main_bj_1992_쿼드트리_서울_20반_박홍빈 {
	static int N;
	static int[][] map;
	private static StringBuilder sb;

	static boolean isPossible(int x, int y, int size) {
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(i >= 0 && i < N && j >=0 && j < N && map[i][j] != map[x][y]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void QuadTree(int x,int y, int size) {
		
		if(isPossible(x,y,size)) {
			sb.append(map[x][y]);
		}
		else {
			int newSize = size/2;
			sb.append("(");
			QuadTree(x, y, newSize);
			QuadTree(x, y+newSize, newSize);
			QuadTree(x+newSize, y, newSize);
			QuadTree(x+newSize, y+newSize, newSize);
			sb.append(")");
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/bj1992.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0 ; i < N ; i++) {
			String str = br.readLine();
			for (int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		QuadTree(0,0,N);
		
		System.out.println(sb);
		
	}

}
