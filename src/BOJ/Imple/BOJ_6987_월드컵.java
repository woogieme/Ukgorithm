package BOJ.Imple;

import java.util.Scanner;

public class BOJ_6987_월드컵 {
    static int [] teamA= {0,0,0,0,0,1,1,1,1,2,2,2,3,3,4}; //6개의 국가는 15번의 게임을 하게됨
    static int [] teamB= {1,2,3,4,5,2,3,4,5,3,4,5,4,5,5}; // 각 게임의번호는 0~14번 게임임.
    static int [][] input, make;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <=4; tc++) {
            input = new int[6][3]; //0:승 1:무 2:패
            make = new int[6][3];
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    input[i][j] = sc.nextInt();
                }
            }//end input
            ans=0;
            game(0);
            System.out.print(ans+" ");
        }
        System.out.println();
    }

    private static void game(int gameIdx) {
        if(gameIdx==15) {
            //자 여기까지 모든 경기의 승패가 기록되었다 ! , input과 일치하는가 ? 아니면 국가들의 승패를 바꾸러 돌아간다.
            if(check()) {
                ans= 1;
            }
            return;
        }
        int team1= teamA[gameIdx];
        int team2= teamA[gameIdx];


        //team1이 이기는 경우
        make[team1][0]++; //승카운트
        make[team2][2]++; //패카운트
        game(gameIdx+1);  //내가 월요일이면 이 상태로 화요일 계산해보라고
        make[team1][0]--; //승카운트
        make[team2][2]--; //패카운트

        //team2이 이기는경우
        make[team1][2]++; //패카운트
        make[team2][0]++; //승카운트
        game(gameIdx+1);  //내가 월요일이면 이 상태로 화요일 계산해보라고
        make[team1][2]--; //패카운트
        make[team2][0]--; //승카운트
        //둘다 비기는경우
        make[team1][1]++; //무승부
        make[team2][1]++; //무승부
        game(gameIdx+1);  //내가 월요일이면 이 상태로 화요일 계산해보라고
        make[team1][1]--; //무승부
        make[team2][1]--; //무승부


    }

    private static boolean check() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if(input[i][j]!=make[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
