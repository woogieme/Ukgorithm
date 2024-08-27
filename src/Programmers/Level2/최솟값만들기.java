package Programmers.Level2;

import java.util.Arrays;

public class 최솟값만들기 {
    public int solution(int []A, int []B)
    {
        int answer = 0;


        Arrays.sort(A);

        Arrays.sort(B);

        int[] arr = new int[A.length];
        int[] brr = new int[B.length];

        for(int i=0; i<A.length; i++){
            arr[i] =A[i];
        }

        for(int i=0; i<B.length; i++){
            brr[i] =B[B.length-1-i];
        }

        for(int i=0; i<B.length; i++){
            answer+= arr[i]*brr[i];
        }


        return answer;
    }
}
