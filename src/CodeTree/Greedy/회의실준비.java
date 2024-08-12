package CodeTree.Greedy;
import java.util.*;
import java.io.*;
public class 회의실준비 {

    static class Company implements Comparable<Company>{

        int start;
        int end;

        Company(int start, int end){
            this.start=start;
            this.end =end;
        }

        @Override
        public int compareTo(Company o){
            return this.end - o.end;
        }
    }



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 여기에 코드를 작성해주세요.

        ArrayList<Company> com = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());

            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());

            com.add(new Company(x,y));
        }
        Collections.sort(com);

        int count=0;
        int prevS =0;
        int prevE =0;
        for(Company c : com){
            int nowS = c.start;
            int nowE = c.end;

            if(prevE<=nowS){
                count++;
                prevE=nowE;
            }
        }
        System.out.println(count);
    }
}
