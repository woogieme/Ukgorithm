package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 연탄의크기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer,Integer> tMap = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){

            int num =Integer.parseInt(st.nextToken());
            if(tMap.containsKey(num)){
                tMap.put(num, tMap.get(num)+1);
            }else{
                tMap.put(num,1);
            }
        }

        int first = 2;
        int last = tMap.lastKey();

        int answer = Integer.MIN_VALUE;

        for(int i=first; i<=last; i++){
            int cnt=1;
            int tmp=0;
            while(true){
                if((i*cnt)>last){
                    break;
                }
                if(tMap.containsKey(i*cnt)){
                    tmp+=tMap.get(i*cnt);
                }
                cnt++;
            }
            answer= Math.max(answer,tmp);
        }

        System.out.println(answer);

    }
}