package homework;

import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.TagAction;

public class 순열 {

	static int[] number;
	static int N,R;
	static int totalCnt;
	
	/*
	 * 1~N. N개중에 R개 뽑아서 만들기
	 * */
	public static void main(String[] args) {
		number = new int[R];
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		순열(0);
		
		System.out.println("총 경우의 수 : " + totalCnt);
		
	}
	
	static void 순열(int index) {
		if(index == R) {
			totalCnt += 1;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(i != N) {
				System.out.println("[" + (index+1) + "," + (i+1) + "]");
			}
		}
		
		순열(index+1);
	}

}
