package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 두개씩그룹짓기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        int[] arr = new int[N*2];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N*2; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        //System.out.print(Arrays.toString(arr));
        int result=0;
        for(int i=0; i<(N*2)/2; i++){
            int tmp = (arr[i]+arr[(N*2)-i-1]);

            if(result<tmp){
                result=tmp;
            }

        }

        System.out.println(result);

    }
}