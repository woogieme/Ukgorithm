package CodeTree.JustSolve;

import java.io.*;
import java.util.*;

public class 정수찾기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb =new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<N; i++){
            hs.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st =new StringTokenizer(br.readLine());

        int[] arr = new int[M];

        for(int i=0; i<M; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<M; i++){
            if(hs.contains(arr[i])){
                sb.append(1);

            }else{
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());

        // 여기에 코드를 작성해주세요.
    }
}