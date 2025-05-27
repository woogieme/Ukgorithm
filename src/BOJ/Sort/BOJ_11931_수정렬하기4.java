package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11931_수정렬하기4 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
           arr[i]=(Integer.parseInt(br.readLine()));
        }

        merge(arr,0,N-1);
        for (int i = arr.length-1; i >=0 ; i--) {
            System.out.println(arr[i]);
        }
    }

    private static void merge(int[] arr,int left, int right) {

        if(left>= right){
            return;
        }

        int mid = (left+right)/2;

        merge(arr,left,mid);
        merge(arr,mid+1,right);

        mergetSort(arr,left,mid,right);



    }

    private static void mergetSort(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right-left +1];

        int idx =0 ;

        int low = left;
        int high = mid+1;

        while(low<=mid && high<=right){

            if(arr[low]<=arr[high]){
                tmp[idx] = arr[low];
                low++;
            }else {
                tmp[idx] = arr[high];
                high++;
            }
            idx++;
        }

        while (low <= mid) { //왼쪽 리스트에 값이 남아 있는 경우
            tmp[idx] = arr[low];
            idx++;
            low++;
        }

        while (high <= right) { //왼쪽 리스트에 값이 남아 있는 경우
            tmp[idx] = arr[high];
            idx++;
            high++;
        }

        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i - left];
        }



    }
}
