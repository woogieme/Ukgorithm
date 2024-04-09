package BOJ.Recur;

import java.io.*;

public class 별_BOJ_16505 {
    static int N;
    static char[][] map;

    static int range;
    static void star(int N,int i, int j) {

        if(N==0) {
            map[i][j]='*';
            return;
        }

        star(N/2,i,j);
        star(N/2,i,j+N/2);
        star(N/2,i+N/2,j);


    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        N =Integer.parseInt(br.readLine());
        range = (int) Math.pow(2,N);
        map = new char [range][range];

        star(range,0,0);

        for(int i=0; i<range; i++) {
            for(int j=0; j<range-i; j++) {
                if(i==range-1 && j>=1){
                    continue;
                }
                if(map[i][j]=='*'){
                    System.out.print(map[i][j]);
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println();
        }

    }

}

