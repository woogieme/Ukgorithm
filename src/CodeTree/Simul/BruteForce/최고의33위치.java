package CodeTree.Simul.BruteForce;

import java.io.*;
import java.util.*;
public class 최고의33위치 {
    public static void main(String[] args) throws IOException{
        // N*N 크기 안에서 여러 3*3 격자중 제일 값이 높은 격자를 구하라.
        // 고려해야할 사항
        // 3*3 격자가 N*N 의 범위를 벗어나선 안된다.
        // 최대값이 바뀌기전까진 이전까지의 값은 제일크다. => 초기값은 0
        // 행과 열의 바뀌는것을 고려해야한다.
        // 정사각형의 크기이기때문에 처음 행은 N-2-i까지 처음 열은 N-2-j까지 고려해보자.
        // 즉, 3*3의 크기는 i와 j의 값이 증감에따라 변하는 임의의 정사각형

        // map => N*N 인 격자의 크기
        // fi => 행의 증가
        // fj => 열의 증가
        // N => N의크기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        // for(int i=0; i<N; i++){
        //     for(int j=0; j<N; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int fi=0;
        int fj=0;
        int sum=0;
        int result=0;
        while(true){
            if(fj>=N-2){
                fi+=1;
                fj=0;
                if(fi >=(N-2)){
                    break;
                }
            }
            for(int i=fi; i<=fi+2; i++){
                for(int j=fj; j<=fj+2; j++){
                    sum+=map[i][j];
                }
            }
            if(sum>result){
                result=sum;
            }
            fj+=1;
            sum=0;
        }
        System.out.println(result);
    }
}