package Programmers.Level2;

import java.util.*;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        int person=1;
        int gCount=0;
        int turn=1;
        int calcu=n+1;
        char last=' ';
        char first=' ';
        boolean isFlag=true;

        HashSet<String> hMap = new HashSet<>();

        for(int i=0; i<words.length; i++){

            //몇번 루트인지 계산
            gCount++;
            if(gCount>n){
                turn++;
                gCount%=n;
            }

            //앞 글자의 맨뒤, 뒷 글자의 맨앞 비교
            if(i==0){
                last=words[i].charAt(words[i].length()-1);
                hMap.add(words[i]);
                person++;
                continue;
            }
            first = words[i].charAt(0);
            if(last!=first){
                isFlag=false;
                break;
            }
            last = words[i].charAt(words[i].length()-1);


            //중복되는것이 있는가?
            if(hMap.contains(words[i])){
                isFlag=false;
                break;
            }
            hMap.add(words[i]);

            //사람
            person++;
            if(person>n){
                person%=n;
            }
        }
        if(isFlag){
            answer[0]= 0;
            answer[1]= 0;
        }else{
            answer[0]= person;
            answer[1]= turn;
        }

        return answer;
    }
}
