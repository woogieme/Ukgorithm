package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 중앙값계산2 {
    static int findCenter(int[] arr, int idx,int N){
        int[] brr = new int[idx+1];
        for(int i=0; i<=idx; i++){
            brr[i]=arr[i];
        }
        Arrays.sort(brr);
        return brr[idx/2];

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        StringTokenizer st =new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb =new StringBuilder();
        for(int i=0; i<N; i++){

            if(i==0){
                sb.append(arr[i]).append(" ");
                continue;
            }
            if(i%2==0){
                int tmp = findCenter(arr,i,N);
                sb.append(tmp).append(" ");
            }
        }
        System.out.print(sb.toString());


        // 여기에 코드를 작성해주세요.
    }
}