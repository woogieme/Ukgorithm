package Programmers.Level3;

import java.util.*;

class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        TreeMap<Integer,Integer> tSet =new TreeMap<>();

        for(int i=0; i<B.length; i++){
            if(tSet.containsKey(B[i])){
                tSet.put(B[i],tSet.get(B[i])+1);
            }else{
                tSet.put(B[i],1);
            }
        }

        for(int i=0; i<B.length; i++){
            Integer higherKey = tSet.higherKey(A[i]);
            if(higherKey!=null){
                answer++;
                int tmp = tSet.get(higherKey);
                tmp--;
                if(tmp==0){
                    tSet.remove(higherKey);
                }else{
                    tSet.put(higherKey,tmp);
                }

                continue;
            }
            if(tSet.containsKey(A[i])){
                int tmp = tSet.get(A[i]);
                tmp--;
                if(tmp==0){
                    tSet.remove(A[i]);
                }else{
                    tSet.put(A[i],tmp);
                }
                continue;
            }

        }

        return answer;
    }
}
