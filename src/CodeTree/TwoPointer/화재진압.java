package CodeTree.TwoPointer;

import java.util.*;
import java.io.*;

public class 화재진압 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N+1];

        HashMap<Integer,Integer> hSet = new HashMap<>();;
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int j=0;
        int result = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++){

            while(j+1<=N){
                if(hSet.containsKey(arr[j+1])){
                    //System.out.println((j+1)+" "+hSet.get(j+1));
                    if(hSet.get(arr[j+1])==K){
                        break;
                    }else{
                        hSet.put(arr[j+1],hSet.get(arr[j+1])+1);
                    }
                }else{
                    hSet.put(arr[j+1],1);
                }
                j++;
            }

            result = Math.max(result,j-i+1);
            hSet.put(arr[i],hSet.get(arr[i])-1);
            if(hSet.get(arr[i])==0){
                hSet.remove(arr[i]);
            }
        }
        System.out.println(result);

        // 여기에 코드를 작성해주세요.
    }
}
