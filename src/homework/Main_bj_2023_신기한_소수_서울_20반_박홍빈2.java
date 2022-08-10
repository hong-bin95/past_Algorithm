package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_2023_신기한_소수_서울_20반_박홍빈2 {
	
	public static void main(String[] args) throws Exception {		
		System.setIn(new FileInputStream("res/input_2023.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.*/
		int N = Integer.parseInt(br.readLine());
		
//		sol()
	}
	
	static void sol(int depth, int num) {
		if(depth == 0) {
			System.out.println(num);
			return;
		}
		
		// 홀수만 체크
		for(int i = 1 ; i <= 9; i+=2) {
			if(isP(num*10+1)) {
				sol(depth-1, num*10+1);				
			}
		}
	}
	
	/*
	 * 소수인지 판별하는 소스
	 * */
	static boolean isP(int n) {
		if(n < 2) {
			return false;
		}
		for(int i = 0 ; i * i < n ; i++) {
			if(n%i == 0) {	// 약수가 있으면 소수가 아니다.
				return false;
			}
		}
		
		return true;
	}

}
