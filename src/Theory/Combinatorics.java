package Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Combinatorics {

    //N = 전체길이, isSelected = 방문여부, numbers = 실제 들어가야하는 숫자
    static int N = 6;
    static boolean[] isSelected = new boolean[N];

    //순열배열
    static int[] numbers = new int[6];

    //조합 배열
    static int[] numbers2 = new int[3];


    public static void main(String[] args) throws IOException {

        while(true){
            int N = chooseComb();
            initialized();
            if (N==0){
                break;
            }
        }


    }

    // 순열 : nPr ==> n!
    private static void perm(int cnt) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < 6; i++) {
            if (isSelected[i]) continue; // 선택 되지 않은 것들만 선택(중복 X)
            numbers[cnt] = i + 1;
            isSelected[i] = true; // 선택
            perm(cnt + 1); // cnt++ 이 아니라 cnt+1 로 해야한다. (cnt 변경되면 안됨.)
            isSelected[i] = false; // 선택 해제
        }
    }

    // 중복 순열 : nㅠr  ==> n^r
    private static void dupperm(int cnt) {
        if (cnt == N) { // 기저 조건
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= 6; i++) { // 유도 파트
            numbers[cnt] = i;
            dupperm(cnt + 1);
        }
    }

    private static void comb(int cnt, int start) {
        if(cnt == 3) {
            System.out.println(Arrays.toString(numbers2));
            return;
        }
        for(int i =start; i<6; i++) {
            numbers2[cnt] = i;
            comb(cnt+1, i+1);
        }
    }

    private static void combCustom(int cnt, int start) {
        if(cnt == 3) {
            System.out.println(Arrays.toString(numbers2));
            return;
        }
        if(cnt==numbers.length){
            return;
        }
        numbers[cnt]=start;
        comb(cnt+1,start+1);
        comb(cnt,start+1);
    }

    // 중복조합 nHr : 6H3 : n+1-1Cr : 8C3 : 56
    private static void dupcomb(int cnt, int start) {
        if(cnt == 3) {
            System.out.println(Arrays.toString(numbers2));
            return;
        }
        for(int i =start; i<6; i++) {
            numbers2[cnt] = i;
            dupcomb(cnt+1, i);
        }
    }

    private static void subset(int count) { // count: 현재까지 고려한 원소 수

        if (count == N) {
            for (int i = 0; i <N; i++) {
                if(isSelected[i]){
                    System.out.print(isSelected[i]);
                }else{
                    System.out.print(isSelected[i]);
                }
                System.out.print("\t");
            }
            System.out.println();
            return;
        }

        isSelected[count] = true;
        subset(count+1);
        isSelected[count] = false;
        subset(count+1);
    }

    private static void desc() {
        System.out.println("1번 : perm");
        System.out.println("2번 : dupperm");
        System.out.println("3번 : comb");
        System.out.println("4번 : combCustom");
        System.out.println("5번 : dupcomb");
        System.out.println("6번 : subset");
        System.out.println("0번 : 종료");
    }

    private static int chooseComb() throws IOException {

        desc();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        while (true) {
            System.out.print("입력하세요 : ");
            try {
                input = Integer.parseInt(br.readLine());
                break;  // 유효한 입력이 들어오면 반복문 탈출
            } catch (NumberFormatException e) {
                System.out.println("숫자를 올바르게 입력해주세요.");
            }
        }
        System.out.println();

        switch (input){
            case 1: perm(0); initialized(); break;
            case 2: dupperm(0); initialized(); break;
            case 3: comb(0,0); initialized(); break;
            case 4: combCustom(0,0); initialized(); break;
            case 5: dupcomb(0,0); initialized(); break;
            case 6: subset(getStartDepth()); initialized(); break;
            case 0: break;
        }
        return N;
    }

    private static int getStartDepth() {
        return 0;
    }

    private static void initialized() {
        isSelected = new boolean[N];

        //순열배열
        numbers = new int[6];

        //조합 배열
        numbers2 = new int[3];
    }
}
