package algorithm.repetitiveStatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10950 {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] arr = new int[T];
		
		for(int test_case = 0 ; test_case < T; test_case++) {
			String input = br.readLine();
			StringTokenizer st = new StringTokenizer(input," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			arr[test_case] = A + B;
		}
		
		for(int test_case = 0 ; test_case < T; test_case++) {

			System.out.println(arr[test_case]);
		}
		
	}

}
