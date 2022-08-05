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
			
			if(i == 0) {
				if(arr[0] == c) {
					sum_arr[0] = 1;
				}
				else {
					sum_arr[0] = 0;
				}
				for(int j = 1 ; j < arr.length ; j++) {
					if(arr[j] == c) {
						sum_arr[j] = sum_arr[j-1] + 1;
					}
					else {			
						sum_arr[j] = sum_arr[j-1];
					}
				}		
			}
			
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			
			int ll;
			
			if(l == 0) {
				ll = sum_arr[0];
			}
			else {
				ll = sum_arr[l-1];
			}
			
			System.out.println(sum_arr[r] - ll);
			
		}
	}	
}
