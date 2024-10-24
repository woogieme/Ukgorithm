package Softeer.Level2;

import java.util.*;
import java.io.*;
public class YeahButNow {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        String one ="1+1";
        String two = "1";

        ArrayList<String> str = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            str.add(String.valueOf(arr[i]));
        }

        ArrayList<String> answer = new ArrayList<>();
        int count=0;
        for(int i=0; i<str.size()-1; i++){
            String first = str.get(i);
            if(first.equals("(")){
                if(i!=0 && answer.get(answer.size()-1).equals(")")){
                    answer.add("+");
                    answer.add(first);
                }else{
                    count++;
                    answer.add(first);
                }
            }else if(first.equals(")")){
                if(answer.get(answer.size()-1).equals("(")){
                    if(count==1){
                        answer.add("1");

                    }else{
                        answer.add(one);
                        count=0;
                    }
                    answer.add(first);
                }else{
                    answer.add(first);
                }

            }


        }
        if(str.get(str.size()-1).equals(")") && answer.get(answer.size()-1).equals("(")){
            answer.add(one);
            answer.add(")");
        }else{
            answer.add("+1");
            answer.add(")");
        }
        for(int i=0; i<answer.size(); i++){
            System.out.print(answer.get(i));
        }



    }
}
