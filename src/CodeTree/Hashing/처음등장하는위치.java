package CodeTree.Hashing;

import java.util.*;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.io.*;

public class 처음등장하는위치 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer,Integer> m = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(!m.containsKey(num)){
                m.put(num,i+1);
            }
        }
        Iterator<Entry<Integer,Integer>> it = m.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer,Integer> go = it.next();

            System.out.println(go.getKey()+" "+go.getValue());
        }
        // 여기에 코드를 작성해주세요.
    }
}
