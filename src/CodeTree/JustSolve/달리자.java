package CodeTree.JustSolve;

import java.util.*;
import java.io.*;
public class 달리자 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());

        int[] home = new int[N];
        int[] person = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            home[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            person[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>=0; i--){

            if(home[i]>person[i]){

            }

        }


        // 여기에 코드를 작성해주세요.
    }
}