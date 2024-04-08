package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 순서를바꾸었을때판별하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        String K = br.readLine();

        char[] A = N.toCharArray();
        char[] B = K.toCharArray();

        Arrays.sort(A);
        Arrays.sort(B);

        String arr = new String(A);
        String arr2 = new String(B);

        if(arr.equals(arr2)){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }



    }
}