package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d3_1228_암호문1_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1228.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1 ; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			ArrayList<String> strList = new ArrayList<>();
			
			
			// 원본 암호문
			for(int i = 0 ; i <N; i++) {
				strList.add(st.nextToken());
			}
			
			int K = Integer.parseInt(br.readLine());
			str = br.readLine();
			st = new StringTokenizer(str);
			
			for(int k = 0 ; k < K ; k++) {
				st.nextToken();	//I
				
				int start = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				
				for(int i = 0 ; i < count; i++) {
					strList.add(start++,st.nextToken());
				}
			}
			
			
			
			sb.append("#" + tc + " ");
			for(int i = 0 ; i < 10; i++) {
				sb.append(strList.get(i) + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
