package Programmers.Level2;

import java.util.*;
class 숫자카드나누기 {
    public int GCDfind(int GCD,int num){
        if(num==0) return GCD;
        return GCDfind(num,GCD%num);
    }
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        int GCD = arrayA[0];
        int GCD2 = arrayB[0];
        for(int i=0; i<arrayA.length; i++){
            GCD = GCDfind(GCD,arrayA[i]);
        }
        for(int i=0; i<arrayB.length; i++){
            GCD2 = GCDfind(GCD2,arrayB[i]);
        }

        //GCD 1번째 최대공약수
        //GCD2 2번째 최대공약수
        boolean isAflag=true;
        boolean isBflag=true;
        //조건 1. GCD로 철수로 모두 나누어지고, 영희는 안됨
        //조건 2. GCD2로 영희로 모두 나누어지고, 철수는 안됨
        for(int i=0; i<arrayA.length; i++){
            if(arrayA[i]%GCD2==0 || GCD2==1){
                isAflag=false;
                break;
            }
        }

        for(int i=0; i<arrayA.length; i++){
            if(arrayB[i]%GCD==0 || GCD==1){
                isBflag=false;
                break;
            }
        }

        if(!isAflag && !isBflag){
            return 0;
        }else if(GCD<GCD2){
            return GCD2;
        }
        return GCD;




    }
}