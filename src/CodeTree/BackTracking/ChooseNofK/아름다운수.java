package CodeTree.BackTracking.ChooseNofK;

import java.util.*;
import java.io.*;

public class 아름다운수 {
    static int N;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static int result;

    static boolean judge(int i, int count){
        if(count%i==0){
            return true;
        }
        return false;

    }

    static void perm(int cnt){

        if(cnt==N){

            boolean isFlag=true;
            int i=0;
            while(true){
                if(i>=arr.length){
                    break;
                }
                int count=0;
                if(arr[i]==1){
                    i+=1;
                    continue;
                }
                for(int j=i; j<arr.length; j++){
                    if(arr[i]!=arr[j]){
                        break;
                    }
                    count++;
                }
                if(!judge(arr[i],count)){
                    isFlag=false;
                    break;
                }
                i+=count;
            }
            if(isFlag){
                result++;
            }
            return;
        }

        for(int i=1; i<=4; i++){
            arr[cnt] =i;
            perm(cnt+1);
        }
    }

    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();

        arr = new int[N];

        result =0;

        perm(0);

        System.out.println(result);

    }
}