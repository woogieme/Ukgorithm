package CodeTree.Simul.PushPull;
import java.io.*;
import java.util.*;

public class 삼각형큰베이어벨트 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] conA= new int [N];
        int[] conB= new int [N];
        int[] conC= new int [N];


        st = new StringTokenizer(br.readLine());

        for(int i =0 ; i <N; i++){
            conA[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i =0 ; i <N; i++){
            conB[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i =0 ; i <N; i++){
            conC[i]= Integer.parseInt(st.nextToken());
        }

        while(true){

            if(T==0){
                break;
            }

            int tmp = conC[N-1];

            for(int i=N-1; i>0; i--){
                conC[i]=conC[i-1];
            }
            conC[0]=conB[N-1];

            for(int i=N-1; i>0; i--){
                conB[i]=conB[i-1];
            }
            conB[0]=conA[N-1];

            for(int i=N-1; i>0; i--){
                conA[i]=conA[i-1];
            }
            conA[0]=tmp;
            T--;
        }

        for(int i=0; i<N; i++){
            System.out.print(conA[i]+" ");
        }
        System.out.println();

        for(int i=0; i<N; i++){
            System.out.print(conB[i]+" ");
        }
        System.out.println();

        for(int i=0; i<N; i++){
            System.out.print(conC[i]+" ");
        }
        System.out.println();
    }
}
