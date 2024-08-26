package CodeTree.Techinque;

import java.util.*;
import java.io.*;

public class 호텔예약 {

    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int idx;

        public Pair(int x, int y,int idx){
            this.x=x;
            this.y=y;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair p){
            if(this.x ==p.x){
                return p.y - this.y;
            }
            return this.x - p.x;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        ArrayList<Pair> pair = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            pair.add(new Pair(X,1,i));
            pair.add(new Pair(Y,-1,i));
        }

        Collections.sort(pair);

        HashSet<Integer> hSet = new HashSet<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> used = new PriorityQueue<>();

        int result=0;

        for(int i=1; i<=N+1; i++){
            pq.add(i);
        }

        for(int i=0; i<N*2; i++){
            int X = pair.get(i).x;
            int Y = pair.get(i).y;
            int idx = pair.get(i).idx;

            if(Y==1){
                hSet.add(idx);
                used.add(pq.poll());
                if(result<used.size()){
                    result=used.size();
                }
            }else{
                hSet.remove(idx);
                pq.add(used.poll());

            }
        }
        System.out.println(result);
        // 여기에 코드를 작성해주세요.
    }
}