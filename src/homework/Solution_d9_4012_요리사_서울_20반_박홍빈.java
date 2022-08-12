package homework;

import java.io.*;
import java.util.*;

public class Solution_d9_4012_요리사_서울_20반_박홍빈 {

	static int N;
	static int[][] taste;
	static int[] food;
	static int[] select;
	static boolean[] visited;
	static int tasteA , tasteB;
	
	static int min = Integer.MAX_VALUE;
	
	static void getTaste(ArrayList<Integer> aFood, ArrayList<Integer> bFood) {
		for(int i = 0 ; i < aFood.size(); i++) {
			for(int j = 0 ; j < aFood.size(); j++) {
				if(i != j) {
					tasteA += taste[aFood.get(i)][aFood.get(j)];
				}
			}
		}
		
		for(int i = 0 ; i < bFood.size(); i++) {
			for(int j = 0 ; j < bFood.size(); j++) {
				if(i != j) {
					tasteB += taste[bFood.get(i)][bFood.get(j)];
				}
			}
		}
		
	}
	
	static void comb(int depth, int start) {
		if(depth == N/2) {			
			ArrayList<Integer> aFood = new ArrayList<>();
			ArrayList<Integer> bFood = new ArrayList<>();
			for(int i = 0 ; i < depth; i++) {
				aFood.add(select[i]);
			}
			for(int i = 0 ; i < N; i++) {
				bFood.add(food[i]);
			}
			bFood.removeAll(aFood);
			
			tasteA = 0;
			tasteB = 0;
			
			getTaste(aFood,bFood);

			if(min > Math.abs(tasteA - tasteB)) {
				min =  Math.abs(tasteA - tasteB);
			}

			return;
		}
		
		for(int i = start ; i < N; i++) {
			select[depth] = food[i];
			comb(depth+1, i+1);
		}
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_4012.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			taste = new int[N][N];
			visited = new boolean[N];
			select = new int[N];
			food = new int[N];
			min = Integer.MAX_VALUE;
			
			for(int i = 0 ; i < N; i++) {
				String str = br.readLine();
				StringTokenizer st = new StringTokenizer(str);
				food[i] = i;
				for(int j = 0 ; j < N ; j++) {
					taste[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			comb(0,0);
			
			
			System.out.println("#" + tc + " " + min);
			
		}

	}

}
