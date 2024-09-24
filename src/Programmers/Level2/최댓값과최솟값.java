package Programmers.Level2;

import java.util.*;

class 최댓값과최솟값 {
    public String solution(String s) {
        String answer = "";
        String[] strCnt = s.split(" ");
        int[] value = new int[strCnt.length];
        for(int i=0; i<strCnt.length; i++){
            value[i] = Integer.parseInt(strCnt[i]);
        }

        Arrays.sort(value);

        answer = String.valueOf(value[0]);
        answer = answer+ " ";
        answer = answer + String.valueOf(value[value.length-1]);




        return answer;
    }
}
