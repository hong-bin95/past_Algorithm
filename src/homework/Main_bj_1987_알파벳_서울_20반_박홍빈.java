package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_1987_알파벳_서울_20반_박홍빈 {

	static final int cnt = 26;
	static boolean[] visited_alpha = new boolean[cnt];
	static char[][] alpha;
	static int R,C;
	
	static int MAX = Integer.MIN_VALUE;
					// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	static void getnext(int x, int y, int depth,int cnt) {
		visited_alpha[ alpha[x][y] - 'A'] = true;
		 
		for(int i = 0 ; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < R && ny < C && visited_alpha[ alpha[nx][ny] - 'A'] == false) {
				getnext(nx,ny, depth + 1, cnt + 1);
			}
		}
		
		visited_alpha[ alpha[x][y] - 'A'] = false;
	
		if(MAX < cnt) {
			MAX = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj1987.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new char[R][C];
		
		for(int i = 0 ; i < R; i++) {
			str = br.readLine();
			for(int j = 0 ; j < C; j++) {
				alpha[i][j] = str.charAt(j);
			}
		}
		
		
		getnext(0,0,0,1);
		
		System.out.println(MAX);

	}

}
