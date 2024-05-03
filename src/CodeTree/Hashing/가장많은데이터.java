package CodeTree.Hashing;

import java.util.*;
import java.io.*;

public class 가장많은데이터 {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> m = new HashMap<>();

        int value=0;

        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(m.containsKey(input)){
                m.put(input,m.get(input)+1);
            }else{
                m.put(input,1);
            }

            if(value<m.get(input)){
                value=m.get(input);
            }
        }

        System.out.println(value);


        // 여기에 코드를 작성해주세요.
    }
}
