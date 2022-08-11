package homework;

import java.io.*;
import java.util.*;

public class Main_bj_3040_백설_공주와_일곱_난쟁이_서울_20반_박홍빈 {
	static int[] arr;
	static int[] result;
	static int sum;
	
	static int N,R;
	
	static void dfs(int index, int start) {
		if(index == R) {
			sum = 0;
			for(int i = 0 ; i < result.length; i++)
				sum += result[i];
			
			if(sum == 100) {
				for(int i = 0 ; i < R; i++) {
					System.out.println(result[i]);
				}
			}
			
			return;
		}
		for(int i = start ; i < N ; i++) {
				result[index] = arr[i];
				dfs(index+1,i+1);	
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj3040.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 9; R = 7;
		
		arr = new int[N];
		result = new int[R];
		
		int all_sum = 0;
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			all_sum += arr[i];
		}
		
		//dfs(0,0);
		
		int fake_a = 0, fake_b = 0;
		
		// 이중 for문
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(all_sum - arr[i] - arr[j] == 100) {
					fake_a = i;
					fake_b = j;
					break;
				}
			}
		}
		
		for(int i = 0 ; i < N; i++) {
			if(i != fake_a && i != fake_b) {
				System.out.println(arr[i]);
			}
		}

	}

}
