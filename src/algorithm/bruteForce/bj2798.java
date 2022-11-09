package algorithm.bruteForce;

import java.io.*;

public class bj2798 {

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/bj2798.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int t = 0 ; t < test_case; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int devil = 666;
			String sDeveil = "666";
			int cnt = 1;
			
			if(N != 1) {
				while(true) {
					devil++;
					if(Integer.toString(devil).contains("666")) {
						sDeveil = Integer.toString(devil);
						cnt++;
					}
					
					if(cnt == N) {
						break;
					}
				}								
			}
			
			System.out.println(sDeveil);
			
		}
	}

}
