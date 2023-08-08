package backtracking.combination;


/**
 * 백 트래킹과 재귀 함수를 통해 주어진 배열에서
 * k 개로 이루어질 수 있는 모든 배열을 추출합니다.
 * 예를 들어, 10개의 원소를 가진 배열에서 원소를 3개만 사용하여
 * 만들 수 있는 모든 배열을 추출하는 경우 등이 있습니다.
 */
public class Combination {

    /**
     * 자신을 재귀적으로 호출하여 가능한 모든 순열을 만들어냅니다.
     * 백 트래킹을 사용해 모든 경우의 수를 탐색하고 출력합니다.
     */
    public static void generateCombinations(int[] arr, int start, int len, int k, int[] result, int index) {
        /**
         * index번 째 재귀 호출이 일어나고 index가 목표하는 배열의
         * 길이와 같을 때 배열 result에 담겨있는 값들을 출력합니다.
         */
        if (index == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        /**
         * 반복 횟수가 목표하는 배열의 길이를 충족할 때 까지
         * 배열 result에 값을 저장하고 다음 칸의 값으로
         * 자신을 재귀적으로 호출합니다.
         */
        for (int i = start; i < len; i++) {
           result[index] = arr[i];
           generateCombinations(arr, i + 1, len, k, result, index + 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        final int range = arr.length;

        for (int i = 0; i < range; i++) {
            arr[i] = i + 1;
        }

        int k = 3; // 목표하는 배열의 길이

        int[] result = new int[k]; // 결과를 담기 위한 배열 result
        generateCombinations(arr, 0, range, k, result, 0);
    }
}
