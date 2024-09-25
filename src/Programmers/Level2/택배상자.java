package Programmers.Level2;

import java.util.*;

class 택배상자 {
    public int solution(int[] order) {
        int answer = 0;

        //택배원이 원하는 상자
        Queue<Integer> truck = new ArrayDeque<>();

        //기본 벨트에있는 상자
        Queue<Integer> main = new ArrayDeque<>();

        //서브 벨트
        ArrayDeque<Integer> sub = new ArrayDeque<>();

        for(int i=0; i< order.length; i++){
            truck.add(order[i]);
            main.add(i+1);
        }

        while(true){

            //트럭에 택배가 꽉차면 끝
            if(truck.size()==0){
                break;
            }

            if(main.peek()==null && sub.peekLast().intValue()!=truck.peek().intValue()){
                break;
            }

            //택배상자가 택배원이랑 맞는가? truck = main ?
            //answer++ 택배상자 out
            if(main.peek()!=null && truck.peek().intValue()==main.peek().intValue()){
                answer++;
                main.poll();
                truck.poll();
            }

            //서브벨트에있는 택배상자가 택배원이랑 맞는가?
            else if(sub.peek()!=null && sub.peekLast().intValue()==truck.peek().intValue()){
                answer++;
                sub.pollLast();
                truck.poll();
            }

            //그게 아니라면 택배상자를 서브벨트에 넣는다
            else if(main.peek()!=null && truck.peek().intValue()!=main.peek().intValue()){
                sub.add(main.poll());
            }

        }
        //System.out.println(sub.peekLast());
        return answer;
    }
}

