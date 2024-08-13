package CodeTree.Greedy;

import java.util.*;
import java.io.*;

public class 높은숫자가이기는게임 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N*2+1];

        ArrayList<Integer> listArr = new ArrayList<>();

        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            arr[tmp] = 1;
            listArr.add(tmp);
        }

        TreeSet<Integer> tSet = new TreeSet<>();

        for(int i=1; i<=N*2; i++){
            if(arr[i]!=1){
                tSet.add(i);
            }
        }
        int count=0;
        for(int i=0; i<N; i++){
            int t = listArr.get(i);
            if(tSet.ceiling(t)!=null){
                count++;
                tSet.remove(tSet.ceiling(t));
            }else{
                tSet.remove(tSet.first());
            }
        }
        System.out.println(count);



        // 여기에 코드를 작성해주세요.
    }
}