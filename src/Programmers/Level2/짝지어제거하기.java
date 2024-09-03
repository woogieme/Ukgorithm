package Programmers.Level2;


import java.util.*;

class 짝지어제거하기
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> arr = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(arr.size()>=1){
                if(arr.get(arr.size()-1)==s.charAt(i)){
                    arr.pop();
                }else{
                    arr.push(s.charAt(i));
                }

            }else{
                arr.push(s.charAt(i));
            }
        }
        if(arr.size()==0){
            return 1;
        }
        return 0;

    }
}