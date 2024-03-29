package CodeTree.Simul.BruteForce;

import java.io.*;
import java.util.*;

public class 트로미노 {
    static int N;
    static int M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map= new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int fi=0;
        int fj=0;
        int result=0;
        int[] cntlist= new int[4];

        while(true){
            int sum=0;
            int cnt=0;
            for(int i=fi; i<=fi+1; i++){
                for(int j=fj; j<=fj+1; j++){
                    cntlist[cnt]=map[i][j];
                    sum+=map[i][j];
                    cnt+=1;
                }
            }
            for(int k=0; k<4; k++){
                //System.out.println(sum+" "+cntlist[k]);
                if(sum-cntlist[k]>result){
                    result= sum-cntlist[k];
                }
            }
            fj+=1;
            if(fj==M-1){
                fi+=1;
                fj=0;
            }
            if(fi==N-1){
                break;
            }
        }

        int sums=0;
        //가로일때
        for(int i=0; i<N; i++){
            boolean isFlag=true;
            for(int k=0; k<M-2; k++){
                sums=0;
                for(int s=k; s<=k+2; s++){
                    if(s>=M){
                        isFlag=false;
                        break;
                    }
                    sums+=map[i][s];
                }
                if(isFlag){
                    if(sums>result){
                        result=sums;
                    }
                }
            }
        }

        for(int i=0; i<M; i++){
            boolean isFlag=true;
            for(int k=0; k<N-2; k++){
                sums=0;
                for(int s=k; s<=k+2; s++){
                    if(s>=N){
                        isFlag=false;
                        break;
                    }
                    sums+=map[s][i];
                }
                if(isFlag){
                    if(sums>result){
                        result=sums;
                    }
                }
            }
        }
        System.out.println(result);
    }
}