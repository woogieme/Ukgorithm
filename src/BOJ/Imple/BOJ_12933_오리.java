package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12933_오리 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] duck = br.readLine().toCharArray();
        char[] sound = {'q','u','a','c','k'};
        int result=0;
        boolean[] checked = new boolean[duck.length];
        boolean isFlag=true;
        for (int i = 0; i < duck.length; i++) {
            int count = 0;
            if(!checked[i] && duck[i] == 'q') {
                for (int j = i; j < duck.length; j++) {
                    if (!checked[j] && (duck[j] == sound[count])) {
                        count++;
                        checked[j] = true;
                        if (count > sound.length - 1) {
                            count = 0;
                        }
                    }
                }
                result++;
                if(count!=0){
                    isFlag=false;
                    break;
                }
            }
        }

        for(int i = 0; i < duck.length; i++) {
            if(!checked[i]){
                isFlag=false;
                break;
            }
        }
        if(isFlag){
            System.out.println(result);
        }else{
            System.out.println(-1);
        }


    }
}


