package BOJ.problem;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_25024_시간과날짜 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            if(X>=0 && X<=23 && Y>=0 && Y<=59){
                System.out.print("YES"+" ");
            }else{
                System.out.print("NO"+" ");
            }

            if(X>=1 && X<=12 ){
                if((X%2==1 || X==8) && Y>=0 && Y<=31){

                }
            }

        }

    }
}
