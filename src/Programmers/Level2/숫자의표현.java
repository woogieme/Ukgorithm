package Programmers.Level2;

import java.util.*;

class 숫자의표현 {
    public int solution(int n) {
        int answer = 0;

        int[] arr = new int[n+1];

        for(int i=1; i<=n; i++){
            arr[i] = i;
        }

        int right = 0;
        int sum=0;
        for(int i=1; i<=n; i++){
            //System.out.println(i+" "+right+" "+sum);
            while(right + 1 <= n  && sum + arr[right+1] <= n){
                sum+=arr[right+1];
                right++;

            }

            if(sum==n){
                answer++;
            }
            sum-=arr[i];

        }


        return answer;
    }
}
