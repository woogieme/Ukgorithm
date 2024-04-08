package CodeTree.SamSung.Simul.NormalSort;

import java.util.*;
import java.io.*;
public class 오름내림차순정렬 {
    static int N;
    static int[] arr;
    static Integer[] arr2;
    public static void main(String[] args) throws IOException{
        // 여기에 코드를 작성해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int [N];
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);



        for(int i=0; i<N; i++){
            System.out.print(arr[i]+" ");

        }
        System.out.println();
        arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2,Collections.reverseOrder());

        for(int i=0; i<N; i++){
            System.out.print(arr2[i]+" ");
        }
    }
}