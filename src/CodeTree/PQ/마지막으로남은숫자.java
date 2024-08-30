package CodeTree.PQ;

import java.io.*;
import java.util.*;

public class 마지막으로남은숫자 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            pq.add(-Integer.parseInt(st.nextToken()));
        }
        while(true){
            if(pq.size()<=1){
                break;
            }
            int front = -pq.poll();
            int rear = -pq.poll();

            int value = -(Math.abs(front)-Math.abs(rear));
            if(value!=0){
                pq.add(value);
            }
        }

        if(pq.size()==1){
            System.out.println(-pq.poll());
        }else if(pq.size()==0){
            System.out.println(-1);
        }

        // 여기에 코드를 작성해주세요.
    }
}