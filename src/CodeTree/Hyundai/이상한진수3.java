package CodeTree.Hyundai;

import java.io.*;
public class 이상한진수3 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //StringTokenizer st = new StringTokenizer(br.readLine());

        char[] chr = br.readLine().toCharArray();

        boolean isFlag=false;
        for(int i=0; i<chr.length; i++){
            if(chr[i]=='0'){
                chr[i]='1';
                isFlag=true;
                break;
            }
        }
        int cnt=0;
        int answer=0;
        if(!isFlag){
            chr[chr.length-1]='0';
        }
        for(int i=chr.length-1; i>=0; i--){
            if(chr[i]=='1'){
                answer+=Math.pow(2,cnt);
            }
            cnt++;
        }
        System.out.println(answer);


    }
}
