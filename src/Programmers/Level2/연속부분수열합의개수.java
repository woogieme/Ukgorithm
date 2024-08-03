package Programmers.Level2;

import java.util.HashSet;

class 연속부분수열합의개수 {
    public int solution(int[] elements) {

        int[] arr = new int[elements.length + (elements.length - 1)];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == elements.length) {
                count = 0;
            }
            arr[i] = elements[count];
            count++;
        }

        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        HashSet<Integer> hMap = new HashSet<>();

        for (int i = 0; i < elements.length; i++) {
            int cnt = 0;
            for (int j = i; j < arr.length; j++) {
                if (j == i) {
                    hMap.add(preSum[j]);
                } else {
                    hMap.add(preSum[j] - preSum[cnt]);
                    cnt++;
                }
            }
        }
        //System.out.println(hMap.size());

        return hMap.size();
    }
}
