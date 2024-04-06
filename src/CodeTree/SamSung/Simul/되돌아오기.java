package CodeTree.SamSung.Simul;

import java.util.*;
import java.io.*;

public class 되돌아오기 {
    static int N;
    static int dir;
    static int dist;
    //N E S W
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static int centerX=0;
    static int centerY=0;
    static int count=0;

    static int distance(String tmp){
        if(tmp.equals("N")){
            return 0;
        }else if(tmp.equals("E")){
            return 1;
        }else if(tmp.equals("S")){
            return 2;
        }
        return 3;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        boolean isFlag=false;
        for(int i=0; i<N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            String dirTmp = st.nextToken();
            dist=Integer.parseInt(st.nextToken());
            dir = distance(dirTmp);
            for(int j=0; j<dist; j++){
                centerX+=dx[dir];
                centerY+=dy[dir];
                if(centerX==0 && centerY==0){
                    count++;
                    isFlag=true;
                    break;
                }
                count++;
            }
            if(isFlag){
                break;
            }

        }
        if(centerX==0 && centerY==0){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
        // 여기에 코드를 작성해주세요.
    }
}