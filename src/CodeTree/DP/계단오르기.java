package CodeTree.DP;

import java.io.*;

public class 계단오르기 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());

        int count=0;

        long[] memo= new long[1001];

        memo[2]=1;
        memo[3]=1;

        for(int i=4; i<=N; i++){
            memo[i]=(memo[i-2]+memo[i-3])%10007;
            //System.out.print(memo[i]+" ");
        }
        //System.out.println();
        System.out.println(memo[N]);

        //2칸 오르거나 3칸 오를수 있음


        // 여기에 코드를 작성해주세요.
    }
}