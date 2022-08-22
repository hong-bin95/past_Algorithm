package homework;

import java.io.*;
import java.util.Arrays;

public class Main_bj_2839_설탕배달_20반_박홍빈 {

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2839.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int sugar3 = 0;
		int sugar5 = 0;

		
		while (N % 5 != 0) {
			N = N - 3;
			sugar3++;

			if (N < 3 && N != 0) {
				System.out.println("-1");
				return 0;
			}
		}
		sugar5 = N / 5;
		
		System.out.println(sugar5 + sugar3);
	}

}
