package CodeTree.Greedy;

import java.util.*;
import java.io.*;
public class 사람들줄세우기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] idx = new int[N];
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[M];
        boolean trigger=true;
        for(int i=0; i<M; i++){

            arr[i]= Integer.parseInt(st.nextToken());
            if(arr[i]==1){
                trigger=false;
            }
        }
        boolean[] checked = new boolean[M];
        HashMap<Integer,Integer> hSet = new HashMap<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int tmp = Integer.parseInt(st.nextToken());
            hSet.put(num,tmp-1);
            idx[tmp-1]= num;
            for(int j=0; j<M; j++){
                if(arr[j]==num){

                    checked[j]=true;
                }
            }
        }


        //1을 빈곳에 모두 집어넣는다
        //다음숫자들을 집어넣는다
        //된다 => 최소값 비교
        //안된다 => 다시
        int start =0;

        int answer=Integer.MAX_VALUE;
        while(true){

            int[] idx_tmp =new int[N];
            for(int i=0; i<N; i++){
                idx_tmp[i] = idx[i];
            }

            int[] tmp = new int[M];
            for(int i=0; i<M; i++){
                tmp[i] = arr[i];
            }

            boolean[] visited = new boolean[M];
            for(int i=0; i<M; i++){
                visited[i] = checked[i];
            }

            boolean game = true;
            //1을빈곳에 집어넣는 행위
            for(int i=start; i<N; i++){
                if(idx_tmp[i]==0){
                    idx_tmp[i]=1;
                    start=i+1;
                    game =false;
                    break;
                }
            }

            if(game){

                break;
            }

            int visit=0;
            //다음 숫자들을 집어넣는다.


            HashMap<Integer,Integer> hMap = new HashMap<>();
            for(int i=0;i<M;i++){
                hMap.put(i,tmp[i]);
            }

            int cnt=0;
            int s_i=0;
            while(true){
                if(cnt==hMap.size()){
                    break;
                }
                if(s_i==N){
                    break;
                }
                if(idx_tmp[s_i]==0){
                    if(hMap.get(cnt)==1){
                        cnt++;
                        continue;
                    }
                    else if(hSet.containsKey(hMap.get(cnt))){
                        s_i=hSet.get(hMap.get(cnt))+1;
                        cnt++;
                        //System.out.println(hMap.get(cnt));
                        //System.out.println(hSet.get(hMap.get(cnt)));

                        continue;
                    }
                    else {
                        idx_tmp[s_i]=hMap.get(cnt);
                        cnt++;
                        continue;
                    }
                }
                s_i++;
            }
            // for(int i=0; i<N;i++){
            //     System.out.print(idx_tmp[i]+" ");
            // }
            // System.out.println();
            hMap = new HashMap<>();
            for(int i=0;i<M;i++){
                hMap.put(tmp[i],i);
            }
            //되는지 안되는지 비교

            boolean flag=false;
            Set<Integer> keySet = hMap.keySet();

            int result=0;
            for(int i=0; i<N; i++){

                if(hMap.containsKey(idx_tmp[i])){
                    if(result==hMap.get(idx_tmp[i])){
                        //System.out.println(result+" "+hMap.get(idx_tmp[i])+" "+idx_tmp[i]);
                        result++;
                    }else{

                        flag=true;
                        break;
                    }
                }
            }

            if(!flag){
                for(int i=0; i<N; i++){
                    if(idx_tmp[i]==1){
                        answer = Math.min(answer,i+1);
                        break;
                    }
                }
            }



        }
        System.out.println(answer);






        // 여기에 코드를 작성해주세요.

    }
}