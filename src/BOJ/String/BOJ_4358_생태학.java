package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4358_생태학 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Double> arr = new TreeMap<>();
        String input="";
        int count=0;
        while((input = br.readLine()) != null) {

            if(arr.containsKey(input)){
                arr.put(input,arr.get(input)+1);
            }else{
                arr.put(input,1d);
            }
            count++;
        }

        List<String> keySet = new ArrayList<>(arr.keySet());

        for (String key : keySet) {
            String format = String.format("%.4f",arr.get(key)/count*100);
            System.out.println(key+" "+format);
        }
    }
}
