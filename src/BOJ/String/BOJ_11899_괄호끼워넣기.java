package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.BatchUpdateException;
import java.util.ArrayList;

public class BOJ_11899_괄호끼워넣기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chr = br.readLine().toCharArray();

        ArrayList<Character> arr = new ArrayList<>();

        int result=0;
        for(int i=0; i<chr.length; i++){

            if(chr[i]=='('){
                arr.add(chr[i]);

            }else{
                if(arr.size()==0){
                    result++;
                }else{
                    arr.remove(arr.size()-1);
                }
            }

        }
        System.out.println(result+arr.size());
    }
}
