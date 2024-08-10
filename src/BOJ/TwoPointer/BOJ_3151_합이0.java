package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_3151_합이0 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        TreeSet<Integer> ts = new TreeSet<>();

        for (int i = 0; i <N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ts.add(arr[i]);
        }
        HashMap<Integer,Integer> hm = new HashMap<>();

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i=0; i<N; i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i],hm.get(arr[i])+1);
            }else{
                hm.put(arr[i],1);
            }
        }

        int j = N-1;
        int result=0;
        for (int i = 0; i <N; i++) {
            int tmp = (arr[i]+arr[j])*-1;
            if(i<=j-2 && hm.containsKey(arr[j]) && hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) - 1);
                if (hm.get(arr[i]) == 0) {
                    hm.remove(arr[i]);
                }

                hm.put(arr[j], hm.get(arr[j]) - 1);
                if (hm.get(arr[j]) == 0) {
                    hm.remove(arr[j]);
                }

                if (hm.containsKey(tmp)) {
                    result += hm.get(tmp);
                }
            }

            while(i<=j-2 && arr[i]+arr[j]>0){
                j--;
                tmp = (arr[i]+arr[j])*-1;

                hm.put(arr[j],hm.get(arr[j])-1);
                if(hm.get(arr[j])==0){
                    hm.remove(arr[j]);
                }
                if(hm.containsKey(tmp)){
                    result+=hm.get(tmp);
                }

            }
        }
        System.out.println(result);



    }
}
