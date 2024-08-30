package CodeTree.PQ;

import java.util.*;
import java.io.*;

public class 배열추출2 {
    static class Pair {
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> hMap = new HashMap<>();
        for(int i=0; i<N; i++){

            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0){
                if(pq.size()==0){
                    System.out.println("0");
                }
                else{
                    int value = pq.poll();
                    if(hMap.containsKey(value*-1)){
                        System.out.println(value*-1);
                        if(hMap.get(value*-1)==1){
                            hMap.remove(value*-1);
                        }else{
                            hMap.put(value*-1,hMap.get(value*-1)-1);
                        }
                    }else{
                        System.out.println(value);
                        if(hMap.get(value)==1){
                            hMap.remove(value);
                        }else{
                            hMap.put(value,hMap.get(value)-1);
                        }
                    }
                }
            }else{

                if(hMap.containsKey(tmp)){
                    hMap.put(tmp,hMap.get(tmp)+1);
                }else{
                    hMap.put(tmp,1);
                }
                pq.add(Math.abs(tmp));
            }
        }

        // 여기에 코드를 작성해주세요.
    }
}