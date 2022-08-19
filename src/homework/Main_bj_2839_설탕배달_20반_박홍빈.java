package homework;

import java.io.*;
import java.util.Arrays;

public class Main_bj_2839_설탕배달_20반_박홍빈 {

	static int[] arr = { 3, 5, 6, 9, 10, 12};
	static boolean[] visited;
	static int nn;
	static int result;
	static int N;
	static int MIN = Integer.MAX_VALUE;
	static boolean isok = false;
	
	static void 부분집합(int depth) {
		if(depth == arr.length) {
			int sum = 0;
			int count = 0;

			for(int i = 0; i < arr.length; i++) {
				if(visited[i] == true) {
					sum += arr[i];
					if(arr[i]%5 == 0) {
						count += arr[i]/5;
					}
					else if(arr[i]%3 == 0) {
						count += arr[i]/3;
					}
				}
			}
			
			if(sum == nn) {
				System.out.print("[" + N + "]");
				for(int i = 0; i < arr.length; i++) {
					if(visited[i] == true) {
						System.out.print(arr[i] + " ");
					}
				}
				System.out.println();
				if(result + count < MIN) {
					MIN = result + count;
				}
				isok = true;
			}
		
			return;
		}

		visited[depth] = true;
		
		부분집합(depth+1);
		
		visited[depth] = false;
		
		부분집합(depth+1);
	}

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/bj2839.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t < 100; t++) {
			
	//		int N = Integer.parseInt(br.readLine());
			N = t;
			
			result = 0;
			MIN = Integer.MAX_VALUE;
			isok = false;
			if(N >= 15) {
				result = (N - N%15) / 5;
				System.out.println("[" + N + "] 15*" + N/15 + "+" + N%15);
				
			}
			
			nn = N%15;
			
			if(nn > 0) {
				if(nn%5 == 0) {
					result += nn/5;
				}
				else if(nn%3 == 0) {
					result += nn/3;
				}
				else {				
					visited = new boolean[arr.length];
					부분집합(0);
					
					if(isok == false) {
						result = -1;
					}
					else {
						result = MIN;
					}
				}
			}
			//System.out.println(result);
			System.out.println(t + " " + result);
			
		}
		
	}

}
