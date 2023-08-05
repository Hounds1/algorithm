package recursion.callstack;

/**
 * 호출 스택이 누적되는 과정을 알아볼 수 있습니다.
 */
public class CallStack {

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int add(int x, int y) {
        int sum = x + y;
        int product = multiply(x, y);
        return sum + product;
    }

    /**
     * main 함수로부터 호출로 누적되는 스택의 순서는 다음과 같습니다.
     * 1. main()
     * 2. add(x,y)
     * 3. multiply(x,y)
     *
     * 이제 순서의 역순으로 연산을 진행하고 최종적인 결과가 main()의 print 함수를 통해 출력됩니다.
     */

    public static void main(String[] args) {
        int x = 3;
        int y = 4;
        System.out.println(add(x, y));
    }
}
