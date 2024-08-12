package CodeTree.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.io.*;

public class 최대숫자만들기 {
    static int result=0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];
        for(int i=0; i<N; i++){
            arr[i]=Long.parseLong(br.readLine());
        }

        Arrays.sort(arr, new Comparator<Long>() {
            @Override
            public int compare(Long a, Long b) {
                String tmpA = String.valueOf(a);
                String tmpB = String.valueOf(b);

                if(Long.parseLong(tmpA.substring(0,1))==Long.parseLong(tmpB.substring(0,1))){
                    if(Long.parseLong(tmpB+tmpA) >Long.parseLong(tmpA+tmpB)){
                        return 1;
                    };
                    return -1;
                }

                if(Long.parseLong(tmpB.substring(0,1)) >Long.parseLong(tmpA.substring(0,1))){
                    return 1;
                };
                return -1;
            }
        });
        for(int i=0; i<N; i++){
            System.out.print(arr[i]);
        }
    }
}