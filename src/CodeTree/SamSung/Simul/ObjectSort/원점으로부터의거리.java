package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;

public class 원점으로부터의거리 {
    static int N;
    static Person[] person;

    static public class Person implements Comparable<Person>{
        int centerX;
        int centerY;
        int number;

        public Person(int centerX, int centerY, int number){
            this.centerX=centerX;
            this.centerY=centerY;
            this.number=number;
        }

        @Override
        public int compareTo(Person person){

            if((Math.abs(this.centerX-0) +Math.abs(this.centerY-0)) == (Math.abs(person.centerX-0)+ Math.abs(person.centerY-0))){
                return this.number - person.number;
            }else if((Math.abs(this.centerX - 0) + Math.abs(this.centerY-0)) > (Math.abs(person.centerX-0)+ Math.abs(person.centerY-0)) ){
                return 1;
            }
            return -1;

        }

    }
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        person = new Person[N];
        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            person[i] = new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i+1);
        }
        Arrays.sort(person);

        int[] arr = new int[N+1];

        for(int i=0; i<N; i++){
            System.out.println(person[i].number);
        }

        for(int i=0; i<N; i++){
            arr[person[i].number] = i+1;
        }




        // for(int i=1; i<=N; i++){
        //     System.out.println(arr[i]);
        // }
    }
}
