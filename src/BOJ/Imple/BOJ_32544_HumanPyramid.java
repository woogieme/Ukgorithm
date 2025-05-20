package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_32544_HumanPyramid {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        long input = Long.parseLong(br.readLine());

        long left=1;
        long right=(long) 2e6;
        long ans=0;
        while(left<=right){

            long mid = (left+right)/2;

            long needPerson = mid*(mid+1)/2;

            if(needPerson<=input){
                ans = mid;
                left=mid+1;
            }else{
                right=mid-1;
            }

        }
        System.out.println(ans);




    }
}
