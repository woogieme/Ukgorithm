package CodeTree.PQ;

import java.util.*;
import java.io.*;
public class 중앙값 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for(int tcp=0; tcp<TC; tcp++){
            int N = Integer.parseInt(br.readLine());
            int [] arr =new int[N];
            PriorityQueue<Integer> pqB = new PriorityQueue<>();

            PriorityQueue<Integer> pqA = new PriorityQueue<Integer>(Collections.reverseOrder());


            StringTokenizer st = new StringTokenizer(br.readLine());



            for(int i=0; i<N; i++){
                int num = Integer.parseInt(st.nextToken());
                pqB.add(num);
                if(i==0){
                    System.out.print(num+" ");
                }
                else{
                    if((pqB.size()>0 && pqA.size()>0) && pqB.peek()<pqA.peek()){
                        int pB = pqB.poll();
                        int pA = pqA.poll();
                        pqB.add(pA);
                        pqA.add(pB);
                    }else if((pqB.size()>0 && pqA.size()>0) && pqA.peek()>pqB.peek()){
                        int pB = pqB.poll();
                        int pA = pqA.poll();
                        pqB.add(pA);
                        pqA.add(pB);
                    }

                    if(pqB.size()-pqA.size()>1){
                        pqA.add(pqB.poll());
                    }else if(pqA.size()-pqB.size()>1){
                        pqB.add(pqA.poll());
                    }

                    if(i%2==0){
                        if(pqA.size()>pqB.size()){
                            System.out.print(pqA.peek()+" ");
                        }else{
                            System.out.print(pqB.peek()+" ");
                        }
                    }
                }

            }
            System.out.println();


        }


    }
}
