package CodeTree.PQ;

import java.io.*;
import java.util.*;


class Pair implements Comparable<Pair>{
    int x;
    int y;
    int sum;

    public Pair(int x,int y,int sum){
        this.x=x;
        this.y=y;
        this.sum=sum;
    }

    @Override
    public int compareTo(Pair p){
        if(this.sum==p.sum){
            if(this.x==p.x){
                return this.y-p.y;
            }
            return this.x-p.x;
        }
        return this.sum - p.sum;

    }
}

public class 가장가까운점 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        // 여기에 코드를 작성해주세요.

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int sum =  Math.abs(x)+Math.abs(y);
            pq.add(new Pair(x,y,sum));
        }

        for(int i=0; i<M; i++){
            Pair shortDot = pq.poll();
            shortDot.x +=2;
            shortDot.y +=2;
            shortDot.sum = Math.abs(shortDot.x)+Math.abs(shortDot.y);
            pq.add(shortDot);
        }

        Pair shortDot = pq.poll();
        System.out.println(shortDot.x+" "+shortDot.y);
    }
}
