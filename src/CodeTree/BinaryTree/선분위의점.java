package CodeTree.BinaryTree;

import java.util.*;
import java.io.*;

public class 선분위의점 {
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr =new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            int left=0;
            int right= N-1;
            int mid = (left+right)/2;

            int ans=N;

            while(true){

                if(left>right){
                    break;
                }
                mid = (left+right)/2;
                if(arr[mid]>Y){
                    right=mid-1;
                    ans=Math.min(mid,ans);
                }else{
                    left=mid+1;
                }
            }

            left=0;
            right= N-1;
            mid = (left+right)/2;

            int ansB=N;
            while(true){

                if(left>right){
                    break;
                }
                mid = (left+right)/2;
                if(arr[mid]>=X){
                    right=mid-1;
                    ansB=Math.min(mid,ansB);
                }else{
                    left=mid+1;
                }
            }
            if(ans==ansB){
                System.out.println(0);
            }else{
                System.out.println(ans-ansB);
            }

        }
        // 여기에 코드를 작성해주세요.
    }
}
