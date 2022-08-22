package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11047_동전0_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj11047.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] Nrr = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			Nrr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = 0;
		
		for(int i = N-1; i >= 0 ; i--) {
			cnt += K / Nrr[i];
			K = K % Nrr[i];
		}
		
		System.out.println(cnt);

	}

}
