package Programmers.Level2;

import java.util.*;
class 다음큰숫자 {
    public int solution(int n) {
        int answer = 0;

        int count=0;
        int count2=0;
        String str = "";
        int n_tmp=n;
        while(true){

            if (n==0 ){
                break;
            }
            if(n==1){
                count++;
                break;
            }
            int tmp = n%2;
            if(tmp==1){
                count++;
            }
            n/=2;

        }


        for(int i=n_tmp+1; i<=1000000; i++){
            int num=i;
            count2=0;
            while(true){

                if (num==0 ){
                    break;
                }
                if(num==1){
                    count2++;
                    break;
                }
                int tmp = num%2;
                if(tmp==1){
                    count2++;
                }
                num/=2;

            }

            if(count2==count){

                answer=i;
                break;
            }
        }


        return answer;
    }
}

//1001110
//1010011

//1001010
//1001100

//1001110
//1010011

//1발견 후 앞에 1이있는가?
//앞으로 전진->
//앞에


