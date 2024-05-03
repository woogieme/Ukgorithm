package CodeTree.Hashing;

import java.util.*;
import java.io.*;

public class 대응되수와문자 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> m = new HashMap<>();
        HashMap<Integer,String> b = new HashMap<>();
        for(int i=0; i<N; i++){
            String input = br.readLine();

            m.put(input,i+1);
            b.put(i+1,input);

        }

        for(int i=0; i<M; i++){
            String input = br.readLine();
            if(m.containsKey(input)){
                System.out.println(m.get(input));
            }else{
                System.out.println(b.get(Integer.parseInt(input)));
            }

        }



    }
}