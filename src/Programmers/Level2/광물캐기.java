package Programmers.Level2;
import java.util.*;
class 광물캐기 {
    public class Pair{
        int x;
        int y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int cnt =0;
        for(int i=0; i<picks.length; i++){
            cnt+=picks[i];
        }
        cnt*=5;

        if(minerals.length<cnt){
            cnt=minerals.length;
        }

        ArrayList<Integer> num = new ArrayList<>();
        int idx=0;
        int sum=0;
        while(true){
            if(idx==cnt){
                break;
            }
            if(minerals[idx].equals("diamond")){
                sum+=25;
            }else if(minerals[idx].equals("iron")){
                sum+=5;
            }else if(minerals[idx].equals("stone")){
                sum+=1;
            }

            idx++;
            if(idx!=0&& (idx%5==0 ||idx==cnt)){
                num.add(sum);
                sum=0;
            }

        }
        int[] ary = new int[num.size()];
        for(int i=0; i<ary.length; i++){
            ary[i]=num.get(i);
        }
        Collections.sort(num,Collections.reverseOrder());
        ArrayList<Pair> pair = new ArrayList<>();

        int value=0;
        boolean isFlag=false;
        for(int i=0; i<picks.length; i++){
            while(true){
                if(picks[i]==0){
                    break;
                }
                pair.add(new Pair(num.get(value),i));
                value++;
                picks[i]--;
                if(value==num.size()){
                    isFlag=true;
                    break;
                }

            }
            if(isFlag){
                break;
            }
        }


        for(int i=0; i<ary.length; i++){
            int j=0;
            while(true){
                if(ary[i]==pair.get(j).x){
                    if(i==ary.length-1){
                        int first = i*5;
                        int mine =pair.get(j).y;

                        for(int s=first;s<cnt; s++){
                            System.out.println(minerals[s]);
                            if(minerals[s].equals("diamond")){
                                if(mine==2){
                                    answer+=25;
                                }else if(mine==1){
                                    answer+=5;
                                }else{
                                    answer++;
                                }
                            }else if(minerals[s].equals("iron")){
                                if(mine==2){
                                    answer+=5;
                                }else{
                                    answer++;
                                }
                            }else{
                                answer++;
                            }
                        }
                        System.out.println("마지막"+" "+answer);
                    }else{
                        int last = (i+1)*5;
                        int first = i*5;
                        int mine = pair.get(j).y;
                        for(int s=first; s<last; s++){
                            if(minerals[s].equals("diamond")){
                                if(mine==2){
                                    answer+=25;
                                }else if(mine==1){
                                    answer+=5;
                                }else{
                                    answer++;
                                }
                            }else if(minerals[s].equals("iron")){
                                if(mine==2){
                                    answer+=5;
                                    System.out.println("???"+" "+answer);
                                }else{
                                    answer++;
                                }
                            }else{
                                answer++;
                            }
                        }
                        System.out.println("처음"+" "+answer);
                    }
                    pair.remove(j);
                    break;
                }
                j++;
            }
        }


        return answer;
    }
}
