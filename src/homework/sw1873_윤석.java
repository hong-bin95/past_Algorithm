package homework;

import java.io.*;
import java.util.*;

public class sw1873_윤석 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[] di = { -1, 0, 1, 0};
        int[] dj = { 0, 1, 0, -1};
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] board = new char[H][];
            int tankI = 0, tankJ = 0, dir = 0, nextI, nextJ;
            for(int i=0;i<H;i++) {
                board[i] = br.readLine().toCharArray();
                for(int j=0;j<W;j++) {
                    if(board[i][j] == '<' || board[i][j] == '^' || board[i][j] == '>' || board[i][j] == 'v') {
                        switch(board[i][j]) {
                        case '^':   dir = 0;    break;
                        case '>':    dir = 1;    break;
                        case 'v':   dir = 2;    break;
                        case '<':    dir = 3;    break;
                        }
                        tankI = i;
                        tankJ = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] cmds = br.readLine().toCharArray();
            for(char cmd : cmds) {
                if(cmd == 'S') {
                    int ballI = tankI, ballJ = tankJ;
                    while(0 <= ballI && ballI < H && 0 <= ballJ && ballJ < W) {
                        if(board[ballI][ballJ] == '*') {
                            board[ballI][ballJ] = '.';
                            break;
                        }
                        else if(board[ballI][ballJ] == '#')
                            break;

                        ballI += di[dir];
                        ballJ += dj[dir];
                    }
                }
                else{
                    if(cmd == 'U')      {
                        dir = 0;
                        board[tankI][tankJ] = '^';
                    }
                    else if(cmd == 'D') {
                        dir = 2;
                        board[tankI][tankJ] = 'v';
                    }
                    else if(cmd == 'L') {
                        dir = 3;
                        board[tankI][tankJ] = '<';
                    }
                    else if(cmd == 'R') {
                        dir = 1;
                        board[tankI][tankJ] = '>';
                    }

                    nextI = tankI + di[dir];
                    nextJ = tankJ + dj[dir];
                    if(nextI < 0 || nextI >= H || nextJ < 0 || nextJ >= W)
                        continue;
                    if(board[nextI][nextJ] == '.') {
                        board[nextI][nextJ] = board[tankI][tankJ];
                        board[tankI][tankJ] = '.';
                        tankI = nextI;
                        tankJ = nextJ;
                    }
                }
            }
            sb.append('#').append(tc).append(' ');
            for(int i=0;i<H;i++) {
                for(int j=0;j<W;j++) {
                    sb.append(board[i][j]);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}