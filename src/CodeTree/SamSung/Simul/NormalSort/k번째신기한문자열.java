package CodeTree.SamSung.Simul.NormalSort;

import java.io.*;
import java.util.*;

public class k번째신기한문자열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String alpha = st.nextToken();

        String[] arr = new String[N];

        int count=0;
        for(int i=0; i<N; i++){
            String tmp = br.readLine();
            if(tmp.startsWith(alpha)){
                arr[count]=tmp;
                count++;
            }
        }
        Arrays.sort(arr,0,count);
        System.out.println(arr[K-1]);

        // 여기에 코드를 작성해주세요.
    }
}