package CodeTree.Techinque;

import java.util.*;
import java.io.*;

public class 컴퓨터이용시간 {

    public static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int idx;

        Pair(int x,int y, int idx){
            this.x=x;
            this.y=y;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair p){
            return this.x - p.x;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr.add(new Pair(x,1,i));
            arr.add(new Pair(y,-1,i));

        }
        Collections.sort(arr);

        HashSet<Integer> hSet = new HashSet<>();
        int[] seqNum = new int[N];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1; i<=N; i++){
            queue.add(i);
        }
        for(int i=0; i<2*N; i++){
            int x= arr.get(i).x;
            int y= arr.get(i).y;
            int idx= arr.get(i).idx;

            if(y==1){
                seqNum[idx]=queue.poll();
            }else{
                hSet.remove(idx);
                queue.add(seqNum[idx]);
            }
        }

        for(int i=0; i<N; i++){
            System.out.print(seqNum[i]+" ");
        }



        // 여기에 코드를 작성해주세요.
    }
}