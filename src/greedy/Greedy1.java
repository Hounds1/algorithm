package greedy;

/**
 * 그리디 알고리즘은 현재 상황에서 가장 최선이라고 생각되는 선택을 하는 방식입니다.
 * 이 예제는 거스름돈을 거슬러 줄 때 가장 큰 단위의 동전부터 최대한 거슬러 주는 결과를 도출합니다.
 */
public class Greedy1 {
    public static void main(String[] args) {
        int money = 3720;
        /**
         * 동전의 종류가 설정됩니다.
         */
        int[] coins = {500, 100, 50, 10};
        /**
         * 각 동전이 몇 개씩 거슬러질지 카운팅할 배열이 선언됩니다.
         */
        int[] count = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            count[i] = money / coins[i];
            money %= coins[i];
        }

        for (int i = 0; i < coins.length; i++) {
            System.out.println(coins[i] + "원 " + count[i] + "개");
        }
    }
}
