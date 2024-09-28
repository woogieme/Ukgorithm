package Programmers.Level2;

import java.util.*;

class 소수찾기 {
    static int[] arr;
    static int[] number;
    static boolean[] checked;
    static int answer =0;
    static HashSet<Integer> hSet;
    public int solution(String numbers) {
        int N = numbers.length();
        hSet = new HashSet<>();
        number = new int[numbers.length()];
        char[] tmp = numbers.toCharArray();
        for(int i=0; i<numbers.length(); i++){
            number[i] = tmp[i]-'0';
        }


        for(int i=1; i<=N; i++){
            checked = new boolean[numbers.length()];
            arr = new int[i];
            perm(0,i);
        }

        Iterator iter = hSet.iterator();
        while(iter.hasNext()){
            int result = (int)iter.next();
            if(result==1){
                continue;
            }
            int value =result/2;
            boolean isFlag=true;
            while(true){
                if(value==1){
                    break;
                }
                if(result%value==0){
                    isFlag=false;
                    break;
                }
                value--;
            }
            if(isFlag){
                answer++;
            }
        }

        return answer;
    }
    public void perm(int idx,int R){
        if(idx==R){
            String result="";
            for(int i=0; i<arr.length; i++){
                if(arr[0]==0){
                    continue;
                }
                result+=arr[i];
            }
            if(result.length()>=1){
                int prim = Integer.parseInt(result);
                hSet.add(prim);
            }
            return;
        }

        for(int i=0; i<number.length; i++){
            if(checked[i]) continue;

            arr[idx]=number[i];
            checked[i]=true;
            perm(idx+1,R);
            checked[i]=false;
        }
    }
}