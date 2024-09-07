package CodeTree.Map;

import java.util.*;
import java.io.*;

public class 자주등장한topK숫자 {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        HashMap<Integer,Integer> hMap = new HashMap<>();

        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());

            if(hMap.containsKey(tmp)){
                hMap.put(tmp,hMap.get(tmp)+1);
            }else{
                hMap.put(tmp,1);
            }
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>();
        entryList = new LinkedList<>(hMap.entrySet());

        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o2.getValue() == o1.getValue()){
                    return o2.getKey() - o1.getKey();
                }
                return o2.getValue() - o1.getValue(); //오름 차순
            }
        });

        int cnt=0;
        for(Map.Entry<Integer, Integer> entry : entryList){

            if(cnt==T){
                break;
            }
            System.out.print(entry.getKey()+" ");
            cnt++;
        }
    }
}