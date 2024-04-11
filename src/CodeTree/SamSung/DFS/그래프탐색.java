package CodeTree.SamSung.DFS;

import java.util.*;
import java.io.*;
public class 그래프탐색 {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] brr;
    static int result;
    static void DFS(int vertex){

        for(int i=1; i<N; i++){
            if(arr[vertex][i]==1 && !brr[i]){
                result++;
                brr[i]=true;
                DFS(i);
            }
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr =new int [N][N];
        brr =new boolean[N];
        result=0;
        for(int i=0; i<M; i++){
            st =new StringTokenizer(br.readLine());
            int ix = Integer.parseInt(st.nextToken())-1;
            int jx = Integer.parseInt(st.nextToken())-1;
            arr[ix][jx]=arr[jx][ix]=1;
        }
        DFS(0);
        System.out.println(result);
        // 여기에 코드를 작성해주세요.
    }
}