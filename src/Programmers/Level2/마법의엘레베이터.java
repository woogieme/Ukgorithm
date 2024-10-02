package Programmers.Level2;

import java.util.*;

class 마법의엘레베이터 {
    static class Stone{
        int pos;
        int count;
        public Stone(int pos, int count){
            this.pos= pos;
            this.count=count;
        }
    }
    public int solution(int storey) {
        int answer = 0;



        int value=storey;
        int i=0;

        int head=0;
        int tail=0;
        tail=storey;

        while(true){
            if(tail==0){
                break;
            }
            tail/=10;
            head++;
        }
        head-=1;
        while(true){
            value = storey;
            if(i>head){
                break;
            }
            //i번째 숫자
            int tmp =(int) (value%Math.pow(10,i));
            int tmp2 = (int)(tmp/Math.pow(10,i-1));
            int num = (int)Math.pow(10,i-1);
            if(tmp2!=0){
                if(tmp2>5){
                    int val = 10-tmp2;
                    answer+=val;
                    storey+=num*val;
                }else{
                    int val = tmp2;
                    answer+=val;
                    storey-=num*tmp2;
                }
            }
            i++;
        }

        //System.out.println(head+" "+storey);
        if((storey/(int)(Math.pow(10,head))<10)){
            answer+=(storey/(int)(Math.pow(10,head)));
        }else{
            answer+=(storey/(int)(Math.pow(10,head+1)));
        }
        return answer;
    }

    public static void main(String[] args) {
        int storey =123123;
        int[] initial = new int[] {storey, 0};
        for(int store : initial){
            System.out.println(store+" ");
        }
        System.out.println();

    }
}
