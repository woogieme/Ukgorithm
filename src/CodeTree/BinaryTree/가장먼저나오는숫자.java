package CodeTree.BinaryTree;

import java.util.*;
import java.io.*;
public class 가장먼저나오는숫자 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());

            int mid=N/2;
            int left=0;
            int right=N-1;
            int ans=N;
            while(true){
                if(left>right){
                    break;
                }
                mid = (left+right)/2;
                if(arr[mid]>=target){
                    right=mid-1;
                    ans = Math.min(ans,mid);
                }
                else{
                    left=mid+1;
                }
            }

            mid=N/2;
            left=0;
            right=N-1;
            int ansB=N;

            while(true){
                if(left>right){
                    break;
                }
                mid = (left+right)/2;
                if(arr[mid]>target){
                    right=mid-1;
                    ansB = Math.min(ansB,mid);
                }
                else{
                    left=mid+1;
                }
            }
            if(ans==ansB){
                System.out.println(-1);
            }else{
                System.out.println(ans+1);
            }
        }
    }
}