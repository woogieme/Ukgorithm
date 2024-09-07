package CodeTree.Map;

import java.util.*;
import java.io.*;

public class 두수의합 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> hMap = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int tmp =Integer.parseInt(st.nextToken());
            if(hMap.containsKey(tmp)){
                hMap.put(tmp,hMap.get(tmp)+1);
            }else{
                hMap.put(tmp,1);
            }


        }
        int [] arr =new int[100000];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        int count=2;
        for(int i=3; i<=N; i++){
            arr[i]=arr[i-1]+count;
            count++;
        }
        int value=0;
        Set<Integer> keySet = hMap.keySet();
        int iTmp=0;
        for (Integer key : keySet) {

            if(hMap.containsKey(key) && hMap.containsKey(K-key)){
                if(key == K-key){
                    iTmp+=arr[hMap.get(key)];
                }else{
                    value+=hMap.get(key)*hMap.get(K-key);
                }
            }
        }
        int result = iTmp+(value/2);
        System.out.println(result);
        // 여기에 코드를 작성해주세요.
    }
}