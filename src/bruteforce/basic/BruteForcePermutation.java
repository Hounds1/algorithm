package bruteforce.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 완전 탐색 알고리즘은 모든 경우의 수를 고려하기 때문에 정확한 답을 보장합니다.
 * 그러나 경우에 따라 실행 시간이 매우 길어질 수 있어 크기가 큰 문제에서는 효율성을 발휘하지 못합니다.
 * 이러한 경우는 완전 탐색이 아닌 다른 방향을 고려하는 것이 추천됩니다.
 * 해당 예제는 1 부터 사용자에게 입력받은 수 init 까지의 숫자가 포함된 배열이 가질 수 있는
 * 모든 순열을 조회합니다.
 */
public class BruteForcePermutation {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void generatePermutation(int[] arr, int index, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            generatePermutation(arr, index + 1, result);
            swap(arr, index, i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int init = sc.nextInt();
        System.out.println("You entered: " + init);

        sc.close();

        int[] arr = new int[init];
        for (int i = 0; i < init; i++) {
            arr[i] = i + 1;
        }

        List<List<Integer>> permutations = new ArrayList<>();
        generatePermutation(arr, 0, permutations);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
