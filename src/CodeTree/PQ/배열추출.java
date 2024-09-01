package CodeTree.PQ;
import java.io.*;
import java.util.*;

public class 배열추출 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = -Integer.parseInt(br.readLine());
            if(num==0){
                if(pq.size()==0){
                    System.out.println(0);
                }else{
                    System.out.println(-pq.poll());
                }
            }else{
                pq.add(num);
            }
        }

        // 여기에 코드를 작성해주세요.
    }
}