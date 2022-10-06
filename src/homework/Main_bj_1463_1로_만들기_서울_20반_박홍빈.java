package homework;

import java.io.*;
import java.util.*;

public class Main_bj_1463_1로_만들기_서울_20반_박홍빈 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/bj1463.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int N = Integer.parseInt(br.readLine());
		System.out.println(recur(N, 0));
	}
 
	static int recur(int N, int count) {
		if (N < 2) {
			return count;
		}
		return Math.min(recur(N / 2, count + 1 + (N % 2)), recur(N / 3, count + 1 + (N % 3)));
 
	}

}


spq rkat