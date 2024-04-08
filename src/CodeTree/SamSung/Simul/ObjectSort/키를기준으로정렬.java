package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;

public class 키를기준으로정렬 {
    static int N;
    static Person[] arr;

    static class Person implements Comparable<Person>{
        String name;
        int height;
        int weight;
        public Person(String name, int height, int weight){
            this.name = name;
            this.height =height;
            this.weight =weight;
        }

        @Override
        public int compareTo(Person person){
            if(this.height > person.height){
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

            arr[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);
        for(int i=0; i<N; i++){
            System.out.println(arr[i].name+" "+arr[i].height+" "+arr[i].weight);
        }
        // 여기에 코드를 작성해주세요.
    }
}