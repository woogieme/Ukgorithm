package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15787_기차가어둠을헤치고 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N+1][21];

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int trainNum = Integer.parseInt(st.nextToken());
            int order = Integer.parseInt(st.nextToken());
            if(trainNum==1){
                //1 i x : i번째 기차에(1 ≤ i ≤ N) x번째 좌석에(1 ≤ x ≤ 20) 사람을 태워라. 이미 사람이 타있다면 , 아무런 행동을 하지 않는다.
                int seat = Integer.parseInt(st.nextToken());
                if(arr[order][seat]!=1){
                    arr[order][seat]=1;
                }

            }else if(trainNum==2){
                //2 i x : i번째 기차에 x번째 좌석에 앉은 사람은 하차한다. 만약 아무도 그자리에 앉아있지 않았다면, 아무런 행동을 하지 않는다.
                int seat = Integer.parseInt(st.nextToken());
                if(arr[order][seat]==1){
                    arr[order][seat]=0;
                }
            }else  if(trainNum==3){
                //3 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 뒤로간다. k번째 앉은 사람은 k+1번째로 이동하여 앉는다. 만약 20번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.

                for(int num=19; num>=1; num--){
                    arr[order][num+1]=arr[order][num];
                }
                arr[order][1]=0;

            }else{
                //4 i : i번째 기차에 앉아있는 승객들이 모두 한칸씩 앞으로간다. k번째 앉은 사람은 k-1 번째 자리로 이동하여 앉는다. 만약 1번째 자리에 사람이 앉아있었다면 그 사람은 이 명령 후에 하차한다.
                for(int num=1; num<=20; num++){
                    arr[order][num-1]=arr[order][num];
                }
                arr[order][20]=0;
            }
        }

        HashMap<ArrayList<Integer>,Integer> map = new HashMap<>();

        for (int i = 1; i <=N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 1; j <=20; j++) {
                if(arr[i][j]==1){
                    list.add(j);
                }
            }

                if(!map.containsKey(list)){
                    map.put(list,i);
                }

        }

        System.out.println(map.size());


    }
}
