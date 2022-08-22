package algorithm;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1978 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj1978.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		int MAX = Integer.MIN_VALUE;
		int[] arr = new int[N];
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(MAX < arr[i]) {
				MAX = arr[i];
			}
		}
		
		boolean[] isPrime = new boolean[MAX+1];
		
		for(int i = 0; i < MAX + 1; i++) {
			isPrime[i] = true;
		}

		isPrime[0] = false;
		isPrime[1] = false;
		
		for (int i = 2; (i * i) <= MAX ; i++)
		{
			if (isPrime[i])
				for (int j = i * i; j <= MAX; j += i)
					isPrime[j] = false;
		}
		
		int count = 0;
		
		for(int i = 0 ; i < N; i++) {
			if(isPrime[arr[i]]) {
				count++;
			}
		}

		System.out.println(count);

	}

}
