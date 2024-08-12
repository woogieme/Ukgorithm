package CodeTree.Greedy;

import java.util.*;
import java.io.*;

public class 자동차단일거래이익최대화2 {
    public static void main(String[] args) throws IOException{

        //내가 가지고있는 값보단 값이 비싸다면 빼버려
        //내가 가지고있는 값보다 작다면 바꿔

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result= arr[0];

        int value=0;
        for(int i=1; i<N; i++){
            if(arr[i]>=result){
                value = Math.max(arr[i]-result,value);
            }else {
                result =arr[i];
            }
        }
        System.out.println(value);


        // 여기에 코드를 작성해주세요.
    }
}
