package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;

public class 정렬숫자위치알아내기 {
    static int N;
    static Person[] person;

    static public class Person implements Comparable<Person>{
        int number;
        int rank;

        public Person(int number,int rank){
            this.number= number;
            this.rank=rank;
        }

        @Override
        public int compareTo(Person person){
            if(this.number == person.number){
                return this.rank - person.rank;
            }
            return this.number - person.number;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N+1];
        StringTokenizer st =new StringTokenizer(br.readLine());

        person = new Person[N];
        for(int i=0; i<N; i++){
            person[i] = new Person(Integer.parseInt(st.nextToken()),i+1);
        }

        Arrays.sort(person);

        // for(int i=0; i<N; i++){
        //     System.out.print(person[i].rank+" ");
        // }

        for(int i=0; i<N; i++){
            arr[person[i].rank]=i+1;
        }

        for(int i=1; i<=N; i++){
            System.out.print(arr[i]+" ");
        }


        // 여기에 코드를 작성해주세요.
    }
}