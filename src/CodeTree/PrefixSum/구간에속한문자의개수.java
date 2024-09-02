package CodeTree.PrefixSum;

import java.util.*;
import java.io.*;

public class 구간에속한문자의개수 {

    public static class Pair {
        int a;
        int b;
        int c;
        public Pair(int a,int b,int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] chr = new char[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                chr[i][j] = str.charAt(j-1);
            }

        }

        // ArrayList<Pair> pair =new ArrayList<>();

        // for(int i=0; i<(N+1)*(M+1); i++){
        //     pair.add(new Pair(0,0,0));
        // }
        // // for(int i=0; i<(N+1)*(M+1); i++){
        // //     System.out.println(pair.get(i).a+" "+pair.get(i).b+" "+pair.get(i).c);
        // // }

        // for(int i=1; i<=N; i++){
        //     for(int j=1; j<=M; j++){
        //         int k = i*M+j;
        //         int k-1 = (i-1)*M+j;
        //     }
        // }
        int[][] arr = new int[N+1][M+1];
        int[][] brr = new int[N+1][M+1];
        int[][] crr = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(chr[i][j]=='a'){
                    arr[i][j] = 1;
                }else if (chr[i][j]=='b'){
                    brr[i][j] =1;
                }else if(chr[i][j]=='c'){
                    crr[i][j] =1;
                }
            }
        }

        // for(int i=1; i<=N; i++){
        //     for(int j=1; j<=M; j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }



        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){

                arr[i][j] = (arr[i][j-1]+arr[i-1][j])-arr[i-1][j-1]+arr[i][j];

                brr[i][j] = (brr[i][j-1]+brr[i-1][j])-brr[i-1][j-1]+brr[i][j];

                crr[i][j] = (crr[i][j-1]+crr[i-1][j])-crr[i-1][j-1]+crr[i][j];
            }
        }


        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int a = arr[x2][y2] - (arr[x2][y1-1] +arr[x1-1][y2]) +arr[x1-1][y1-1];
            int b = brr[x2][y2] - (brr[x2][y1-1] +brr[x1-1][y2]) +brr[x1-1][y1-1];
            int c = crr[x2][y2] - (crr[x2][y1-1] +crr[x1-1][y2]) +crr[x1-1][y1-1];

            System.out.println(a+" "+b+" "+c);

        }


        // 여기에 코드를 작성해주세요.
    }
}
