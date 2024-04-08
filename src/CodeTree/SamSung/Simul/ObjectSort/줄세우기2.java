package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;
public class 줄세우기2 {
    static int N;
    static Person[] person;
    static public class Person implements Comparable<Person>{
        int height;
        int weight;
        int rank;
        public Person(int height,int weight,int rank){
            this.height = height;
            this.weight = weight;
            this.rank = rank;

        }

        @Override
        public int compareTo(Person person){
            if(this.height == person.height){
                return person.weight - this.weight;
            }
            return this.height - person.height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        person =new Person[N];


        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            person[i] =new Person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i+1);
        }
        Arrays.sort(person);
        for(int i=0; i<N; i++){
            System.out.println(person[i].height+" "+person[i].weight+" "+person[i].rank);

        }
    }
}