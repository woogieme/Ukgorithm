package CodeTree.SamSung.Exam;

import java.io.*;
import java.util.*;

public class 메이즈러너개정판 {
    static int N;
    static int M;
    static int K;
    static Square square;
    static Part[] part;
    static int[][] map;
    static int[] dx= {-1,1,0,0};
    static int[] dy= {0,0,-1,1};
    static int escapeX;
    static int escapeY;
    static int allPartMove;

    static public class Part{
        int pX;
        int pY;
        boolean pMove;
        boolean pEsacpe;

        public Part(int pX,int pY,boolean pMove,boolean pEsacpe){
            this.pX=pX;
            this.pY=pY;
            this.pMove=pMove;
            this.pEsacpe=pEsacpe;
        }
    }

    static public class Square implements Comparable<Square>{
        int si;
        int sj;
        int ei;
        int ej;

        public Square(int si,int sj,int ei, int ej){
            this.si=si;
            this.sj=sj;
            this.ei=ei;
            this.ej=ej;
        }

        @Override
        public int compareTo(Square square){
            if(this.ei==square.ei){
                return this.ej - square.ej;
            }
            return this.ei - square.ei;
        }
    }

    static boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    static int findDist(int si,int sj,int ei,int ej){
        return Math.abs(si-ei)+Math.abs(sj-ej);
    }
    static boolean allEscape(){
        for(int i=0; i<M; i++){
            if(!part[i].pEsacpe){
                return false;
            }
        }
        return true;
    }
    static void partMove(){

        for(int i=0; i<M; i++){
            if(part[i].pEsacpe){
                continue;
            }
            int pi = part[i].pX;
            int pj = part[i].pY;

            //현재 거리
            int escDist = findDist(pi,pj,escapeX,escapeY);
            //System.out.println("얍 "+escDist);
            int escResult = 10000000;

            int changeX=pi;
            int changeY=pj;
            for(int d=0; d<4; d++){
                int nexti = pi+dx[d];
                int nextj = pj+dy[d];
                //범위를 벗어나지 말아야하며 벽이 없고  현재 거리보다 최단거리가 가까워야함
                if((inRange(nexti,nextj)) && (map[nexti][nextj]==0 || map[nexti][nextj]==-1) && escDist >
                        findDist(nexti,nextj,escapeX,escapeY)){

                    escDist = findDist(nexti,nextj,escapeX,escapeY);
                    changeX=nexti;
                    changeY=nextj;
                    if(map[nexti][nextj]==-1){
                        break;
                    }

                }
            }

            part[i].pX=changeX;
            part[i].pY=changeY;
            if(changeX!=pi || changeY!=pj){
                //System.out.println("얍 "+part[i].pX+" "+part[i].pY+" "+escDist);
                allPartMove+=1;
            }
            if(part[i].pX == escapeX && part[i].pY == escapeY){
                part[i].pEsacpe=true;
            }

        }
    }

