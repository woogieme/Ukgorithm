package CodeTree.Simul.Bomb;

import java.util.*;
import java.io.*;

public class 일차원폭발게임 {
    static int N;
    static int M;
    static int[] arr;
    static int[] temp;
    static int bomb;

    static void print(){
        for(int i=0; i <N; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bomb=0;
        arr = new int[N];
        temp = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        boolean findBomb=false;
        int iStart=0;
        int bombOfRange=N;


        while(true){
            boolean checkbomb=false;
            int bombOfTempRange=0;

            while(true){
                int count=1;

                if(iStart>=bombOfRange){
                    break;
                }

                for(int i=iStart; i<bombOfRange-1; i++){
                    if(arr[i]==arr[i+1] ){

                        count++;
                    }
                    else{
                        break;
                    }
                }

                if(count>=M){
                    findBomb=true;
                }else{
                    findBomb=false;
                }
                if(findBomb){

                    for(int i=iStart; i<=iStart+(count-1); i++){
                        arr[i]=0;
                    }
                    //print();
                    checkbomb=true;

                }
                iStart+=count;

            }

            for(int i=0; i<bombOfRange; i++){
                if(arr[i]!=0){
                    temp[bombOfTempRange] = arr[i];
                    bombOfTempRange++;
                }
            }

            for(int i=0; i<bombOfTempRange; i++){
                arr[i]=temp[i];
            }

            bombOfRange=bombOfTempRange;
            iStart=0;
            if(!checkbomb){
                break;
            }
        }

        for(int i=0; i<bombOfRange; i++){
            if(arr[i]>0){
                bomb++;
            }
        }
        System.out.println(bomb);

        for(int i=0; i<bombOfRange; i++){
            if(arr[i]>0){
                System.out.println(arr[i]);
            }
        }




    }
}