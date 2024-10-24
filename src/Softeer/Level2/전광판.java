package Softeer.Level2;

import java.util.*;
import java.io.*;
public class 전광판 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] checked = {
                {true, true, true, false, true, true, true},// 0
                {false, false, true, false, false, true, false},  // 1
                {true, false, true, true, true, false, true},     // 2
                {true, false, true, true, false, true, true},     // 3
                {false, true, true, true, false, true, false},    // 4
                {true, true, false, true, false, true, true},     // 5
                {true, true, false, true, true, true, true},      // 6
                {true, true, true, false, false, true, false},   // 7
                {true, true, true, true, true, true, true},       // 8
                {true, true, true, true, false, true, true}       // 9
        };
        int[] count = {6,2,5,5,4,5,6,4,7,6};
        for(int i=0; i<N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer=0;
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            while(true){
                int oneTmp=-1;
                int twoTmp=-1;
                if(one>0){
                    oneTmp=one%10;
                    one/=10;
                }
                if(two>0){
                    twoTmp=two%10;
                    two/=10;
                }

                if(oneTmp==-1 && twoTmp==-1){
                    break;
                }

                if(oneTmp==-1){
                    answer+=count[twoTmp];
                    continue;
                }
                else if(twoTmp==-1){
                    answer+=count[oneTmp];
                    continue;
                }

                //one과 two 가 살아남을때 one은 two가 되어야함
                //one => two
                // 같이 true거나 false일때만 continue

                int one_cnt= oneTmp;
                int two_cnt= twoTmp;
                for(int d=0; d<7; d++){
                    if(checked[one_cnt][d]!=checked[two_cnt][d]){
                        answer++;
                    }
                }
            }

            System.out.println(answer);


        }



    }
}

//4 3 3 3 3



