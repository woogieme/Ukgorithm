package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_2002_추월 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> hMapA= new HashMap<>();
        HashMap<String,Integer> hMapB= new HashMap<>();

        String[] tmp = new String[N];
        for(int i=0; i<N; i++){
            String arr = br.readLine();
            hMapA.put(arr,i);
            tmp[i]=arr;
        }

        for(int i=0; i<N; i++){
            String arr = br.readLine();
            hMapB.put(arr,i);
        }

        int count=0;
        for (int i = 0; i <N; i++) {
            if(hMapA.get(tmp[i])>hMapB.get(tmp[i])) {
                count++;
            }else{
                for(int j=0; j<hMapB.get(tmp[i]); j++){
                    if(hMapA.get(tmp[i]) > hMapA.get(tmp[j]) && hMapB.get(tmp[i])< hMapB.get(tmp[j])){
                        count++;
                        break;
                    }

                }
            }
        }

        System.out.println(count);
    }
}
