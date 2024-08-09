package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525_IOIOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =Integer.parseInt(br.readLine());

        int len = Integer.parseInt(br.readLine());

        char [] arr =br.readLine().toCharArray();


        int iStart= 0;
        int jStart= 3*N-(N-1);

        StringBuilder value= new StringBuilder();

        StringBuilder compare= new StringBuilder();

        if(3*N-(N-1)>len){
            //System.out.println(0);
            return;
        }

        for (int i = 0; i < 3*N-(N-1); i++) {
            if(i%2==0){
                compare.append("I");
            }else{
                compare.append("O");
            }
        }

        for (int i = 0; i <3*N-(N-1) ; i++) {
            value.append(arr[i]);
        }

        int count =0;

        while(true){
            //System.out.println(value+" "+compare);
            if(value.toString().equals(compare.toString())){
                count++;
            }

            if(jStart==len){
                break;
            }
            value.deleteCharAt(0);
            value.append(arr[jStart]);
            jStart+=1;



        }
        System.out.println(count);


    }
}
