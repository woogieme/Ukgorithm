package Programmers.Level2;

import java.util.*;

class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Long> one = new ArrayDeque<>();
        Queue<Long> two = new ArrayDeque<>();

        long oneSum=0;
        long twoSum=0;

        for(int i=0; i<queue1.length; i++){
            one.add((long)queue1[i]);
            two.add((long)queue2[i]);
        }

        for(int i=0; i<queue1.length; i++){
            oneSum+=queue1[i];
            twoSum+=queue2[i];
        }

        int count=0;

        while(true){
            if(count>=10000000){
                return -1;
            }
            if(oneSum==twoSum){
                break;
            }

            if(oneSum<twoSum){
                long tmp = (long)two.poll();
                one.add(tmp);
                twoSum-=tmp;
                oneSum+=tmp;
                answer++;
                count++;
            }else{
                long tmp = (long)one.poll();
                two.add(tmp);
                oneSum-=tmp;
                twoSum+=tmp;
                answer++;
                count++;
            }



        }


        return answer;
    }
}

//합 7 < 13
//합
//1 2 1 2 1
//1 10 1 2
