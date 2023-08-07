package dp.basic;

import java.util.Arrays;

/**
 * DP != 군탈체포조
 * 동적 프로그래밍은 복잡한 문제를 해결할 때 사용하는 알고리즘 디자인 패러다임 중 하나입니다.
 * 큰 문제를 작은 하위 문제로 나누어 푸는 것을 강조하며, 각 하위 문제의 결과를 저장하고 재사용하여
 * 중복 계산을 피합니다.
 */
public class DynamicProgramming {

    /**
     * 중복 계산을 피하기 위한 배열을 선언합니다.
     */
    static long[] memo;

    public static long fibonacci(int n) {
        /**
         * 탐색하고자 하는 항이 음수 또는 0 또는 1일 경우 그대로 반환합니다.
         */
        if (n <= 1) {
            return n;
        }

        /**
         * 이미 계산한 결과가 있다면 반환합니다.
         */
        if (memo[n] != -1) {
            return memo[n];
        }

        /**
         * 계산한 결과를 메모합니다.
         */
        memo[n]  = fibonacci(n - 1) + fibonacci(n - 2);
        return memo[n];
    }

    public static void main(String[] args) {
        /**
         * 피보나치 수열의 10번째 항을 탐색하기 위해 n을 10으로 초기화합니다.
         */
        int n = 10;

        /**
         * 메모를 위해 배열의 길이를 선언하고
         * 이미 계산한 항과 그렇지 않은 항을 구분하기 위해 모든 원소를 -1로 초기화합니다.
         */
        memo = new long[n + 1];
        Arrays.fill(memo, -1);

        long result = fibonacci(n);

        System.out.println("Result is : " + result);
    }
}
