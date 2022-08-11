package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_16935_배열_돌리기_3_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj16935.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열 크기, 크기, 회전배열 수
		int N,M,K;
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	}

}
