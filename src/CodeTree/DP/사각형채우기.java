package CodeTree.DP;

import java.io.*;

public class 사각형채우기 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());

        int count=0;

        long[] memo= new long[1001];

        memo[1]=1;
        memo[2]=2;

        for(int i=3; i<=N; i++){
            memo[i]=(memo[i-1]+memo[i-2])%10007;
            //System.out.print(memo[i]+" ");
        }
        //System.out.println();
        System.out.println(memo[N]);

        //2칸 오르거나 3칸 오를수 있음


        // 여기에 코드를 작성해주세요.
    }
}