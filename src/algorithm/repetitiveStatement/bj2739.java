package algorithm.repetitiveStatement;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj2739 {

	/*구구단*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
		
        for(int i = 1 ; i <= 9 ; i++) {
    		System.out.printf("%d * %d = %d\n",T,i,T*i);        	
        }
	}

}
