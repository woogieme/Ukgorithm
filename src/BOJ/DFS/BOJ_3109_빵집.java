package BOJ.DFS;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
    static char[][] map;
    static boolean[][] visit;

    static int[] di = {-1,0,1};
    static int[] dj = {1,1,1};

    static int R,C,ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R= Integer.parseInt(st.nextToken());
        C= Integer.parseInt(st.nextToken());
        visit = new boolean[R][C];
        map = new char[R][];
        for (int r = 0; r < R; r++) {
            map[r]= br.readLine().toCharArray();
        }
        for (int r = 0; r < R; r++) {
            func(r,0);
        }
        System.out.println(ans);
    }
    static boolean func(int nowi, int nowj) {
        visit[nowi][nowj] = true;

        if(nowj == C-1) {
            ans++;
            return true;
        }
        for (int d = 0; d < 3; d++) {
            int nexti= nowi+di[d];
            int nextj= nowj+dj[d];
            //다른 재귀가 갔던 옆칸?? 그럼파이프가 있거나 또는 파이프가 없어도 놓을수 없는 칸이였네!!
            if(nexti<0 || nexti>= R || nextj<0 || nextj>=C || map[nexti][nextj]=='x' || visit[nexti][nextj]) continue;

            boolean result= func(nexti,nextj); // 내가 보냈던 애가
            if(result==true) { //true를 들고왔네??
                return true;
            }
        }
        return false;
    }
}
