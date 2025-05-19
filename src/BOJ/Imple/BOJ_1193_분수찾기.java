package BOJ.Imple;

import java.util.Scanner;

public class BOJ_1193_분수찾기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int count= 0;

        int up=0;
        int down=0;

        for (int i = 1; i < 1000000; i++) {
            count++;
            if(N>i){
                N-=i;
            }
            else if(N<=i){

                break;
            }

        }
        //System.out.println(count);
        if(count==1){
            System.out.println(1+"/"+1);
            return;
        }else{
            if(count%2==0){
                up=1;
                down=count;
                for (int i = 1; i <N; i++) {
                    up++;
                    down--;
                }
            }else{
                up=count;
                down=1;
                for (int i = 1; i <N; i++) {
                    up--;
                    down++;
                }

            }
        }
        System.out.println(up+"/"+down);
    }
}
