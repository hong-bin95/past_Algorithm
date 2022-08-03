package algorithm.conditional;

import java.util.Scanner;

public class bj2480 {
	/*
	 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다. 
	 * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
	 * 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
	 * */

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int win;
		
		if(A == B && B == C) {
			win = 10000 + A * 1000;
		}
		else if(A == B) {
			win = 1000 + A * 100;
		}
		else if(C == B) {
			win = 1000 + C * 100;
		}
		else if(A == C) {
			win = 1000 + A * 100;
		}
		else {
			int max = A;
			if(max < B) {
				max = B;
			}
			if(max < C) {
				max = C;
			}
			
			win = max * 100;
		}
		
		System.out.println(win);
	}

}
