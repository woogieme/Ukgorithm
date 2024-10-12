package Programmers.Level2;

import java.util.*;

class 이진코드변환하기 {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt=0;
        int num=0;
        int ans=0;
        while(!s.equals("1")){
            ans++;
            num=0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='1'){
                    num++;
                }else{
                    cnt+=1;
                }
            }

            s= Integer.toBinaryString(num);
        }
        answer[0]=ans;
        answer[1]=cnt;
        return answer;
    }
}
