package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;
public class 개인정보 {
    static int N;
    static Person[] arr;

    static class Person implements Comparable<Person>{
        String name;
        int weight;
        double number;
        boolean isFlag;

        public Person(String name,int weight, double number,boolean isFlag){
            this.name = name;
            this.weight = weight;
            this.number = number;
            this.isFlag = isFlag;
        }

        @Override
        public int compareTo(Person person){
            if(!isFlag){
                return this.name.compareToIgnoreCase(person.name);
            }
            return person.weight- this.weight;

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 5;
        arr =new Person[N];
        boolean isFlag=false;
        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            arr[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Double.parseDouble(st.nextToken()),isFlag);
        }

        Arrays.sort(arr);
        System.out.println("name");
        for(int i=0; i<N; i++){
            System.out.println(arr[i].name+" "+arr[i].weight+" "+arr[i].number);
            arr[i].isFlag=true;
        }
        Arrays.sort(arr);
        System.out.println();
        System.out.println("height");
        for(int i=0; i<N; i++){
            System.out.println(arr[i].name+" "+arr[i].weight+" "+arr[i].number);

        }

        // 여기에 코드를 작성해주세요.
    }
}