package Programmers.Level3;

class 점찍기 {
    public long solution(int k, int d) {
        long answer = 0;
        long dSquared = (long) d * d; // d의 제곱값 미리 계산

        // x를 k씩 증가시킴
        for (long x = 0; x <= d; x += k) {
            // 주어진 x에서 가능한 y 최대값 찾기
            long maxYSquared = dSquared - x * x;
            long maxY = (long) Math.sqrt(maxYSquared); // 제곱근으로 y 최대값 계산

            // y를 k씩 증가시킬 수 있는 개수는 maxY / k + 1 (0을 포함하기 때문에 +1)
            answer += (maxY / k) + 1;
        }

        return answer;
    }
}
