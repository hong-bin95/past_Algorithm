package algorithm.부분합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj11399 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj11399.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] sum_arr = new int[N+1];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i = 0; i < N ;i++ ) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		arr[N] = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		
		arr[N] = 0;
		
		int sum = 0;
		
		for(int i = 1 ; i < N+1; i++) {
			int a  = arr[i-1];
			sum_arr[i] = sum_arr[i-1] + arr[i-1];
			sum += sum_arr[i];
		}
		
		System.out.println(sum);
	}

}
