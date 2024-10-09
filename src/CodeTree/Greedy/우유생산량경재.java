package CodeTree.Greedy;

import java.util.*;
import java.io.*;
public class 우유생산량경재 {
    static public class Pair implements Comparable<Pair>{

        int day;
        String cow;
        int curve;

        Pair(int day,String cow, int curve){
            this.day=day;
            this.cow=cow;
            this.curve=curve;
        }

        @Override
        public int compareTo(Pair o){
            return this.day-o.day;
        }
    }

    static public class Head implements Comparable<Head>{

        String cow;
        int curve;

        Head(String cow, int curve){

            this.cow=cow;
            this.curve=curve;
        }

        @Override
        public int compareTo(Head o){
            return o.curve - this.curve;
        }
    }


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        ArrayList<Pair> arr = new ArrayList<>();
        ArrayList<Head> brr = new ArrayList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            String cow = st.nextToken();
            String tmp = st.nextToken();
            int curve=0;
            if(tmp.charAt(0)=='-'){
                curve = Integer.parseInt(tmp.substring(1))*-1;

            }else{
                curve = Integer.parseInt(tmp.substring(1));
            }
            arr.add(new Pair(day,cow,curve));
        }

        Collections.sort(arr);

        HashMap<String,Integer> hMap = new HashMap<>();


        hMap.put("Mildred",1);
        hMap.put("Elsie",1);
        hMap.put("Bessie",1);

        brr.add(new Head("Mildred",7));
        brr.add(new Head("Elsie",7));
        brr.add(new Head("Bessie",7));

        int answer=0;

        while(true){

            if(arr.size()==0){
                break;
            }

            HashMap<String,Integer> compare = new HashMap<>();

            String cow = arr.get(0).cow;
            int curve = arr.get(0).curve;

            for(int i=0; i<brr.size(); i++){
                if(brr.get(i).cow.equals(cow)){
                    brr.get(i).curve+=arr.get(0).curve;
                    break;
                }
            }

            Collections.sort(brr);

            int cnt=1;
            for(int i=0; i<brr.size(); i++){
                if(i==0){
                    compare.put(brr.get(i).cow,cnt);
                }else{
                    if(brr.get(i-1).curve!=brr.get(i).curve){
                        cnt++;
                        compare.put(brr.get(i).cow,cnt);
                    }else{
                        compare.put(brr.get(i).cow,cnt);
                    }
                }
            }
            Set<String> str = hMap.keySet();
            for(String k : str){
                if(hMap.get(k)!= compare.get(k)){
                    if((hMap.get(k)==1 && compare.get(k)!= 1) || (hMap.get(k)!=1 && compare.get(k)== 1)){
                        answer++;
                        break;
                    }

                }
            }

            for(String k : str){
                hMap.put(k,compare.get(k));
            }
            arr.remove(0);
        }

        System.out.println(answer);





    }
}
