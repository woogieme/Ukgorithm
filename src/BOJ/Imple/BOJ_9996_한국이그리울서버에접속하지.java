package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9996_한국이그리울서버에접속하지 {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        String tmp = br.readLine();

        String[] tmp_A= tmp.split("\\*");
        char[] front=tmp_A[0].toCharArray();
        char[] rear=tmp_A[1].toCharArray();

        for (int i = 0; i < N; i++) {
            boolean isFlag=true;
            char[] value = br.readLine().toCharArray();
            if(front.length+rear.length > value.length){
                System.out.println("NE");
                continue;
            }

            for (int f = 0; f < front.length; f++) {
                if(front[f]!=value[f]){
                    isFlag=false;
                    break;
                }
            }
            int count=0;
            for (int r = value.length-rear.length; r < value.length; r++) {
                if(rear[count]!=value[r]){
                    isFlag=false;
                    break;
                }
                count++;
            }
            if(!isFlag){
                System.out.println("NE");
            }else{
                System.out.println("DA");
            }

        }


    }
}
