package CodeTree.Techinque;

import java.util.*;
import java.io.*;

public class 구간크기의합 {

    public static class Pair implements Comparable<Pair>{

        int x;
        int y;
        int idx;

        public Pair(int x,int y, int idx){
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

            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());

            arr.add(new Pair(x,1,i));
            arr.add(new Pair(y,-1,i));

        }

        Collections.sort(arr);

        HashSet<Integer> hSet = new HashSet<>();

        int low=0;
        int high=0;
        int result=0;
        for(int i=0; i<N*2; i++){
            int x = arr.get(i).x;
            int y = arr.get(i).y;
            int idx = arr.get(i).idx;


            if(y==1){
                if(hSet.size()==0){
                    low=x;
                }
                hSet.add(idx);
            }else{
                hSet.remove(idx);
                if(hSet.size()==0){

                    result+=x-low;
                }
            }
        }
        System.out.println(result);
        // 여기에 코드를 작성해주세요.
    }
}
