package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class TokK숫자구하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        System.out.println(arr[K]);

    }
}