package CodeTree.Tree;

import java.util.*;
import java.io.*;


class Pair implements Comparable<Pair>{
    int x,y;

    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public int compareTo(Pair p){
        if(this.y==p.y){
            return this.x - p.x;
        }
        return this.y - p.y;
    }
}

public class 문제추천시스템1 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int TC_A = Integer.parseInt(br.readLine());
        TreeSet<Pair> s = new TreeSet<>();


        StringTokenizer st = null;

        for(int i=0; i<TC_A; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            s.add(new Pair(x1,y1));
        }

        int TC_B = Integer.parseInt(br.readLine());

        for(int i=0; i<TC_B; i++){
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if(order.equals("ad")){
                s.add(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }else if(order.equals("sv")){
                s.remove(new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }else if(order.equals("rc")){
                int x =Integer.parseInt(st.nextToken());
                if(x==-1){
                    Pair value = s.first();
                    System.out.println(value.x);
                }else{
                    Pair value = s.last();
                    System.out.println(value.x);
                }
            }
        }
    }
}