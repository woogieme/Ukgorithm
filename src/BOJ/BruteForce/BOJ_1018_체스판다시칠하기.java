package BOJ.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] chr = new char[N][M];

        for(int i=0; i<N; i++){
            chr[i] =br.readLine().toCharArray();
        }
        int Aidx=0;
        int Bidx=0;
        int tmpA=Integer.MAX_VALUE;
        int tmpB=Integer.MAX_VALUE;

        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                //System.out.println(i+" "+(N-(N-8)+i)+" "+j+" "+(M-(M-8)+j));
                int countA=0;
                for(int a=i; a<N-(N-8)+i; a++){
                    int countB=0;
                    for(int b=j; b<M-(M-8)+j; b++){

                        //0,2,4,6 줄인가?
                        if(countA%2==0){
                            if(countB%2==0){
                                if(chr[a][b]!='B'){
                                    Aidx++;
                                }

                            }else{
                                if(chr[a][b]!='W'){
                                    Aidx++;
                                }
                            }
                        }else{
                            //1,3,5,7줄인가?
                            if(countB%2==0){
                                if(chr[a][b]!='W'){
                                    Aidx++;
                                }
                            }else{
                                if(chr[a][b]!='B'){
                                    Aidx++;
                                }
                            }
                        }
                        countB++;
                    }
                    countA++;
                }
                tmpA= Math.min(tmpA,Aidx);
                Aidx=0;
            }
        }
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){
                int countA=0;
                for(int a=i; a<N-(N-8)+i; a++){
                    int countB=0;
                    for(int b=j; b<M-(M-8)+j; b++){
                        //0,2,4,6 줄인가?
                        if(countA%2==0){
                            if(countB%2==0){
                                if(chr[a][b]!='W'){
                                    Bidx++;
                                }

                            }else{
                                if(chr[a][b]!='B'){
                                    Bidx++;
                                }
                            }
                        }else{
                            if(countB%2==0){
                                if(chr[a][b]!='B'){
                                    Bidx++;
                                }
                            }else{
                                if(chr[a][b]!='W'){
                                    Bidx++;
                                }
                            }
                        }
                        countB++;
                    }
                    countA++;
                }
                tmpB= Math.min(tmpB,Bidx);
                Bidx=0;

            }
        }

        int result =Math.min(tmpA,tmpB);
        System.out.println(result);

    }
}
