import java.util.*;
import java.io.*;

public class 특정조건에맞게k개중에1개를n번뽑기 {
    static int N;
    static int K;
    static int[] arr;
    static int[] target;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        K =Integer.parseInt(st.nextToken());
        N =Integer.parseInt(st.nextToken());

        arr =new int[N];
        target= new int[K];
        for(int i=0; i<K; i++){
            target[i]=i+1;
        }
        perm(0);


        // 여기에 코드를 작성해주세요.
    }
    static void perm(int idx){
        if(idx==arr.length){
            int count=0;
            boolean isFlag=false;
            for(int i=0; i<arr.length-1; i++){
                if(arr[i]==arr[i+1]){
                    count++;
                }else if(arr[i]!=arr[i+1]){
                    count=0;
                }

                if(count==2){
                    isFlag=true;
                    break;
                }
            }
            if(!isFlag){
                for(int i=0; i<arr.length; i++){
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }

            return;
        }

        for(int i=0; i<K; i++){
            arr[idx]=target[i];
            perm(idx+1);
        }
    }


}