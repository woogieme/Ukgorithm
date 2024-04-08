package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 문자열정렬 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] str2 = str.toCharArray();
        Arrays.sort(str2);
        String abc = new String(str2);
        System.out.println(abc);
        // 여기에 코드를 작성해주세요.
    }
}