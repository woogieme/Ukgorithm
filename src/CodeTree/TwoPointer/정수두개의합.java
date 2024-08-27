package CodeTree.TwoPointer;

import java.util.*;
import java.io.*;

public class 정수두개의합 {
    static int N;
    static int[] merget_arr;
    static int[] arr ;

    public static void merge_sort(int[] arr, int low,int high){
        if(low<high){
            int mid = (low+high)/2;
            merge_sort(arr,low,mid);
            merge_sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }

    }

    public static int[] merge(int arr[], int low, int mid, int high){

        int i = low;
        int j =mid+1;
        int k=low;
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){

                merget_arr[k] =arr[i];
                i++;
                k++;
            }else{
                merget_arr[k]=arr[j];
                j++;
                k++;
            }
        }
        while(i<=mid){
            merget_arr[k]=arr[i];
            k++;
            i++;
        }

        while(j<=high){
            merget_arr[k]=arr[j];
            k++;
            j++;
        }

        for(int idx=low; idx<=high; idx++){
            arr[idx]=merget_arr[idx];
        }

        return arr;

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 여기에 코드를 작성해주세요.
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        merget_arr= new int[N+1];



        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // for(int idx=0; idx<=N; idx++){
        //     System.out.print(arr[idx]+" ");
        // }

        // System.out.println();

        merge_sort(arr,1,N);

        // for(int idx=0; idx<=N; idx++){
        //     System.out.print(arr[idx]+" ");
        // }
        // System.out.println();
        int j=N;
        long result=0;
        for(int i=1; i<=N; i++){

            while(j-1>=0 && arr[i]+arr[j]>K){
                j--;
            }
            if(j<=i){
                break;
            }

            result+=j-i;
            //System.out.println(j+" "+i);

        }
        System.out.println(result);

    }
}