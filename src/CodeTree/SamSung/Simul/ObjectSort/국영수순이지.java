package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;

public class 국영수순이지 {
    static int N;
    static Person[] arr;

    static class Person implements Comparable<Person>{
        String name;
        int height;
        int weight;
        int moveon;
        public Person(String name, int height, int weight,int moveon){
            this.name = name;
            this.height =height;
            this.weight =weight;
            this.moveon = moveon;
        }

        @Override
        public int compareTo(Person person){
            if(this.height == person.height){
                if(this.weight == person.weight){
                    if(this.moveon < person.moveon){
                        return 1;
                    }
                    return -1;
                }else if(this.weight < person.weight){
                    return 1;
                }
                return -1;
            }else if(this.height< person.height){
                return 1;
            }
            return -1;


        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr =new Person[N];
        for(int i=0; i<N; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());

            arr[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i].name+" "+arr[i].height+" "+arr[i].weight+" "+arr[i].moveon);
        }
        // 여기에 코드를 작성해주세요.
    }
}