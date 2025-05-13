package Programmers.Level2;

public class 타겟넘버 {

    static int N;
    static boolean[] isSelected;
    static int[] number;
    static int T;
    static int result = 0;

    public int solution(int[] numbers, int target) {
        int answer = 0;

        N = numbers.length;
        isSelected = new boolean[N];
        number = new int[numbers.length];
        T = target;


        for (int i = 0; i < number.length; i++) {
            number[i] = numbers[i];
        }
        subset(0);

        // 문제 해결 로직 구현

        return result;
    }

    private static void subset(int count) { // count: 현재까지 고려한 원소 수

        if (count == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (isSelected[i]) {
                    sum += -1 * number[i];
                } else {
                    sum += number[i];
                }
            }
            if (sum == T) {
                result++;
            }

            return;
        }

        isSelected[count] = true;
        subset(count + 1);
        isSelected[count] = false;
        subset(count + 1);
    }


    public static void main(String[] args) {
        // 예시로 numbers와 target을 미리 설정
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        // Solution 클래스 객체 생성
        타겟넘버 solution = new 타겟넘버();

        // solution 메서드 호출
        int result = solution.solution(numbers, target);

        // 결과 출력
        System.out.println("결과: " + result);
    }
}

