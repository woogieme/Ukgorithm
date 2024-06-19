package CodeTree.NotSolved;
import java.io.*;
public class 미래가보이는가위바위보 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] chr = new char[N];

        int num1=0;
        int num2=0;
        int num3=0;

        int compareNum1=0;
        int compareNum2=0;
        int compareNum3=0;
        int compareNum4=0;
        int compareNum5=0;
        int compareNum6=0;

        int result1=0;
        int result2=0;
        int result3=0;
        int result4=0;

        int max1=0;
        int max2=0;
        int max3=0;
        int max4=0;
        int max5=0;
        int max6=0;

        int value1=0;
        int value2=0;
        int value3=0;
        int value4=0;
        int value5=0;
        int value6=0;

        char compareOne;
        char compareTwo;
        char compareThree;

        for(int i=0; i<N; i++){
            String input = br.readLine();

            if(input.equals("P")){
                num1++;
            }else if(input.equals("H")){
                num2++;
            }else{
                num3++;
            }
            chr[i] = input.charAt(0);
        }

        int big =  (num1>num2)&& (num1>num3)? num1:(num3>num2?num3:num2);

        if(big==num1){
            compareOne='P';
        }else if(big==num2){
            compareOne='H';
        }else{
            compareOne='S';
        }
        num1++;
        int middle =(num1>num2)?((num1>num3)?((num2>num3)?num2:num3):num1):((num2>num3)?((num1>num3)?num1:num3):num2);
        if(middle==num1){
            compareTwo='P';
        }else if(middle==num2){
            compareTwo='H';
        }else{
            compareTwo='S';
        }
        num2++;
        int small =(num2>num1)&&(num3>num1)?num1:(num2>num3?num3:num2);

        if(small==num1){
            compareThree='P';
        }else if(small==num2){
            compareThree='H';
        }else{
            compareThree='S';
        }
        num1--;
        num2--;
        //System.out.println(compareOne+" "+compareTwo+" "+compareThree);
        int[] L1 = new int[N]; //big값이 왼쪽으로 쭉
        int[] L2 = new int[N]; //middle값이 왼쪽으로 쭉
        int[] L3 = new int[N]; //small값이 왼쪽으로 쭉
        int[] R1 = new int[N]; //big값이 오른쪽으로 쭉
        int[] R2 = new int[N]; //middle값이 오른쪽으로 쭉
        int[] R3 = new int[N]; //small값이 오른쪽으로 쭉


        for(int i=0; i<N; i++){
            if(chr[i]==compareOne){
                if(i==0){
                    L1[i]=1;
                }else{
                    L1[i]=L1[i-1]+1;
                }
            }else if(chr[i]!=compareOne){
                if(i==0){
                    L1[i]=0;
                }else{
                    L1[i]=L1[i-1];
                }
            }
            if(max1<L1[i] &&i!=N-1){
                max1=L1[i];
                value1=i;
            }
        }

        for(int i=0; i<N; i++){
            if(chr[i]==compareTwo){
                if(i==0){
                    L2[i]=1;
                }else{
                    L2[i]=L2[i-1]+1;
                }
            }else if(chr[i]!=compareTwo){
                if(i==0){
                    L2[i]=0;
                }else{
                    L2[i]=L2[i-1];
                }
            }
            if(max2<L2[i] && i!=N-1){
                max2=L2[i];
                value2=i;
            }
        }

        for(int i=0; i<N; i++){
            if(chr[i]==compareThree){
                if(i==0){
                    L3[i]=1;
                }else{
                    L3[i]=L3[i-1]+1;
                }
            }else if(chr[i]!=compareThree){
                if(i==0){
                    L3[i]=0;
                }else{
                    L3[i]=L3[i-1];
                }
            }
            if(max5<L3[i] && i!=N-1){
                max5=L3[i];
                value5=i;
            }
        }


        for(int i=N-1; i>=0; i--){
            if(chr[i]==compareOne){
                if(i==N-1){
                    R1[i]=1;
                }else{
                    R1[i]=R1[i+1]+1;
                }
            }else if(chr[i]!=compareOne){
                if(i==N-1){
                    R1[i]=0;
                }else{
                    R1[i]=R1[i+1];
                }
            }
            if(max3<R1[i] && i!=0){
                max3=R1[i];
                value3=i;
            }
        }

        for(int i=N-1; i>=0; i--){
            if(chr[i]==compareTwo){
                if(i==N-1){
                    R2[i]=1;
                }else{
                    R2[i]=R2[i+1]+1;
                }
            }else if(chr[i]!=compareTwo){
                if(i==N-1){
                    R2[i]=0;
                }else{
                    R2[i]=R2[i+1];
                }
            }
            if(max4<R2[i] && i!=0){
                max4=R2[i];
                value4=i;
            }
        }

        for(int i=N-1; i>=0; i--){
            if(chr[i]==compareThree){
                if(i==N-1){
                    R3[i]=1;
                }else{
                    R3[i]=R3[i+1]+1;
                }
            }else if(chr[i]!=compareThree ){
                if(i==N-1){
                    R3[i]=0;
                }else{
                    R3[i]=R3[i+1];
                }
            }
            if(max6<R3[i] && i!=0){
                max6=R3[i];
                value6=i;
            }
        }

        //System.out.println(value4);
        //System.out.println(R3[value5]+" "+L1[value5-1]);
        if(value1+1!=N ){
            compareNum1=R1[value1+1]+L2[value1];
        }else if(value3-1!=0){
            compareNum2=L2[value3-1]+R1[value3];
        }else if(value2+1!=N ){
            compareNum3=R2[value2+1]+L1[value2];
        }else if(value4-1!=0 ){
            compareNum4=L1[value4-1]+R2[value4];
        }else if(value6-1!=0 ){
            compareNum5=R3[value6]+L1[value6-1];
        }else if(value5+1!=N ){
            compareNum6=L3[value5]+R1[value5+1];
        }



        if(compareNum1>compareNum2){
            result1=compareNum1;
        }else{
            result1=compareNum2;
        }

        if(compareNum3>compareNum4){
            result2=compareNum3;
        }else{
            result2=compareNum4;
        }

        if(compareNum5>compareNum6){
            result4=compareNum5;
        }else{
            result4=compareNum6;
        }

        //System.out.println(result1+" "+result2+" "+big);
        result3 = (big>result2)&& (big>result1)? big:(result1>result2?result1:result2);

        if(result3<result4){
            result3=result4;
        }
        System.out.println(result3);



        for(int i=0; i<N; i++){
            //System.out.print(L1[i]+" ");
            //System.out.println(L1[i]+" "+L2[i]+" "+L3[i]+" "+R1[i]+" "+R2[i]+" "+R3[i]);
        }

    }
}