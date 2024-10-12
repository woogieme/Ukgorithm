package Programmers.Level2;

import java.util.*;
class 파일명정렬 {

    public class Pair implements Comparable<Pair>{

        String Head;
        String Num;
        String Tail;

        Pair(String Head, String Num, String Tail){
            this.Head=Head;
            this.Num= Num;
            this.Tail=Tail;
        }

        @Override
        public int compareTo(Pair o){
            if(this.Head.toLowerCase().equals(o.Head.toLowerCase())){
                System.out.println(this.Num+" "+o.Num);
                return Integer.parseInt(this.Num) -Integer.parseInt(o.Num);
            }
            return this.Head.toLowerCase().compareToIgnoreCase(o.Head.toLowerCase());
        }

    }
    public String[] solution(String[] files) {

        ArrayList<Pair> arr = new ArrayList<>();


        for(int i=0; i<files.length; i++){
            boolean isHead=false;
            boolean isNum=false;
            String a= "";
            String b= "";
            String c= "";
            int cnt_tmp=0;
            for(int j=0; j<files[i].length(); j++){
                if(files[i].charAt(j)-'0'>=0 && files[i].charAt(j)-'0'<=9 && cnt_tmp<5 && !isNum){
                    isHead=true;
                    cnt_tmp++;
                    b+=String.valueOf(files[i].charAt(j));
                }else if((files[i].charAt(j)-'0'<0 || files[i].charAt(j)-'0'>9) && !isHead){
                    a+=String.valueOf(files[i].charAt(j));
                }else if(isHead){
                    isNum=true;
                    c+=String.valueOf(files[i].charAt(j));
                }
            }

            arr.add(new Pair(a,b,c));
        }
        Collections.sort(arr);

        String[] answer = new String[files.length];

        int cnt=0;
        while(true){
            if(cnt>=arr.size()){
                break;
            }

            String tmp = arr.get(cnt).Head +arr.get(cnt).Num+arr.get(cnt).Tail;

            answer[cnt]=tmp;
            cnt++;
        }

        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i]+" ");
        }

        return answer;
    }
}
