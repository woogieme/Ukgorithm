package CodeTree.SamSung.Exam;

import java.io.*;
import java.util.*;
public class 루돌프의반란 {
    static int N;
    static int M;
    static int santaN;
    static int RP;
    static int SP;
    static Santa[] santa;
    static Rudolf dolf;
    static WaitSanta[] waitSanta;
    static int[][] map;
    static int changeX;
    static int changeY;
    static int turn;
    static boolean gameStop;
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    static final String SName = "Santa";

    static public class WaitSanta implements Comparable<WaitSanta>{
        int wNum;
        int wR;
        int wC;
        int dist;

        public WaitSanta(int wNum,int wR, int wC,int dist){
            this.wNum=wNum;
            this.wR =wR;
            this.wC=wC;
            this.dist=dist;
        }

        @Override
        public int compareTo(WaitSanta waitSanta){
            if(this.dist ==waitSanta.dist) {
                if (this.wR == waitSanta.wR) {
                    return waitSanta.wC - this.wC;
                }
                return waitSanta.wR - this.wR;
            }
            return this.dist - waitSanta.dist;
        }
    }

    static public class Santa implements Comparable<Santa>{
        int sNum;
        int sR;
        int sC;
        int sScore;
        int sStun;
        boolean sDie;

        public Santa(int sNum,int sR, int sC, int sScore, int sStun, boolean sDie){
            this.sNum=sNum;
            this.sR =sR;
            this.sC=sC;
            this.sScore =sScore;
            this.sStun=sStun;
            this.sDie=sDie;
        }

        @Override
        public int compareTo(Santa santa){
            return this.sNum - santa.sNum;
        }
    }

    static public class Rudolf{
        int rR;
        int rC;

        public Rudolf(int rR,int rC){
            this.rR=rR;
            this.rC=rC;
        }
    }

    static void santaScore() {
        for(int i=0; i<santaN; i++){
            if(santa[i].sDie){
                continue;
            }
            santa[i].sScore+=1;
        }
    };

    static int twoDist(int si, int sj, int ei,int ej){
        return (((si-ei)*(si-ei)) + ((sj-ej) * (sj-ej)));
    }

