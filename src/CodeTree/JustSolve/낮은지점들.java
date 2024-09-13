package CodeTree.JustSolve;


import java.util.*;
import java.io.*;

public class 낮은지점들 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<Long,Long> hMap = new HashMap<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new  StringTokenizer(br.readLine());

            long x = Integer.parseInt(st.nextToken());
            long y = Integer.parseInt(st.nextToken());

            if(hMap.containsKey(x)){
                if(hMap.get(x)>y){
                    hMap.put(x,y);
                }
            }else{
                hMap.put(x,y);
            }
        }

        Set<Long> keySet = hMap.keySet();
        long value=0;
        for(Long key : keySet){
            value+=hMap.get(key);
        }
        System.out.println(value);
        // 여기에 코드를 작성해주세요.
    }
}