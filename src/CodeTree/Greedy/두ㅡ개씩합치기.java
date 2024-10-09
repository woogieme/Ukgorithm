package CodeTree.Greedy;

import java.util.*;
import java.io.*;
public class 두ㅡ개씩합치기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeMap<Long,Long> hSet = new TreeMap<>();

        for(int i=0; i<N; i++){
            long num = Long.parseLong(st.nextToken());
            if(hSet.containsKey(num)){
                hSet.put(num,hSet.get(num)+1L);
            }else{
                hSet.put(num,1L);
            }

        }

        long answer=0;

        while(true){

            Long firstKey = hSet.firstKey();

            long score = hSet.get(firstKey);

            if(score-1==0){
                hSet.remove(firstKey);
            }else{
                hSet.put(firstKey, hSet.get(firstKey)-1L);
            }

            Long secondKey = hSet.firstKey();

            score = hSet.get(secondKey);

            if(score-1==0){
                hSet.remove(secondKey);
            }else{
                hSet.put(secondKey, hSet.get(secondKey)-1L);
            }

            answer += (firstKey+secondKey);

            if(hSet.containsKey(firstKey+secondKey)){
                hSet.put(firstKey+secondKey,hSet.get(firstKey+secondKey)+1L);
            }else{
                hSet.put(firstKey+secondKey,1L);
            }

            if(hSet.size()==1){
                break;
            }

        }
        System.out.println(answer);

    }
}