    static boolean inRange(int x,int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    static void isAlldie(){
        for(int i=0; i<santaN; i++){
            if(!santa[i].sDie){
                gameStop=false;
                return;
            }
        }
        gameStop=true;
    }
    static void Crush(int num,int Point,String name){
        int santI=santa[num-1].sR;
        int santJ=santa[num-1].sC;

        if(name.equals(SName)){

            santa[num-1].sR+=changeX;
            santa[num-1].sC+=changeY;
            changeX = changeX*(-1);
            changeY = changeY*(-1);

        }

        santa[num-1].sStun =turn+1;
        santa[num-1].sScore+=Point;

        int isX =santa[num-1].sR+(Point*changeX);
        int isY =santa[num-1].sC+(Point*changeY);

        map[santI][santJ]=0;
        if(!inRange(isX,isY)){
            santa[num-1].sDie=true;
            isAlldie();
            return;
        }

        santa[num-1].sR+=(Point*changeX);
        santa[num-1].sC+=(Point*changeY);

        int santaIdx = map[isX][isY];
        map[isX][isY]=num;

        if(santaIdx==0){
            return;
        }

        PushSanta(santaIdx,num);
    }

    static void PushSanta(int santaIdx,int num){

        Queue<Integer> santaQ = new ArrayDeque<>();

        santaQ.add(santaIdx);

        while(!santaQ.isEmpty()){
            int Idx = santaQ.poll();

            int nexti = santa[Idx-1].sR+changeX;
            int nextj = santa[Idx-1].sC+changeY;
            if(!inRange(nexti,nextj)){
                santa[Idx-1].sDie=true;
                if(map[santa[Idx-1].sR][santa[Idx-1].sC]==santaIdx){
                    map[santa[Idx-1].sR][santa[Idx-1].sC]=santaIdx;


                }

                isAlldie();
                break;
            }

            if(map[nexti][nextj]>0){
                int nextIdx = map[nexti][nextj];
                map[nexti][nextj] = Idx;
                santa[Idx-1].sR=nexti;
                santa[Idx-1].sC=nextj;
                santaQ.add(nextIdx);
            }else{
                map[nexti][nextj] = Idx;
                santa[Idx-1].sR=nexti;
                santa[Idx-1].sC=nextj;
            }

        }


    }
    static void rudolfMove(){

        int centerX = dolf.rR;
        int centerY = dolf.rC;
        int tmpX;
        int tmpY;
        int distResult=Integer.MAX_VALUE;
        int cnt=0;

        map[centerX][centerY]=0;
        changeX=0;
        changeY=0;

        for(int i=0; i<santaN; i++){
            if(santa[i].sDie){

                continue;
            }
            int xValue = santa[i].sR;
            int yValue = santa[i].sC;
            int dist = twoDist(centerX,centerY,xValue,yValue);
            if(distResult>=dist){
                waitSanta[cnt]=new WaitSanta(santa[i].sNum,santa[i].sR,santa[i].sC,dist);
                distResult=dist;
                cnt++;
            }
        }

        Arrays.sort(waitSanta,0,cnt);
        tmpX = waitSanta[0].wR;
        tmpY = waitSanta[0].wC;

        if(tmpX>centerX){
            changeX=1;
        }else if (tmpX<centerX){
            changeX=-1;
        }
        if(tmpY>centerY){
            changeY=1;
        }else if (tmpY<centerY){
            changeY=-1;
        }
        centerX+=changeX;
        centerY+=changeY;

        if(map[centerX][centerY]>0){
            Crush(map[centerX][centerY],RP,"Rudolf");
            if(gameStop){
                return;
            }
        }
        map[centerX][centerY]=-1;
        dolf.rR =centerX;
        dolf.rC =centerY;
    }

    static void santaMove(){

        for(int i=0; i<santaN; i++){
            if(santa[i].sDie || santa[i].sStun>=turn){
                continue;
            }

            //산타 현재 위치
            int num = santa[i].sNum;
            int centerX = santa[i].sR;
            int centerY = santa[i].sC;
            int dolfX = dolf.rR;
            int dolfY = dolf.rC;

            changeX=0;
            changeY=0;

            //현재 산타와 루돌프의 거리
            int distResult=twoDist(centerX,centerY,dolfX,dolfY);

            //현재 산타가 바라보는 방향
            int tmpX=-1;
            int tmpY=-1;
            int dir=-1;

            for(int d=3; d>=0; d--){
                int nexti = centerX+dx[d];
                int nextj = centerY+dy[d];

                //맵 밖으로 나가는지 확인 및 현재 거리의 갱신이 되는지?
                 if(inRange(nexti,nextj) && map[nexti][nextj]<=0 &&(distResult >=twoDist(nexti,nextj,dolfX,dolfY))){
                    distResult=twoDist(nexti,nextj,dolfX,dolfY);
                    tmpX = nexti;
                    tmpY = nextj;
                    dir=d;
                }
            }

            //움직일수 있는 칸이 있거나 혹은 다른산타가 있거나
            if((tmpX==-1 && tmpY==-1 )|| map[tmpX][tmpY]>0){
                continue;
            }

            changeX=dx[dir];
            changeY=dy[dir];

            if(map[centerX+changeX][centerY+changeY]!=-1){
                map[centerX][centerY]=0;
                map[centerX+changeX][centerY+changeY]=num;
                santa[i].sR = centerX+changeX;
                santa[i].sC = centerY+changeY;
                continue;
            }

            santa[i].sR = centerX;
            santa[i].sC = centerY;

            Crush(map[centerX][centerY],SP,"Santa");

            if(gameStop){
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        santaN=Integer.parseInt(st.nextToken());
        RP=Integer.parseInt(st.nextToken());
        SP=Integer.parseInt(st.nextToken());

        santa = new Santa[santaN];
        waitSanta = new WaitSanta[santaN];
        map = new int[N][N];

        st =new  StringTokenizer(br.readLine());
        int tmpSr =Integer.parseInt(st.nextToken())-1;
        int tmpSc =Integer.parseInt(st.nextToken())-1;
        dolf =new Rudolf(tmpSr,tmpSc);
        map[tmpSr][tmpSc]=-1;
        turn=0;
        for(int i=0; i<santaN; i++){
            st =new StringTokenizer(br.readLine());

            int num =Integer.parseInt(st.nextToken());
            int x =Integer.parseInt(st.nextToken())-1;
            int y =Integer.parseInt(st.nextToken())-1;

            map[x][y]=num;
            santa[i] = new Santa(num,x,y,0,-1,false);
        }
        Arrays.sort(santa);

        gameStop=false;

        while(true){
            if(M==0){
                break;
            }

            rudolfMove();
            if(gameStop){
                break;
            }

            santaMove();
            if(gameStop){
                break;
            }

            santaScore();

            M--;
            turn++;
        }
        for(int i=0; i<santaN; i++){
            System.out.print(santa[i].sScore+" ");
        }

        // 여기에 코드를 작성해주세요.
    }
}



//    static void print(){
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//
//    static void showAllstun(){
//        System.out.println("스턴여부 확인 ");
//        for(int i=0; i<N; i++){
//
//                System.out.print(santa[i].sStun+" ");
//
//        }
//        System.out.println();
//    }