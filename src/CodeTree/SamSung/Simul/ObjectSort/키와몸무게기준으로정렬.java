package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;
public class 키와몸무게기준으로정렬 {
    static int N;
    static Person[] arr;

    static class Person implements Comparable<Person>{
        String name;
        int weight;
        int number;


        public Person(String name,int weight, int number){
            this.name = name;
            this.weight = weight;
            this.number = number;

        }

        @Override
        public int compareTo(Person person){
            if(this.weight < person.weight){
                return -1;
            }else if(this.weight==person.weight){
                if(this.number< person.number){
                    return 1;
                }
                return -1;
            }
            return 1;

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr =new Person[N];
        boolean isFlag=false;
        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            arr[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i].name+" "+arr[i].weight+" "+arr[i].number);

        }

        // 여기에 코드를 작성해주세요.
    }
}