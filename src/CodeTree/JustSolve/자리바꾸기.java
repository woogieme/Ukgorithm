package CodeTree.JustSolve;

import java.util.*;
import java.io.*;


public class 자리바꾸기 {

    static public class Change{

        int front;
        int back;

        Change(int front,int back){
            this.front=front;
            this.back=back;
        }

    }

    static public class Number{
        int first;
        int second;

        Number(int first, int second){
            this.first=first;
            this.second=second;
        }

        @Override
        public boolean equals(Object o){
            if( o instanceof Object){
                Number tmp =(Number)o;
                return first==tmp.first && second==tmp.second;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        public String toString(){
            return first +":" +second+"\n";
        }
        public int getIndex() {
            return first;
        }

    }


    public static void main(String[] args) throws IOException{


        HashSet<Number> set = new HashSet();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr =new int[N+1];
        Change[] ch = new Change[M];

        for(int i=1; i<=N; i++){
            arr[i] = i;
            set.add(new Number(i,i));
        }

        for(int i=0; i<M; i++){
            st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ch[i] = new Change(x,y);
        }

        int count =0;

        int row= 0;
        while(true){
            if(count==M*3){
                break;
            }

            int x = ch[row].front;
            int y = ch[row].back;

            int tmp = arr[x];
            arr[x]=arr[y];
            arr[y]=tmp;

            set.add(new Number(arr[x],x));
            set.add(new Number(arr[y],y));

            row++;
            count++;
            if(row%M==0){
                row=0;
            }

        }
        StringBuilder sb =new StringBuilder();

        int[] arr2 =new int[N+1];
        for(Number value: set){
            arr2[value.getIndex()]+=1;
        }
        for(int i=1; i<=N; i++){
            System.out.println(arr2[i]);
        }
    }
}