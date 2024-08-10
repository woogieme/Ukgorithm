package BOJ.dxdyTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_3190_뱀 {

    static int N;
    static int apple;
    static int[][] map;
    static int time;
    static int[] dx ={0,1,0,-1};
    static int[] dy ={1,0,-1,0};

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x=x;
            this.y=y;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        apple = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        for(int i=0; i<apple; i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x-1][y-1] = 1;
        }

        time = Integer.parseInt(br.readLine());
        int count=0;
        int d=0;
        int preX;
        int preY;

        ArrayList<Position> pos = new ArrayList<Position>();

        pos.add(new Position(0,0));
        boolean isFlag;

        int tmpX=0;
        String tmpDist ="";
        for(int i=0; i<time+1; i++){
            int X =10000000;
            String dist =tmpDist;
            isFlag=false;
            if(i!=time) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                dist = st.nextToken();
                tmpDist=dist;

            }
            while(true){
                count++;

                //X초가 끝난다면?
                if(count>X ){
                    count--;
                    break;
                }

                //현재 위치에서 +1칸 가야됨
                int nowX =pos.get(0).x;
                int nowY =pos.get(0).y;

                preX = nowX+dx[d];
                preY = nowY+dy[d];

                //벽일때 끝남
                if(preX<0 || preX>=N || preY<0 || preY>=N){
                    isFlag=true;
                    break;
                }

                //자신의 몸통이라면?
                for(int findI=0; findI<pos.size(); findI++){
                    if(preX==pos.get(findI).x && preY==pos.get(findI).y){
                        isFlag=true;
                        break;
                    }
                }

                //사과라면 그대로 머리만 추가
                if(map[preX][preY]==1){
                    pos.add(0,new Position(preX,preY));
                    map[preX][preY]=0;
                }else{
                    //공백이라면 머리추가후 꼬리는 삭제
                    pos.add(0,new Position(preX,preY));
                    pos.remove(pos.size()-1);
                }

            }

            if(isFlag){
                break;
            }

            if(dist.equals("L")){
                d--;
                if(d==-1){
                    d=3;
                }
            }else{
                d++;
                d=d%4;
            }
        }
        System.out.println(count);


    }
}