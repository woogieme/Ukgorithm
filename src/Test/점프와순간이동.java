package Test;

public class 점프와순간이동 {
    static int distance;
    static int b_Answer=Integer.MAX_VALUE;
    public static void DFS(int start,int battery){

        if(start>distance){
            return;
        }
        if(start==distance){
            if(b_Answer>battery){
                b_Answer=battery;
            }
        }

        DFS(start+1,battery+1);
        if(start!=0) {

            DFS(start * 2, battery);
        }

    }
    public static int solution(int n) {
        int ans = 0;

        //거리=n, 현재 위치, 배터리
        distance=n;

        DFS(0,0);


        return b_Answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5000));
        System.out.println("????");

    }
}
