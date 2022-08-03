package homework;

import java.io.*;
import java.util.*;

public class Solution_d3_1873_상호의배틀필드_서울_20반_박홍빈 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//input_battle
				System.setIn(new FileInputStream("res/input_battle.txt"));
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
				int T = Integer.parseInt(br.readLine());
				for(int tc = 1; tc <= T ; tc++) {
					String input = br.readLine();
					StringTokenizer st = new StringTokenizer(input," ");

					int H = Integer.parseInt(st.nextToken());
					int W = Integer.parseInt(st.nextToken());
					
					char [][]map = new char[H][W];
					
					int x = 0,y = 0;
					char direct = '>'; // 오른쪽 >
					
					/*맵 입력받기*/
					for(int i = 0 ; i < H; i++) {
						input = br.readLine();
						for(int j = 0 ; j < W; j++) {
							map[i][j] = input.charAt(j);
							if( input.charAt(j) == '^'||
									input.charAt(j) == '>'||
									input.charAt(j) == '<'||
									input.charAt(j) == 'v') {
								x = i;
								y = j;	
								direct = input.charAt(j);
							}
						}
					}
					
					int N = Integer.parseInt(br.readLine());
					
					input = br.readLine();
					
					for(int i = 0 ; i < N; i++) {
						if(input.charAt(i) == 'U' || input.charAt(i) == 'D' ||
								input.charAt(i) == 'L' || input.charAt(i) == 'R') {
							int nx = x,ny = y;
							switch(input.charAt(i)) {
								case 'U' :
									direct = '^';
									nx = x - 1;
									break;
								case 'D' :
									direct = 'v';
									nx = x + 1;
									break;
								case 'L' :
									direct = '<';
									ny = y - 1;
									break;
								default:
								case 'R' :
									direct = '>';
									ny = y + 1;
									break;
							}
							// 탱크 위치 표시 해주고
							map[x][y] = direct;
							
							// 유효한지 확인 (그리고 평지인지)
							if(nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') {
								// 원래 있던 자리 평지로 바꾸고
								map[x][y] = '.';
								x = nx;
								y = ny;
								// 바뀐 탱크 위치 표시 해주고
								map[x][y] = direct;
							}	
						}
						else {
							// 바라보는 방향의 벽 종류
							char see = '!'; // 없음~
							int nx = x,ny = y;
							int mx = 0 , my = 0;
							switch(direct) {
							case '^' :
								direct = '^';
								nx = x - 1;
								mx = -1;
								break;
							case 'v' :
								nx = x + 1;
								mx = + 1;
								break;
							case '<' :
								ny = y - 1;
								my = -1;
								break;
							default:
							case '>' :
								ny = y + 1;
								my = 1;
								break;
							}
							
							while(nx >= 0 && nx < H && ny >= 0 && ny < W ) {
								see = map[nx][ny];
								
								if(see == '*') {
									map[nx][ny] = '.';
									break;
								}
								else if(see == '#') {
									break;
								}
								
								nx += mx;
								ny += my;
							}
								
						}
					}
					

					System.out.print("#" + tc + " ");
					for(int i = 0 ; i < map.length; i++) {
						for(int j = 0 ; j < map[0].length; j++) {
							System.out.print(map[i][j]);
						}
						System.out.println();
					}
			}		
				
	}

}
