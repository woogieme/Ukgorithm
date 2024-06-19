package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4889_안정적인문자열 {


    static int[] card ;

    static int[] arr;

    static boolean[] select;

    static int N;

    static int result =Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String temp = Integer.toString(N);
        card = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++) {
            card[i] =temp.charAt(i)- '0';
        }

        arr =new int [temp.length()];
        select =new boolean[temp.length()];
        //System.out.println(Arrays.toString(card));
        perm(0);
        if(result==Integer.MAX_VALUE){

            System.out.println(0);
        }else {
            System.out.println(result);
        }
    }

    static void perm(int idx){
        if(idx==card.length){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<card.length; i++){
                sb.append(arr[i]);
            }
            int value = Integer.parseInt(String.valueOf(sb));
            if(N<value){
                if(value<result){
                    result=value;
                }
            }
            //()

        }

        for(int i=0; i<card.length; i++){
            if(select[i]) continue;

            arr[idx]=card[i];
            select[i]=true;
            perm(idx+1);
            select[i]=false;
        }
    }

}
