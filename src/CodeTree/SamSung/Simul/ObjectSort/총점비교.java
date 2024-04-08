package CodeTree.SamSung.Simul.ObjectSort;

import java.util.*;
import java.io.*;
public class 총점비교 {
    static int N;

    static class Person implements Comparable<Person>{
        String name;
        int subject1;
        int subject2;
        int subject3;

        public Person(String name, int subject1,int subject2,int subject3){
            this.name=name;
            this.subject1=subject1;
            this.subject2=subject2;
            this.subject3=subject3;
        }

        @Override
        public int compareTo(Person person){
            if(this.subject1+this.subject2+this.subject3 > person.subject1+person.subject2+person.subject3){
                return 1;
            }
            return -1;
        }

    }
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];
        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            arr[i] = new Person(st.nextToken(),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        }
        Arrays.sort(arr);

        for(int i=0; i<N; i++){
            System.out.println(arr[i].name+" "+arr[i].subject1+" "+arr[i].subject2+" "+arr[i].subject3);
        }
        // 여기에 코드를 작성해주세요.
    }
}