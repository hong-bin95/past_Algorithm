package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_2563_색종이_서울_20반_박홍빈2 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/bj2563.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int P = Integer.parseInt(br.readLine());
		int size = 0;
		boolean[][] paper = new boolean[100][100];
		//초기값 false
		
		for(int p = 0 ; p < P; p++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			
			int x2 = x1 + 10;
			int y2 = y1 + 10;
			
			for(int i = x1 ; i < x2 ;i++) {
				for(int j = y1 ; j < y2 ;j++) {
					paper[i][j] = true;
				}
			}	
			
		}
		
		for(int i = 0 ; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				if(paper[i][j])
					size++;
			}	
		}
		
		System.out.println(size);

	}

}
