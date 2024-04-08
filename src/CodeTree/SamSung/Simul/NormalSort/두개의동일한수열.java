package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 두개의동일한수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        int[] arr = new int[N];
        int[] brr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            brr[i]= Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        boolean isFlag=false;
        for(int i=0; i<N; i++){
            if(arr[i]!=brr[i]){
                isFlag=true;
                break;
            }
        }
        if(isFlag){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }


    }
}