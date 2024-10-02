package BOJ.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer=0;

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int eE=1;
        int sS=1;
        int mM=1;
        while(true){

            if(E==eE && S==sS && M==mM){
                answer++;
                break;
            }
            eE++;
            sS++;
            mM++;

            if(eE==16){
                eE=1;
            }if(sS==29){
                sS=1;
            }if(mM==20){
                mM=1;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
