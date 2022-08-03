package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_11659_구간합구하기4_서울_20반_박홍빈 {
/*
 * 문제
 * 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

 * 입력
 * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 
 * 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 
 * 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

 * 출력
 * 총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

 * 제한
 * 1 ≤ N ≤ 100,000
 * 1 ≤ M ≤ 100,000
 * 1 ≤ i ≤ j ≤ N
 * */
	public static void main(String[] args) throws Exception {		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input_11659.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = 0, M = 0,i = 0,j = 0;
		
		// 첫째줄 : N, M
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int []arr = new int [N];
		int []arr_sun = new int [N+1];
		
		input = br.readLine();
		st = new StringTokenizer(input," ");
		
		for(int n = 0 ; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int n = 1 ; n < arr.length; n++) {
			arr_sun[n] += arr_sun[n - 1] + arr[n-1];
		}		
		
		for(int m = 0 ; m < M; m++) {

			input = br.readLine();
			st = new StringTokenizer(input," ");		

			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			
			// 1 3
			// I = 1, j = 33
			// 
			int result = arr_sun[j-1] - arr_sun[i-1];
			
			sb.append(result + "\n");
			
		}

		System.out.println(sb.toString());
		
	}

}
