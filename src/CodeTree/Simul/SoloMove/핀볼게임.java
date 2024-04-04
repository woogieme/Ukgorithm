package CodeTree.Simul.SoloMove;

import java.util.*;
import java.io.*;

public class 핀볼게임 {
    static int N;
    static int[][] map;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};

    static int result;
    static int change(int num,int dist){

        if(num==1){
            if(dist==1){
                return 2;
            }else if(dist ==2){
                return 1;
            }else if(dist ==0){
                return 3;
            }else if(dist==3){
                return 0;
            }
        }
        else if(num==2) {
            if (dist == 1) {
                return 0;
            } else if (dist == 0) {
                return 1;
            } else if (dist == 3) {
                return 2;
            } else if (dist == 2) {
                return 3;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        result=0;

        for(int j=0; j<N; j++){
            int i=-1;
            int dist=0;
            int count=0;
            int tmpJ=j;
            while(true){
                int nexti = i+dx[dist];
                int nextj = tmpJ+dy[dist];
                //System.out.println("2 "+nexti+" "+nextj);
                if(nexti <0 ||nextj<0 || nexti>=N || nextj>=N ){
                    count++;
                    break;
                }

                count++;

                if(map[nexti][nextj]==1){
                    dist = change(1,dist);
                }else if(map[nexti][nextj]==2){
                    dist = change(2,dist);
                }
                i=nexti;
                tmpJ=nextj;
                //System.out.println("1");
            }

            if(result<count){
                result=count;
            }

        }

        for(int i=0; i<N; i++){
            int j=-1;
            int dist=1;
            int count=0;
            int tmpI=i;
            while(true){
                int nexti = tmpI+dx[dist];
                int nextj = j+dy[dist];

                if(nexti <0 ||nextj<0 || nexti>=N || nextj>=N ){
                    count++;
                    break;
                }
                //System.out.println("22222222222");
                count++;

                if(map[nexti][nextj]==1){
                    dist = change(1,dist);
                }else if(map[nexti][nextj]==2){
                    dist = change(2,dist);
                }
                tmpI=nexti;
                j=nextj;
            }

            if(result<count){
                result=count;
            }

        }

        for(int j=0; j<N; j++){
            int i=N;
            int dist=2;
            int count=0;
            int tmpJ=j;
            while(true){
                int nexti = i+dx[dist];
                int nextj = tmpJ+dy[dist];

                if(nexti <0 ||nextj<0 || nexti>=N || nextj>=N ){
                    count++;
                    break;
                }

                count++;
                //System.out.println("2 "+nexti+" "+nextj);
                if(map[nexti][nextj]==1){
                    dist = change(1,dist);
                }else if(map[nexti][nextj]==2){
                    dist = change(2,dist);
                }
                i=nexti;
                tmpJ=nextj;
            }

            if(result<count){
                result=count;
            }

        }

        for(int i=0; i<N; i++){
            int j=N;
            int dist=3;
            int count=0;
            int tmpI=i;
            while(true){
                int nexti = tmpI+dx[dist];
                int nextj = j+dy[dist];

                if(nexti <0 ||nextj<0 || nexti>=N || nextj>=N ){
                    count++;
                    break;
                }
                //System.out.println("3");
                count++;
                if(map[nexti][nextj]==1){
                    dist = change(1,dist);
                }else if(map[nexti][nextj]==2){
                    dist = change(2,dist);
                }
                tmpI=nexti;
                j=nextj;
            }

            if(result<count){
                result=count;
            }

        }
        System.out.println(result);
    }
}