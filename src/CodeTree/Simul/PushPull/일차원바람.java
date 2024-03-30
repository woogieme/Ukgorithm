package CodeTree.Simul.PushPull;

import java.util.*;
import java.io.*;

public class 일차원바람 {

    static int N;
    static int M;
    static int Q;

    static int[][] map;
    static boolean[] checked;
    static ArrayList<Wind> queue;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int t=0; t<Q; t++){
            checked = new boolean[N];

            queue = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            queue.add(new Wind(Integer.parseInt(st.nextToken())-1, st.nextToken()));
            while(true){
                if(queue.isEmpty()){
                    break;
                }

                int num = queue.get(0).height;
                String pos = queue.get(0).pos;
                checked[num]=true;

                if(pos.equals("L")){
                    int tmp = map[num][M-1];

                    for(int i=M-1; i>0; i--){
                        map[num][i] = map[num][i-1];
                    }
                    map[num][0]=tmp;
                }
                else{
                    int tmp = map[num][0];

                    for(int i=0; i<M-1; i++){
                        map[num][i] = map[num][i+1];
                    }
                    map[num][M-1]=tmp;
                }


                //아래 검사
                if(num+1<N && checked[num+1]==false){
                    for(int i=0; i<M; i++){
                        if(map[num][i]==map[num+1][i]){
                            if(pos.equals("L")){
                                queue.add(new Wind(num+1,"R"));
                            }
                            else{
                                queue.add(new Wind(num+1,"L"));
                            }
                            break;
                        }
                    }

                }

                //위 검사
                if(num-1>=0 && checked[num-1]==false){
                    for(int i=0; i<M; i++){
                        if(map[num][i]==map[num-1][i]){
                            if(pos.equals("L")){
                                queue.add(new Wind(num-1,"R"));
                            }
                            else{
                                queue.add(new Wind(num-1,"L"));
                            }
                            break;
                        }
                    }
                }

                queue.remove(0);
                // System.out.println("==========================");
                // for(int i=0; i<N; i++){
                //     for(int j=0; j<M; j++){
                //         System.out.print(map[i][j]+" ");
                //     }
                //     System.out.println();
                // }
                // for(int i=0; i<queue.size(); i++){
                //     System.out.println(queue.get(i).height+" "+queue.get(i).pos);
                // }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }

    static class Wind{
        int height;
        String pos;
        public Wind(int height, String pos){
            this.height = height;
            this.pos = pos;
        }
    }
}