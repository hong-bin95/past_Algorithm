package algorithm.부분합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2559 {

	static int result;
	static int[] arr;
	static int sum_max;
	static int[] sum_arr;
	static int cnt;

	static int N,K;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2559.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		result = 0;
		sum_max = Integer.MIN_VALUE;
		
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sum_arr = new int[N-K+1];
		cnt = 0;

		input = br.readLine();
		st = new StringTokenizer(input);

		
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i = 0 ; i < N-K+1; i++) {
			for(int j = 0 ; j < K; j++) {
				sum_arr[i] += arr[i + j];
			}
			if(sum_max < sum_arr[i])
				sum_max = sum_arr[i];
		}
		
		System.out.println(sum_max);
		
		
	}
	

}
