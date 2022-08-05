package homework;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_d3_1225_암호생성기_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input_1225.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = 10;		
		
		for(int tc = 0; tc <= T; tc++) {
			tc = Integer.parseInt(br.readLine());
			st  = new StringTokenizer(br.readLine());
			ArrayDeque<Integer> d = new ArrayDeque<>();
			
			for(int i = 0 ; i < 8 ; i++) {
				d.offer(Integer.parseInt(st.nextToken()));
			}

			int cnt = 1;
			
			while(!d.isEmpty() && d.peekLast() > 0 ) {
				//System.out.println(cnt%5);
				d.offerLast(d.pollFirst()-(cnt%5 == 0 ? 5 : cnt%5));					
				cnt++;
			}
			

			
			if(d.peekLast() < 0) {
				d.pollLast();
				d.offerLast(0);
			}
				
			
			System.out.print("#" + tc + " ");
			
			for(int i = 0 ; i < 8 ; i++) {
				System.out.print(d.pollFirst() + " ");
			}
			System.out.println();
			
			/*for(int i = 0 ; i < 8 ; i++) {
				System.out.print(d.pollFirst() + " ");
			}
			System.out.println();
			d.offerLast(132);
			
			for(int i = 0 ; i < 9 ; i++) {
				System.out.print(d.pollFirst() + " ");
			}

			System.out.println("===");*/
		}
		
		
		
		
	}

}
