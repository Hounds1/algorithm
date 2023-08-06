package bruteforce.subset;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 주어진 숫자들 중 합이 특정한 값을 갖는 부분집합을 탐색합니다.
 * 주어진 숫자란 사용자가 입력한 길이의 배열 속 사용자가 입력한 숫자들로 이루어집니다.
 * 이 경우에도 모든 경우의 수를 탐색하고 적합한 해를 찾습니다.
 */
public class SubsetBruteForce {

    /**
     * 주어진 숫자 배열에서 모든 가능한 부분 집합을 생성합니다.
     * 재귀적으로 호출되며, 매 호출마다 현재 인덱스를 증가시켜 다음 숫자를 부분집합에 추가하거나
     * 제외시킵니다.
     * @param numbers
     * @param index
     * @param current
     * @param result
     * @param target
     */
    public static void generateSubsets(int[] numbers, int index, List<Integer> current, List<List<Integer>> result, int target) {
        /**
         * 현재 인덱스가 배열의 길이에 도달한 경우 부분집합이 완성되었으므로 부분집합의 합을 계산하고
         * 이 합이 주어진 값과 일치하는지 확인합니다. 만약, 일치하는 경우 해당 부분집합을 result 리스트에 추가합니다.
         */
        if (index == numbers.length) {
            int sum = 0;
            for (int num : current) {
                sum += num;
            }
            if (sum == target) {
                result.add(new ArrayList<>(current));
            }

            return;
        }

        /**
         * 현재 숫자를 부분집합에 추가한 후 자신을 재귀적으로 호출합니다. 이로써 현재 숫자를 포함한 경우의 부분 집합을
         * 생성합니다.
         */
        current.add(numbers[index]);
        generateSubsets(numbers, index + 1, current, result, target);
        /**
         * Backtrack : 위에서 추가한 현재 숫자를 다시 제거하여 원래의 부분집합으로 돌아갑니다.
         * 이는 다음 숫자로 넘어가면서 부분집합을 생성할 때 영향을 주지 않도록 하기 위함입니다.
         */
        current.remove(current.size() - 1);

        /**
         * 현재 숫자를 부분집합에 추가하지 않고, 다음 숫자로 넘어가기 위해 자신을 재귀적으로 호출합니다.
         * 이로써 현재 숫자를 제외한 경우의 부분집합을 생성합니다.
         */
        generateSubsets(numbers, index + 1, current, result, target);
    }

    /**
     * 특정 합을 갖는 부분집합을 찾습니다.
     * generateSubsets()를 호출하여 부분집합을 생성하고, 그 중에서 합이 주어진 값과 일치하는
     * 부분집합만 반환합니다.
     * @param numbers
     * @param target
     * @return
     */
    public static List<List<Integer>> findSubsetsWithSum(int[] numbers, int target) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(numbers, 0, new ArrayList<>(), subsets, target);
        return subsets;
    }

    public static void printSubset(List<List<Integer>> subsets) {
        if (subsets.isEmpty()) {
            System.out.println("No subsets found.");
            return;
        }

        System.out.println("Subsets with the target sum: ");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("Enter the target sum: ");
        int target = sc.nextInt();

        List<List<Integer>> subsets = findSubsetsWithSum(numbers, target);
        printSubset(subsets);

        sc.close();
    }
}
