package CodeTree.PQ;

import java.util.*;
import java.io.*;
public class 최솟값3개 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st =new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
            if(i<2){
                System.out.println(-1);
            }else{
                int X =pq.poll();
                int Y =pq.poll();
                int Z =pq.poll();
                System.out.println((long)X*Y*Z);
                pq.add(X);
                pq.add(Z);
                pq.add(Y);
            }

        }

        // 여기에 코드를 작성해주세요.
    }
}
