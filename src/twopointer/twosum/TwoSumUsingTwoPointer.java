package twopointer.twosum;


import java.util.ArrayList;
import java.util.List;

/**
 * 정렬된 배열에서 두 수의 합이 목표값과 일치하는 지를 찾습니다.
 */
public class TwoSumUsingTwoPointer {

    private static final List<Boolean> counts = new ArrayList<>();

    public static void hasTwoSum(int[] nums, int target) {
        /**
         * 각 포인터는 배열의 첫 번째 요소와 마지막 요소를 가리킵니다.
         */
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            /**
             * 모든 경우의 수를 출력하기 위해 값을 반환하지 않고 일치하는 값을 찾았다면 각 포인터를 이동시켜
             * 계속해서 탐색합니다.
             */
            if (sum == target) {
                System.out.println("Left is : " + nums[left]);
                System.out.println("Right is : " + nums[right]);
                counts.add(Boolean.TRUE);
                left++;
                right--;
            } else if (sum < target) {
                left++; // 합이 목표값 보다 작다면 왼쪽 포인터를 오른쪽으로 한칸 이동시킵니다.
            } else {
                right--; // 합이 목표값 보다 크다면 오른쪽 포인터를 왼쪽으로 한간 이동시킵니다.
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        int target = 12;

        hasTwoSum(nums, target);
        if (counts.size() > 0) System.out.println("Yes and " + counts.size() + " cases exist");
        else System.out.println("No");
    }
}
