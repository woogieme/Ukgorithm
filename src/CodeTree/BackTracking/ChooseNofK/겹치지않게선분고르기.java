package CodeTree.BackTracking.ChooseNofK;

import java.util.*;
import java.io.*;

public class 겹치지않게선분고르기 {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Pos> pos;
    static ArrayList<Pos> check;
    static int result = Integer.MIN_VALUE;
    static int R;

    static class Pos implements Comparable<Pos>{
        int x;
        int y;

        Pos(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Pos p){
            if(this.x==p.x){
                return this.x-p.y;
            }
            return this.x-p.x;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        pos = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            pos.add(new Pos(x,y));
        }

        Collections.sort(pos);

        R=1;
        visited= new boolean[N];
        comb(0,0);

        System.out.println(result);
    }

    static void comb(int idx,int cnt){
        if(idx==N){
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<visited.length; i++){
                if(visited[i]){
                    list.add(i);
                }
            }

            ArrayList<Integer> num = new ArrayList<>();
            boolean isFlag=false;
            for(int i=0; i<list.size(); i++){

                if(i==0){

                    int b =pos.get(list.get(i)).y;
                    num.add(b);
                    continue;
                }
                int x =pos.get(list.get(i)).x;
                int y =pos.get(list.get(i)).y;

                if(num.get(num.size()-1)>=x){
                    isFlag=true;
                    break;
                }
                num.add(y);
            }
            if(!isFlag){
                result=Math.max(result,list.size());
            }
            return;
        }if(cnt==N){
            return;
        }

        visited[idx]=true;
        comb(idx+1,cnt+1);
        visited[idx]=false;
        comb(idx+1,cnt);
    }
}
