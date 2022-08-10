package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1233_사칙연산_유효성_검사_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1233.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int tc = 1 ; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			// 가능하면 1, 불가능하면 0
			int result = 1;
			
			for(int i = 0 ; i < N ; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				st.nextToken();	//번호
				
				char node = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					if(node >= '1' && node <= '9') {
						result = 0;
					}
				}
				else {
					// 맨 마지막인데 숫자가 아니면
					if(node < '1' || node > '9') {
						result = 0;
					}
				}
				
			}
			
			System.out.println("#" + tc + " " + result);
		}
		
		

	}

}
