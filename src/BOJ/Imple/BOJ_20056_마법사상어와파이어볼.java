package BOJ.Imple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20056_마법사상어와파이어볼 {

    static int N;
    static int M;
    static int K;

    static List<Point>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static HashSet<Number> hSet;

    static class Number {
        int x;
        int y;

        Number(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Number)) return false;
            Number p = (Number) o;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static class Point {

        int x;
        int y;
        int m;
        int d;
        int s;

        Point(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.d = d;
            this.s = s;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new List[N][N];
        hSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            Point p = new Point(x, y, m, s, d);
            hSet.add(new Number(x, y));
            map[x][y].add(p);

        }


        int loop = 0;
        while (true) {
            //System.out.println("Before================"+" "+loop);
            //print();
            if (loop == K) {
                break;
            }

            List<Number> target = new ArrayList<>();
            List<Number> new_target = new ArrayList<>();
            //System.out.println("Naming: "+"x y 질 속 방 가야하는거리");
            //1.모든 파이어볼이 움직인다
            List<Point> fireBalls = new ArrayList<>();
            for (Number p : hSet) {

                int px = p.x;
                int py = p.y;
                target.add(p);
                //System.out.println(p.x+" "+p.y+" "+map[px][py].size());
                for (int i =map[px][py].size()-1; i >=0; i--) {

                    Point fireBall = map[px][py].get(i);
                    if(fireBall.m==0){
                        map[px][py].remove(i);
                        continue;
                    }
                    int x = fireBall.x;
                    int y = fireBall.y;
                    int m = fireBall.m;
                    int s = fireBall.s;
                    int d = fireBall.d;

                    int distance = s % N;
                    if(s==0){
                        continue;
                    }
                    //System.out.println("Before: "+x+" "+y+" "+m+" "+s+" "+d+" "+distance);
                    //현재 거리와 맵끝거리
                    x = (x + distance * dx[d] + N) % N;
                    y = (y + distance * dy[d] + N) % N;
//                    System.out.println("After: "+x+" "+y+" "+m+" "+s+" "+d+" "+distance);
//                    System.out.println();

                    fireBalls.add(new Point(x,y,m,s, d));
                    new_target.add(new Number(x,y));
                    map[px][py].remove(i);
                }

            }
            for (int i = 0; i < fireBalls.size(); i++) {
                map[fireBalls.get(i).x][fireBalls.get(i).y].add(fireBalls.get(i));
            }
            for (int i = 0; i < target.size(); i++) {
                hSet.remove(target.get(i));
            }

            for (int i = 0; i < new_target.size(); i++) {
                hSet.add(new_target.get(i));
            }


            target = new ArrayList<>();
            new_target = new ArrayList<>();

            //System.out.println("After================"+" "+loop);
            //print();
            for (int i = 0; i < N; i++) {



                //이동이 모두 끝난뒤 2개 이상의 파이어볼을 찾는다

                for (int j = 0; j < N; j++) {
                    if (map[i][j].size() >= 2) {
                        HashSet<Integer> d = new HashSet<>();
                        target.add(new Number(i,j));
                        int size = map[i][j].size();
                        //1.같은칸에있는 파이어볼을 모두 합친다
//                        System.out.println("==");
                        double totalMass = 0;
                        double totalSpeed = 0;
                        for (int k = 0; k < map[i][j].size(); k++) {
                            d.add(map[i][j].get(k).d);
                            totalSpeed += map[i][j].get(k).s;
                            totalMass += map[i][j].get(k).m;
//                            System.out.println(map[i][j].get(k).m);
//                            System.out.println("plusTotal: "+totalMass);
                        }
                        map[i][j].clear();
                        //System.out.println("totalMass: "+totalMass);
                        //4. 질량은 (합쳐진 파이어볼의 질량의 합)/5 + Floor
                        double newMass =Math.floor(totalMass/5);
                        //System.out.println(newMass);
                        if (newMass > 0) {
                            //5. 속력은 (합쳐진 파이어볼의 속력의 합)/합쳐진 파이어볼의 개수 + Floor
                            new_target.add(new Number(i,j));
                            double t = totalSpeed/size;
                            boolean even = false;
                            boolean odd = false;
                            for (Integer num : d) {
                                if (num % 2 == 0) {
                                    even = true;
                                } else {
                                    odd = true;
                                }
                            }
                            if (even && odd) {
                                int[] arr = {1, 3, 5, 7};
                                for (int k = 0; k < 4; k++) {
                                    Point p = new Point(i, j, (int)newMass,(int) t,arr[k]);
                                    map[i][j].add(p);
                                }

                            } else {
                                int[] arr = {0, 2, 4, 6};
                                for (int k = 0; k < 4; k++) {
                                    Point p = new Point(i, j,(int) newMass,(int)t,arr[k]);
                                    map[i][j].add(p);
                                }
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < target.size(); i++) {
                hSet.remove(target.get(i));
            }
            for (int i = 0; i < new_target.size(); i++) {

                hSet.add(new_target.get(i));
            }

//            System.out.println("index");
//            for (Number o : hSet) {
//                System.out.println(o.x+" "+o.y);
//            }

            loop++;
        }

        int result = 0;
        //print();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].size()>0){
                    for (int k = 0; k < map[i][j].size(); k++) {
                        result+=map[i][j].get(k).m;
                    }
                }
            }
        }
        System.out.println(result);


    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j].size()>0){
                    System.out.print(map[i][j].size()+" ");
                }else{
                    System.out.print("0"+" ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }

}
