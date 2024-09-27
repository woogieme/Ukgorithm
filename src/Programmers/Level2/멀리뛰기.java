package Programmers.Level2;

import java.util.*;
class 멀리뛰기 {
    public long solution(int n) {
        long answer = 0;
        int[] dp = new int[2000];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;

        if(n>=3){
            for(int i=3; i<=n; i++){
                dp[i]=dp[i-1]+dp[i-2];
                dp[i]%=1234567;
            }
        }

        return dp[n];
    }
}