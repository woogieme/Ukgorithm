package CodeTree.Hyundai;

import java.io.*;
public class 괄호쌍만들어주기3 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        int N = arr.length;
        int answer=0;
        for(int i=0; i<N-1; i++){
            if(arr[i]=='('){
                for(int j=i+1; j<N; j++){
                    if(arr[j]==')'){
                        answer++;
                    }
                }
            }

        }
        System.out.println(answer);

    }
}
