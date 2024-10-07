package Test;

import java.util.Arrays;

public class 백트래킹테스트 {
    static int[] card = {1,2,3,4,5,6,7,8,9};

    static int[] person;

    //5장뽑을거임
    static int N = 5;
    static int M = card.length;

    static boolean[] checked;

    public static void main(String[] args) {
        person = new int[N];
        checked = new boolean[M];

        //perm(0);

        person = new int[N];
        checked = new boolean[M];

        //comb(0,0);

        person = new int[N];
        checked = new boolean[M];

        powerSet(0);

    }

    private static void powerSet(int idx) {

        if(idx==M){
            for (int i = 0; i < M; i++) {
                if(checked[i]){
                    System.out.print(i+" ");
                }
            }
            System.out.println();
            //System.out.println(Arrays.toString(person));
            return;
        }
        checked[idx] = true;
        powerSet(idx+1);
        checked[idx] = false;
        powerSet(idx+1);

    }

    private static void perm(int idx) {
        if(idx==N){
            System.out.println(Arrays.toString(person));
            return;
        }
        for(int i=0; i<M; i++){
            if(checked[i]){
               continue;
            }
            checked[i] = true;
            person[idx] = card[i];
            perm(idx+1);
            checked[i] = false;
        }
    }

    private static void comb(int cnt, int idx) {
        if(cnt==N){
            System.out.println(Arrays.toString(person));
            return;
        }
        if (idx == M) {
            return;
        }

        person[cnt] =idx;
        comb(cnt+1,idx+1);
        comb(cnt,idx+1);

    }


}
