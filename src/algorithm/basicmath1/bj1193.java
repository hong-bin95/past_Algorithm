package algorithm.basicmath1;

import java.io.*;
import java.util.*;

public class bj1193 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj1193.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++) {
		*/			
			int X = Integer.parseInt(br.readLine());
			
			int cnt = 1, c = 1;
			
			label:
			while(true) {
				if(c % 2 != 1) {
					for(int i = 1; i <= c; i++) {
						if(cnt == X) {
							System.out.println(i + "/" + (c - i + 1));
							break label; 
						}
						cnt += 1;
					}
				}
				else {
					for(int i = c; i >= 1 ; i--) {
						if(cnt == X) {
							System.out.println(i + "/" + (c - i + 1));
							break label; 
						}
						cnt += 1;
					}
				}
				
				c += 1;
			}

//		}

	}

}
