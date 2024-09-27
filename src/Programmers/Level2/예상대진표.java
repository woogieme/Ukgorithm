package Programmers.Level2;

import java.util.*;

class 예상대진표
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int game=1;
        int gameCount=0;
        Queue<Integer> arr = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            if(i==a || i==b){
                arr.add(-1);
            }else{
                arr.add(i);
            }

        }
        n/=2;
        while(true){

            int x = arr.poll();
            int y = arr.poll();
            if(x==-1 && y==-1){
                break;
            }

            if(x==-1 || y==-1){
                arr.add(-1);
            }else{
                arr.add(x);
            }
            gameCount++;
            if(gameCount==n){
                gameCount=0;
                answer++;
                n/=2;
            }
        }




        return answer;
    }
}
