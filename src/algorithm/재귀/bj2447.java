package algorithm.재귀;

import java.io.*;
import java.util.*;

public class bj2447 {
	static char[][] arr;
	static void star(int x, int y, int N, boolean blank) {
		 
		if (blank) {
			for (int i = x; i < x + N; i++) {
				for (int j = y; j < y + N; j++) {
					arr[i][j] = ' ';
				}
			}
			return;
		}
 
		// 더이상 쪼갤 수 없는 블록일 때
		if (N == 1) {
			arr[x][y] = '*';
			return;
		}
 
 
		int size = N / 3;
		int count = 0;
		for (int i = x; i < x + N; i += size) {
			for (int j = y; j < y + N; j += size) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2447.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			Scanner in = new Scanner(System.in);
			int N = in.nextInt();
	 
			arr = new char[N][N];
	        
			star(0, 0, N, false);
	 
			/*
			   BufferedWriter 의 write 메소드는 배열도 순서대로 출력해주기 때문에
			   2차원 배열의 경우 한 행씩 write 해주면
			   자체에서 해당 행의 열들을 순서대로 담아준다.
			*/
	        
			for (int i = 0; i < N; i++) {
				bw.write(arr[i]);	
				bw.write("\n");
			}
			bw.flush();
			bw.close();
	}
}
