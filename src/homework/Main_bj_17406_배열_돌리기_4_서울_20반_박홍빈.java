package homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_17406_배열_돌리기_4_서울_20반_박홍빈 {


    static int[][] board;
    static int[][] rotation;
    static int min = Integer.MAX_VALUE;
    static int n, m;
    static boolean[] visited;
    static int[] result;
    

    public static void permutation(int idx, int k) {
        if(idx == k) {
            int[][] copy = new int[n][m];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    copy[i][j] = board[i][j];
                }
            }
            findMin(copy);
            return;
        }
        
        for(int i = 0; i < k; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                result[idx] = i;
                permutation(idx + 1, k);
                visited[i] = false;
            }
        }
    }
    
    public static void findMin(int[][] copy) {
        for(int i = 0; i < result.length; i++) {
            int lx = rotation[result[i]][0] - rotation[result[i]][2] - 1;
            int ly = rotation[result[i]][1] - rotation[result[i]][2] - 1;
            int rx = rotation[result[i]][0] + rotation[result[i]][2] - 1;
            int ry = rotation[result[i]][1] + rotation[result[i]][2] - 1;
            rotate(lx, ly, rx, ry, copy); //lx ly ~ rx ry까지 회전
        }
        rowcal(copy);//회전한 배열의 최소 행값을 구함
    }
    
    public static void rowcal(int[][] copy) {
        for(int i = 0; i < copy.length; i++) {
            int sum = 0;
            for(int j = 0; j < copy[i].length; j++) {
                sum += copy[i][j];
            }
            min = Math.min(min, sum);
        }
    }
    
    public static void rotate(int lx, int ly, int rx, int ry, int[][] copy) {
        if(lx == rx && ly == ry) {
            return;
        }
        
        int[] temp = new int[3]; //방향별로 값을 옮기다 보면 지워질 수 있는 좌표값을 저장.
        temp[0] = copy[lx][ry];
        temp[1] = copy[rx][ry];
        temp[2] = copy[rx][ly];
        
        //오른쪽으로 회전
        for(int i = ry; i > ly; i--) {
            copy[lx][i] = copy[lx][i - 1];
        }
        //아래로 회전
        for(int i = rx; i > lx; i--) {
            if(i == lx + 1) copy[i][ry] = temp[0];
            else copy[i][ry] = copy[i - 1][ry];
        }
        //왼쪽으로 회전
        for(int i = ly; i < ry; i++) {
            if(i == ry - 1) copy[rx][i] = temp[1];
            else copy[rx][i] = copy[rx][i + 1];
        }
        //위로 회전
        for(int i = lx; i < rx; i++) {
            if(i == rx - 1) copy[i][ly] = temp[2];
            else copy[i][ly] = copy[i + 1][ly];
        }    
        rotate(lx + 1, ly + 1, rx - 1, ry - 1, copy);
    }
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/bj17406.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int k = Integer.parseInt(st.nextToken());		

        board = new int[n][m];
		for(int i = 0 ; i< n; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
			for(int j = 0 ; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

        rotation = new int[k][3];
        for(int i = 0; i < k; i++) {
			str = br.readLine();
			st = new StringTokenizer(str);
            rotation[i][0] = Integer.parseInt(st.nextToken());
            rotation[i][1] = Integer.parseInt(st.nextToken());
            rotation[i][2] = Integer.parseInt(st.nextToken());
        }
        
        visited = new boolean[k];
        result = new int[k];
        permutation(0, k);
        
        System.out.println(min);
		
		
	}
	

}
