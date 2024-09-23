package Programmers.Level2;

import java.util.*;

class 숫자변환하기 {

    static int MAX_VALUE = Integer.MAX_VALUE;

    static class Pair{
        int target;
        int count;

        Pair(int target, int count){
            this.target=target;
            this.count=count;
        }
    }


    public void BFS(int x,int y, int n){
        boolean[] checked = new boolean[1000001];
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x,0));
        checked[x]=true;
        while(!queue.isEmpty()){

            Pair p = queue.poll();

            if(p.target==y){
                MAX_VALUE=p.count;
            }

            if(p.target+n <= y && !checked[p.target+n]){
                checked[p.target+n]=true;
                queue.add(new Pair(p.target+n,p.count+1));
            }
            if(p.target*2<= y && !checked[p.target*2]){
                queue.add(new Pair(p.target*2,p.count+1));
                checked[p.target*2]=true;
            }
            if(p.target*3<=y && !checked[p.target*3]){
                queue.add(new Pair(p.target*3,p.count+1));
                checked[p.target*3]=true;
            }

        }

    }
    public int solution(int x, int y, int n) {
        int answer = 0;

        BFS(x,y,n);

        return MAX_VALUE!=2147483647? MAX_VALUE : -1;
    }


}
