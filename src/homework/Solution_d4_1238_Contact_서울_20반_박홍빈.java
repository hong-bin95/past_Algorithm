package homework;

import java.io.*;
import java.util.*;

public class Solution_d4_1238_Contact_서울_20반_박홍빈  {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/input1238.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
             
            ArrayList<ArrayList<Integer>> number = new ArrayList<>();
             
            for (int i = 0; i < 101; i++) {
                number.add(new ArrayList<>());
            }
             
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n / 2; i++) {
                int k = Integer.parseInt(st.nextToken());
                number.get(k).add(Integer.parseInt(st.nextToken()));
            }
             
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[101];
            
            visited[s] = true;
            
             
            ArrayList<Integer> maxList = new ArrayList<>();
            queue.offer(s);
     
            while (!queue.isEmpty()) {
                int size = queue.size();
                int max = 0;
                 
                for (int i = 0; i < size; i++) {
                    s = queue.poll();
                    for (int j = 0; j < number.get(s).size(); j++) {
                        int k = number.get(s).get(j);
                        if (visited[k]) continue;
                        visited[k] = true;
                        queue.offer(k);
                        max = Math.max(k, max);
                    }
                }
                 
                maxList.add(max);
            }
             
            sb.append("#").append(tc).append(" ").append(maxList.get(maxList.size()-2)).append("\n");
        }
        System.out.println(sb);
	}

}
