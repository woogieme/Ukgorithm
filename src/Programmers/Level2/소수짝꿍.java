package Programmers.Level2;

import java.util.*;
class 소수짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        HashMap<Double,Integer> hMap = new HashMap<>();

        for(int i=0; i<weights.length; i++){
            double one = (weights[i]*1.0);
            double two = (weights[i]*2.0)/3.0;
            double three = (weights[i]*1.0)/2.0;
            double four = (weights[i]*3.0)/4.0;

            if(hMap.containsKey(one)){
                answer+=hMap.get(one);
            }if(hMap.containsKey(two)){
                answer+=hMap.get(two);
            }if(hMap.containsKey(three)){
                answer+=hMap.get(three);
            }if(hMap.containsKey(four)){
                answer+=hMap.get(four);
            }

            if(hMap.containsKey(weights[i]*1.0)){
                hMap.put(weights[i]*1.0,hMap.get(weights[i]*1.0)+1);
            }else{
                hMap.put(weights[i]*1.0,1);
            }

        }


        return answer;
    }
}
