package Programmers.Level2;

import java.util.*;
class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        HashMap<String,Integer> hMap = new HashMap<>();
        HashMap<String,Integer> sMap = new HashMap<>();

        for(int i=0; i<number.length; i++){
            hMap.put(want[i],number[i]);
        }

        for(int i=0; i<discount.length; i++){

            if(sMap.containsKey(discount[i])){
                sMap.put(discount[i],sMap.get(discount[i])+1);
            }else{
                sMap.put(discount[i],1);
            }

            Iterator<String> keys = hMap.keySet().iterator();

            boolean isFlag=true;

            while(keys.hasNext()){
                String strKey = keys.next();
                if(hMap.get(strKey)!=sMap.get(strKey)){
                    isFlag=false;
                    break;
                }
            }
            if(isFlag){
                answer++;
            }
            if(i>=9){

                sMap.put(discount[(i+1)-10],sMap.get(discount[(i+1)-10])-1);
            }
        }

        return answer;
    }
}


//             Iterator<String> test = hMap.keySet().iterator();
//             while(test.hasNext()){
//                 String strKey = test.next();
//                 Integer strValue = hMap.get(strKey);
//                 Integer strValue2 = sMap.get(strKey);
//                 System.out.print( strKey +":"+ strValue +" <> ");
//                 System.out.println( strKey +":"+ strValue2 );


//             }
//             System.out.println();

