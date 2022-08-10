package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_9229_한빈이와_Spot_Mart_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_9229.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc<=T; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			// 과자 봉지 갯수
			int N = Integer.parseInt(st.nextToken());
			// 리미트
			int M = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			
			str = br.readLine();
			st = new StringTokenizer(str);
			
			int max = -1;
			
			for(int i = 0 ; i < N ; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(j != i && arr[i] + arr[j] > max &&  arr[i] + arr[j] <= M) {
						max =  arr[i] + arr[j];
					}
				}
			}
			
			System.out.println("#" +  tc + " " + max );	
			
		}

	}
	

}
