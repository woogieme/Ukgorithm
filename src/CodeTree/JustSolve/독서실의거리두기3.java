package CodeTree.JustSolve;

import java.io.*;
public class 독서실의거리두기3 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] chr = br.readLine().toCharArray();

        int result=0;
        int count=0;
        int tmp=2000;
        for(int i=0; i<N; i++){
            if(i==0){
                continue;
            }
            if(chr[i]=='1'){
                if(chr[i-1]=='1'){
                    count=1;
                    result =Math.max(count,result);
                    tmp = Math.min(count,tmp);
                }else{
                    count++;
                    result =Math.max(count,result);
                    tmp = Math.min(count,tmp);
                    count=0;
                }
            }else if (chr[i]=='0'){
                count++;
            }
        }

        if(result!=0){
            result/=2;
        }

        if(result<tmp){
            System.out.println(result);
        }else{
            System.out.println(tmp);
        }
        // 여기에 코드를 작성해주세요.
    }
}