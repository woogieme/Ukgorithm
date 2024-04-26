package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
    static int T;
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tc=1; tc <=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr=new int[N+1];
            makeSet();
            for (int i = 1; i <=M; i++) {
                st = new StringTokenizer(br.readLine());
                int X=Integer.parseInt(st.nextToken());
                int Y=Integer.parseInt(st.nextToken());
                union(X,Y);
            }
            int[] brr= new int[N+1];
            int count=0;
            for (int i = 1; i <=N; i++) {
                if(brr[check(i)]==0) {
                    count+=1;
                    brr[check(i)]=1;
                }
            }
            System.out.println("#"+tc+" "+count);
        }

    }
    private static void union(int x, int y) {
        int p1 = check(x);
        int p2 = check(y);

        arr[p1]=p2;

    }
    private static int check(int cnt) {
        if(arr[cnt]==cnt) {
            return cnt;
        }
        else {
            return check(arr[cnt]);
        }

    }
    private static void makeSet() {
        for (int i = 1; i <=N; i++) {
            arr[i]=i;
        }

    }
}
