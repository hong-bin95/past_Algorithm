package homework;

import java.io.*;
import java.util.*;

public class Main_bj_17471_게리맨더링_서울_20반_박홍빈 {
	
	static int N;	// 구역의 갯수
	static List<Section> section;	// 구역의 정보
	static ArrayList<ArrayList<Integer>> map;	// 인접그래프
	static int m = Integer.MAX_VALUE;	// 인구 수 차이
	
	static class Section{
		int number;
		int population;
		
		public Section(int number, int population){
			this.number = number;
			this.population = population;
		}
	}
	
	public static void main(String[] args) throws Exception {		
		System.setIn(new FileInputStream("res/bj17471.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		section = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		for(int i = 0 ; i < N; i++) {
			int population = Integer.parseInt(st.nextToken());
			section.add(new Section(i, population));
		}
		
		int M;
		int[] arr = new int[N];
		boolean[] visited = new boolean[N];
		
		map = new ArrayList<>();
        
		for(int i = 0 ; i < N; i++){
			arr[i] = i;
			str = br.readLine();
			st = new StringTokenizer(str);
			M = Integer.parseInt(st.nextToken());
			map.add(new ArrayList<>());
			for(int j = 0; j < M; j++ ) {
				int adj = Integer.parseInt(st.nextToken())-1;
				map.get(i).add(adj);
			}
		}		
		
		powerSet(arr, visited, N , 0);
		
		if(m != Integer.MAX_VALUE) {
			System.out.println(m);			
		}
		else {
			System.out.println(-1);
		}
	}
	
	static void powerSet(int[] arr, boolean[] visited, int n, int idx) {
	    if(idx == n) {
	        ArrayList<Integer> ps1 = new ArrayList<>();
	        ArrayList<Integer> ps2 = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            if (visited[i] == true) {
	            	//System.out.print(arr[i] + " ");
	            	ps1.add(arr[i]);
	            }	        
	            else {
	            	ps2.add(arr[i]);
	            }
	        }
	        //System.out.println();
	        if(ps1.size() > 0 && ps2.size() > 0) {
	        	boolean con1 = isConnect(section.get(ps1.get(0)).number, ps1, ps1.size());
	        	boolean con2 = isConnect(section.get(ps2.get(0)).number, ps2, ps2.size());
	        	if(con1 && con2 && Math.abs(getPopulation(ps1) - getPopulation(ps2)) < m ) {
	        		m = Math.abs(getPopulation(ps1) - getPopulation(ps2));
	        	}	        	
	        }
	        
	        return;
	    }
	 
	    visited[idx] = false;
	    powerSet(arr, visited, n, idx + 1);
	 
	    visited[idx] = true;
	    powerSet(arr, visited, n, idx + 1);
	}
	
    public static boolean isConnect(int num, ArrayList<Integer> arr, int size) {
        boolean[] visited = new boolean[N + 1];
        visited[num] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(num);
 
        int count = 1;
        while (!q.isEmpty()) {
            int start = q.poll();
 
            for (int i : map.get(start)) {
                // 이미 방문한 적이 없고, arr에 속해야 함.
                if (!visited[i] && arr.contains(i)) {
                    visited[i] = true;
                    count++;
                    q.offer(i);
                }
            }
        }
 
        if (count == size) {
            return true;
        }
        return false;
    }
	
	static int getPopulation(ArrayList<Integer> sectionNumberList) {
		int totalPopulation = 0;
		
		for(int i = 0 ; i < sectionNumberList.size(); i++ ) {
			totalPopulation += section.get(sectionNumberList.get(i)).population;
		}
		
		return totalPopulation;
	}

}
