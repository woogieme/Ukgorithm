package CodeTree.JustSolve;

import java.util.*;
import java.io.*;

public class 순위경재2 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int A = 0;
        int B = 0;

        int result=0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String person = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            if(score==0){
                continue;
            }
            int preA = A;
            int preB = B;

            if(person.equals("A")){
                A+=score;
            }else{
                B+=score;
            }

            //preA가 preB보다 작았는데 A가 B보다 클때
            if(preA <= preB && A >= B){

                result++;
            }else if(preB <= preA && B >= A){
                result++;
            }



        }

        System.out.println(result);
        // 여기에 코드를 작성해주세요.
    }
}