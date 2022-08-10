package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_12891_DNA_비밀번호_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {
		//input_11660.txt
		System.setIn(new FileInputStream("res/input_12891.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input," ");

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		/*문자열*/
		char[] arr = new char[S];
		int a,c,g,t;
		int _a = 0,_c = 0,_g = 0,_t = 0;
		int result = 0;
				
		input = br.readLine();

		arr = input.toCharArray();
		
		input = br.readLine();
		st = new StringTokenizer(input," ");

		a = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < P; i++) {
			char ch = arr[i];
			if(ch == 'A') {
				_a++;
			}
			else if(ch == 'C') {
				_c++;
			}
			else if(ch == 'G') {
				_g++;
			}
			else if(ch == 'T') {
				_t++;
			}

			if(_a >= a && _c >= c && _g >= g && _t >= t ) {
				result++;
			}
		}
		
		for(int i = 1 ; i <= S - P; i++) {
			char ch = arr[i-1];
			
			if(ch == 'A') {
				_a--;
			}
			else if(ch == 'C') {
				_c--;
			}
			else if(ch == 'G') {
				_g--;
			}
			else if(ch == 'T') {
				_t--;
			}
			
			ch = arr[i+P-1];
			
			if(ch == 'A') {
				_a++;
			}
			else if(ch == 'C') {
				_c++;
			}
			else if(ch == 'G') {
				_g++;
			}
			else if(ch == 'T') {
				_t++;
			}
			
			if(_a >= a && _c >= c && _g >= g && _t >= t ) {
				result++;
			}
			
		}
		

		System.out.println(result);
	}

}
