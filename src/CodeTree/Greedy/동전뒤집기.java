package CodeTree.Greedy;
import java.util.*;
import java.io.*;
public class 동전뒤집기 {
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer=0;

        int idx = N-1;
        int jdx = M-1;
        boolean zero =false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(arr[i][j]==1){
                    zero=true;
                }
            }
        }
        if(!zero){
            System.out.println(0);
            return;
        }

        if(N!=1){
            while(true){
                idx -=1;
                if(idx==-1){
                    jdx-=1;
                    idx=N-2;
                }
                if(jdx==-1){
                    break;
                }

                boolean isFlag=true;

                if(arr[N-1][jdx] == arr[idx][jdx]){
                    continue;
                }

                for(int i=0; i<=idx; i++){
                    for(int j=0; j<=jdx; j++){
                        if(arr[i][j]==1){
                            arr[i][j]=0;
                        }else{
                            arr[i][j]=1;
                        }
                    }
                }
                answer++;


            }
        }

        N = 0;

        while(true){

            int value=-1;
            int nextj=-1;
            for(int j=1; j<M; j++){
                if(arr[N][j]!= arr[N][j-1]){
                    value=arr[N][j];
                    nextj=j-1;
                    break;
                }
            }

            if(nextj!=-1){
                for(int j=0; j<=nextj; j++){
                    arr[N][j]=value;
                }
            }
            boolean isFlag=true;
            for(int j=1; j<M; j++){
                if(arr[N][j]!= arr[N][j-1]){
                    isFlag=false;
                    break;
                }
            }
            answer++;
            if(isFlag){

                if(arr[N][0]==0){
                    break;
                }
                answer++;
                break;
            }

        }

        System.out.println(answer);
    }
}
//앞면 0
//뒷면 1

// 1 0
// 0 1

// 0 0
// 0 1

// 1 1
// 1 1

// 0 0
// 0 0


// 0 1
// 1 0

// 1 1
// 1 0

// 0 0
// 0 0

//0 1
//1 0

// 1 1
// 1 0

// 0 0
// 0 0

//가설1. 모두 1을 만든다음에 뒤집기
//0 이 더 많을때
// 0 1 0 0 0 0 1 1 1 0 0 1
// 1 1 0 0 0 0 1 1 1 0 0 1 1
// 0 0 1 1 1 1 1 1 1 0 0 1 2
// 1 1 1 1 1 1 1 1 1 0 0 1 3
// 0 0 0 0 0 0 0 0 0 0 0 1 4
// 1 1 1 1 1 1 1 1 1 1 1 1 5
// 0 0 0 0 0 0 0 0 0 0 0 0 6


// 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
// 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1

/// 1 1 1 0 0 0 1