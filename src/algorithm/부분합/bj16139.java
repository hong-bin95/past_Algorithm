package algorithm.부분합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16139 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj16139.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		int q = Integer.parseInt(br.readLine());
		
		char []arr = S.toCharArray();
		int[] sum_arr = new int[arr.length];
		
		
		
		for(int i = 0 ; i < q; i++) {
			S = br.readLine();
			
			StringTokenizer st = new StringTokenizer(S);
			char c = st.nextToken().charAt(0);
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			sum_arr[0] = arr[0] == c ? 1 : 0;
			
			for(int j = 1 ; j < arr.length ; j++) {
				sum_arr[j] = arr[j] == c ? sum_arr[j-1] + 1 : sum_arr[j-1];
			}
			
			System.out.println(sum_arr[end] - sum_arr[start-1 < 0 ? 0 : start-1]);
			
		}
	}	
}
