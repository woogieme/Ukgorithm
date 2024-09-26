package Programmers.Level2;

import java.util.*;
class 쿼드압축개수세기 {

    static int count;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] map;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        map = new int[arr.length][arr.length];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                map[i][j] = arr[i][j];
            }
        }

        func(0,0,arr.length);

        for(int i=0; i<ans.size(); i++){
            if(ans.get(i)==0){
                answer[0]++;
            }
            else if(ans.get(i)==1){
                answer[1]++;
            }
        }
        return answer;
    }

    private static void func(int x, int y, int size) {
        if(isPossible(x,y,size) ) {
            ans.add(map[x][y]);
            return;
        }


        int newSize = size/ 2;

        func(x,y,newSize);
        func(x,y+newSize,newSize);
        func(x+newSize,y,newSize);
        func(x+newSize,y+newSize,newSize);

    }

    public static boolean isPossible(int x, int y, int size) {
        int value = map[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(value != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }



}
