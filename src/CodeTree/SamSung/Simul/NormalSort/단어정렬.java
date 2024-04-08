package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 단어정렬 {
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] abc = new String[N];
        for(int i=0; i<N; i++){

            abc[i]=br.readLine();
        }

        Arrays.sort(abc);
        for(int i=0; i<N; i++){

            sb.append(abc[i]).append("\n");
        }
        System.out.print(sb.toString());

    }
}