package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4949_균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while(true){


            char[] str = sc.readLine().toCharArray();

            if(str[0] == '.'){
                break;
            }
            ArrayList<String> q = new ArrayList<>();
            boolean flag = false;
            for (char c : str) {
                if (c == '(' || c == '[') {
                    q.add(String.valueOf(c));
                } else if (c == ')' || c == ']') {
                    if (q.isEmpty()) {
                        flag = true;
                        break;
                    }
                    if ((q.get(q.size() - 1).equals("(") && c == ')') || (q.get(q.size() - 1).equals("[") && c == ']')) {
                        q.remove(q.size() - 1);
                    } else {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag || !q.isEmpty()){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }

        }
    }
}
