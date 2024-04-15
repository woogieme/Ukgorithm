package BOJ.Recur;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경사로_BOJ_14890 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int[][] saveMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                saveMap[j][i] = map[i][j];
            }
        }

        int res = process(N, M, map, saveMap);
        System.out.println(res);
    }

    private static int process(int x, int y, int[][] map, int[][] saveMap) {
        int max_cnt = 0;
        for (int i = 0; i < x; i++) {
            if (makeRoad(map[i], x, y))
                max_cnt++;
            if (makeRoad(saveMap[i], x, y))
                max_cnt++;
        }
        return max_cnt;
    }

    private static boolean makeRoad(int[] map, int n, int l) {
        int beforeHeight = map[0];
        int count = 1;
        for (int j = 1; j < n; j++) {
            // 같은 높이
            if (beforeHeight == map[j]) {
                count++;
            }

            // 이전 칸이 한 칸 낮음
            else if (beforeHeight + 1 == map[j]) {
                if(count < l) return false;
                beforeHeight++;
                count = 1;
            }

            // 이전 칸이 한 칸 높음
            else if (beforeHeight - 1 == map[j]) {
                // 앞으로 평지의 수를 세어야 한다.
                int remain = 0;
                for(int k = j; k < n; k++) {
                    if(beforeHeight-1 != map[k]) break;
                    remain++;
                }
                if(remain < l) return false;

                // 설치 가능
                j += l-1;
                count = 0;
                beforeHeight--;
            }

            // 높이 차이 2이상
            else {
                return false;
            }
        }
        return true;
    }
}