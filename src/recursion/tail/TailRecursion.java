package recursion.tail;

/**
 * 꼬리 재귀 예제입니다.
 */
public class TailRecursion {

    public static int tailRecursion(int n, int total) {
        if (n == 1) {
            return total;
        }

        /**
         * 미리 연산된 결과로 자신을 다시 호출함으로 호출 스택이 누적되지 않습니다.
         * 재귀 함수를 호출하기 전 n - 1 , n * total 연산을 마치고 스스로를 호출함으로
         * 추가 연산이 없고 호출 스택에 누적되지 않습니다.
         */
        return tailRecursion(n - 1, n * total);
    }

    public static void main(String[] args) {
        int n = 5;
        int total = 1;
        int result = tailRecursion(n, total);

        System.out.println(result);
    }
}
