package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 진정한효도 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        int[][] map = new int[3][3];
        for(int i=0; i<3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        int answer=Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            if(map[i][0]==map[i][1] &&map[i][1]==map[i][2]){
                answer=0;
                break;
            }else if(map[i][0]==map[i][1]){
                answer=Math.min(answer,Math.abs(map[i][0]-map[i][2]));
            }else if(map[i][0]==map[i][2]){
                answer=Math.min(answer,Math.abs(map[i][0]-map[i][1]));
            }else if(map[i][1]==map[i][2]){
                answer=Math.min(answer,Math.abs(map[i][0]-map[i][2]));
            }
        }

        for(int i=0; i<3; i++){
            if(map[0][i]==map[1][i] &&map[1][i]==map[2][i]){
                answer=0;
                break;
            }else if(map[0][i]==map[1][i]){
                answer=Math.min(answer,Math.abs(map[0][i]-map[2][i]));
            }else if(map[0][i]==map[2][i]){
                answer=Math.min(answer,Math.abs(map[0][i]-map[1][i]));
            }else if(map[1][i]==map[2][i]){
                answer=Math.min(answer,Math.abs(map[0][i]-map[2][i]));
            }
        }

        System.out.println(answer);



    }
}
