package CodeTree.TwoPointer;

import java.util.*;
import java.io.*;

public class 서로다른K개의문자 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        char[] chr = new char[str.length()+1];

        for(int i=1; i<=chr.length-1; i++){
            chr[i] = str.charAt(i-1);
        }

        int K = Integer.parseInt(st.nextToken());

        HashMap<Character,Integer> hMap = new HashMap<>();

        int result = Integer.MIN_VALUE;

        int j=0;
        for(int i=1; i<chr.length; i++){

            //서로 다른 k개의 개수 이내인가?
            while(j+1<chr.length && hMap.size()<=K){
                if(!hMap.containsKey(chr[j+1]) && hMap.size()+1>K){
                    break;
                }
                //포함안됐어
                if(!hMap.containsKey(chr[j+1])){

                    hMap.put(chr[j+1],1);

                }
                else if(hMap.containsKey(chr[j+1])){
                    hMap.put(chr[j+1],hMap.get(chr[j+1])+1);
                }
                //포함됐어

                j++;


            }

            result = Math.max(result,j-i+1);
            //System.out.println(chr[i]+" "+hMap.get(chr[i]));
            if(hMap.get(chr[i])-1==0){
                hMap.remove(chr[i]);
            }else{
                hMap.put(chr[i],hMap.get(chr[i])-1);
            }

        }


        System.out.println(result);





        // 여기에 코드를 작성해주세요.
    }
}