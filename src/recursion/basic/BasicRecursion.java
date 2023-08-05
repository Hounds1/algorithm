package recursion.basic;

/**
 * 기본적인 재귀 함수 예제입니다.
 */
public class BasicRecursion {

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        /**
         * 재귀 호출이 진행될 수록 호출 스택이 깊어집니다.
         * 호출 스택이 쌓이다 조건문처럼 n이 1이 되는 시점에 더 이상 재귀 호출이 진행되지 않고 함수가 반환됩니다.
         * 이때 종료 조건으로 1을 반환하게 되며, 이후에 이전 호출들이 차례로 반환되며 최종적인 팩토리얼 값을 얻게됩니다.
         */
        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int n = 5;
        int factorial = factorial(n);
        System.out.println(factorial);
    }
}
