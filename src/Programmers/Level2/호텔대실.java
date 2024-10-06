package Programmers.Level2;

import java.util.*;
class 호텔대실 {

    public class Pair implements Comparable<Pair>{
        int head;
        int tail;
        int idx;

        public Pair(int head, int tail, int idx){
            this.head=head;
            this.tail=tail;
            this.idx=idx;
        }

        @Override
        public int compareTo(Pair o){
            if(this.head == o.head){
                return this.tail - o.tail;
            }
            return this.head - o.head;
        }

    }
    public int solution(String[][] book_time) {
        int answer = 0;

        ArrayList<Pair> pair = new ArrayList<>();

        for(int i=0; i<book_time.length; i++){
            String[] str =book_time[i][1].split(":");
            int tmp1 = Integer.parseInt(str[0]);
            int tmp2 = Integer.parseInt(str[1]);
            tmp2+=10;
            if(tmp2>=60){
                tmp2-=60;
                tmp1++;
            }
            String tmpA = book_time[i][0].substring(0,2)+book_time[i][0].substring(3);
            String min="";
            if(tmp2<10){
                min="0"+String.valueOf(tmp2);
            }else{
                min=String.valueOf(tmp2);
            }
            String tmpB = String.valueOf(tmp1)+String.valueOf(min);

            pair.add(new Pair(Integer.parseInt(tmpA),1,i));
            pair.add(new Pair(Integer.parseInt(tmpB),-1,i));
        }
        Collections.sort(pair);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> used = new PriorityQueue<>();

        for(int i=1; i<=book_time.length; i++){
            pq.add(i);
        }
        for(int i=0; i<pair.size(); i++){
            int x = pair.get(i).head;
            int y = pair.get(i).tail;
            int idx = pair.get(i).idx;
            //System.out.println(x+" "+y+" "+idx);
        }
        for(int i=0; i<pair.size(); i++){

            int x = pair.get(i).head;
            int y = pair.get(i).tail;
            int idx = pair.get(i).idx;

            if(y==1){
                used.add(pq.poll());
                if(answer<used.size()){
                    answer=used.size();
                }

            }else{
                if(used.size()>0){
                    pq.add(used.poll());
                }
            }

        }

        return answer;
    }
}
