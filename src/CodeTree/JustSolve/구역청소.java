package CodeTree.JustSolve;

import java.io.*;
import java.util.*;

public class 구역청소 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int areaA = Math.abs(x-y);
        int areaB = Math.abs(a-b);
        int tmp=0;
        int result=0;
        if(x<=a && a<=y && y<=b){
            result = areaA+areaB-Math.abs(a-y);
        }else if(x<=a && a<=y && y>=b){
            result=areaA;
        }else if(a<=x && x<=b && b<=y){
            result = areaA+areaB-Math.abs(b-x);
        }else if(a<=x && x<=b && b>=y){
            result=areaB;
        }else if(a==x && b==y){
            result=areaB;
        }else{
            result =areaA+areaB;
        }
        System.out.println(result);

    }
}