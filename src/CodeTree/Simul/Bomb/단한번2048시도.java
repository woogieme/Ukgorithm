package CodeTree.Simul.Bomb;

import java.util.*;
import java.io.*;

public class 단한번2048시도 {
    static int MAX_HEIGHT=4;
    static int MAX_WEIGHT=4;
    static int[][] map= new int[MAX_HEIGHT][MAX_WEIGHT];
    static int[][] copy =new int[MAX_HEIGHT][MAX_WEIGHT];
    static boolean[][] checked = new boolean[MAX_HEIGHT][MAX_WEIGHT];
    static String tmp;
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i<MAX_HEIGHT; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<MAX_WEIGHT; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        tmp = br.readLine();
        char dir = tmp.charAt(0);

        if(dir=='D'){
            for(int j=0; j<MAX_HEIGHT; j++){
                int endOfArray=MAX_HEIGHT-1;
                for(int i=MAX_HEIGHT-1; i>=0; i--){
                    if(map[i][j]!=0){
                        if(endOfArray+1<MAX_HEIGHT && copy[endOfArray+1][j]==map[i][j] && !checked[endOfArray+1][j]){
                            copy[endOfArray+1][j]+=map[i][j];
                            checked[endOfArray+1][j]=true;
                        }else{
                            copy[endOfArray][j]=map[i][j];
                            endOfArray--;
                        }
                    }
                }
            }
        }
        else if(dir=='U'){
            for(int j=0; j<MAX_HEIGHT; j++){
                int endOfArray=0;
                for(int i=0; i<MAX_WEIGHT; i++){
                    if(map[i][j]!=0){
                        if(endOfArray-1>=0 && copy[endOfArray-1][j]==map[i][j] && !checked[endOfArray-1][j]){
                            copy[endOfArray-1][j]+=map[i][j];
                            checked[endOfArray-1][j]=true;
                        }else{
                            copy[endOfArray][j]=map[i][j];
                            endOfArray++;
                        }
                    }
                }
            }
        }
        else if(dir=='L'){
            for(int i=0; i<MAX_HEIGHT; i++){
                int endOfArray=0;
                for(int j=0; j<MAX_WEIGHT; j++){
                    if(map[i][j]!=0){
                        if(endOfArray-1>=0 && copy[i][endOfArray-1]==map[i][j] && !checked[i][endOfArray-1]){
                            copy[i][endOfArray-1]+=map[i][j];
                            checked[i][endOfArray-1]=true;
                        }else{
                            copy[i][endOfArray]=map[i][j];
                            endOfArray++;
                        }
                    }
                }
            }
        }
        else if(dir=='R'){
            for(int i=0; i<MAX_HEIGHT; i++){
                int endOfArray=MAX_HEIGHT-1;
                for(int j=MAX_HEIGHT-1; j>=0; j--){
                    if(map[i][j]!=0){
                        if(endOfArray+1<MAX_HEIGHT && copy[i][endOfArray+1]==map[i][j] && !checked[i][endOfArray+1]){
                            copy[i][endOfArray+1]+=map[i][j];
                            checked[i][endOfArray+1]=true;
                        }else{
                            copy[i][endOfArray]=map[i][j];
                            endOfArray--;
                        }
                    }
                }
            }
        }
        for(int i=0; i<MAX_HEIGHT; i++){
            for(int j=0; j<MAX_WEIGHT; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }








    }
}