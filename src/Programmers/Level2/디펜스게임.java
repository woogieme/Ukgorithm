package Programmers.Level2;

import java.util.*;
class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq =new PriorityQueue<Integer>();

        for(int i=0; i<enemy.length; i++){

            pq.add(enemy[i]);

            if(pq.size()>k){
                int num= pq.poll();
                n-=num;
            }

            if(n<0){
                break;
            }
            answer++;
        }


        return answer;
    }
}