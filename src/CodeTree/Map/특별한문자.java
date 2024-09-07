package CodeTree.Map;
import java.util.*;
import java.io.*;

public class 특별한문자 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();

        HashMap<String,Integer> hMap = new HashMap<>();

        for(int i=0; i<str.length; i++){
            String tmp =String.valueOf(str[i]);
            if(hMap.containsKey(tmp)){
                hMap.put(tmp,hMap.get(tmp)+1);
            }else{
                hMap.put(tmp,1);
            }
        }
        String value="None";
        for(int i=0; i<str.length; i++){
            String tmp =String.valueOf(str[i]);
            if(hMap.containsKey(tmp)){
                if(hMap.get(tmp)==1){
                    value=tmp;
                    break;
                }
            }
        }

        System.out.println(value);



        // 여기에 코드를 작성해주세요.
    }
}