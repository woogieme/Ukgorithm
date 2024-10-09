package CodeTree.Greedy;

import java.util.*;
        import java.io.*;
public class 막대자르기의최소비용 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeMap<Long,Long> hMap = new TreeMap<>();

        Long value=0L;
        long answer=0;
        for(int i=0; i<N; i++){
            long num = Integer.parseInt(st.nextToken());
            if(hMap.containsKey(num)){
                hMap.put(num,hMap.get(num)+1L);
            }else{
                hMap.put(num,1L);
            }
            value+=num;
        }

        while(true){

            Long num = hMap.lastKey();

            if(hMap.get(num)-1==0){
                hMap.remove(num);
            }else{
                hMap.put(num,hMap.get(num)-1);
            }


            value -=num;

            answer +=(value*num);

            if(hMap.size()==1 && value== hMap.lastKey() && hMap.get(value)==1 ){
                break;
            }




        }
        System.out.println(answer);

    }
}


//하나의 막대를 n개의 막대로 자르려고함
//길이가 x+y인 막대를  자를때 xy의 비용이 든다
//잘린 각 막대의 길이가 주어졌을때, 원래 막대의길이는 각막대의 길이의합이다.
//n =3
//각 막대의 길이 20, 10, 30
// 60
// 10 20 30
// 30 30 = 900
// 10 20 =>200
// 3 + 5 + 4  +2
// 8 + 4 + 2 + 14

//14
//  2 3 4 5
// 5 9 => 45
// 9 4 =>
// 9
// 2 3 4
// 4 5 => 20
// 2 3 => 6




//원래 막대를 잘잘라서 주어진 n개로 막대가 되도록 해야한다
//이때 필요한 최소비용을 계산하라.