package CodeTree.JustSolve;

import java.util.*;
import java.io.*;
public class 순간이동 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        //그냥가기
        int chapter1 = Math.abs(A-B);

        //x 텔포
        int chapter2 = Math.abs(A-x) + Math.abs(B-y);

        //y 텔포
        int chapter3 = Math.abs(A-y)+ Math.abs(B-x);

        int result = Integer.MAX_VALUE;

        result = Math.min(chapter1,chapter2);
        result = Math.min(result,chapter3);

        System.out.println(result);

        // 여기에 코드를 작성해주세요.
    }
}
