package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_2164_카드2_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj2164.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer> d = new ArrayDeque<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			d.offer(i);
		}
		
		int i = 0;
		
		while(d.size() != 1) {
			d.poll();
			d.offerLast(d.poll());
		}
		
		System.out.println(d.poll());
		
		
	}

}
