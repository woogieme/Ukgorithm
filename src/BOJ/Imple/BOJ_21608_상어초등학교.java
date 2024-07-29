package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {
    static int N;
    static int[][] map;
    static int[][] friends;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int M;
    static int blank;
    static int ih;
    static int jh;

    static class Position{
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static class PositionS{
        int x;
        int y;
        int count;

        PositionS(int x, int y,int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = (int) Math.pow(N,2);

        map = new int[N][N];

        friends = new int[M][5];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                friends[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int q=0; q<M; q++) {
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            blank = -1;
            ih = 0;
            jh = 0;
            findBlank();

            ArrayList<Position> arr = new ArrayList<>();
            ArrayList<PositionS> brr = new ArrayList<>();

            //비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 존재하는가?
            int minValue = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int nexti = i + dx[d];
                            int nextj = j + dy[d];
                            if (range(nexti, nextj)) {
                                for (int k = 1; k < 5; k++) {
                                    if (map[nexti][nextj] == friends[q][k]) {
                                        count++;
                                    }
                                }
                                brr.add(new PositionS(i, j, count));
                                minValue = Math.max(minValue, count);
                            }
                        }
                    }
                }
            }
            for (PositionS p : brr) {
                if (minValue != 0 && p.count == minValue) {
                    arr.add(new Position(p.x, p.y));
                }
            }


            //좋아하는친구가 한명도없을때
            if (arr.isEmpty()) {
                map[ih][jh] = friends[q][0];
                continue;
            }

            //1을 만족하는 칸이 여러개면 인접한 칸중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
            int result = Integer.MIN_VALUE;
            int weight = -1;
            int height = -1;

            for (Position value : arr) {
//                if(friends[q][0]==2){
//                    for (Position values : arr) {
//                        System.out.println(values.x+" "+values.y);
//                    }
//                }
                int tmpValue = 0;
                //친구의 인접한칸 구하기( 범위 벗어나면안됨 0인곳
                for (int d = 0; d < 4; d++) {
                    int nexti = value.x + dx[d];
                    int nextj = value.y + dy[d];

                    tmpValue += inRange(nexti, nextj);
                }

                if (result < tmpValue) {
                    weight = value.x;
                    height = value.y;
                    result = tmpValue;
                } else {
                    if (weight > value.x) {
                        weight = value.x;
                        height = value.y;
                    } else if (weight == value.x) {
                        if (height > value.y) {
                            height = value.y;
                        }
                    }
                }
                //end for tmp

            }
            map[weight][height] = friends[q][0];
            //end for arr

//            map[weight][height]= friends[q][0];
        }



        int lastValue=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for(int s = 0; s < M; s++) {
                    if(map[i][j]==friends[s][0]) {
                        for (int d = 0; d < 4; d++) {
                            int nexti = i + dx[d];
                            int nextj = j + dy[d];
                            if (range(nexti, nextj)) {
                                for (int k = 1; k <= 4; k++) {
                                    if (map[nexti][nextj] == friends[s][k]) {
                                        //System.out.println(i+" "+j+" "+friends[s][k]);
                                        count++;
                                    }
                                }
                            }
                        }

                    }
                }
               //System.out.println("count"+" "+count);
                if(count>=2){
                    lastValue+= (int) Math.pow(10,count-1);
                }else if(count==1){
                    lastValue+=1;
                }

            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(lastValue);
    }

    private static void findBlank() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count=0;
                if(map[i][j]==0) {
                    for (int d = 0; d < 4; d++) {
                        int nexti = i + dx[d];
                        int nextj = j + dy[d];
                        count += inRange(nexti, nextj);
                    }
                    if (blank < count) {
                        blank = count;
                        ih = i;
                        jh = j;
                    }
                }

            }

        }



    }

    private static int inRange(int i, int j) {
        if(i>=0 && i<N && j>=0 && j<N && map[i][j]==0){
            return 1;
        }
        return 0;

    }

    private static boolean nearRange(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N && map[i][j] == 0;

    }

    private static boolean range(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;

    }
}
