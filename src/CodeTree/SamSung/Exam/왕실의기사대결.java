package CodeTree.SamSung.Exam;

import java.io.*;
import java.util.*;

public class 왕실의기사대결 {
    static int L;
    static int N;
    static int Q;
    static int K;
    static Night[] nights;
    static Night[] tmpNights;
    static int tmpNightCnt;
    static int[] dx ={-1,0,1,0};
    static int[] dy ={0,1,0,-1};
    static boolean firstDead;
    static int[][] map;
    static int[][] nightMap;
    static int[][] copyMap;
    static Queue<Integer> arr;
    static int[] blood;
    static boolean[] visited;

    static public class Night{
        int nNum;
        int nR;
        int nC;
        int sR;
        int sC;
        int nK;
        public Night(int nNum, int nR,int nC,int sR,int sC,int nK){
            this.nNum=nNum;
            this.nR=nR;
            this.nC=nC;
            this.sR=sR;
            this.sC=sC;
            this.nK=nK;
        }
    }

    static boolean canGoKing(int si,int sj,int ei,int ej){
        if (si< 0 || si>=L || sj<0 || sj>=L || ei>=L || ei<0 || ej <0|| ej>=L){
            return false;
        }
        for(int x=0; x<L; x++){
            for(int y=0; y<L; y++){
                if(x>=si && x<=ei && y>=sj && y<=ej && map[x][y]==2){
                    return false;
                }
            }
        }
        return true;
    }

    static void isOtherMap(int si,int sj,int ei,int ej,int num){

        for(int x=0; x<L; x++){
            for(int y=0; y<L; y++){
                if(x>=si && x<=ei && y>=sj && y<=ej && nightMap[x][y]>0 && nightMap[x][y]!=num && !visited[nightMap[x][y]]){
                    arr.add(nightMap[x][y]);
                }
            }
        }

    }
    static void moveNight(int orderNum, int dir){
        tmpNights= new Night[200];
        tmpNightCnt=-1;

        if(nights[orderNum-1].nK<1 ){
            firstDead=true;
            return;
        }

        int kLife = nights[orderNum-1].nK;
        boolean isGoFlag=false;
        copyMap = new int[L][L];

        arr =new ArrayDeque<>();
        arr.add(nights[orderNum-1].nNum);

        while(!arr.isEmpty()){
            int kNightNum = arr.poll();

            int si = nights[kNightNum-1].nR;
            int sj = nights[kNightNum-1].nC;
            int ei = nights[kNightNum-1].sR;
            int ej = nights[kNightNum-1].sC;
            int num = nights[kNightNum-1].nNum;

            visited[num]=true;

            int nextSi = si+dx[dir];
            int nextSj = sj+dy[dir];
            int nextEi = ei+dx[dir];
            int nextEj = ej+dy[dir];

            if(!canGoKing(nextSi,nextSj,nextEi,nextEj)){
                isGoFlag=true;
                firstDead=true;
                break;
            }

            tmpNights[++tmpNightCnt] = new Night(num,nextSi,nextSj,nextEi,nextEj,kLife);

            //가짜 맵으로 이동
            for(int x=0; x<L; x++){
                for(int y=0; y<L; y++){
                    if(x>=nextSi && x<=nextEi && y>=nextSj && y<=nextEj){
                        copyMap[x][y]=num;
                    }
                }
            }

            isOtherMap(nextSi,nextSj,nextEi,nextEj,num);
        }

        if(!isGoFlag){

            for(int i=0; i<=tmpNightCnt; i++){
                for(int j=0; j<N; j++){
                    if(nights[j].nNum == tmpNights[i].nNum){
                        nights[j].nR=tmpNights[i].nR;
                        nights[j].nC=tmpNights[i].nC;
                        nights[j].sR=tmpNights[i].sR;
                        nights[j].sC=tmpNights[i].sC;
                    }
                }
            }

            for(int i=0; i<L; i++){
                for(int j=0; j<L; j++){
                    for(int k=1; k<=N; k++){
                        if(!visited[k] && nightMap[i][j]==k){
                            copyMap[i][j]=k;
                        }
                    }
                }
            }

            for(int i=0; i<L; i++){
                for(int j=0; j<L; j++){
                    nightMap[i][j]=copyMap[i][j];
                }
            }
        }
    }
    static void damageNight(int orderNum){

        for(int i=0; i<N; i++){
            int count=0;
            if(nights[i].nK < 1  || i==orderNum-1 || !visited[i+1]){
                continue;
            }
            int num = nights[i].nNum;
            int si = nights[i].nR;
            int sj = nights[i].nC;
            int ei = nights[i].sR;
            int ej = nights[i].sC;
            int kLife = nights[i].nK;

            for(int x=0; x<L; x++){
                for(int y=0; y<L; y++){
                    if(x>=si && x<=ei && y>=sj && y<=ej && map[x][y]==1){
                        count++;
                    }
                }
            }
            kLife-=count;
            blood[num]+=count;

            if(kLife<1){
                for(int x=0; x<L; x++){
                    for(int y=0; y<L; y++){
                        if(x>=si && x<=ei && y>=sj && y<=ej && nightMap[x][y]==num){
                            nightMap[x][y]=0;
                        }
                    }
                }
                blood[num]=-1;
            }
            nights[i].nK=kLife;
        }
    }

    static void print1(){
        System.out.println("========================");
        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void print2(){
        System.out.println("========================");
        for(int i=0; i<L; i++){
            for(int j=0; j<L; j++){
                System.out.print(nightMap[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        L =Integer.parseInt(st.nextToken());
        N =Integer.parseInt(st.nextToken());
        Q =Integer.parseInt(st.nextToken());

        map = new int[L][L];
        nightMap = new int[L][L];
        copyMap = new int[L][L];

        nights= new Night[N];

        for(int i=0; i<L; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<L; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            int si = Integer.parseInt(st.nextToken())-1;
            int sj = Integer.parseInt(st.nextToken())-1;
            int ei = Integer.parseInt(st.nextToken())-1+si;
            int ej = Integer.parseInt(st.nextToken())-1+sj;
            int life = Integer.parseInt(st.nextToken());

            int num=i+1;

            nights[i]=new Night(i+1,si,sj,ei,ej,life);

            for(int x=0; x<L; x++){
                for(int y=0; y<L; y++){
                    if(x>=si && x<=ei && y>=sj && y<=ej){
                        nightMap[x][y]=num;
                    }
                }
            }
        }
        blood = new int[N+1];
        while(true){

            if(Q==0){
                break;
            }
            visited= new boolean[N+1];
            st =new StringTokenizer(br.readLine());

            int orderNum= Integer.parseInt(st.nextToken());
            int dir= Integer.parseInt(st.nextToken());

            firstDead = false;

            moveNight(orderNum,dir);

            if(!firstDead){
                damageNight(orderNum);

            }

            Q--;
        }

        int result=0;

        for(int i=0; i<N; i++){
            if(blood[i+1]!=-1){
                result+=blood[i+1];
            }
        }

        System.out.println(result);


    }
}