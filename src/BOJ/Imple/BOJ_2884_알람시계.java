package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884_알람시계 {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(M-45<0){
            N-=1;
            if(N==-1){
                N=23;
            }
            M= 60-Math.abs(M-45);
        }else{
            M=M-45;
        }
        System.out.println(N+" "+M);

    }
}
