package BOJ.DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 단지번호붙이기_BOJ_2667 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int count;
    static int ans;
    static ArrayList<Integer> arr;
    static int[] dx= {-1,0,1,0};
    static int[] dy={0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i]=br.readLine().toCharArray();
        }
        visited= new boolean[N][N];
        ans=0;
        arr= new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count=1;
                if(map[i][j]=='1'&& !visited[i][j]){
                    dfs(i,j,visited);
                    ans++;
                    arr.add(count);
                }
            }
        }

        System.out.println(ans);
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }



    }

    private static void dfs(int si, int sj, boolean[][] visit) {
        visit[si][sj]=true;
        Pointer now = new Pointer(si,sj);
        for (int d = 0; d < dx.length; d++) {
            int nexti = now.x + dx[d];
            int nextj = now.y + dy[d];
            if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[nexti][nextj] == '1' && !visit[nexti][nextj]) {
                count += 1;
                dfs(nexti,nextj,visit);
            }

        }
    }

    private static class Pointer {
        int x;
        int y;
        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
}
