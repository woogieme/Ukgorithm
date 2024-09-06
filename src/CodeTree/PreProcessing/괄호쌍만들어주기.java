package CodeTree.PreProcessing;

import java.io.*;

public class 괄호쌍만들어주기 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] chr = br.readLine().toCharArray();
        int N = chr.length;
        long[] L = new long[N];
        long[] R = new long[N];

        int first=Integer.MAX_VALUE;
        int last=-1;

        for(int i=0; i<N-1; i++){
            if(chr[i]=='(' && chr[i+1]=='('){
                L[i+1]=L[i]+1;
            }else{
                L[i+1]=0;
            }
        }

        for(int i=N-2; i>=1; i--){
            if(chr[i]==')' && chr[i+1]==')'){
                R[i]=R[i+1]+1;
            }else{
                R[i]=R[i+1];
            }
        }

        long result=0L;

        for(int i=0; i<N-1; i++){
            if(chr[i+1]==')'){
                result+=L[i]*R[i+1];
            }
        }
        System.out.println(result);
    }






    // 여기에 코드를 작성해주세요.
}
