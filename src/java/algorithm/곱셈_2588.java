package java.algorithm;

import java.util.Scanner;

public class 곱셈_2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int _B = B;
		while(B > 0) {
			System.out.println(A*(B % 10));
			B /= 10;
		}
		
		System.out.println(A*_B);
		
	}

}
