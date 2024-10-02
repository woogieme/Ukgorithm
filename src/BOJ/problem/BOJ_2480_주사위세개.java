package BOJ.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2480_주사위세개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer=0;
        if(arr[0]==arr[1] && arr[1]==arr[2]){
            answer=10000+arr[0]*1000;
        }else if(arr[0]==arr[1] || arr[0]==arr[2] || arr[1]==arr[2]){
            if(arr[0]==arr[1] || arr[1]==arr[2]){
                answer=1000+arr[1]*100;
            }else{
                answer=1000+arr[0]*100;
            }
        }else{
            int Max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                Max=Math.max(Max,arr[i]);
            }
            answer=Max*100;
        }

        System.out.println(answer);
    }
}
