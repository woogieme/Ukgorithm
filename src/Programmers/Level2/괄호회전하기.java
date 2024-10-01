package Programmers.Level2;

import java.util.*;

class 괄호회전하기 {
    public int solution(String s) {
        int answer = 0;
        int x = s.length();

        //x의 크기
        for(int i = 0; i<x; i++){
            //올바른 괄호 문자열인가?
            List<String> arr = new ArrayList<String>();

            boolean isFalse=false;
            for(int k=0; k<x; k++){
                char idx = s.charAt(k);

                if(idx=='(' || idx =='[' || idx =='{'){
                    arr.add(String.valueOf(idx));
                    continue;
                }
                if(idx=='}'){
                    if(arr.size()==0){
                        isFalse=true;
                        break;
                    }
                    if(arr.get(arr.size()-1).equals("{")){
                        arr.remove(arr.size()-1);
                    }else{
                        isFalse=true;
                        break;
                    }
                }
                else if(idx==']'){
                    if(arr.size()==0){
                        isFalse=true;
                        break;
                    }
                    if(arr.get(arr.size()-1).equals("[")){

                        arr.remove(arr.size()-1);
                    }else{
                        isFalse=true;
                        break;
                    }

                }else if(idx==')'){
                    if(arr.size()==0){
                        isFalse=true;
                        break;
                    }
                    if(arr.get(arr.size()-1).equals("(")){
                        arr.remove(arr.size()-1);
                    }else{
                        isFalse=true;
                        break;
                    }
                }
            }
            if(!isFalse && arr.size()==0){
                answer+=1;
            }
            //s을 왼쪽으로 i만큼 회전
            char tmp = s.charAt(0);
            String tmpA="";
            for(int q =1; q<x; q++){
                tmpA+=s.charAt(q);
            }
            tmpA+=tmp;
            s=tmpA;

        }
        return answer;
    }
}