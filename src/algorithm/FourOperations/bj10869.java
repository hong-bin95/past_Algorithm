package algorithm.FourOperations;

import java.util.Scanner;

public class bj10869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A+B, A-B, A*B, A/B(몫), A%B(나머지)
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		System.out.printf("%d\n", A + B);
		System.out.printf("%d\n", A - B);
		System.out.printf("%d\n", A * B);
		System.out.printf("%d\n", A / B);
		System.out.printf("%d\n", A % B);
	}

}