    static boolean findRange(int si,int sj,int ei,int ej){
        boolean isPartFind=false;
        boolean isEscapeFind=false;
        //System.out.println(si+" "+sj+" "+ei+" "+ej);
        for(int i=si; i<=ei; i++){
            for(int j=sj; j<=ej; j++){
                for(int ip=0; ip<M; ip++){
                    if(i==part[ip].pX && j==part[ip].pY && !part[ip].pEsacpe){
                        //System.out.println(ip+" "+part[ip].pX+" "+part[ip].pX+" ");
                        isPartFind=true;

                    }
                    if(i==escapeX && j==escapeY){
                        isEscapeFind=true;
                    }
                    if(isEscapeFind && isPartFind){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    static void rotate(){
        int R = escapeX;
        int C = escapeY;
        int cnt=1;
        while(true){

            boolean isFlag=false;
            //좌측 위
            for(int i=0; i<N-cnt; i++){
                for(int j=0; j<N-cnt; j++){
                    if(findRange(i,j,i+cnt,j+cnt)){
                        isFlag=true;
                        square = new Square(i,j,i+cnt,j+cnt);
                        break;
                    }
                }
                if(isFlag){
                    break;
                }
            }
            if(isFlag){
                break;
            }
            cnt++;
            //System.out.println("ASASAS");
        }
        // System.out.println("이거 " +K+" "+square.si+" "+square.sj+" "+square.ei+" "+square.ej);
        // for(int i=0; i<M; i++){
        //     System.out.println(i+" 위치 "+part[i].pX+" "+part[i].pY);
        // }
        // System.out.println("출구  "+escapeX+" "+escapeY);

        int[][] copymap = new int[N][N];

        int Idx=0;
        for(int i= square.si; i<=square.ei; i++){
            int Jdx=0;
            for(int j=square.sj; j<=square.ej; j++){
                for(int q=0; q<M; q++){
                    if(part[q].pMove|| part[q].pEsacpe){
                        continue;
                    }
                    if(part[q].pX==i && part[q].pY==j){
                        //System.out.println("이해좀 "+part[q].pX+" "+i+" "+part[q].pY+" "+j);
                        part[q].pX=square.si+Jdx;
                        part[q].pY=square.ej-Idx;
                        part[q].pMove=true;
                    }
                }

                copymap[square.si+Jdx][square.ej-Idx]=map[i][j];
                Jdx++;
            }
            Idx++;
        }
        //copyprint(copymap);
        for(int i= square.si; i<=square.ei; i++){
            for(int j=square.sj; j<=square.ej; j++){
                map[i][j]=copymap[i][j];
                if(map[i][j]>0){
                    map[i][j]-=1;
                }
                if(map[i][j]==-1){
                    escapeX=i;
                    escapeY=j;
                }
            }
        }
        // System.out.print("??");
        // print();
    }
    static void moveSet(){
        for(int i=0; i<M; i++){
            if(part[i].pEsacpe){
                continue;
            }
            part[i].pMove=false;
        }
    }
    static void copyprint(int[][] copymap){
        System.out.println("카피---------------");
        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){
                System.out.print(copymap[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void print(){
        for(int i=0; i<N; i++){

            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        //맵 초기화
        map =new int[N][N];
        part = new Part[M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken())-1;
            int y =Integer.parseInt(st.nextToken())-1;

            part[i] = new Part(x,y,false,false);
        }

        st = new StringTokenizer(br.readLine());
        escapeX = Integer.parseInt(st.nextToken())-1;
        escapeY = Integer.parseInt(st.nextToken())-1;

        map[escapeX][escapeY]=-1;
        allPartMove=0;

        // for(int i=0; i<M; i++){
        //     System.out.println(i+" 위치 "+part[i].pX+" "+part[i].pY);
        // }
        int cnt=1;
        while(true){
            if(K==0){
                break;
            }

            //System.out.println(cnt+"번째 ");
            //System.out.println("partMove전 ==================");
            //print();
//            for(int i=0; i<M; i++){
//                System.out.print(i+"번쨰: "+part[i].pEsacpe+" "+part[i].pX+" "+part[i].pY+" ");
//            }
            //System.out.println();
            partMove();
            //System.out.println("partMove후 ==================");
            // print();
////            for(int i=0; i<M; i++){
////                System.out.print(i+"번쨰: "+part[i].pEsacpe+" "+part[i].pX+" "+part[i].pY+" ");
////            }
//            System.out.println();
            if(allEscape()){
                break;
            }

            rotate();
            moveSet();
            //System.out.println("RotateMove후 ==================");
//            for(int i=0; i<M; i++){
//                System.out.print(i+"번쨰: "+part[i].pEsacpe+" "+part[i].pX+" "+part[i].pY+" "+" Square "+ square.si+" "+ square.sj+" "+ square.ei+" "+ square.ej+" ");
//            }
            cnt++;
            //print();
            //System.out.println();
            //움System.out.println("움직임 "+ allPartMove);
            K--;
        }
        System.out.println(allPartMove);
        System.out.println((escapeX+1)+" "+(escapeY+1));
        // 여기에 코드를 작성해주세요.
    }
}