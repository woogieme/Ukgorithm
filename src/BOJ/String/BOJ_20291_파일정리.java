package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class BOJ_20291_파일정리 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String a = br.readLine().split("\\.")[1];
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }

        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String a = it.next();
            System.out.println(a+" "+map.get(a));
        }
    }
}
