package LIS.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LIS(최장 증가 부분 수열)는 주어진 숫자열에서 가장 긴 증가하는 부분 수열을 찾는 알고리즘입니다.
 * 부분 수열이란 순서대로 나열된 숫자들 중에서 몇 개의 숫자를 선택하여 만든 수열을 의미합니다.
 * 증가하는 부분 수열은 선택된 숫자들이 순서대로 커지는 수열을 의미합니다.
 * 일반적으로, LIS 문제는 동적 계획법(DP / Dynamic Programming)을 활용하여 효율적으로 해결될 수 있습니다.
 */
public class LIS {

    public static List<Integer> findLIS(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1); // 모든 위치에서의 LIS 길이를 1로 초기화합니다.

        int maxLength = 1; // 최장 증가 부분 수열의 길이를 저장할 변수를 초기화합니다.
        int endIndex = 0;

        /**
         * 각 숫자에 대해 이전 숫자들과 비교하며 LIS를 갱신합니다.
         */
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * 만약 현재 숫자가 이전 숫자보다 큰 경우,
                 * 현재 위치에서의 LIS 길이를 갱신합니다.
                 */
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 증가하는 부분 수열의 길이를 갱신합니다.
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[endIndex]);
        int listSize = maxLength;

        for (int i = endIndex - 1; i >= 0; i--) {
            if (dp[i] == listSize - 1 && nums[i] < list.get(list.size() - 1)) {
                list.add(nums[i]);
                listSize--;
            }
        }

        return list;
    }


    public static void main(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        List<Integer> lis = findLIS(nums);
        int[] array = lis.stream().mapToInt(i -> i).toArray();

        System.out.print("number is : " );

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
        System.out.println("and lis size is : " + lis.size());
    }
}
