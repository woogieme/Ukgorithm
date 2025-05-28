package BOJ.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

    static class People implements Comparable<People>{

        int number;
        int age;

        String name;

        People(int number, int age, String name){
            this.number=number;
            this.age = age;
            this.name =name;
        }




        @Override
        public int compareTo(People o) {
            if(this.age == o.age){
                return this.number -  o.number;
            }
            return this.age - o.age;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<People> people = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            people.add(new People(i,age,name));
        }
        Collections.sort(people);

        StringBuilder sb = new StringBuilder();
        for(People p: people){
            sb.append(p.age).append(" ").append(p.name).append("\n");
        }
        System.out.println(sb);


    }
}
