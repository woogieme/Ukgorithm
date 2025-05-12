package BOJ.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[] arr = new int[N+1];
        int[] checked = new int[100001];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        checked[arr[1]]=1;
        int j=1;
        int ans=0;
        for (int i = 1; i <= N; i++) {

            while(j+1<=N && checked[arr[j+1]] <K){
                checked[arr[j+1]]++;
                j++;
            }
            ans = Math.max(ans,j-i+1);
            checked[arr[i]]--;
        }
        System.out.println(ans);
    }
}
