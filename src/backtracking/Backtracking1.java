package backtracking;

/**
 * 배열에서 조합 가능한 모든 순열을 출력합니다.
 */

public class Backtracking1 {
    public static void permutation(int[] arr, int n, int size) {
        if(n == size) {
            for(int num : arr) {
                System.out.println(num + "");
            }
            System.out.println();
            return;
        }

        /**
         * 재귀 함수의 동작 원리는 다음과 같습니다.
         * 1. n = 0, i = 0에서 처음 swap이 일어나고 n = 1로 재귀호출합니다.
         * 2. n = 1, i = 1에서 또다시 swap이 일어나고 n = 2로 재귀호출합니다.
         * 3. n = 2, i = 2에서 마지막 swap이 일어나고 n = 3로 재귀호출합니다.
         * 4. n = 3에서 n이 size와 같으므로 {1, 2, 3}을 출력하고 return;합니다.
         * 5. 반환된 호출은 n = 2, i = 2의 상태로 돌아가게 되고, 루프의 끝에 도달하여 그 상위 호출로 돌아갑니다.
         * 6. n = 1, i = 1의 상태에서 i값이 증가되어 i = 2가 되고, swap(arr, 1, 2)를 호출하여 배열은 {1, 3, 2}가 됩니다.
         * 7. 이 상태에서 n = 2로 재귀호출하고, 이후 과정을 계속 반복하여 {1, 3, 2}를 출력합니다.
         *
         * 다음의 과정을 반복하여 재귀호출을 통해 모든 순열을 추출합니다.
         */

        for(int i = n; i < size; i++) {
            swap(arr, n, i);
            permutation(arr, n+1, size);
            swap(arr, n, i);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        permutation(arr, 0, arr.length);
    }
}
