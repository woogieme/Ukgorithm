package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 나무공격 {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] checked;
    static TreeMap<Integer,List<Integer>> tMap;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        tMap = new TreeMap<>();

        for(int i=0; i<N; i++ ){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){

                    if(tMap.containsKey(i)){
                        tMap.get(i).add(j);
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        tMap.put(i, list);
                    }

                }
            }
        }

        // for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
        //     System.out.println(entry.getKey() + ": " + entry.getValue());
        // }

        for(int i=0; i<2; i++){

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;

            for(int d=start; d<=end; d++){
                if(tMap.containsKey(d)){
                    List<Integer> tmp = tMap.get(d);
                    tmp.remove(0);
                    if(tmp.size()==0){
                        tMap.remove(d);
                    }else{
                        tMap.put(d,tmp);
                    }

                }
            }

        }
        int answer=0;
        for (Map.Entry<Integer, List<Integer>> entry : tMap.entrySet()) {
            answer+=entry.getValue().size();
        }
        System.out.println(answer);

    }
}

