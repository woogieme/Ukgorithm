package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ_4889_안정적인문자열 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int count=0;
            String tmp =br.readLine();
            if(tmp.contains("-")){
                break;
            }
            char[] chr = tmp.toCharArray();
            ArrayList<Character> arr = new ArrayList<>();
            for (int i = 0; i < chr.length; i++) {

                if(arr.size()!=0 && arr.get(arr.size()-1)=='{' && chr[i]=='}'){
                    arr.remove(arr.size()-1);
                    //System.out.println("????");
                }else{
                    arr.add(chr[i]);
                }

            }
            for (int i = 0; i < arr.size(); i++) {
                if(i<arr.size()/2 && arr.get(i)=='}'){
                    count++;
                }else if(i>=arr.size()/2 && arr.get(i)=='{'){
                    count++;
                }
            }
            System.out.println(count);

        }

    }

}
