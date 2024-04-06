package CodeTree.SamSung.Simul;

import java.io.*;
import java.util.*;

public class 되돌아오기2 {
    static int lenN;
    static String dir;
    static int[] dx ={1,0,-1,0};
    static int[] dy ={0,1,0,-1};
    static int centerX=0;
    static int centerY=0;
    static int dist;

    static int move(char tmp,int distTmp){
        if(tmp=='L'){
            return (distTmp-1+4)%4;
        }
        return (distTmp+1)%4;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        dir = br.readLine();
        lenN= dir.length();
        dist=0;
        boolean isFlag=false;
        int count=0;

        for(char d : dir.toCharArray()){
            count++;
            if(d=='L' || d=='R'){
                dist=move(d,dist);
                continue;
            }
            centerX+=dx[dist];
            centerY+=dy[dist];
            //System.out.println(centerX+" "+centerY);
            if(centerX==0 && centerY==0){
                isFlag=true;
                break;
            }

        }
        if(isFlag){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }

        // 여기에 코드를 작성해주세요.
    }
}