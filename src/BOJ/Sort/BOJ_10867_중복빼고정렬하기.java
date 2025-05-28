package BOJ.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10867_중복빼고정렬하기 {

    public static void main(String[] args) throws IOException {
        //long startTime = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> hSet = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hSet.add(Integer.parseInt(st.nextToken()));
        }

        int[] arr = new int[hSet.size()];
        int count=0;

        Iterator<Integer> it = hSet.iterator();
        while (it.hasNext()) {

                arr[count] = it.next();
            count++;
        }



    merge(arr,0,hSet.size()-1);
    StringBuilder sb = new StringBuilder();


        for (int i = 0; i <arr.length ; i++) {
        sb.append(arr[i]);
        sb.append("\n");
    }
        System.out.println(sb);
    //long endTime = System.currentTimeMillis();  // 종료 시간 기록
    //System.out.println("파일 생성 및 작성 시간(ms): " + (endTime - startTime));
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

