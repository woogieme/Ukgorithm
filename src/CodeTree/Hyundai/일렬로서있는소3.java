package CodeTree.Hyundai;

import java.util.*;
import java.io.*;
public class 일렬로서있는소3 {

    static int N;
    static boolean[] checked;
    static int[] arr;
    static int[] card;
    static int answer;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        N = Integer.parseInt(br.readLine());

        arr =new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        card= new int[3];
        answer=0;
        comb(0,0);
        System.out.println(answer);

    }
    static public void comb(int idx,int cnt){
        if(cnt==3){
            for(int i=0; i<card.length-1; i++){
                if(card[i]>card[i+1]){
                    return;
                }
            }
            answer++;
            return;
        }
        if(idx==N){
            return;
        }

        card[cnt]=arr[idx];
        comb(idx+1,cnt+1);
        comb(idx+1,cnt);
    }
}