package CodeTree.PQ;
import java.util.*;
import java.io.*;

public class 앞에서부터삭제하기2 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int sumVal=0;
        double maxAvg=0;
        pq.add(arr[N - 1]);
        sumVal += arr[N - 1];


        for(int i=N-2; i>=1; i--){
            pq.add(arr[i]);
            sumVal+=arr[i];

            double avg =   (double)( sumVal-pq.peek())/(N-i-1);

            if(maxAvg<avg){
                maxAvg=avg;
            }

        }

        System.out.printf("%.2f",maxAvg);



    }
}
