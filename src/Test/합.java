package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 합 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //.out.println(M);
        long result=0;
        int[] arr =new int[4000003];
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
            arr[A]=K;


        }

        for(int i=0; i<=4000005; i++){
            if(i>=4000001){
                break;
            }
            result+=arr[i];
        }
        System.out.println(result);
        System.out.println("야호");

    }
}
