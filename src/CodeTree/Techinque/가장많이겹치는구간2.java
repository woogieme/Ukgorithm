package CodeTree.Techinque;

import java.util.*;
import java.io.*;

public class 가장많이겹치는구간2 {

    public static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int compareTo(Pair p){
            return this.x - p.x;
        }
    }
    public static void main(String[] args) throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Pair> pairs = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            pairs.add(new Pair(x,1));
            pairs.add(new Pair(y,-1));
        }

        Collections.sort(pairs);

        int value=0;
        int result=0;
        for(int i=0; i<2*N; i++){
            int x = pairs.get(i).x;
            int y = pairs.get(i).y;

            value+=y;

            if(result<value){
                result=value;
            }

        }
        System.out.println(result);

        // 여기에 코드를 작성해주세요.
    }
}
