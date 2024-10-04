package Programmers.Level2;

import java.util.*;
class 테이블해시함수 {
    public int solution(int[][] data, int col1, int row_begin2, int row_end2) {
        int answer = 0;
        int col = col1-1;
        int row_begin = row_begin2-1;
        int row_end = row_end2-1;


        Arrays.sort (data, (row1,row2)->{
            int comparison = Integer.compare(row1[col], row2[col]);
            if(comparison==0){
                return Integer.compare(row2[0],row1[0]);
            }
            return comparison;
        });

        int a=0;
        int b=0;
        ArrayList<Integer> arr =new ArrayList<>();
        for(int i=row_begin; i<=row_end; i++){
            answer=0;
            for(int j=0; j<data[i].length; j++){
                answer+= data[i][j]%(i+1);
            }
            arr.add(answer);
        }
        int cnt=0;
        if(arr.size()==1){
            return arr.get(0);
        }

        while(true){
            if(arr.size()==1){
                break;
            }
            int tmp = arr.get(0)^arr.get(1);
            arr.remove(0);
            arr.remove(0);
            arr.add(0,tmp);
        }



        return arr.get(0);
    }
}
