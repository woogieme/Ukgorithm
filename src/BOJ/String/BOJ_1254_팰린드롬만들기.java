package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1254_팰린드롬만들기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        char[] chr = input.toCharArray();

        int end = chr.length-1;
        int start = chr.length-2;

        int result = Integer.MIN_VALUE;

        while(true){
            if(start<0){
                break;
            }
            boolean isFlag=true;
            int k=0;
            for(int i=start; i<start+(end-start+1)/2; i++){

                if(chr[i]!=chr[end-k]){
                    isFlag=false;
                    break;
                }
                k++;
            }

            if(isFlag){
                if(result<(end-start)+1){
                    result=end-start+1;
                }
            }
            start--;


        }

        //팰린드롬이 하나도 맞지않을때
        if(result==Integer.MIN_VALUE){
            System.out.println(chr.length*2-1);
        }
        //팰린드롬갯수와 전체길이가 똑같을때
        else if(result==chr.length){
            System.out.println(result);
        }
        //팰린드롬갯수와 전체길이가 틀릴때
        else {
            int tmp = chr.length - result;
            result+=tmp*2;
            System.out.println(result);
        }


    }
}
