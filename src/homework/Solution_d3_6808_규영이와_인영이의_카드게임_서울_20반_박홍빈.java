package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_6808_규영이와_인영이의_카드게임_서울_20반_박홍빈 {

	static int[] 규영 = new int[9];
	static int[] 인영 = new int[9];
	static boolean[] visited = new boolean[9];
	static int win = 0, lose = 0;
	

	static void perm(int depth, int 규영_score, int 인영_score) {
		if(depth == 9) {
			if(규영_score > 인영_score) {
				win++;
			}
			else {
				lose++;
			}		
			규영_score = 0;
			인영_score = 0;
			return;
		}
		
		for(int i = 0 ; i < 9 ; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(규영[depth] > 인영[i]) {
					perm(depth+1, 규영_score + (규영[depth] + 인영[i]) , 인영_score);
				}
				else {
					perm(depth+1, 규영_score, 인영_score+ (규영[depth] + 인영[i]));
				}
				visited[i] = false;
			}
		}
		
	}
	

	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_6808.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int tc = 1 ; tc <= T ; tc++) {

			win = 0;
			lose = 0;
			
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			for(int i = 0 ; i < 9; i++) {
				규영[i] = Integer.parseInt(st.nextToken());				
			}
			
			int count = 0;
			
			for(int i = 1 ; i <= 18; i++) {
				boolean is = false;
				for(int j = 0 ; j < 9 ; j++) {
					if(규영[j] == i) {
						is = true;
					}
				}
				if(!is) {
					인영[count++] = i;
				}
			}
			
			perm(0,0,0);
			
			System.out.println("#" + tc + " " + win + " " + lose);
			
			
		}
		
	}	//main
	
}
