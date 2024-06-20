package CodeTree.Techinque;

import java.util.*;
import java.io.*;
public class 겹치는선분들 {

    static class Pair implements Comparable<Pair>{

        int x;
        int y;
        int idx;

        public Pair(int x,int y,int idx){
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Pair> arr = new ArrayList<>();

        int x =0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());

            String input = st.nextToken();


            if(input.equals("L")){
                y=x-y;
                arr.add(new Pair(y,1,i));
                arr.add(new Pair(x,-1,i));
                x=y;
            }else{
                y=x+y;
                arr.add(new Pair(x,1,i));
                arr.add(new Pair(y,-1,i));
                x=y;
            }
        }


        Collections.sort(arr);

        int cnt=0;
        int result=0;

        HashSet<Integer> hSet = new HashSet<>();

        int value=0;
        for(int i=0; i<2*N; i++){

            int a = arr.get(i).x;
            int b = arr.get(i).y;
            int idx = arr.get(i).idx;

            if(b==1){
                hSet.add(idx);
                if(hSet.size()==K){
                    value=a;
                }
            }
            else{
                hSet.remove(idx);
                if(hSet.size()==K-1){
                    result+=Math.abs(value-a);
                }
            }

        }
        System.out.println(result);

        // 여기에 코드를 작성해주세요.
    }
}